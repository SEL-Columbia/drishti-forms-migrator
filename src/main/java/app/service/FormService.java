package app.service;

import app.model.Audit;
import app.model.BaseEntity;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static app.Constants.*;

public class FormService {
    private Repository repository;
    private MapTransformer mapTransformer;
    private ObjectConverter objectConverter;

    public FormService(Repository repository, MapTransformer mapTransformer, ObjectConverter objectConverter) {
        this.repository = repository;
        this.mapTransformer = mapTransformer;
        this.objectConverter = objectConverter;
    }

    public void save(List<Map<String, Object>> responseData) {
        if(responseData.size() == 0)
            return;

        Stream<Map<String, Object>> transform = mapTransformer.transform(responseData);
        save(transform, responseData.size());
    }

    private void save(Stream<Map<String, Object>> mappedData, int size) {
        final Long[] maxVersion = {0L};

        mappedData.forEach(map -> {
            BaseEntity savedEntity = repository.create(objectConverter.create(map));
            Long serverVersion = Long.valueOf((String) map.get(SERVER_VERSION));
            maxVersion[0] = serverVersion > maxVersion[0] ? serverVersion : maxVersion[0];

            if (savedEntity != null && map.containsKey(SUB_FORMS) && map.get(SUB_FORMS) != null) {
                ((List<Map<String, Object>>) map.get(SUB_FORMS)).forEach(subForm -> {
                    subForm.put(PARENT_ID, savedEntity.getId());
                    repository.create(objectConverter.create(subForm));
                });
            }
        });
        createAuditFor(maxVersion[0], size);
    }

    private void createAuditFor(Long maxVersion, long count) {
        repository.create(new Audit(maxVersion, count));
    }
}

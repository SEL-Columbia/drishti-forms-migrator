package app.service;

import app.model.BaseEntity;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static app.Constants.PARENT_ID;
import static app.Constants.SUB_FORMS;

public class FormService {
    private Repository repository;
    private MapTransformer mapTransformer;
    private ObjectConverter objectConverter;

    public FormService(Repository repository, MapTransformer mapTransformer, ObjectConverter objectConverter) {
        this.repository = repository;
        this.mapTransformer = mapTransformer;
        this.objectConverter = objectConverter;
    }

    public List<Map<String, Object>> save(List<Map<String, Object>> responseData) {
        if (responseData.size() == 0)
            return responseData;

        return save(mapTransformer.transform(responseData));
    }

    private List<Map<String, Object>> save(Stream<Map<String, Object>> mappedData) {
        List<Map<String, Object>> processedForms = Lists.newArrayList();

        mappedData.forEach(map -> {
            BaseEntity savedEntity = repository.create(objectConverter.create(map));
            if (savedEntity != null) {
                if (map.containsKey(SUB_FORMS) && map.get(SUB_FORMS) != null) {
                    ((List<Map<String, Object>>) map.get(SUB_FORMS)).forEach(subForm -> {
                        subForm.put(PARENT_ID, savedEntity.getId());
                        repository.create(objectConverter.create(subForm));
                    });
                }
                processedForms.add(map);
            }
        });
        return processedForms;
    }
}

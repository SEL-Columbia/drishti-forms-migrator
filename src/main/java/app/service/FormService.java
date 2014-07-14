package app.service;

import app.exception.FormMigrationException;
import app.model.BaseEntity;
import app.model.ErrorAudit;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static app.Constants.*;
import static java.lang.String.valueOf;

public class FormService {
    private Repository repository;
    private MapTransformer mapTransformer;
    private ObjectConverter objectConverter;
    private Logger logger = LoggerFactory.getLogger(FormService.class);

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
            try {
                processedForms.add(process(map));
            } catch (FormMigrationException ex) {
                String detailedMessage = ex.getCause() == null ? "" : ex.getCause().getMessage();
                logger.error(ex.getMessage() + "\n form entry: " + map, ex);
                repository.create(new ErrorAudit(valueOf(map.get(ENTITY_ID)), ex.getMessage(), detailedMessage));
            }
        });
        return processedForms;
    }

    private Map<String, Object> process(Map<String, Object> map) {
        BaseEntity savedEntity = repository.create(objectConverter.create(map));
        if (map.containsKey(SUB_FORMS) && map.get(SUB_FORMS) != null) {
            ((List<Map<String, Object>>) map.get(SUB_FORMS)).forEach(subForm -> {
                subForm.put(PARENT_ID, savedEntity.getId());
                repository.create(objectConverter.create(subForm));
            });
        }
        return map;
    }
}

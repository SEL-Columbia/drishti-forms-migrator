package app.service;

import app.exception.FormMigrationException;
import app.model.BaseEntity;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static app.Constants.PARENT_ID;
import static app.Constants.SUB_FORMS;

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
                logger.error(ex.getMessage() + '\n' + map, ex);
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

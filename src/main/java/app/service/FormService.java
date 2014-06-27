package app.service;

import app.model.BaseEntityForm;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;

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

    public void save(List<Map<String, Object>> responseData) {
        Stream<Map<String, Object>> mappedData = mapTransformer.transform(responseData);

        mappedData.forEach(map -> {
            BaseEntityForm savedEntity = repository.create(objectConverter.create(map));

            if (savedEntity != null && map.containsKey(SUB_FORMS) && map.get(SUB_FORMS) != null) {
                ((List<Map<String, Object>>) map.get(SUB_FORMS)).forEach(subForm -> {
                    subForm.put(PARENT_ID, savedEntity.getId());
                    repository.create(objectConverter.create(subForm));
                });
            }
        });
    }
}

package app.service;

import app.model.BaseEntityForm;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;

import java.util.List;
import java.util.Map;

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
        List<Map<String, Object>> mappedData = mapTransformer.transform(responseData);

        for (Map<String, Object> map : mappedData) {
            BaseEntityForm savedEntity = repository.create(objectConverter.create(map));

            if (savedEntity != null && map.containsKey(SUB_FORMS) && map.get(SUB_FORMS) != null) {
                for (Map<String, Object> subForm : (List<Map<String, Object>>) map.get(SUB_FORMS)) {
                    subForm.put(PARENT_ID, savedEntity.getId());
                    BaseEntityForm entityForm = objectConverter.create(subForm);
                    repository.create(entityForm);
                }
            }
        }
    }
}

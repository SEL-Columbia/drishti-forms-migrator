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

    public List<Map<String, Object>> save(List<Map<String, Object>> formEntries) {
        if (formEntries.size() == 0)
            return formEntries;

        List<Map<String, Object>> processedForms = Lists.newArrayList();
        formEntries.forEach(formEntry -> {
            Map<String, Object> processedForm = processForm(formEntry);
            if (processedForm != null)
                processedForms.add(processedForm);
        });
        return processedForms;
    }

    private Map<String, Object> processForm(Map<String, Object> formEntry) {
        try {
            return process(formEntry);
        } catch (FormMigrationException ex) {
            String detailedMessage = ex.getCause() == null ? "" : ex.getCause().getMessage();
            logger.error(ex.getMessage() + "\n form entry: " + formEntry, ex);

            repository.create(new ErrorAudit(valueOf(formEntry.get(ENTITY_ID)), ex.getMessage(), detailedMessage));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    private Map<String, Object> process(Map<String, Object> map) {
        Map<String, Object> transformedMap = mapTransformer.transform(map);
        BaseEntity entityForm = objectConverter.create(transformedMap);
        BaseEntity savedEntity = repository.create(entityForm);

        if (transformedMap.containsKey(SUB_FORMS) && transformedMap.get(SUB_FORMS) != null) {
            ((List<Map<String, Object>>) transformedMap.get(SUB_FORMS)).forEach(subForm -> {
                subForm.put(PARENT_ID, savedEntity.getId());
                repository.create(objectConverter.create(subForm));
            });
        }
        return map;
    }
}

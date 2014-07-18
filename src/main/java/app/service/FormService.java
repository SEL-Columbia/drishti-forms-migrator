package app.service;

import app.exception.FormMigrationException;
import app.model.BaseEntity;
import app.model.ErrorAudit;
import app.repository.Repository;
import app.repository.TransactionManager;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static app.Constants.*;
import static com.google.common.base.Strings.nullToEmpty;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class FormService {
    private Repository repository;
    private MapTransformer mapTransformer;
    private ObjectConverter objectConverter;
    private TransactionManager transactionManager;
    private AuditService auditService;
    private Logger logger = LoggerFactory.getLogger(FormService.class);

    public FormService(Repository repository, MapTransformer mapTransformer, ObjectConverter objectConverter, TransactionManager transactionManager, AuditService auditService) {
        this.repository = repository;
        this.mapTransformer = mapTransformer;
        this.objectConverter = objectConverter;
        this.transactionManager = transactionManager;
        this.auditService = auditService;
    }

    public List<Map<String, Object>> save(List<Map<String, Object>> formEntries) {
        if (formEntries.size() == 0)
            return formEntries;

        return formEntries.stream().map(this::processForm).filter(Objects::nonNull).collect(toList());
    }

    private Map<String, Object> processForm(Map<String, Object> formEntry) {
        try {
            return (Map<String, Object>) transactionManager.doInTransaction(() -> process(formEntry));
        } catch (FormMigrationException ex) {
            String detailedMessage = ex.getCause() == null ? "" : nullToEmpty(ex.getCause().getMessage());
            logger.error(ex.getMessage() + "\n form entry: " + formEntry, ex);

            auditService.createErrorAudit(new ErrorAudit(valueOf(formEntry.get(INSTANCE_ID)), ex.getMessage(), detailedMessage));
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
                repository.create(objectConverter.createSubForm(subForm));
            });
        }
        return map;
    }
}

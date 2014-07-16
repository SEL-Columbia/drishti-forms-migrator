package app.service;

import app.exception.FormMigrationException;
import app.model.Audit;
import app.model.BaseEntity;
import app.model.ErrorAudit;
import app.repository.Repository;
import app.repository.TransactionManager;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static app.Constants.*;
import static java.lang.String.valueOf;

public class AuditService {
    private Repository repository;
    private TransactionManager transactionManager;

    public AuditService(Repository repository, TransactionManager transactionManager) {
        this.repository = repository;
        this.transactionManager = transactionManager;
    }

    public void createAuditFor(List<Map<String, Object>> processedForms, List<Map<String, Object>> allForms) {
        if(allForms.size() == 0)
            return;

        Map<String, Object> maxVersionedForm = allForms.stream().max((form1, form2) ->
                getParsedVersion(form1) >= getParsedVersion(form2) ? 1 : -1
        ).get();

        Audit entityForm = new Audit(getParsedVersion(maxVersionedForm), allForms.size(), processedForms.size());
        transactionManager.doInTransaction(() -> repository.create(entityForm) );
    }

    private Long getParsedVersion(Map<String, Object> form1) {
        return Long.valueOf((String) form1.get(SERVER_VERSION));
    }

    public Audit getLastAudit() {
        return (Audit) transactionManager.doInTransaction(repository::getLastAudit);
    }
}

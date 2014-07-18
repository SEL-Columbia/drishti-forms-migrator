package app.service;

import app.model.Audit;
import app.model.ErrorAudit;
import app.repository.Repository;
import app.repository.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static app.Constants.SERVER_VERSION;
import static com.google.common.base.Optional.fromNullable;

public class AuditService {
    private Repository repository;
    private TransactionManager transactionManager;
    private Logger logger = LoggerFactory.getLogger(AuditService.class);

    public AuditService(Repository repository, TransactionManager transactionManager) {
        this.repository = repository;
        this.transactionManager = transactionManager;
    }

    public void createAuditFor(List<Map<String, Object>> processedForms, List<Map<String, Object>> allForms) {
        if (allForms.size() == 0)
            return;

        Map<String, Object> maxVersionedForm = allForms.stream().max((form1, form2) -> getParsedVersion(form1) >= getParsedVersion(form2) ? 1 : -1).get();

        try {
            Audit entityForm = new Audit(getParsedVersion(maxVersionedForm), allForms.size(), processedForms.size());
            transactionManager.doInTransaction(() -> repository.create(entityForm));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Audit getLastAudit() {
        return fromNullable((Audit) transactionManager.doInTransaction(repository::getLastAudit)).or(Audit.DEFAULT);
    }

    public void createErrorAudit(ErrorAudit errorAudit) {
        try {
            transactionManager.doInTransaction(() -> repository.create(errorAudit));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private Long getParsedVersion(Map<String, Object> form1) {
        return Long.valueOf((String) form1.get(SERVER_VERSION));
    }
}

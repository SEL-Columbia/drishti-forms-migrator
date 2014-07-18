package app.service;

import app.MigratorConfiguration;
import app.MockTransactionManager;
import app.model.Audit;
import app.model.ErrorAudit;
import app.repository.JTransaction;
import app.repository.Repository;
import app.repository.TransactionManager;
import app.scheduler.FormMigratorJob;
import app.util.HttpClient;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static app.Constants.SERVER_VERSION;
import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AuditServiceTest {
    private AuditService auditService;
    private Repository repository;

    @Before
    public void setup() {
        auditService = mock(AuditService.class);
        repository = mock(Repository.class);

        auditService = new AuditService(repository, new MockTransactionManager());
    }

    @Test
    public void shouldCreateAuditWithTheMaxVersionedForm() {
        HashMap<String, Object> form1 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "120"); }};
        HashMap<String, Object> form2 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "420"); }};
        HashMap<String, Object> form3 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "220"); }};
        ArrayList<Map<String, Object>> allForms = newArrayList(form1, form2, form3);
        ArrayList<Map<String, Object>> processForms = newArrayList(form1, form2);

        auditService.createAuditFor(processForms, allForms);

        verify(repository).create(new Audit(420L, allForms.size(), processForms.size()));
    }

    @Test
    public void shouldNotCreateAuditWhenTheFormsAreEmpty() {
        auditService.createAuditFor(newArrayList(), newArrayList());

        verify(repository, never()).create(any(Audit.class));
    }

    @Test
    public void shouldReturnLastAudit() {
        Audit audit = new Audit(123L, 100L, 100L);
        when(repository.getLastAudit()).thenReturn(audit);

        assertEquals(audit, auditService.getLastAudit());
    }

    @Test
    public void shouldReturnDefaultLastAuditIfItIsNull() {
        when(repository.getLastAudit()).thenReturn(null);

        assertEquals(Audit.DEFAULT, auditService.getLastAudit());
    }

    @Test
    public void shouldCreateErrorAudit() {
        ErrorAudit errorAudit = new ErrorAudit();

        auditService.createErrorAudit(errorAudit);
        verify(repository).create(errorAudit);
    }

}
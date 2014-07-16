package app.service;

import app.MockTransactionManager;
import app.exception.FormMigrationException;
import app.model.BaseEntity;
import app.model.ErrorAudit;
import app.model.forms.PncVisit;
import app.model.subForms.ChildPncVisit;
import app.repository.Repository;
import app.repository.TransactionManager;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import com.google.common.collect.Lists;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static app.Constants.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class FormServiceTest {
    @Mock
    private Repository repository;
    @Mock
    private MapTransformer mapTransformer;
    @Mock
    private ObjectConverter objectConverter;
    @Mock
    private TransactionManager transactionManager;

    private FormService formService;
    private HashMap<String, Object> formData;

    @Before
    public void setUp() throws Exception {
        SessionFactory mock = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(mock.openSession()).thenReturn(session);

        initMocks(this);
        formService = new FormService(repository, mapTransformer, objectConverter, new MockTransactionManager());
        formData = new HashMap<>();
        formData.put(FORM_NAME, "pnc_visit");
        formData.put(SERVER_VERSION, "1");
    }

    @Test
    public void shouldCallCreateOfRepositoryAfterTransformation(){
        PncVisit responseFormObj = new PncVisit();

        when(mapTransformer.transform(formData)).thenReturn(formData);
        when(objectConverter.create(any(Map.class))).thenReturn(responseFormObj);

        formService.save(Lists.<Map<String, Object>>newArrayList(formData));

        verify(objectConverter, times(1)).create(any(Map.class));
        verify(repository).create(responseFormObj);
    }

    @Test
    public void shouldCallCreateOfRepositoryForSubFormsAfterTransformation(){
        HashMap<String, Object> subForm1 = new HashMap<String, Object>() {{
            put(NAME, "child_pnc");
        }};
        HashMap<String, Object> transformedSubForm = new HashMap<String, Object>() {{
            put(NAME , "child_pnc");
            put(SUB_FORMS, Lists.<Map<String, Object>>newArrayList(subForm1));
        }};

        PncVisit pncVisit = new PncVisit();
        ChildPncVisit childPncVisit = new ChildPncVisit();

        when(mapTransformer.transform(formData)).thenReturn(transformedSubForm);
        when(objectConverter.create(any(Map.class))).thenReturn(pncVisit).thenReturn(childPncVisit);
        when(repository.create(any(BaseEntity.class))).thenReturn(pncVisit);

        formService.save(Lists.<Map<String, Object>>newArrayList(formData));

        verify(repository).create(pncVisit);
        verify(repository).create(childPncVisit);
    }

    @Test
    public void shouldCreateErrorAuditOnException(){
        String entity_id = "entity_id";
        String errorMessage = "Some message";
        formData.put(INSTANCE_ID, entity_id);

        when(mapTransformer.transform(formData)).thenReturn(formData);
        when(objectConverter.create(any(Map.class))).thenThrow(new FormMigrationException(errorMessage));

        formService.save(Lists.<Map<String, Object>>newArrayList(formData));

        verify(repository).create(new ErrorAudit(entity_id, errorMessage, ""));
    }

    @Test
    public void shouldCreateErrorAuditOnException2(){
        when(mapTransformer.transform(formData)).thenThrow(new FormMigrationException("form class"));

        formService.save(Lists.<Map<String, Object>>newArrayList(formData));
    }
}

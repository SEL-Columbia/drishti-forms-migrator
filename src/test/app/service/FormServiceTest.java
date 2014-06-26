package app.service;

import app.model.BaseEntityForm;
import app.model.PncVisit;
import app.model.subForms.ChildPncVisit;
import app.repository.Repository;
import app.util.MapTransformer;
import app.util.ObjectConverter;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static app.Constants.FORM_NAME;
import static app.Constants.SUB_FORMS;
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

    private FormService formService;
    private HashMap<String, Object> formData;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        formService = new FormService(repository, mapTransformer, objectConverter);
        formData = new HashMap<String, Object>();
        formData.put(FORM_NAME, "pnc_visit");
    }

    @Test
    public void shouldCallCreateOfRepositoryAfterTransformation(){
        ArrayList<Map<String, Object>> allFormData = Lists.<Map<String, Object>>newArrayList(formData);
        PncVisit responseFormObj = new PncVisit();

        when(mapTransformer.transform(allFormData)).thenReturn(allFormData);
        when(objectConverter.create(any(Map.class))).thenReturn(responseFormObj);

        formService.save(allFormData);

        verify(objectConverter, times(1)).create(any(Map.class));
        verify(repository).create(responseFormObj);
    }

    @Test
    public void shouldCallCreateOfRepositoryForSubFormsAfterTransformation(){
        HashMap<String, Object> subForm1 = new HashMap<String, Object>();
        subForm1.put("name", "child_pnc");
        formData.put(SUB_FORMS, Lists.<Map<String, Object>>newArrayList(subForm1));
        ArrayList<Map<String, Object>> allFormData = Lists.<Map<String, Object>>newArrayList(formData);

        PncVisit pncVisit = new PncVisit();
        ChildPncVisit childPncVisit = new ChildPncVisit();

        when(mapTransformer.transform(allFormData)).thenReturn(allFormData);
        when(objectConverter.create(any(Map.class))).thenReturn(pncVisit).thenReturn(childPncVisit);
        when(repository.create(any(BaseEntityForm.class))).thenReturn(pncVisit);

        formService.save(allFormData);

        verify(repository).create(pncVisit);
        verify(repository).create(childPncVisit);
    }
}

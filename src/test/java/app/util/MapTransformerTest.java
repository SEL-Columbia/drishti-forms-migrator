package app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static app.Constants.*;
import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class MapTransformerTest {

    private MapTransformer mapTransformer;
    private Map<String, Object> formData;

    @Before
    public void setup() throws IOException {
        mapTransformer = new MapTransformer();

        String url = getClass().getResource("/sample.json").getFile();
        formData = new ObjectMapper().readValue(new File(url), Map.class);

        formData.put(FORM_INSTANCE, new ObjectMapper().writeValueAsString(formData.get(FORM_INSTANCE)));
    }

    @Test
    public void shouldTransformTheGivenMap() throws JsonProcessingException {
        Map<String, Object> transformedMap = mapTransformer.transform(newArrayList(formData)).findFirst().get();

        assertEquals("demo1", transformedMap.get("anmId"));
        assertEquals("pnc_registration_oa", transformedMap.get(FORM_NAME));

        assertEquals("99f42bc6-1fc2-4b67-8917-924335e1972f", transformedMap.get("motherId"));
        assertEquals("2013-08-07", transformedMap.get("registrationDate"));
        assertEquals(null, transformedMap.get("aadhaarNumber"));
        assertEquals(null, transformedMap.get("deliveryOutcome"));
    }

    @Test
    public void shouldTransformTheSubFormsInAGivenMap() throws JsonProcessingException {
        Map<String, Object> transformedMap = mapTransformer.transform(newArrayList(formData)).findFirst().get();

        assertEquals("demo1", transformedMap.get("anmId"));

        assertNotNull(transformedMap.get(SUB_FORMS));

        List<Map<String, Object>> subForms = (List<Map<String, Object>>) transformedMap.get(SUB_FORMS);
        assertEquals(3, subForms.size());

        Map<String, Object> subForm1 = subForms.get(0);
        assertEquals("child_registration_oa", subForm1.get(NAME));
        assertEquals("male", subForm1.get("gender"));
        assertEquals("bcg opv_0 hepb_0", subForm1.get("immunizationsGiven"));

        Map<String, Object> subForm2 = subForms.get(1);
        assertEquals("one_more_registration", subForm2.get(NAME));
        assertEquals("harry", subForm2.get("firstName"));
        assertEquals("1988-07-31", subForm2.get("dob"));

        Map<String, Object> subForm3 = subForms.get(2);
        assertEquals("one_more_registration", subForm3.get(NAME));
        assertEquals("ron", subForm3.get("firstName"));
    }
}

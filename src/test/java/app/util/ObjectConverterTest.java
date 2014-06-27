package app.util;

import app.model.EcRegistration;
import app.model.subForms.PncChildRegistration;
import org.junit.Test;

import java.util.HashMap;

import static app.Constants.FORM_NAME;
import static app.Constants.NAME;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class ObjectConverterTest{

    @Test
    public void shouldCreateObjectFromTheCorrespondingMap() throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("phc", "phc_betagera");
        hashMap.put("subCenter", "katarki");
        hashMap.put("village", "belur");
        hashMap.put("householdNumber", "123");
        hashMap.put("householdAddress", null);
        hashMap.put("headOfHousehold", null);
        hashMap.put("aadharNumber", "420");
        hashMap.put("formName", "ec_registration");
        hashMap.put("anmId", "someId");

        EcRegistration entityForm = (EcRegistration) new ObjectConverter().create(hashMap);

        assertEquals(hashMap.get("phc"), entityForm.getPhc());
        assertEquals(hashMap.get("subCenter"), entityForm.getSubCenter());
        assertEquals(hashMap.get("village"), entityForm.getVillage());
        assertEquals(hashMap.get("householdNumber"), entityForm.getHouseholdNumber());
        assertEquals(hashMap.get("aadharNumber"), entityForm.getAadharNumber());
        assertNull(entityForm.getHeadOfHousehold());
        assertNull(entityForm.getHouseholdAddress());
    }

    @Test
    public void shouldCreateSubFormObjectFromTheCorrespondingMap() throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "child_registration_oa");
        hashMap.put("id", "child_id_404");
        hashMap.put("gender", "male");
        hashMap.put("bloodGroup", "AB+");
        hashMap.put("parentId", 404L);

        PncChildRegistration entityForm = (PncChildRegistration) new ObjectConverter().create(hashMap);

        assertEquals(hashMap.get("name"), entityForm.getSubFormName());
        assertEquals(hashMap.get("id"), entityForm.getChildId());
        assertEquals(hashMap.get("gender"), entityForm.getGender());
        assertEquals(hashMap.get("bloodGroup"), entityForm.getBloodGroup());
        assertEquals(hashMap.get("parentId"), entityForm.getPncRegistrationOaId());
    }

    @Test
    public void shouldReturnNullIfThereIsNoEntityWithGivenFormName() throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put(FORM_NAME, "some_random");
        hashMap.put("id", "child_id_404");
        hashMap.put("gender", "male");
        hashMap.put("bloodGroup", "AB+");

        assertNull(new ObjectConverter().create(hashMap));
    }

    @Test
    public void shouldReturnNullIfThereIsNoEntityWithGivenName() throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put(NAME, "some_random");
        hashMap.put("id", "child_id_404");
        hashMap.put("gender", "male");
        hashMap.put("bloodGroup", "AB+");

        assertNull(new ObjectConverter().create(hashMap));
    }
}
package app.util;

import app.model.ec_registration;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class ObjectConverterTest{

    @Test
    public void shouldCreateObjectFromTheCorrespondingMap() throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("district", "koppal");
        hashMap.put("phc", "phc_betagera");
        hashMap.put("subCenter", "katarki");
        hashMap.put("village", "belur");
        hashMap.put("householdNumber", "123");
        hashMap.put("householdAddress", null);
        hashMap.put("headOfHousehold", null);
        hashMap.put("aadharNumber", "420");
        hashMap.put("formName", "ec_registration");
        hashMap.put("anmId", "someId");

        ec_registration entityForm = (ec_registration) new ObjectConverter().create(hashMap);

        assertEquals(hashMap.get("district"), entityForm.getDistrict());
        assertEquals(hashMap.get("phc"), entityForm.getPhc());
        assertEquals(hashMap.get("subCenter"), entityForm.getSubCenter());
        assertEquals(hashMap.get("village"), entityForm.getVillage());
        assertEquals(hashMap.get("householdNumber"), entityForm.getHouseholdNumber());
        assertEquals(hashMap.get("aadharNumber"), entityForm.getAadharNumber());
        assertNull(entityForm.getHeadOfHousehold());
        assertNull(entityForm.getHouseholdAddress());
    }
}
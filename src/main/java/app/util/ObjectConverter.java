package app.util;

import app.model.*;
import app.model.subForms.ChildPncVisit;
import app.model.subForms.ChildRegistration;
import app.model.subForms.PncChildRegistration;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static app.Constants.FORM_NAME;
import static app.Constants.NAME;

public class ObjectConverter {
    private static HashMap<String, Type> formNameMap;
    private static HashMap<String, Type> subFormNameMap;

    static {
        formNameMap = new HashMap<String, Type>();
        formNameMap.put("anc_close", AncClose.class);
        formNameMap.put("anc_registration", AncRegistration.class);
        formNameMap.put("anc_registration_oa", AncRegistrationOa.class);
        formNameMap.put("anc_visit", AncVisit.class);
        formNameMap.put("child_close", ChildClose.class);
        formNameMap.put("child_illness", ChildIllness.class);
        formNameMap.put("child_immunizations", ChildImmunizations.class);
        formNameMap.put("child_registration_ec", ChildRegistrationEc.class);
        formNameMap.put("child_registration_oa", ChildRegistrationOa.class);
        formNameMap.put("delivery_outcome", DeliveryOutcome.class);
        formNameMap.put("delivery_plan", DeliveryPlan.class);
        formNameMap.put("delivery_plan", DeliveryPlan.class);
        formNameMap.put("ec_close", EcClose.class);
        formNameMap.put("ec_edit", EcEdit.class);
        formNameMap.put("ec_registration", EcRegistration.class);
        formNameMap.put("fp_change", FpChange.class);
        formNameMap.put("fp_complications", FpComplications.class);
        formNameMap.put("fp_followup", FpFollowup.class);
        formNameMap.put("hb_test", HbTest.class);
        formNameMap.put("ifa", Ifa.class);
        formNameMap.put("pnc_close", PncClose.class);
        formNameMap.put("pnc_registration_oa", PncRegistrationOa.class);
        formNameMap.put("pnc_visit", PncVisit.class);
        formNameMap.put("postpartum_family_planning", PostpartumFamilyPlanning.class);
        formNameMap.put("record_ecps", RecordEcps.class);
        formNameMap.put("renew_fp_product", RenewFpProduct.class);
        formNameMap.put("tt", Tt.class);
        formNameMap.put("tt_1", Tt.class);
        formNameMap.put("tt_2", Tt.class);
        formNameMap.put("tt_booster", Tt.class);
        formNameMap.put("vitamin_a", VitaminA.class);

        subFormNameMap = new HashMap<String, Type>();
        subFormNameMap.put("child_registration_oa", PncChildRegistration.class);
        subFormNameMap.put("child_registration", ChildRegistration.class);
        subFormNameMap.put("child_pnc_visit", ChildPncVisit.class);
    }

    public static BaseEntityForm create(Map hashMap) {
        boolean isBaseForm = hashMap.containsKey(FORM_NAME);
        Class<Object> classType = isBaseForm ?
                (Class<Object>) formNameMap.get(hashMap.get(FORM_NAME)) :
                (Class<Object>) subFormNameMap.get(hashMap.get(NAME));

        if (classType == null)
            return null;
        return (BaseEntityForm) new ObjectMapper().convertValue(hashMap, classType);
    }
}

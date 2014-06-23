package app.util;

import app.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObjectConverter {
    private static HashMap<String, Type> formNameMap;

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
    }

    public static EntityForm create(Map hashMap){
        return (EntityForm) new ObjectMapper().convertValue(hashMap, (Class<Object>) formNameMap.get(hashMap.get("formName")));
    }

    public static Set<String> getAllFormNames() {
        return formNameMap.keySet();
    }
}

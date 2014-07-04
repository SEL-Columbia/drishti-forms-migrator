package app.util;

import app.model.BaseEntity;
import app.model.forms.*;
import app.model.subForms.ChildPncVisit;
import app.model.subForms.ChildRegistration;
import app.model.subForms.PncChildRegistration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static app.Constants.FORM_NAME;
import static app.Constants.NAME;

public class ObjectConverter {
    private static HashMap<String, Type> formNameMap;
    private static HashMap<String, Type> subFormNameMap;
    private Logger logger = LoggerFactory.getLogger(ObjectConverter.class);

    static {
        formNameMap = new HashMap<>();
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

        subFormNameMap = new HashMap<>();
        subFormNameMap.put("child_registration_oa", PncChildRegistration.class);
        subFormNameMap.put("child_registration", ChildRegistration.class);
        subFormNameMap.put("child_pnc_visit", ChildPncVisit.class);
    }

    public BaseEntity create(Map hashMap) {
        boolean isBaseForm = hashMap.containsKey(FORM_NAME);
        Class<Object> classType = isBaseForm ?
                (Class<Object>) formNameMap.get(hashMap.get(FORM_NAME)) :
                (Class<Object>) subFormNameMap.get(hashMap.get(NAME));

        if (classType == null)
            return null;

        BaseEntity baseEntity = null;
        try {
            baseEntity = (BaseEntity) getObjectMapper().convertValue(hashMap, classType);
        } catch (IllegalArgumentException e) {
            logger.error("Could not parse json for :" + hashMap);
            logger.error(e.getMessage());
        }
        return baseEntity;
    }

    private ObjectMapper getObjectMapper() {
        SimpleModule module = new SimpleModule("InvalidDateParse");
        module.addDeserializer(Date.class, new DateTypeDeserializer(Date.class));
        module.addDeserializer(Integer.class, new IntTypeDeserializer(Integer.class));
        module.addDeserializer(Float.class, new FloatTypeDeserializer(Float.class));

        return new ObjectMapper().registerModule(module);
    }
}

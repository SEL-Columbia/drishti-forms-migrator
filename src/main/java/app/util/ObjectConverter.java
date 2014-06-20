package app.util;

import app.model.EntityForm;
import app.model.ec_registration;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ObjectConverter {
    private static HashMap<String, Type> formNameMap;

    static {
        formNameMap = new HashMap<String, Type>();
        formNameMap.put("ec_registration", ec_registration.class);
    }

    public static EntityForm create(Map hashMap){
        return (EntityForm) new ObjectMapper().convertValue(hashMap, (Class<Object>) formNameMap.get(hashMap.get("formName")));
    }
}

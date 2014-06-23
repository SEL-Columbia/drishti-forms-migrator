package app.util;

import app.model.EcRegistration;
import app.model.EntityForm;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObjectConverter {
    private static HashMap<String, Type> formNameMap;

    static {
        formNameMap = new HashMap<String, Type>();
        formNameMap.put("ec_registration", EcRegistration.class);
    }

    public static EntityForm create(Map hashMap){
        return (EntityForm) new ObjectMapper().convertValue(hashMap, (Class<Object>) formNameMap.get(hashMap.get("formName")));
    }

    public static Set<String> getAllFormNames() {
        return formNameMap.keySet();
    }
}

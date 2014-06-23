package app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static app.Constants.*;
import static com.google.common.base.Strings.emptyToNull;

public class MapTransformer {

    private final ArrayList<String> otherFields = Lists.newArrayList("anmId", FORM_NAME);

    public List<Map<String, Object>> transform(List<Map<String, Object>> formData) {
        return Lists.transform(filter(formData), new Function<Map<String, Object>, Map<String, Object>>() {
            @Override
            public Map<String, Object> apply(Map<String, Object> formMap) {
                return transform(formMap);
            }
        });
    }

    private List<Map<String, Object>> filter(List<Map<String, Object>> formData) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        for (Map<String, Object> map : formData) {
            if(ObjectConverter.getAllFormNames().contains(map.get(FORM_NAME))) {
                result.add(map);
            }
        }
        return result;
    }

    private Map<String, Object> transform(Map<String, Object> formMap) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for (String fieldName : otherFields) {
            resultMap.put(fieldName, formMap.get(fieldName));
        }

        try {
            Map<String, Object> formDetails = new ObjectMapper().readValue((String) formMap.get(FORM_INSTANCE), Map.class);
            Map<String, Object> formInfo = (Map<String, Object>) formDetails.get(FORM);
            List<Map<String, Object>> allFieldsMap = (List<Map<String, Object>>) formInfo.get(FIELDS);

            for (Map<String, Object> field : allFieldsMap) {
                resultMap.put((String) field.get(NAME), emptyToNull((String) field.get(VALUE)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;
    }
}

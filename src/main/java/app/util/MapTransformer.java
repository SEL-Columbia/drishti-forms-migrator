package app.util;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static app.Constants.FIELDS;
import static app.Constants.NAME;
import static app.Constants.VALUE;

public class MapTransformer {

    private final ArrayList<String> otherFields = Lists.newArrayList("anmId");

    public List<Map<String, Object>> transform(List<Map<String, Object>> formData) {
        return Lists.transform(formData, new Function<Map<String, Object>, Map<String, Object>>() {
            @Override
            public Map<String, Object> apply(Map<String, Object> formMap) {
                return transform(formMap);
            }
        });
    }

    private Map<String, Object> transform(Map<String, Object> formMap) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for (String fieldName : otherFields) {
            resultMap.put(fieldName, formMap.get(fieldName));
        }

        List<Map<String, Object>> allFieldsMap = (List<Map<String, Object>>) formMap.get(FIELDS);
        for (Map<String, Object> field : allFieldsMap) {
            resultMap.put((String) field.get(NAME), field.get(VALUE));
        }

        return resultMap;
    }
}

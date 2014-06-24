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
import static com.google.common.collect.Lists.newArrayList;

public class MapTransformer {

    private final ArrayList<String> otherFields = newArrayList(ANM_ID, INSTANCE_ID, ENTITY_ID, FORM_NAME, CLIENT_VERSION, SERVER_VERSION, FORM_DATA_DEFINITION_VERSION);

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
        Map<String, Object> formInfo = getFormInfo(formMap);

        for (String fieldName : otherFields) {
            resultMap.put(fieldName, formMap.get(fieldName));
        }

        for (Map<String, Object> field : (List<Map<String, Object>>) formInfo.get(FIELDS)) {
            resultMap.put((String) field.get(NAME), emptyToNull((String) field.get(VALUE)));
        }

        if (formInfo.containsKey(SUB_FORMS) && formInfo.get(SUB_FORMS) != null) {
            resultMap.put(SUB_FORMS, transformSubForms((List<Map<String, Object>>) formInfo.get(SUB_FORMS)));
        }

        return resultMap;
    }

    private List<Map<String, Object>> transformSubForms(List<Map<String, Object>> subFormsData) {
        List<Map<String, Object>> allTransformedSubForms = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> subForm : subFormsData) {

            List<Map<String, Object>> subFormsFields = (List<Map<String, Object>>) subForm.get(INSTANCES);

            for (Map<String, Object> subFormsFieldMap : subFormsFields) {
                subFormsFieldMap.put(NAME, subForm.get(NAME));
            }

            allTransformedSubForms.addAll(subFormsFields);
        }
        return allTransformedSubForms;
    }

    private Map<String, Object> getFormInfo(Map<String, Object> formMap) {
        Map<String, Object> formDetails = new HashMap<String, Object>();
        try {
            formDetails = new ObjectMapper().readValue((String) formMap.get(FORM_INSTANCE), Map.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (Map<String, Object>) formDetails.get(FORM);
    }
}
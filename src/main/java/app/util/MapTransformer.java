package app.util;

import app.exception.FormMigrationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static app.Constants.*;
import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.valueOf;

public class MapTransformer {

    private final ArrayList<String> otherFields = newArrayList(ANM_ID, INSTANCE_ID, ENTITY_ID, FORM_NAME, CLIENT_VERSION, SERVER_VERSION, FORM_DATA_DEFINITION_VERSION);

    public Map<String, Object> transform(Map<String, Object> formMap) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Map<String, Object> formInfo = getFormInfo(formMap);

        otherFields.forEach(fieldName -> resultMap.put(fieldName, formMap.get(fieldName)));

        ((List<Map<String, Object>>) formInfo.get(FIELDS)).forEach(x ->
                resultMap.put(valueOf(x.get(NAME)), emptyToNull((String) x.get(VALUE))));

        if (formInfo.containsKey(SUB_FORMS) && formInfo.get(SUB_FORMS) != null) {
            resultMap.put(SUB_FORMS, transformSubForms((List<Map<String, Object>>) formInfo.get(SUB_FORMS)));
        }

        return resultMap;
    }

    private List<Map<String, Object>> transformSubForms(List<Map<String, Object>> subFormsData) {
        return subFormsData.stream()
                .flatMap(subForm -> {
                    List<Map<String, Object>> maps = (List<Map<String, Object>>) subForm.get(INSTANCES);
                    Stream<Map<String, Object>> map = maps.stream()
                            .map(instance -> {
                                instance.put(NAME, subForm.get(NAME));
                                return instance;
                            });
                    return map;
                })
                .collect(Collectors.toList());
    }

    private Map<String, Object> getFormInfo(Map<String, Object> formMap) {
        try {
            Map formInstance = new ObjectMapper().readValue((String) formMap.get(FORM_INSTANCE), Map.class);
            return (Map<String, Object>) formInstance.get(FORM);
        } catch (IOException ex) {
            throw new FormMigrationException("Could not parse form instance to json", ex);
        }
    }
}
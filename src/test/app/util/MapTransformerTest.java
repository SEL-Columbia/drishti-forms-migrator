package app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static app.Constants.*;
import static com.google.common.collect.ImmutableMap.of;
import static junit.framework.Assert.assertEquals;

public class MapTransformerTest {

    private MapTransformer mapTransformer;

    @Before
    public void setup() {
        mapTransformer = new MapTransformer();
    }

    @Test
    public void test() throws JsonProcessingException {
        ImmutableMap<String, Object> key1 = of(NAME, (Object) "name", VALUE, "harry", "source", "eligible_couple.name");
        ImmutableMap<String, Object> key2 = of(NAME, (Object) "id", VALUE, "12345", "source", "eligible_couple.id");
        ImmutableMap<String, Object> key3 = of(NAME, (Object) "district", VALUE, "koppal", "source", "eligible_couple.district");

        Map<String, Object> formInstance = new HashMap<String, Object>();
        formInstance.put(FORM, of(FIELDS, Lists.<Map<String, Object>>newArrayList(key1, key2, key3)));

        ImmutableMap<String, Object> formMap = of(
                "anmId", (Object) "123",
                "formName", "ec_registration",
                "clientVersion", 1,
                FORM_INSTANCE, new ObjectMapper().writeValueAsString(formInstance)
        );

        Map<String, Object> transformedMap = mapTransformer.transform(Lists.<Map<String, Object>>newArrayList(formMap)).get(0);
        assertEquals("123", transformedMap.get("anmId"));
        assertEquals("12345", transformedMap.get("id"));
        assertEquals("harry", transformedMap.get(NAME));
        assertEquals("koppal", transformedMap.get("district"));
    }
}

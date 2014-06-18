package app.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static app.Constants.FIELDS;
import static app.Constants.NAME;
import static app.Constants.VALUE;
import static com.google.common.collect.ImmutableMap.of;
import static junit.framework.Assert.assertEquals;

public class MapTransformerTest {

    private MapTransformer mapTransformer;

    @Before
    public void setup() {
        mapTransformer = new MapTransformer();
    }

    @Test
    public void test() {
        ImmutableMap<String, Object> key1 = of(NAME, (Object) "name", VALUE, "harry", "source", "eligible_couple.name");
        ImmutableMap<String, Object> key2 = of(NAME, (Object) "id", VALUE, "12345", "source", "eligible_couple.id");
        ImmutableMap<String, Object> key3 = of(NAME, (Object) "district", VALUE, "koppal", "source", "eligible_couple.district");

        ImmutableMap<String, Object> formMap = of(
                "anmId", (Object) "123",
                "entityId", 123,
                "clientVersion", 1,
                FIELDS, Lists.<Map<String, Object>>newArrayList(key1, key2, key3)
        );

        Map<String, Object> transformedMap = mapTransformer.transform(Lists.<Map<String, Object>>newArrayList(formMap)).get(0);
        assertEquals("123", transformedMap.get("anmId"));
        assertEquals("12345", transformedMap.get("id"));
        assertEquals("harry", transformedMap.get(NAME));
        assertEquals("koppal", transformedMap.get("district"));
    }
}

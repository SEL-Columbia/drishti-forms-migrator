package app;


import app.model.EcRegistration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;

public class SampleTest {

    @Test
    public void test() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("subCenter", "Harry");
        map.put("foo", "bar");
        map.put("jobTitle", "Wizard");

        EcRegistration person = new ObjectMapper().convertValue(map, EcRegistration.class);
//        assertEquals(1, person.getId());
//        assertEquals("Harry", person.getSubCenter());
    }
}

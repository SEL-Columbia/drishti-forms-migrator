package app;


import app.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SampleTest {

    @Test
    public void test() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("full_name", "Harry");
        map.put("foo", "bar");
        map.put("jobTitle", "Wizard");

        Person person = new ObjectMapper().convertValue(map, Person.class);
        assertEquals(1, person.getId());
        assertEquals("Harry", person.getFullName());
    }
}

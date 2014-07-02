package app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class HttpClientTest {

    private String uri;
    private String username;
    private String password;

    @Before
    public void setup() {
        uri = "https://smartregistries.org/form-submissions?anm-id=demo1&timestamp=0&batchsize=100";
        username = "demo1";
        password = "1";
    }

    @Test
    public void shouldMakeHttpCallAndFetchResult() throws IOException, URISyntaxException {
        List<Map<String, Object>> result = HttpClient.call(new URI(uri), username, password);

        assertNotEquals(0, result.size());

        Map<String, Object> formData = result.get(0);

        Map<String, Object> formDetails = new ObjectMapper().readValue((String) formData.get("formInstance"), Map.class);
        assertNotNull(formDetails);

        Map<String, Object> formInfo = (Map<String, Object>) formDetails.get("form");
        assertNotNull(formInfo);

        List<Map<String, Object>> fields = (List<Map<String, Object>>) formInfo.get("fields");
        assertNotNull(fields);
        assertNotEquals(0, fields.size());
    }
}

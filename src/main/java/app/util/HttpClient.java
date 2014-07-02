package app.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class HttpClient {

    public static List<Map<String, Object>> call(String uri, String username, String password) {
        Client client = Client.create(HttpClientHelper.configureClient());
        client.addFilter(new HTTPBasicAuthFilter(username, password));
        WebResource service = client.resource(getBaseURI(uri));

        return (List<Map<String, Object>>)service.accept(MediaType.APPLICATION_JSON).get(List.class);
    }

    private static URI getBaseURI(String uri) {
        return UriBuilder.fromUri(uri).build();
    }
}

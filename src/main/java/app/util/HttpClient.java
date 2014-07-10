package app.util;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class HttpClient {
    private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    public List<Map<String, Object>> call(URI uri, String username, String password) {
        Client client = Client.create(HttpClientHelper.configureClient());
        client.addFilter(new HTTPBasicAuthFilter(username, password));
        WebResource service = client.resource(uri);

        try {
            return (List<Map<String, Object>>) service.accept(MediaType.APPLICATION_JSON).get(List.class);
        } catch (Exception e) {
            logger.error("Could not make http call : " + e.getMessage());
        }

        return Lists.newArrayList();
    }
}

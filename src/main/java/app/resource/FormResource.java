package app.resource;

import app.service.FormService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/form")
@Produces(MediaType.APPLICATION_JSON)
public class FormResource {
    private FormService formService;

    public FormResource(FormService formService) {
        this.formService = formService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(List<Map<String, Object>> formData) {
        formService.save(formData);
        Map<String, Object> entity = new HashMap<String, Object>();
        entity.put("saved", "ok");

        return Response.ok().entity(entity).build();
    }
}

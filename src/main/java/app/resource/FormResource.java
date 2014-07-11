package app.resource;

import app.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static app.Constants.FORM_INSTANCE;

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
        List<Map<String, Object>> processedForms = formService.save(doTransform(formData));

        Map<String, Object> entity = new HashMap<String, Object>() {{
            put("saved", "ok");
            put("successfullyProcessed", processedForms.size());
        }};

        return Response.ok().entity(entity).build();
    }

    private List<Map<String, Object>> doTransform(List<Map<String, Object>> formData) {
        return formData.stream().map(form -> {
            form.replace(FORM_INSTANCE, parseToString(form.get(FORM_INSTANCE)));
            return form;
        }).collect(Collectors.toList());
    }

    private String parseToString(Object o){
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (IOException e) {
            System.out.println("Could not parse");
        }
        return "";
    }
}

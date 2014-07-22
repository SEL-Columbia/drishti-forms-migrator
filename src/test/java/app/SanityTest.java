package app;

import app.model.FormEntity;
import app.util.ObjectConverter;
import org.junit.Test;
import org.reflections.Reflections;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static app.Constants.FORM_NAME;
import static org.junit.Assert.assertTrue;

public class SanityTest {

    private ObjectConverter objectConverter = new ObjectConverter();

    @Test
    public void allFormClassesShouldBeDefinedInObjectMapper() {
        Set<Class<? extends FormEntity>> allClasses = new Reflections("app.model.forms").getSubTypesOf(FormEntity.class);
        ArrayList<String> unknownForms = new ArrayList<>();

        allClasses.forEach(clazz -> {
            String formName = clazz.getAnnotation(Table.class).name();
            HashMap<String, Object> formData = new HashMap<String, Object>() {{
                put(FORM_NAME, formName);
            }};

            try {
                objectConverter.create(formData);
            } catch (Exception e) {
                unknownForms.add(formName);
            }
        });

        assertTrue("Following forms entries are not defined in Object Converter: " + unknownForms.toString(), unknownForms.isEmpty());
    }
}

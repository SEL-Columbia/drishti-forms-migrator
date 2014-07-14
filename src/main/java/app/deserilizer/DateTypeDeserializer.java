package app.deserilizer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;

import static com.google.common.base.Strings.isNullOrEmpty;

public class DateTypeDeserializer extends StdDeserializer<Date> {

    public DateTypeDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String dateValue = jp.getValueAsString();
        if(isNullOrEmpty(dateValue) || "Invalid Date".equalsIgnoreCase(dateValue) || "Nan".equalsIgnoreCase(dateValue))
            return null;

        return super._parseDate(jp, ctxt);
    }
}

package app.deserilizer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Strings;

import java.io.IOException;

public class FloatTypeDeserializer extends StdDeserializer<Float> {
    public FloatTypeDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public Float deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if("NaN".equalsIgnoreCase(jp.getValueAsString()) || Strings.isNullOrEmpty(jp.getValueAsString()))
            return null;
        return super._parseFloatPrimitive(jp, ctxt);
    }
}

package app.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Strings;

import java.io.IOException;

public class IntTypeDeserializer extends StdDeserializer<Integer> {
    protected IntTypeDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public Integer deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if("NaN".equalsIgnoreCase(jp.getValueAsString()) || Strings.isNullOrEmpty(jp.getValueAsString()))
            return null;
        return super._parseIntPrimitive(jp, ctxt);
    }
}

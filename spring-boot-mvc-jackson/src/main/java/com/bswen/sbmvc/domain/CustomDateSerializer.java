package com.bswen.sbmvc.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2019/6/24.
 */
public class CustomDateSerializer extends JsonSerializer<Date> {
    private static SimpleDateFormat formatter
            = new SimpleDateFormat("yyyyMMdd hh:mm:ss");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(formatter.format(date));
    }
}

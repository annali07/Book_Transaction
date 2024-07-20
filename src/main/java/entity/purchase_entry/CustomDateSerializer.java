package entity.purchase_entry;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Custom serializer for formatting Date objects as "yyyy-MM-dd" in JSON.
 */
public class CustomDateSerializer extends JsonSerializer<Date> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Serializes a Date object to a formatted date string in JSON.
     *
     * @param date the Date object to serialize
     * @param jsonGenerator the generator used to output resulting JSON content
     * @param serializerProvider the provider that can be used to get serializers for serializing
     *                           Objects value contains, if any.
     * @throws IOException if an input/output exception occurs
     */
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formattedDate = dateFormat.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}

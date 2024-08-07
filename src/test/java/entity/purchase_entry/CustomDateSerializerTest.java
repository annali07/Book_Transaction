package entity.purchase_entry;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CustomDateSerializerTest {

    private CustomDateSerializer customDateSerializer;
    private StringWriter writer;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;

    @BeforeEach
    void setUp() throws Exception {
        customDateSerializer = new CustomDateSerializer();
        writer = new StringWriter();
        jsonGenerator = new JsonFactory().createGenerator(writer);
        serializerProvider = new ObjectMapper().getSerializerProvider();
    }

    @Test
    void testSerialize() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2024-08-01");

        customDateSerializer.serialize(date, jsonGenerator, serializerProvider);
        jsonGenerator.flush();

        String json = writer.toString();
        assertEquals("\"2024-08-01\"", json);
    }
}

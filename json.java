import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class json {
    
    private static ObjectMapper objectMapper = getDefaultObjectMapper();


    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }


    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <T> T fromJson(JsonNode node, Class<T> classy) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classy);
    }

    public static JsonNode toJson(Object t){
        return objectMapper.valueToTree(t);
    }

    public static String toString(JsonNode node) {
        return generateString(node, false);
    }

    public static String toPrettyString(JsonNode node){
        return generateString(node, true);
    }


    private static String generateString(JsonNode node, boolean isPretty) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        if (isPretty)
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        return objectWriter.writeValueAsString(node);
    }
}


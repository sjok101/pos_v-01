import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

class testJson {
    public static void main(String[]args) throws IOException{

    String jsonSource = "{ \"title\": \"This is test\", \"author\": \"Test\" }";

    JsonNode node = json.parse(jsonSource);
    System.out.println(node.get("title").asText());
    System.out.println(node.get("author").asText());
       
    readJson read = json.fromJson(node, readJson.class);
    System.out.println(read.getTitle());
    
    
    }
}
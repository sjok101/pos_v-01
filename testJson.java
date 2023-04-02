import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Scanner;
import java.io.File;

class testJson {
    public static void main(String[]args) throws IOException{
        String test = "";
        try {
            File myObj = new File("test.json");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("\n");
            while (myReader.hasNext()) {
              test = myReader.next();
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    
    

    JsonNode node = json.parse(test);
    System.out.println(node.get("title").asText());
    System.out.println(node.get("author").asText());
       
    readJson read = json.fromJson(node, readJson.class);
    System.out.println(read.getTitle());
    
    
    }
}
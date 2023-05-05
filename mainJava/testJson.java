

import java.io.IOException;

import java.io.FileNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Scanner;
import java.io.File;

class testJson {
    public static void main(String[]args) throws IOException{
        String test = "";
        try {
            File myObj = new File("mainJava/test.json");
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
    
    //from Json test
    readJson read = json.fromJson(node, readJson.class);
    System.out.println(read.getTitle());
    
    //to Json Test
    read.setTitle("toJson Test");
    JsonNode testNode = json.toJson(read);
    System.out.println(testNode.get("title").asText());

    //print out string in json format
    System.out.println(json.toString(testNode));
    System.out.println(json.toPrettyString(testNode));
    

    }
}
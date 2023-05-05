<<<<<<< HEAD


import java.io.IOException;

import java.io.FileNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
import java.util.Scanner;
import java.io.File;

class testJson {
    public static void main(String[]args) throws IOException{
        String test = "";
        try {
<<<<<<< HEAD
            File myObj = new File("mainJava/test.json");
=======
            File myObj = new File("mainJava/login4.json");
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
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
<<<<<<< HEAD
    System.out.println(node.get("title").asText());
    System.out.println(node.get("author").asText());
    
=======
    
    System.out.println(node.toString());
    // System.out.println(node.get("pass").asText());
    
    System.exit(0);

>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
    //from Json test
    readJson read = json.fromJson(node, readJson.class);
    System.out.println(read.getTitle());
    
    //to Json Test
    read.setTitle("toJson Test");
    JsonNode testNode = json.toJson(read);
    System.out.println(testNode.get("title").asText());

<<<<<<< HEAD
    //print out string in json format
    System.out.println(json.toString(testNode));
    System.out.println(json.toPrettyString(testNode));
    
=======
    //ObjectMapper
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = "{ \"title\" : \"King\", \"author\" : \"Julian\" }";
    JsonNode jsonNode = objectMapper.readTree(jsonString);


    //print out string in json format
    System.out.println(json.toString(testNode));
    System.out.println(jsonNode.toString());
        
    // read = json.fromJson(jsonNode, readJson.class);
    
    System.out.println(jsonNode.toString());
    String out = "{" + jsonNode.toString() + "," + testNode.toString() + "}";
    System.out.println(out);




    //Files.write(Paths.get("./saves/login2.txt"), json.toPrettyString(testNode).getBytes());
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c

    }
}
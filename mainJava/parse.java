import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class parse {
    private static File file;
    private static HashMap<String, String> userLogInfo;


    private static HashMap<String,String> loginParseIn() throws IOException{
        file = new File("./saves/login.txt");
        userLogInfo = new HashMap<String, String>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String s1 = scan.nextLine();
            String s2 = scan.nextLine();
            userLogInfo.put(s1, s2);
        }
        return userLogInfo;
    }
    

    private static String loginParseOut(HashMap<String,String> updatedHash) throws IOException{
        String hashString = updatedHash.toString();
        hashString = hashString.replace("{", "");
        hashString = hashString.replace("}", "");
        for(int i = 0; i< updatedHash.size(); i++){
            hashString = hashString.replace("=", "\n");
        }
        for(int i = 0; i< updatedHash.size()-1; i++){
            hashString = hashString.replace(", ", "\n");
        }
        
        Files.write(Paths.get("./saves/login.txt"), hashString.getBytes());
        return hashString;
    
    }

    public static boolean authUserPass(String user, String pass) throws IOException{
        if (user.equals("") || pass.equals("")){
            return false;
        }
        HashMap<String, String> listUserPass = loginParseIn();
        if(listUserPass.get(user)==null){
            return false;
        }
        if (listUserPass.get(user).equals(pass)){
            return true;
        }
        else{
            return false;
        }

    }

    public static void main(String[]args) throws IOException{
        HashMap<String,String> testIn = loginParseIn();
        String testOut = loginParseOut(testIn);
        System.out.println(testOut);
        
    }

}

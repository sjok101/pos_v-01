import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class parse {

    public static boolean authUserPass(String user, String pass) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<loginJson> listLog = objectMapper.readValue(new File("saves/user.json"), new TypeReference<List<loginJson>>(){});
        LinkedList<loginJson> logJ = new LinkedList<loginJson>(listLog);
        
        for(int i = 0; i<logJ.size(); i++){
            
            
            if (user.equals("") || pass.equals("")){
            return false;
            }
            if(user.equals(logJ.get(i).getUser()) && pass.equals(logJ.get(i).getPass())){
                return true;
            } 
        }
        return false;
    }

    public void main(String[]args) throws IOException{
        if(authUserPass("quaso", "croissant")){
            System.out.println("yay");
        }
        
    }

   
}

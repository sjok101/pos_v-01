import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class loginJson {
    private String username;
    private String password;

 
    public String getUser(){
        return username;
    }
    public void setUser(String user){
        this.username = user;
    }

    public String getPass(){
        return password;
    }

    public void setPass(String pass){
        this.password = pass;
    }


}

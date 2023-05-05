import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {
 
    private static HashMap<String,String> authUsers;
    
    public void login(){}

    @FXML
    private Button login;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;

    public void login(ActionEvent event) throws IOException{
        authenticate();
    }

    private void authenticate() throws IOException{
        PosMenu p = new PosMenu();
        if (parse.authUserPass(user.getText().toString(), pass.getText().toString())){
            wrongLogin.setText("Login Success");
            p.changeScene("MainMenuScene.fxml");
        }
        else if (user.getText().isEmpty() && pass.getText().isEmpty()){
            wrongLogin.setText("Please enter your data!");
        }
        else{
            wrongLogin.setText("Wrong user or pass!");
        }
        
        
        // if(user.getText().toString().equals("test") && pass.getText().toString().equals("foo")) {
        //     wrongLogin.setText("Success");
            
        //     p.changeScene("MainMenuScene.fxml");
        // }
    }    
}

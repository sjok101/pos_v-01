package uiControl;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;


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
        PosMenu a = new PosMenu();
        if(user.getText().toString().equals("test") && pass.getText().toString().equals("foo")) {
            wrongLogin.setText("Success");
            
            a.changeScene("MainMenuScene.fxml");
        }
        else if (user.getText().isEmpty() && pass.getText().isEmpty()){
            wrongLogin.setText("Please enter your data!");
        }
        else{
            wrongLogin.setText("Wrong user or pass!");
        }
    }    
}

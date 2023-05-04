import java.io.IOException;

import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MainMenuSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label name;
    @FXML
    private Label position;

    public void logOut(ActionEvent event) throws IOException{
       PosMenu p = new PosMenu();
       p.changeScene("login.fxml");
    }

    public void clockInOut(){

        if (name.getText().isEmpty()){
            //set clock time
            name.setText("Foo Man");
            position.setText("Chef");
        }else {
            //set clock time
            name.setText("");
            position.setText("");
        }

    }

    public void switchToDineInScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("TableScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void switchToKitchenScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("KitchenScene.fxml");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTakeoutScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("TicketScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToOverviewScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("OverviewScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTicketsScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("TicketScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToInventoryScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("Inventory.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToAnalysisScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("AnalysysScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}

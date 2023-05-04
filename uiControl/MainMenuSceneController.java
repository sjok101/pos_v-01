
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
            Parent root = FXMLLoader.load(getClass().getResource("TableScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void switchToKitchenScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("KitchenScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTakeoutScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToOverviewScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("OverviewScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTicketsScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToInventoryScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InventoryScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToAnalysisScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AnalysisScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}

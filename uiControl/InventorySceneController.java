import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;

public class InventorySceneController {
    private Stage stage;
    private Scene scene;

    public void switchToMainMenuInScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
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

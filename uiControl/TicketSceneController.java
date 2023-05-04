import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;

public class TicketSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMainMenuScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("MainMenuScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


}

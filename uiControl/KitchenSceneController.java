package uiControl;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.*;

public class KitchenSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML private TableView<kitchenTicket> kitchenview;
    @FXML private TableColumn<kitchenTicket,String> tableNumCol;
    @FXML private TableColumn<kitchenTicket,Integer> seatsCol;
    @FXML private TableColumn<kitchenTicket,Integer> statusCol;
    @FXML private TableColumn<kitchenTicket,Integer> ticketCol;
    @FXML private TableColumn<kitchenTicket,String> ordersCol;

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

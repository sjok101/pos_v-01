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

public class KitchenSceneController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML private TableView<kitchenTicket> kitchenview;
    @FXML private TableColumn<kitchenTicket,String> creationTimeCol;
    @FXML private TableColumn<kitchenTicket,Integer> priorityCol;
    @FXML private TableColumn<kitchenTicket,Integer> tableNumCol;
    @FXML private TableColumn<kitchenTicket,Integer> ticketidCol;
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

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        creationTimeCol.setCellValueFactory(new PropertyValueFactory<kitchenTicket,String>("creationTime"));
        priorityCol.setCellValueFactory(new PropertyValueFactory<kitchenTicket,Integer>("priority"));
        tableNumCol.setCellValueFactory(new PropertyValueFactory<kitchenTicket,Integer>("TableNum"));
        ticketidCol.setCellValueFactory(new PropertyValueFactory<kitchenTicket,Integer>("Ticketid"));
        ordersCol.setCellValueFactory(new PropertyValueFactory<kitchenTicket,String>("orderString"));
        kitchenview.setItems(getkTickets());
    }

    public ObservableList<kitchenTicket> getkTickets() {
        ObservableList<kitchenTicket> tickets = FXCollections.observableArrayList();
        tickets.add(new kitchenTicket("9:00",1,2,3,"macncheese,hot"));
        tickets.add(new kitchenTicket("3:00",4,5,6,"macncheese,cold"));
        return tickets;
    }

    @FXML
    private void completeTicket(ActionEvent event) {
        kitchenview.getItems().removeAll(kitchenview.getSelectionModel().getSelectedItem());
        kitchenview.refresh();
    }
}

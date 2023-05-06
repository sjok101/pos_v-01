
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TicketHistorySceneController implements Initializable{
    
    private Stage stage;
    private Scene scene;
    @FXML private TableView<jsonTicket> historyview;
    @FXML private TableColumn<jsonTicket,String> ticketidCol;
    @FXML private TableColumn<jsonTicket,String> closingTimeCol;
    @FXML private TableColumn<jsonTicket,String> creationTimeCol;
    @FXML private TableColumn<jsonTicket,String> totalCol;
    @FXML private TableColumn<jsonTicket,String> ordersCol;
    private LinkedList<jsonTicket> currTickets = new LinkedList<jsonTicket>();
    private ticketJson tj = new ticketJson();

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
        ticketidCol.setCellValueFactory(new PropertyValueFactory<jsonTicket,String>("TicketID"));
        creationTimeCol.setCellValueFactory(new PropertyValueFactory<jsonTicket,String>("CreationTime"));
        closingTimeCol.setCellValueFactory(new PropertyValueFactory<jsonTicket,String>("ClosingTime"));
        totalCol.setCellValueFactory(new PropertyValueFactory<jsonTicket,String>("Total"));
        ordersCol.setCellValueFactory(new PropertyValueFactory<jsonTicket,String>("Orders"));
        historyview.setItems(getTickets());
    }

    public ObservableList<jsonTicket> getTickets() {
        ObservableList<jsonTicket> tickets = FXCollections.observableArrayList();
        try {
            currTickets = tj.getTicketsHistory();
            for(jsonTicket k: currTickets) {
                tickets.add(k);
            }
            currTickets.size();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}

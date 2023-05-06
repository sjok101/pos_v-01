
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

public class KitchenSceneController implements Initializable{
    private Stage stage;
    private Scene scene;
    @FXML private TableView<kitchenTicket> kitchenview;
    @FXML private TableColumn<kitchenTicket,String> creationTimeCol;
    @FXML private TableColumn<kitchenTicket,Integer> priorityCol;
    @FXML private TableColumn<kitchenTicket,Integer> tableNumCol;
    @FXML private TableColumn<kitchenTicket,Integer> ticketidCol;
    @FXML private TableColumn<kitchenTicket,String> ordersCol;
    private LinkedList<kitchenTicket> currTickets = new LinkedList<kitchenTicket>();
    private kitchenJson kj = new kitchenJson();
    

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
        try {
            currTickets = kj.getKitchenTicketsJson();
            for(kitchenTicket k: currTickets) {
                tickets.add(k);
            }
            currTickets.size();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @FXML
    private void completeTicket(ActionEvent event) {
        kitchenTicket k = kitchenview.getSelectionModel().getSelectedItem();
        kitchenview.getItems().removeAll(kitchenview.getSelectionModel().getSelectedItem());
        kitchenview.refresh();
        int kTable = 0;
        int tickID = 0;
        for(kitchenTicket ta: currTickets) {
            if(ta.equals(k) == true) {
                currTickets.remove(k);
                kTable = ta.getTableNum();
                tickID = ta.getTicketid();
                try {
                    kj.KitchenTicketsToJson(currTickets);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        ticketJson tj = new ticketJson();
        try {
            LinkedList<Ticket> tickets = tj.getTicketsJson();
            LinkedList<Ticket> oldTickets = tj.getDoneTicketsJson();
            for(Ticket t: tickets) {
                if(t.getTicketID() == tickID && t.getTableNum() == kTable) {
                    tickets.remove(t);
                    t.closeTicket();
                    oldTickets.add(t);
                    tj.doneTicketsToJson(oldTickets);
                    tj.ticketsToJson(tickets);
                    break;
                }
            }
            tableJson tja = new tableJson();
            LinkedList<table> tables = tja.getTablesJson();
            for(table t: tables) {
                if(t.getTicket() == tickID && t.getTableNumber() == kTable) {
                    tables.remove(t);
                    t.setTicket(0);
                    tables.add(t);
                    tja.tablesToJson(tables);
                    break;
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deletedKitchenTicket(ActionEvent event) {
        kitchenTicket k = kitchenview.getSelectionModel().getSelectedItem();
        kitchenview.getItems().removeAll(kitchenview.getSelectionModel().getSelectedItem());
        kitchenview.refresh();
        int kTable = 0;
        int tickID = 0;
        for(kitchenTicket ta: currTickets) {
            if(ta.equals(k) == true) {
                currTickets.remove(k);
                kTable = ta.getTableNum();
                tickID = ta.getTicketid();
                try {
                    kj.KitchenTicketsToJson(currTickets);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        ticketJson tj = new ticketJson();
        try {
            LinkedList<Ticket> tickets = tj.getTicketsJson();
            for(Ticket t: tickets) {
                if(t.getTicketID() == tickID && t.getTableNum() == kTable) {
                    tickets.remove(t);
                    tj.ticketsToJson(tickets);
                    break;
                }
            }
            tableJson tja = new tableJson();
            LinkedList<table> tables = tja.getTablesJson();
            for(table t: tables) {
                if(t.getTicket() == tickID && t.getTableNumber() == kTable) {
                    tables.remove(t);
                    t.setTicket(0);
                    tables.add(t);
                    tja.tablesToJson(tables);
                    break;
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

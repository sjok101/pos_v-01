
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

import java.io.IOException;
import java.net.URL;
import java.util.*;



public class TablesSceneController implements Initializable{
    private Stage stage;
    private Scene scene;

    @FXML private TableView<table> tableview;
    @FXML private TableColumn<table,Integer> tableNumCol;
    @FXML private TableColumn<table,Integer> seatsCol;
    @FXML private TableColumn<table,String> statusCol;
    @FXML private TableColumn<table,Integer> ticketCol;
    @FXML private TableColumn<table,String> descriptionCol;
    @FXML private Label lTableNumber;
    @FXML private TextField TableNumberForTicket;
    @FXML private TextField inputSeats;
    @FXML private TextField inputstatus;
    @FXML private Label lTicket;
    @FXML private TextArea inputDescription;
    private LinkedList<table> currTables = new LinkedList<table>();
    private tableJson tj = new tableJson();

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

    public void switchToTicketsScene(ActionEvent event) {
        try {
            int tn = Integer.parseInt(TableNumberForTicket.getText());
            boolean match = false;
            int tick = 0;
            for(table t:currTables) {
                if(t.getTableNumber() == tn) {
                    match = true;
                    tick = t.getTicket();
                    break;
                }
            }
            if(match == true) {
                passTicket.ticketId = tick;
                passTicket.tableNum = tn;
                Parent root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        tableNumCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("tableNumber"));
        seatsCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("numberOfSeats"));
        ticketCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("ticket"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<table,String>("description"));
        statusCol.setCellValueFactory(new PropertyValueFactory<table,String>("status"));
        tableview.setItems(getTables());
    }

    public ObservableList<table> getTables(){
        ObservableList<table> tables = FXCollections.observableArrayList();
        try {
            currTables = tj.getTablesJson();
            for(table t:currTables) {
                tables.add(t);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return tables;
    }
    
    @FXML void submit(ActionEvent event) {
        ObservableList<table> tables = tableview.getItems();
        int currentTableNum = Integer.parseInt(lTableNumber.getText());
        for(table table: tables) {
            if(table.getTableNumber() == currentTableNum) {
                table.setNumberOfSeats(Integer.parseInt(inputSeats.getText()));
                table.setStatus(inputstatus.getText());
                table.setTicket(Integer.parseInt(lTicket.getText()));
                table.setTableDescription(inputDescription.getText());
                tableview.setItems(tables);
                tableview.refresh();
                LinkedList<table> newTables = new LinkedList<table>(tables);
                try {
                    tj.tablesToJson(newTables);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @FXML void rowClicked(MouseEvent event) {
        table selectedTable = tableview.getSelectionModel().getSelectedItem();
        lTableNumber.setText(String.valueOf(selectedTable.getTableNumber()));
        inputSeats.setText(String.valueOf(selectedTable.getNumberOfSeats()));
        inputstatus.setText(String.valueOf(selectedTable.getStatus()));
        lTicket.setText(String.valueOf(selectedTable.getTicket()));
        inputDescription.setText(String.valueOf(selectedTable.getDescription()));
    }

    @FXML
    private void deleteTable(ActionEvent event) {
        table t = tableview.getSelectionModel().getSelectedItem();
        tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
        tableview.refresh();
        for(table ta: currTables) {
            if(ta.equals(t) == true) {
                currTables.remove(t);
                try {
                    tj.tablesToJson(currTables);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @FXML
    private void createTable(ActionEvent event) {
        int tbnum = 0;
        boolean inserted = false;
        table tab = null;
        while(inserted == false) {
            tbnum++;
            if(tbnum != 99) {
                inserted = true;
                for(table t: currTables) {
                    if(t.getTableNumber() == tbnum) {
                        inserted = false;
                        break;
                    }
                }
                if(inserted == true) {
                    tab = new table(tbnum,1,"open",0,"");
                    currTables.add(tab);
                }
            }
        }
        try {
            tj.tablesToJson(currTables);
        }
        catch(IOException e) {
            e.printStackTrace();
        }   
        tableview.getItems().add(tab);
        tableview.refresh();
    }
}

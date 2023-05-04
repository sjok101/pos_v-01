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

import mainJava.table;

public class TablesSceneController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private TableView<table> tableview;
    @FXML private TableColumn<table,Integer> tableNumCol;
    @FXML private TableColumn<table,Integer> seatsCol;
    @FXML private TableColumn<table,String> statusCol;
    @FXML private TableColumn<table,Integer> ticketCol;
    @FXML private TableColumn<table,String> descriptionCol;
    @FXML private TextField inputTableNumber;
    @FXML private TextField TableNumberForTicket;
    @FXML private TextField inputSeats;
    @FXML private TextField inputstatus;
    @FXML private TextField inputTicket;
    @FXML private TextArea inputDescription;

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
    
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        tableNumCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("tableNumber"));
        seatsCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("numberOfSeats"));
        ticketCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("ticket"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<table,String>("description"));
        statusCol.setCellValueFactory(new PropertyValueFactory<table,String>("status"));
        tableview.setItems(getTables());
    }

    public ObservableList<table> getTables() {
        ObservableList<table> tables = FXCollections.observableArrayList();
        tables.add(new table(1,2,"open",1,"1 table"));
        tables.add(new table(2,2,"full",4,"2 table"));
        return tables;
    }
    
    @FXML void submit(ActionEvent event) {
        ObservableList<table> tables = tableview.getItems();
        int currentTableNum = Integer.parseInt(inputTableNumber.getText());
        for(table table: tables) {
            if(table.getTableNumber() == currentTableNum) {
                table.setNumberOfSeats(Integer.parseInt(inputSeats.getText()));
                table.setStatus(inputstatus.getText());
                table.setTicket(Integer.parseInt(inputTicket.getText()));
                table.setTableDescription(inputDescription.getText());
                tableview.setItems(tables);
                tableview.refresh();
                break;
            }
        }
    }

    @FXML void rowClicked(MouseEvent event) {
        table selectedTable = tableview.getSelectionModel().getSelectedItem();
        inputTableNumber.setText(String.valueOf(selectedTable.getTableNumber()));
        inputSeats.setText(String.valueOf(selectedTable.getNumberOfSeats()));
        inputstatus.setText(String.valueOf(selectedTable.getStatus()));
        inputTicket.setText(String.valueOf(selectedTable.getTicket()));
        inputDescription.setText(String.valueOf(selectedTable.getDescription()));
    }

    @FXML
    private void deleteTable(ActionEvent event) {
        tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
        tableview.refresh();
    }
}

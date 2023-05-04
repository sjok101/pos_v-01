package uiControl;
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
    @FXML private TableColumn<table,Integer> statusCol;
    @FXML private TableColumn<table,Integer> ticketCol;
    @FXML private TableColumn<table,String> descriptionCol;

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
        statusCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("status"));
        ticketCol.setCellValueFactory(new PropertyValueFactory<table,Integer>("ticket"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<table,String>("description"));
        tableview.setItems(getTables());
    }

    public ObservableList<table> getTables() {
        ObservableList<table> tables = FXCollections.observableArrayList();
        tables.add(new table(1,2,1,1,"1 table"));
        tables.add(new table(2,2,3,4,"2 table"));
        return tables;
    }
}

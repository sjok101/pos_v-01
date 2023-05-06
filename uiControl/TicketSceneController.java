
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class TicketSceneController implements Initializable{
    private Stage stage;
    private Scene scene;
    private int tableNumber = 0;
    private int Ticketid = 0;
    private boolean editTicket = false;
    @FXML private Label ticketID;
    @FXML private Label table;
    @FXML private TableView<Dish> ticketitems;
    @FXML private TableColumn<Dish, Double> total;
    @FXML private TableColumn<Dish, String> name;
    @FXML private Button burger;
    @FXML private Button fries;
    @FXML private Button soda;
    @FXML private Button chicken_soup;
    @FXML private Button salad;
    @FXML private Button chips_salsa;
    @FXML private Button queso;
    @FXML private Button water;
    @FXML private Button removebutton;
    @FXML private Label totallabel;
    @FXML private Button presshere;
    private ticketJson tj = new ticketJson();

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        this.tableNumber = passTicket.tableNum;
        this.Ticketid = passTicket.ticketId;
        ticketID.setText(String.valueOf(this.Ticketid));
        table.setText(String.valueOf(this.tableNumber));
        total.setCellValueFactory(new PropertyValueFactory<Dish,Double>("price"));
        name.setCellValueFactory(new PropertyValueFactory<Dish, String>("name"));
        LinkedList<Dish> d = new LinkedList<Dish>();
        try {
            LinkedList<Ticket> tickets = tj.getTicketsJson();
            for(Ticket t: tickets) {
                if(t.getTableNum() == tableNumber && t.getTicketID() == Ticketid && 0 != Ticketid) {
                    editTicket = true;
                    d = t.getDishes();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(editTicket == true) {
            ObservableList<Dish> list = FXCollections.observableArrayList(d);
            ticketitems.setItems(list);
        }
        else {
            ObservableList<Dish> list = FXCollections.observableArrayList();
            ticketitems.setItems(list);
        }

       
    }

    public void addBurger(ActionEvent event){
        try{
            Dish d = new Dish("Burger", 10.25, 1);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addSalad(ActionEvent event){
        try{
            Dish d = new Dish("Salad", 3, 2);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addChipsSalsa(ActionEvent event){
        try{
            Dish d = new Dish("Chips + Salsa", 4.50, 2);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addQueso(ActionEvent event){
        try{
            Dish d = new Dish("Queso", 10, 2);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addWater(ActionEvent event){
        try{
            Dish d = new Dish("Water", 1, 2);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addFries(ActionEvent event){
        try{
            Dish d = new Dish("Fries", 5.75, 2);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addSoda(ActionEvent event){
        try{
            Dish d = new Dish("Soda", 2.00, 3);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addChickenSoup(ActionEvent event){
        try{
            Dish d = new Dish("Chicken Soup", 9.33, 2);
            ticketitems.getItems().add(d);
            ticketitems.refresh();
            Double newtot = Double.parseDouble(this.totallabel.getText());
            newtot += d.getPrice();
            this.totallabel.setText(newtot+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void removeItem(ActionEvent event){
        try{
            ticketitems.getItems().remove(ticketitems.getItems().size()-1);
            ticketitems.refresh();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



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

    public void saveTicket(ActionEvent event) {
        try {
            if(tableNumber != 99) {
                LinkedList<Dish> d = new LinkedList<Dish>(ticketitems.getItems());
                if(editTicket == true) {
                    LinkedList<Ticket> tickets = tj.getTicketsJson();
                    Ticket ti = new Ticket(tableNumber,d);
                    for(Ticket t: tickets) {
                        if(t.getTableNum() == tableNumber && t.getTicketID() == Ticketid) {
                            tickets.remove(t);
                            ti.setPriority(t.getPriority());
                            ti.setTicketID(Ticketid);
                            ti.setTotal(Double.parseDouble(this.totallabel.getText()));
                            tickets.add(ti);
                            tj.ticketsToJson(tickets);
                            break;
                        }
                    }
                    kitchenJson kj = new kitchenJson();
                    LinkedList<kitchenTicket> kts = kj.getKitchenTicketsJson();
                    for(kitchenTicket kt: kts) {
                        if(kt.getTableNum() == tableNumber && kt.getTicketid() == Ticketid) {
                            kts.remove(kt);
                            kitchen k = new kitchen(kts);
                            LinkedList<Ticket> tempList = new LinkedList<Ticket>();
                            tempList.add(ti);
                            k.ticketsToKitchenTickets(tempList);
                            kj.KitchenTicketsToJson(k.getKitchenTickets());
                            break;
                        }
                    }  
                }
                else {
                    Ticket ti = new Ticket(tableNumber,d);
                    LinkedList<Ticket> tickets = tj.getTicketsJson();
                    tickets.add(ti);
                    tj.ticketsToJson(tickets);
                    tableJson tja = new tableJson();
                    LinkedList<table> tabs = tja.getTablesJson();
                    for(table t: tabs) {
                        if(t.getTableNumber() == tableNumber) {
                            tabs.remove(t);
                            t.setTicket(ti.getTicketID());
                            tabs.add(t);
                            tja.tablesToJson(tabs);
                            break;
                        }
                    }
                    kitchenJson kj = new kitchenJson();
                    kitchen k = new kitchen(kj.getKitchenTicketsJson());
                    LinkedList<Ticket> tempList = new LinkedList<Ticket>();
                    tempList.add(ti);
                    k.ticketsToKitchenTickets(tempList);
                    kj.KitchenTicketsToJson(k.getKitchenTickets());
                } 
            }
            else {
                LinkedList<Dish> d = new LinkedList<Dish>(ticketitems.getItems());
                Ticket ti = new Ticket(tableNumber,d);
                LinkedList<Ticket> tickets = tj.getTicketsJson();
                tickets.add(ti);
                tj.ticketsToJson(tickets);
                kitchenJson kj = new kitchenJson();
                kitchen k = new kitchen(kj.getKitchenTicketsJson());
                LinkedList<Ticket> tempList = new LinkedList<Ticket>();
                tempList.add(ti);
                k.ticketsToKitchenTickets(tempList);
                kj.KitchenTicketsToJson(k.getKitchenTickets());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
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
        //if editticket = true grab ticket and set it
        //else add ticket to linked list
        //putticketbackintojson

    }
    /*
    public void setLabels() {
        this.tableNumber = passTicket.tableNum;
        this.Ticketid = passTicket.ticketId;
        ticketID.setText(String.valueOf(this.Ticketid));
        table.setText(String.valueOf(this.tableNumber));
    }
    */
}

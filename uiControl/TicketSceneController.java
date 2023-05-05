import java.net.URL;
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
    private Parent root;
    private int orderno = 0;
    private Ticket tik = new Ticket(99);
    private int tableNumber = 0;
    private int Ticketid = 0;
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

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        // this.tableNumber = passTicket.tableNum;
        // this.Ticketid = passTicket.ticketId;
        // this.table.setText(tableNumber+"");
        // this.ticketID.setText(Ticketid+"");

        total.setCellValueFactory(new PropertyValueFactory<Dish,Double>("price"));
        name.setCellValueFactory(new PropertyValueFactory<Dish, String>("name"));
        Dish d1 = new Dish("bread", 0.0, 1);
        ObservableList<Dish> list = FXCollections.observableArrayList(d1);
        ticketitems.setItems(list);

        //ticketitems.setItems(getTables());
    }

    // public Ticket getTicket(){
        
    // }

        public void pressed(ActionEvent event){
            try {
                this.tableNumber = passTicket.tableNum;
                this.Ticketid = passTicket.ticketId;
                table.setText(String.valueOf(this.Ticketid));
                ticketID.setText(String.valueOf(this.tableNumber));
            }
            catch(Exception e) {
                e.printStackTrace();
            }
    
        }

    public void switchToMainMenuScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("MainMenuScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
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

    // public void addFries(ActionEvent event){
    //     try{
    //         Dish d = new Dish("Fries", 5.75, 2);
    //         ticketitems.getItems().add(d);
    //         ticketitems.refresh();
    //         Double newtot = Double.parseDouble(this.totallabel.getText());
    //         newtot += d.getPrice();
    //         this.totallabel.setText(newtot+"");
    //     }
    //     catch(Exception e){
    //         e.printStackTrace();
    //     }
    // }

    public void addItem(ActionEvent event){
        try{
            //Dish d = new Dish();
            ticketitems.getItems().add(null);
            
            //ticketitems.getItems().add(ordr);
            ticketitems.refresh();
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



}

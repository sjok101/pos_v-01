import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class TicketSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int orderno =0;
    @FXML private TableView<Order> ticketitems;
    @FXML private TableColumn<Order, Double> total;

    
    public void switchToMainMenuScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("MainMenuScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void addRow(ActionEvent event){
        try{
            Order ordr = new Order(1);
            ticketitems.getItems().add(ordr);
        }
        catch(Exception e){

        }
    }


}

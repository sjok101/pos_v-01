
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.control.*;

public class TicketSceneController {
    private Stage stage;
    private Scene scene;
    private int tableNumber = 0;
    private int Ticketid = 0;
    @FXML private Label ticketID;
    @FXML private Label table;

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
        //ticket creation
        //getticketjson
        //addtickettoticketlist
        //putticketbackintojson
        //gettablejson
        //searchtickettablenumber in list
        //remove it and add it back in
        //puttablebackinto
        //getkitchenticketjson
        //make kitchen with kitchenticketlistin it
        //convert to kitchenticket
        //put kitchenticketbackintojson
    }
    public void setLabels() {
        this.tableNumber = passTicket.tableNum;
        this.Ticketid = passTicket.ticketId;
        ticketID.setText(String.valueOf(this.Ticketid));
        table.setText(String.valueOf(this.tableNumber));
    }
}

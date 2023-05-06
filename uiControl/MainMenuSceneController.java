
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class MainMenuSceneController {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label name;
    @FXML
    private Label position;

    public void logOut(ActionEvent event) throws IOException{
        PosMenu a = new PosMenu();
        a.changeScene("login.fxml");
     }

     public void clockInOut() throws StreamReadException, DatabindException, IOException{
        final JFrame parent = new JFrame();
        String pin = JOptionPane.showInputDialog(parent, "Enter your pin.", null);
            
        ObjectMapper objectMapper = new ObjectMapper();
        List<employeeJson> listLog = objectMapper.readValue(new File("saves/employee.json"), new TypeReference<List<employeeJson>>(){});
        LinkedList<employeeJson> logJ = new LinkedList<employeeJson>(listLog);
        
        for (int i = 0; i<logJ.size(); i++){
        
            if (logJ.get(i).getPin().equals(pin) ){
                if(!logJ.get(i).getClocked()){
                    name.setText(logJ.get(i).getFirstName() + " " + logJ.get(i).getLastName());
                    position.setText(logJ.get(i).getPosition() );
                    logJ.get(i).setClocked(true);
                    System.out.println(logJ.get(i).getClocked());

            }
                else{
                logJ.get(i).setClocked(false);
                name.setText("");
                position.setText("");
            }
            }
        }
        ObjectMapper tableMapper = new ObjectMapper();
        tableMapper.writeValue(new File("saves/employee.json"), logJ);
        
    }



    public void switchToDineInScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("TableScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void switchToKitchenScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("KitchenScene.fxml");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTakeoutScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("TicketScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToOverviewScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("OverviewScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTicketsScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("TicketScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToInventoryScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("InventoryScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToAnalysisScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("AnalysisScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}

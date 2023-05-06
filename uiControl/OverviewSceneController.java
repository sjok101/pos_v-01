
import java.io.IOException;

import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;




public class OverviewSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

  

    public void switchToMainMenuScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("MainMenuScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoEmpMan () throws IOException{
       

        try {
            PosMenu p = new PosMenu();
            p.changeScene("EmployeeManagement.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void gotoSaleHis () throws IOException{
        
        try {
            PosMenu p = new PosMenu();
            p.changeScene("SaleHistory.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        
    }
}

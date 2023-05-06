
import java.io.IOException;

import javafx.event.*;




public class OverviewSceneController {

  

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

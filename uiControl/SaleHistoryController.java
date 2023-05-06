

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SaleHistoryController {

    @FXML
    Button back;

    @FXML
    public void gotoOverview() throws Exception{
    
        try {
            PosMenu p = new PosMenu();
            p.changeScene("OverviewScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

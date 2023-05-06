
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;


public class AnalysisSceneController implements Initializable{

    @FXML
    private ComboBox monthCombo;
    @FXML
    private TableView<jsonTicket> dataChart;
    @FXML
    private BarChart<?,?> barGraph;
    @FXML
    private LineChart<?,?> lineGraph;
    @FXML
    private CategoryAxis lineX;
    @FXML
    private NumberAxis lineY;
    @FXML
    private CategoryAxis barX;
    @FXML
    private NumberAxis barY;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // XYChart.Series set1 = new XYChart.Series<>();

        // set1.getData().add(new XYChart.Data("1", 10));
        // set1.getData().add(new XYChart.Data("2", 30));
        // set1.getData().add(new XYChart.Data("3", 20));
        // set1.getData().add(new XYChart.Data("4", 50));
        // lineGraph.getData().addAll(set1);
        
    }
    public void displaySalesAnalytics(ActionEvent event){
        clearData();
        XYChart.Series  salesSet = new XYChart.Series<>();
        salesSet = getEmployeeData();
        lineGraph.getData().addAll(salesSet);
    }

    private XYChart.Series getEmployeeData(){
        
        return null;
    }

    public void displayEmployeeAnalytics(ActionEvent event){
        clearData();
        
    }

    private void clearData(){
        lineGraph.getData().clear();
    }

    public void switchToMainMenuInScene(ActionEvent event) {
        try {
            PosMenu p = new PosMenu();
            p.changeScene("MainMenuScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    
}

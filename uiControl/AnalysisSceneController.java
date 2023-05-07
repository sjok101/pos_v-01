
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class AnalysisSceneController implements Initializable{

    ObservableList<String> monthsList = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "Augest", "September", "October", "November", "December");

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
        monthCombo.setValue("January");
        monthCombo.setItems(monthsList);
        // XYChart.Series set1 = new XYChart.Series<>();

        // set1.getData().add(new XYChart.Data("1", 10));
        // set1.getData().add(new XYChart.Data("2", 30));
        // set1.getData().add(new XYChart.Data("3", 20));
        // set1.getData().add(new XYChart.Data("4", 50));
        // lineGraph.getData().addAll(set1);
        
    }
    public void testReturn(ActionEvent event){
      System.out.println(monthCombo.getValue());

    }
    public void displaySalesAnalytics(ActionEvent event) throws IOException{
        clearData();
        XYChart.Series  salesSet = new XYChart.Series<>();
        salesSet = getMonthlyData();
        lineGraph.getData().addAll(salesSet);
        barGraph.getData().addAll(salesSet);
    }

    private XYChart.Series getMonthlyData() throws IOException{ 
        ObjectMapper objectMapper = new ObjectMapper();
        List<jsonTicket> listLog = objectMapper.readValue(new File("C:\\Users\\Joon\\Desktop\\pos_v-01\\saves\\ticketTest.json"), new TypeReference<List<jsonTicket>>(){});
        LinkedList<jsonTicket> logJ = new LinkedList<jsonTicket>(listLog);
        LinkedList<jsonTicket> logTemp = new LinkedList<jsonTicket>();
        XYChart.Series set1 = new XYChart.Series<>();
        
        // System.out.println(monthToNum(monthCombo.getValue().toString()));
        for (int i =0; i< logJ.size(); i++){

            if(logJ.get(i).getCreationTime().substring(0,2).equals(monthToNum(monthCombo.getValue().toString()))){  //compares the first two characters with months parsed to its number value
                logTemp.add(logJ.get(i));   //add matching months into temp
                //System.out.println(i);
                //implement adding to set
            }
        }

        int dailyProfit = 0;
        String day = null;
        for (int i = 0; i< logTemp.size(); i++){
            if(dailyProfit ==0){                                        //set dailyProfit for first run
                dailyProfit = Integer.parseInt(logTemp.get(i).getTotal());
                day = logTemp.get(i).getCreationTime().substring(3, 5);
                System.out.println(dailyProfit);
            }
            if(i==logTemp.size()-1){ //end of tickets or only 1 ticket
                System.out.println("adding to "+ day );
                set1.getData().add(new XYChart.Data(day, dailyProfit));
            }
            if(i<logTemp.size()-1){
            if(logTemp.size()>1 && logTemp.get(i).getCreationTime().substring(3, 5).equals(logTemp.get(i+1).getCreationTime().substring(3, 5))){ //more than 1 ticket with same day
                System.out.println("adding profits");
                dailyProfit += Integer.parseInt(logTemp.get(i+1).getTotal());
            } else { //ticket 1 does not have same day as ticket 2
                System.out.println("adding to "+ day );
                set1.getData().add(new XYChart.Data(day, dailyProfit));
                dailyProfit = 0;
            }
            }
        }

        return set1;
    }
    private String monthToNum(String month){
        switch (month) {
            case "January":
                return "01";
            case "February":
                return "02";
            case "March":
                return "03";
            case "April":
                return "04";
            case "May":
                return "05";
            case "June":
                return "06";
            case "July":
                return "07";        
            case "Augest":
                return "08";
            case "September":
                return "09";
            case "October":
                return "10";
            case "November":
                return "11";
            case "December":
                return "12";
            default:
                return "\0";
        }
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

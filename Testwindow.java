import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.event.*;
import java.io.IOException;


public class Testwindow extends Application{

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("Ticketscene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        stg.setScene(scene);
        stg.show();
        //stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
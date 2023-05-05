
<<<<<<< HEAD
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.event.*;
=======
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c


public class PosMenu extends Application{

<<<<<<< HEAD
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
=======
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
=======

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        // stg.getScene().setRoot(pane);
        stg.setScene(new Scene(pane));
        stg.show();
    }
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
    public static void main(String[] args) {
        launch(args);
    }
}

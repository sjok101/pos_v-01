package uiControl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.event.*;


public class PosMenu extends Application{

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
             primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
        Button btn = new Button();
        btn.setText("hello world");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("hellow world");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root,600,600);
        primaryStage.setTitle("world of hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

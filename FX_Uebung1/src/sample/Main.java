package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Label _label;

    @Override public void init(){
        _label = new Label("Hello World");
    }

    @Override
    public void start(Stage stage) throws Exception{
        StackPane root = new StackPane();
        root.getChildren().add(_label);
        Scene scene = new Scene(root, 200, 200);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    @Override public void stop(){

    }


    public static void main(String[] args) {
        launch(args);
    }
}

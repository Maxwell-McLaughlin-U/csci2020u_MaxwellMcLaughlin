package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import server.Server;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane plane = new GridPane();
        TextArea txtMain = new TextArea();
        plane.add(txtMain,0,0);

        Server mainServer = new Server(8080,txtMain);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(plane, 300, 275));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

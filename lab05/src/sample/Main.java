package sample;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class Main extends Application {

    @Override


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("lab05");
        primaryStage.setScene(new Scene(root, 480, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


    }
}

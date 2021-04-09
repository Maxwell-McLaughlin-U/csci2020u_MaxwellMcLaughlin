package server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {
    private BufferedReader in;
    private ServerSocket serverSocket = null;

    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane plane = new GridPane();
        TextArea txtMain = new TextArea();
        txtMain.setEditable(true);
        plane.add(txtMain,0,0);
        Button btnExit = new Button("Exit");

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        plane.add(btnExit,0,1);


        new Thread(() -> {
            try {

                ServerSocket serverSocket = new ServerSocket(8080);

                //infinite loop like example in tutorial
                while (true) {
                    // Listen for a connection request, add new connection
                    Socket socket = serverSocket.accept();
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    txtMain.appendText(in.readLine() + "\n");

                    //serverSocket.close();
                }
            } catch (IOException e) {
                //idk
            }

            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();
//
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(plane, 300, 275));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

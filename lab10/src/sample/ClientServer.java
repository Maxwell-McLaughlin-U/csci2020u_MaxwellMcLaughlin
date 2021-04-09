package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer extends Application {


    public void start(Stage primaryStage) throws Exception{


        Label lblUser = new Label("Username: ");
        Label lblMes = new Label("Message: ");
        TextField txtUser = new TextField();
        TextField txtMes = new TextField();
        Button btnSend = new Button("Send");
        Button btnExit = new Button("Exit");
        GridPane plane = new GridPane();
        plane.add(lblUser,0,0);
        plane.add(lblMes,0,1);
        plane.add(txtUser,1,0);
        plane.add(txtMes,1,1);
        plane.add(btnSend,0,2);
        plane.add(btnExit,0,3);


        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BufferedReader in;
                PrintWriter out;


                String hostname = "localhost";
                //String uri = args[2];
                int port = 8080;

                Socket socket = null;
                try {
                    socket = new Socket(hostname, port);

                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     out = new PrintWriter(socket.getOutputStream());
                    // send the request
                    //System.out.println("Userame: " + txtUser.getText() + "Message: " + txtMes.getText());


                    out.println("Userame: " + txtUser.getText() + " Message: " + txtMes.getText());
                    out.flush();


                    in.close();
                    out.close();
                    //socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });








        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab10 Client");
        primaryStage.setScene(new Scene(plane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }


}

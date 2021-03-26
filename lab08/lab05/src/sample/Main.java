package sample;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static sample.Controller.*;




public class Main extends Application {
    public static holder hld = new holder();
    @Override



    public void start(Stage primaryStage) throws Exception{
        final String[] strFile = new String[1];
        strFile[0] = "itWorked.csv";


        MenuBar menuRibbon = new MenuBar();

        Menu menuDrop = new Menu("File");
        //menuRibbon.getMenus().addAll(menuDrop);

        MenuItem menExit = new MenuItem("Exit");
        menExit.setOnAction(e ->{System.exit(0);});

        MenuItem menNew = new MenuItem("New");
        menNew.setOnAction(e ->{});

        MenuItem menOpen = new MenuItem("Open");
        menOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                        new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                if (selectedFile != null) {

                }

                    strFile[0] = (selectedFile.getAbsolutePath()).toString();

                String[] strSplit;
                ObservableList<StudentRecord> studentsEnter = DataSource.getAllMarks();
                try {
                    Scanner fileReader = new Scanner(selectedFile);
                    while(fileReader.hasNextLine()){
                        strSplit = fileReader.nextLine().split(",");
                        studentsEnter.add(new StudentRecord(strSplit[0],Float.parseFloat(strSplit[1]),
                                Float.parseFloat(strSplit[2]),Float.parseFloat(strSplit[3])));
                    }
                    hld.students = studentsEnter;//---
                    //Controller.openVals();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        MenuItem menSave = new MenuItem("Save");
        menSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){

                try {
                    saveAsCSV(strFile[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        MenuItem menSaveAs = new MenuItem("Save as");
        menSaveAs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){

                try {
                    saveAsCSV("itWorked.csv");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


        menuDrop.getItems().add(menExit);
        menuDrop.getItems().add(menNew);
        menuDrop.getItems().add(menOpen);
        menuDrop.getItems().add(menSave);
        menuDrop.getItems().add(menSaveAs);

        menuRibbon.getMenus().add(menuDrop);






        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        FlowPane myScene = new FlowPane(root, menuRibbon);

        primaryStage.setTitle("lab05");
        primaryStage.setScene(new Scene(myScene, 480, 400));
        primaryStage.show();

        System.out.println(hld.students);//--
        //saveAsCSV("a.txt");
    }

    public void saveAsCSV(String strPath) throws IOException {




        PrintWriter myWriter = new PrintWriter(strPath);
        hld.students.forEach(p -> {//--

            myWriter.println(p.toString());

        });
        System.out.println("call");
        myWriter.close();
    }



    public static void main(String[] args) {
        launch(args);


    }
}

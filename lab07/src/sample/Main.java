package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scanner fileScanner = new Scanner(new File("resources\\weatherwarnings-2015.csv"));

        HashMap<String,Integer> countMap = new HashMap<String,Integer>();

        while(fileScanner.hasNextLine()){
            String strLine = fileScanner.nextLine();

            String[] strSplit = strLine.split(",");

            if(countMap.containsKey(strSplit[5])){
                countMap.put(strSplit[5],countMap.get(strSplit[5]) + 1);
            }else{
                countMap.put(strSplit[5],1);
            }

        }

        double dblDenominator = countMap.get("FLASH FLOOD") + countMap.get("TORNADO") + countMap.get("SEVERE THUNDERSTORM") +
                countMap.get("SPECIAL MARINE");

        Canvas canvas = new Canvas(1000,1000);
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setStroke(Color.BLACK);


        context.setFill(Color.GREEN);
        double dblStart = (360*(countMap.get("FLASH FLOOD") / dblDenominator));
        context.fillArc(100, 100, 500, 500, 0, dblStart, ArcType.ROUND);

        context.setFill(Color.RED);
        context.fillArc(100, 100, 500, 500, dblStart, (360*(countMap.get("TORNADO") / dblDenominator)), ArcType.ROUND);
        dblStart += (360*(countMap.get("TORNADO") / dblDenominator));

        context.setFill(Color.BLUE);
        context.fillArc(100, 100, 500, 500, dblStart, (360*(countMap.get("SEVERE THUNDERSTORM") / dblDenominator)), ArcType.ROUND);
        dblStart += (360*(countMap.get("SEVERE THUNDERSTORM") / dblDenominator));

        context.setFill(Color.BLACK);
        context.fillArc(100, 100, 500, 500, dblStart, (360*(countMap.get("SPECIAL MARINE") / dblDenominator)), ArcType.ROUND);
        //dblStart += (360*(countMap.get("SPECIAL MARINE") / dblDenominator));


        context.setStroke(Color.GREEN);
        context.setFill(Color.GREEN);
        context.fillRect(700,100,50,25);
        context.fillText("FLASH FLOOD",760,115,500);

        context.setStroke(Color.RED);
        context.setFill(Color.RED);
        context.fillRect(700,150,50,25);
        context.fillText("TORNADO",760,165,500);

        context.setStroke(Color.BLUE);
        context.setFill(Color.BLUE);
        context.fillRect(700,200,50,25);
        context.fillText("SEVERE THUNDERSTORM",760,215,500);

        context.setStroke(Color.BLACK);
        context.setFill(Color.BLACK);
        context.fillRect(700,250,50,25);
        context.fillText("SPECIAL MARINE",760,275,500);

        primaryStage.setTitle("Lab07");
        FlowPane pane = new FlowPane(canvas);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        Scene mainScene = new Scene(pane, 1000, 1000);

        primaryStage.setScene(mainScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

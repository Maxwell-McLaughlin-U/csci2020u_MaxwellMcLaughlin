package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        List<Double> lstGOOG = downloadStockPrices("GOOG");
        List<Double> lstAMZN = downloadStockPrices("AMZN");



        Canvas mainCanvas = new Canvas(1000,500);
        GraphicsContext grafc = mainCanvas.getGraphicsContext2D();
        grafc.setFill(Color.BLACK);
        grafc.setStroke(Color.BLACK);
        grafc.setLineWidth(5);

        drawLinePlot(grafc,lstGOOG,lstAMZN);

        FlowPane pane = new FlowPane(mainCanvas);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab9");
        primaryStage.setScene(new Scene(pane, 1000, 500));
        primaryStage.show();

        //InputStream inStream = conn.getInputStream();
    }


    public List<Double> downloadStockPrices(String tag) throws IOException, ParseException {

        long begin = LocalDate.of(1970,1,1)
                .atStartOfDay(ZoneId.systemDefault()).toEpochSecond();

        long ending = LocalDate.of(2020,12,31)
                .atStartOfDay(ZoneId.systemDefault()).toEpochSecond();

        List<Double> outVals = new ArrayList<Double>();

        String sURL = "https://query1.finance.yahoo.com/v7/finance/download/" + tag + "?peri" +
                "od1=" + begin + "&period2=" + ending + "&interval=1mo&events=history&" +
                "includeAdjustedClose=true";
        URL netURL = new URL(sURL);

        URLConnection conn = netURL.openConnection();
        conn.setDoOutput(false);
        conn.setDoInput(true);

        BufferedReader myReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        double endingVal = 0.0f;

        String strLine = myReader.readLine();
        strLine = myReader.readLine();

        while(strLine != null){

            String[] arrLine = strLine.split(",");
            //System.out.println(arrLine[4]);
            outVals.add(Double.parseDouble(arrLine[4]));
            strLine = myReader.readLine();
        }
        return outVals;
    }

    public void drawLinePlot(GraphicsContext gc, List<Double> stock1, List<Double> stock2){
        gc.strokeLine(50,450,950,450);
        gc.strokeLine(50,450,50,50);

        gc.setFill(Color.RED);
        gc.setStroke(Color.RED);
        plotLine(gc,stock1);

        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLUE);
        plotLine(gc,stock2);
    }

    public void plotLine(GraphicsContext gc ,List<Double> lineData){
        double prevX = 50;
        double prevY = 450;

        double dblXinterval = 900.0 / lineData.size() ;
        double dblYscaler = Collections.max(lineData) / 400.0;

        for (Double current : lineData) {
            gc.strokeLine(prevX,prevY,prevX+dblXinterval,450 - (current/dblYscaler));
            prevX = prevX+dblXinterval;
            prevY = 450 - (current/dblYscaler);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

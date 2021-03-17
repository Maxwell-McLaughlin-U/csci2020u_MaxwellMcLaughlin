package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
public class Main extends Application {


    @Override public void start(Stage stage) {
        stage.setTitle("Lab6");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> chart1 = new BarChart<String,Number>(xAxis,yAxis);
        chart1.setTitle("Housing Prices");
        xAxis.setLabel("Year");
        yAxis.setLabel("Price");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("House Price");
        series1.getData().add(new XYChart.Data("1", 247381.0));
        series1.getData().add(new XYChart.Data("2", 264171.4));
        series1.getData().add(new XYChart.Data("3", 287715.3));
        series1.getData().add(new XYChart.Data("4", 294736.1));
        series1.getData().add(new XYChart.Data("5", 308431.4));
        series1.getData().add(new XYChart.Data("6", 322635.9));
        series1.getData().add(new XYChart.Data("7", 340253.0));
        series1.getData().add(new XYChart.Data("8", 363153.7));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Commercial Price");
        series2.getData().add(new XYChart.Data("1", 1121585.3));
        series2.getData().add(new XYChart.Data("2", 1219479.5));
        series2.getData().add(new XYChart.Data("3", 1246354.2));
        series2.getData().add(new XYChart.Data("4", 1295364.8));
        series2.getData().add(new XYChart.Data("5", 1335932.6));
        series2.getData().add(new XYChart.Data("6", 1472362.0));
        series2.getData().add(new XYChart.Data("7", 1583521.9));
        series2.getData().add(new XYChart.Data("8", 1613246.3));


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("18-25", 684),
                        new PieChart.Data("26-35", 1021),
                        new PieChart.Data("36-45", 2453),
                        new PieChart.Data("46-55", 3173),
                        new PieChart.Data("56-65", 1869),
                        new PieChart.Data("65+", 2247));

        final PieChart chart2 = new PieChart(pieChartData);
        chart2.setTitle("purchase by age group");




        FlowPane pane = new FlowPane(chart1, chart2);

        //Scene scene  = new Scene(chart1,800,600);
        Scene scene  = new Scene(pane,1000,600);
        //((Group) scene.getRoot()).getChildren().add(chart);//ghvvvvvvvvvvvv
        chart1.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();

        for (XYChart.Series<String, Number> series : chart1.getData()) {
            if(series.getName().equals("House Price"))
            {
                System.out.println("Series name: " + series.getName());
                for(Data data : series.getData())
                {
                    data.getNode().setStyle("-fx-bar-fill: blue;");
                }
            }
        }

        for (XYChart.Series<String, Number> series : chart1.getData()) {
            if(series.getName().equals("Commercial Price"))
            {
                System.out.println("Series name: " + series.getName());
                for(Data data : series.getData())
                {
                    data.getNode().setStyle("-fx-bar-fill: red;");
                }
            }
        }

        for(Node node : chart1.lookupAll("Label.chart-legend-item"))
        {
            Label tempLabel = (Label)node;
            if(tempLabel.getText().equals("House Price"))
            {
                tempLabel.getGraphic().setStyle("-fx-bar-fill: blue;");
            }
        }

        for(Node node : chart1.lookupAll("Label.chart-legend-item"))
        {
            Label tempLabel = (Label)node;
            if(tempLabel.getText().equals("Commercial Price"))
            {
                tempLabel.getGraphic().setStyle("-fx-bar-fill: red;");
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
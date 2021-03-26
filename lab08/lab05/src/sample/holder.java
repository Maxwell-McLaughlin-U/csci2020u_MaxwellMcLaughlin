package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.io.PrintWriter;



public class holder {

    public   ObservableList<StudentRecord> students = DataSource.getAllMarks();

    public void openPass(){
        //Controller.openVals();
    }

}

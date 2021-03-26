package sample;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
//import javax.swing.text.html.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.event.Event;
import javafx.event.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

public class Controller {

    @FXML
    TableView<StudentRecord> tblMain;

    @FXML
    TableColumn clmSID;
    @FXML
    TableColumn clmAssignments;
    @FXML
    TableColumn clmMidterm;
    @FXML
    TableColumn clmFinal;

    private ObservableList<StudentRecord> data = FXCollections.observableArrayList();
    private String strFileName;
    //public ObservableList<StudentRecord> students = DataSource.getAllMarks();
    public String strFile;


    @FXML public void initialize() {



        tblMain.setEditable(true);
        tblMain.setItems(data);
        Main.hld.students.forEach(p->data.add(p));


        clmSID.setEditable(true);
        clmSID.setCellFactory(TextFieldTableCell.forTableColumn());
        clmSID.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<StudentRecord, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setID(t.getNewValue())
        );

        clmAssignments.setEditable(true);
        clmAssignments.setCellFactory(TextFieldTableCell.forTableColumn());
        clmAssignments.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<StudentRecord, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setAssignments(Float.parseFloat(t.getNewValue()))
        );

        clmMidterm.setEditable(true);
        clmMidterm.setCellFactory(TextFieldTableCell.forTableColumn());
        clmMidterm.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<StudentRecord, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setMidterm(Float.parseFloat(t.getNewValue()))
        );

        clmFinal.setEditable(true);
        clmFinal.setCellFactory(TextFieldTableCell.forTableColumn());
        clmFinal.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<StudentRecord, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setFinal(Float.parseFloat(t.getNewValue()))
        );
        //tblMain.getItems().setAll(DataSource.getAllMarks());
    }

    public void setFileName(String strFile){
        this.strFile = strFile;
    }

    public void openVals(){
        tblMain.setItems(Main.hld.students);
    }




}

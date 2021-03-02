package sample;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
//import javax.swing.text.html.ListView;

public class Controller {
    @FXML
    TableView tblMain;

    @FXML public void initialize() {


        tblMain.getItems().setAll(DataSource.getAllMarks());
    }

}

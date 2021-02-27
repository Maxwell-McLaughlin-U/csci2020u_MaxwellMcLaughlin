package sample;
import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class Controller {

    @FXML TextField txtUserName;
    @FXML TextField txtPassword;
    @FXML TextField txtFullName;
    @FXML TextField txtEmail;
    @FXML TextField txtPhone;
    @FXML TextField txtBirth;

    public void buttonClicked(Event e){
        System.out.print("User: " + txtUserName.getText() + " Password: " + txtPassword.getText() +
                " Full Name: " + txtFullName.getText() + " email: " + txtEmail.getText() + " Phone#: " + txtPhone.getText() +
                " Birthday: " + txtBirth.getText());
    }

}

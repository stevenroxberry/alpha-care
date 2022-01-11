/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;

/**
 * FXML Controller class
 *
 * @author apple
 */

public class LoginUICntl implements Initializable {

    @FXML
    private TextField usernameTextfield;

    @FXML
    private PasswordField passwordTextfield;

    @FXML
    private Label loginErrorLabel;

    @FXML
    private Button loginButton;
    
    @FXML
    private CheckBox doctorStatus;

    public LoginUICntl() {
        Account.getAccount();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    //Authenticates the user based on doctor status
    @FXML 
    public void authorizeUser(ActionEvent event) throws IOException
    {
        if (doctorStatus.isSelected())
        {
            authorize(event, true);
        } else {
            authorize(event, false);
        }
    }
    
    //Checks user credentials and either moves to Doctor/Patient dashboard or display error
    @FXML
    public void authorize(ActionEvent event, boolean doctorStatus) throws IOException {

        boolean authenticate = false;
        String path;
        
        if (doctorStatus){
            authenticate = Account.getAccount().AuthenticateDoctor(usernameTextfield.getText(), passwordTextfield.getText());
        } else {
            authenticate =  Account.getAccount().AuthenticatePatient(usernameTextfield.getText(), passwordTextfield.getText());
        }
        
        if (authenticate) {    
            if (doctorStatus){
                //go to DoctorDashboard
                path = "/View/DoctorDashboard.fxml";
            } else {
                //go to PatientDashboard
                path = "/View/PatientDashboard.fxml";
            }
            
            Parent fileViewParent = FXMLLoader.load(getClass().getResource(path));
            Scene fileView = new Scene(fileViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(fileView);
            window.show();
            this.getLoginErrorLabel().setOpacity(0);

        } else {
            //display error message
            this.getLoginErrorLabel().setOpacity(1);
        }

    }

    /**
     * @return the loginErrorLabel
     */
    public Label getLoginErrorLabel() {
        return loginErrorLabel;
    }

    /**
     * @param loginErrorLabel the loginErrorLabel to set
     */
    public void setLoginErrorLabel(Label loginErrorLabel) {
        this.loginErrorLabel = loginErrorLabel;
    }

}

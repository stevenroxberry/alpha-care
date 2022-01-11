/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import model.PatientList;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class DoctorDashboardCntl implements Initializable {

    private PatientList patientList;
    private ObservableList<String> names;
    private int selectedId;

    @FXML
    private Button logoutButton;

    @FXML
    private Label alphaCareLabel;

    @FXML
    private Label dateText;

    @FXML
    private Button testButton;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private ListView<String> patientListView;

    @FXML
    private ListView<String> appointmentList;

    @FXML
    private Label patientNumber;

    @FXML
    private Label appointmentNumber;
    
    @FXML
    private Label totalNumber;

    /*
    ObservableList<String> names = FXCollections.observableArrayList(
          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
    ListView<String> listView = new ListView<String>(names);
     */
    public DoctorDashboardCntl() {
        patientList = new PatientList();
        patientList.loadXMLList();

        names = FXCollections.observableArrayList();

        for (int i = 0; i < patientList.getPatientList().size(); ++i) {
            names.add(patientList.getPatient(i).getName());
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalNumber.setText(Integer.toString(patientList.getPatientList().size()));
        patientListView.setItems(names);
    }

    public void navigateHome(Event event) throws IOException {
        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/DoctorDashboard.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }

    public void logout(ActionEvent event) throws IOException {
        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }

    //navigate to Covid Survey
    public void navigateMedicalRecord(ActionEvent event) throws IOException {

        if (patientListView.getSelectionModel().getSelectedItem() != null)
        {
            for (int i = 0; i < patientList.getPatientList().size(); ++i)
            {
                if (patientList.getPatient(i).getName() == patientListView.getSelectionModel().getSelectedItem().toString())
                {
                    selectedId = i;
                }
            }
       
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PatientMedicalRecord.fxml"));
            loader.setController(new PatientMedicalRecordCntl(selectedId, patientList));
            Parent fileViewParent = loader.load();

            Scene fileView = new Scene(fileViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(fileView);
            window.show();
        }

    }

    /**
     * @return the patientList
     */
    public PatientList getDoctorList() {
        return patientList;
    }

    /**
     * @param doctorList the patientList to set
     */
    public void setDoctorList(PatientList doctorList) {
        this.patientList = doctorList;
    }

    /**
     * @return the logoutButton
     */
    public Button getLogoutButton() {
        return logoutButton;
    }

    /**
     * @param logoutButton the logoutButton to set
     */
    public void setLogoutButton(Button logoutButton) {
        this.logoutButton = logoutButton;
    }

    /**
     * @return the alphaCareLabel
     */
    public Label getAlphaCareLabel() {
        return alphaCareLabel;
    }

    /**
     * @param alphaCareLabel the alphaCareLabel to set
     */
    public void setAlphaCareLabel(Label alphaCareLabel) {
        this.alphaCareLabel = alphaCareLabel;
    }

    /**
     * @return the dateText
     */
    public Label getDateText() {
        return dateText;
    }

    /**
     * @param dateText the dateText to set
     */
    public void setDateText(Label dateText) {
        this.dateText = dateText;
    }

    /**
     * @return the testButton
     */
    public Button getTestButton() {
        return testButton;
    }

    /**
     * @param testButton the testButton to set
     */
    public void setTestButton(Button testButton) {
        this.testButton = testButton;
    }

    /**
     * @return the doctorNameLabel
     */
    public Label getDoctorNameLabel() {
        return doctorNameLabel;
    }

    /**
     * @param doctorNameLabel the doctorNameLabel to set
     */
    public void setDoctorNameLabel(Label doctorNameLabel) {
        this.doctorNameLabel = doctorNameLabel;
    }

    /**
     * @return the patientListView
     */
    public ListView getPatientList() {
        return patientListView;
    }

    /**
     * @param patientList the patientListView to set
     */
    public void setPatientList(ListView patientList) {
        this.patientListView = patientList;
    }

    /**
     * @return the appointmentList
     */
    public ListView getAppointmentList() {
        return appointmentList;
    }

    /**
     * @param appointmentList the appointmentList to set
     */
    public void setAppointmentList(ListView appointmentList) {
        this.appointmentList = appointmentList;
    }

    /**
     * @return the patientNumber
     */
    public Label getPatientNumber() {
        return patientNumber;
    }

    /**
     * @param patientNumber the patientNumber to set
     */
    public void setPatientNumber(Label patientNumber) {
        this.patientNumber = patientNumber;
    }

    /**
     * @return the appointmentNumber
     */
    public Label getAppointmentNumber() {
        return appointmentNumber;
    }

    /**
     * @param appointmentNumber the appointmentNumber to set
     */
    public void setAppointmentNumber(Label appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

}

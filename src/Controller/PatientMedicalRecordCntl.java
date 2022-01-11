/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.PatientList;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class PatientMedicalRecordCntl implements Initializable {

    private PatientList patientList;
    private int selectedId;
    private ArrayList<String> patientPrescriptions;

    @FXML
    private ChoiceBox covidImmunizedField;

    @FXML
    private TextField genderSelector;

    @FXML
    private TextField insuranceField;

    @FXML
    private TextField bloodTypeField;

    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;

    @FXML
    private TextArea prescriptionField;

    @FXML
    private Label patientName;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;
    
    @FXML
    private Button exportButton;

    @FXML
    private Label messageLabel;

    public PatientMedicalRecordCntl() {
    }

    public PatientMedicalRecordCntl(int selectedId, PatientList patientList) {
        this.setSelectedId(selectedId);
        this.setPatientList(patientList);
    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

        getCovidImmunizedField().getItems().addAll("Yes", "No");

        getPatientName().setText(getPatientList().getPatient(getSelectedId()).getName());
        getWeightField().setText(getPatientList().getPatient(getSelectedId()).getPatientRecord().getWeight());
        getHeightField().setText(getPatientList().getPatient(getSelectedId()).getPatientRecord().getHeight());
        getInsuranceField().setText(getPatientList().getPatient(getSelectedId()).getPatientRecord().getInsuranceInfo());
        getBloodTypeField().setText(getPatientList().getPatient(getSelectedId()).getPatientRecord().getBloodType());
        getGenderSelector().setText(getPatientList().getPatient(getSelectedId()).getPatientRecord().getGender());

        if (getPatientList().getPatient(getSelectedId()).getPatientRecord().isCovidImmunized()) {
            getCovidImmunizedField().getSelectionModel().clearAndSelect(1);
        } else {
            getCovidImmunizedField().getSelectionModel().clearAndSelect(0);
        }

        //display prescriptions
        getPrescriptionField().setText(buildPrescriptionsString(getPatientList().getPatient(getSelectedId()).getPatientRecord().getPrescriptions()));

    }

    public String buildPrescriptionsString(String[] prescriptions) {
        StringBuilder prescriptionsBuilder = new StringBuilder("");

        for (int i = 0; i < prescriptions.length; ++i) {
            prescriptionsBuilder.append(prescriptions[i]);
            if (i < prescriptions.length - 1) {
                prescriptionsBuilder.append(", ");
            }
        }

        return prescriptionsBuilder.toString();
    }

    public void exportMedicalRecord(Event event) throws IOException {
        getPatientList().printPatient(getSelectedId());
        getMessageLabel().setText("Record Exported Successfully");
        getMessageLabel().setOpacity(1);
    }

    public void navigateHome(Event event) throws IOException {

        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/DoctorDashboard.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }

    public void savePatientRecord(Event event) throws IOException {

        getPatientList().getPatient(getSelectedId()).getPatientRecord().setWeight(getWeightField().getText());
        getPatientList().getPatient(getSelectedId()).getPatientRecord().setHeight(getHeightField().getText());
        getPatientList().getPatient(getSelectedId()).getPatientRecord().setInsuranceInfo(getInsuranceField().getText());
        getPatientList().getPatient(getSelectedId()).getPatientRecord().setBloodType(getBloodTypeField().getText());
        getPatientList().getPatient(getSelectedId()).getPatientRecord().setWeight(getWeightField().getText());
        getPatientList().getPatient(getSelectedId()).getPatientRecord().setGender(getGenderSelector().getText());

        if (getCovidImmunizedField().getSelectionModel().getSelectedIndex() == 0) {
            getPatientList().getPatient(getSelectedId()).getPatientRecord().setCovidImmunized(false);
        } else {
            getPatientList().getPatient(getSelectedId()).getPatientRecord().setCovidImmunized(true);
        }

        setPatientPrescriptions(new ArrayList<String>());

        for (String patient : getPrescriptionField().getText().split(",")) {
            getPatientPrescriptions().add(patient.trim());
        }

        getPatientList().getPatient(getSelectedId()).getPatientRecord().setPrescriptions(getPatientPrescriptions().toArray(new String[0]));

        getMessageLabel().setText("Record Saved Successfully");
        getMessageLabel().setOpacity(1);
        getPatientList().saveXMLList();
    }

    /**
     * @return the patientList
     */
    public PatientList getPatientList() {
        return patientList;
    }

    /**
     * @param patientList the patientList to set
     */
    public void setPatientList(PatientList patientList) {
        this.patientList = patientList;
    }

    /**
     * @return the selectedId
     */
    public int getSelectedId() {
        return selectedId;
    }

    /**
     * @param selectedId the selectedId to set
     */
    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    /**
     * @return the patientPrescriptions
     */
    public ArrayList<String> getPatientPrescriptions() {
        return patientPrescriptions;
    }

    /**
     * @param patientPrescriptions the patientPrescriptions to set
     */
    public void setPatientPrescriptions(ArrayList<String> patientPrescriptions) {
        this.patientPrescriptions = patientPrescriptions;
    }

    /**
     * @return the covidImmunizedField
     */
    public ChoiceBox getCovidImmunizedField() {
        return covidImmunizedField;
    }

    /**
     * @param covidImmunizedField the covidImmunizedField to set
     */
    public void setCovidImmunizedField(ChoiceBox covidImmunizedField) {
        this.covidImmunizedField = covidImmunizedField;
    }

    /**
     * @return the genderSelector
     */
    public TextField getGenderSelector() {
        return genderSelector;
    }

    /**
     * @param genderSelector the genderSelector to set
     */
    public void setGenderSelector(TextField genderSelector) {
        this.genderSelector = genderSelector;
    }

    /**
     * @return the insuranceField
     */
    public TextField getInsuranceField() {
        return insuranceField;
    }

    /**
     * @param insuranceField the insuranceField to set
     */
    public void setInsuranceField(TextField insuranceField) {
        this.insuranceField = insuranceField;
    }

    /**
     * @return the bloodTypeField
     */
    public TextField getBloodTypeField() {
        return bloodTypeField;
    }

    /**
     * @param bloodTypeField the bloodTypeField to set
     */
    public void setBloodTypeField(TextField bloodTypeField) {
        this.bloodTypeField = bloodTypeField;
    }

    /**
     * @return the weightField
     */
    public TextField getWeightField() {
        return weightField;
    }

    /**
     * @param weightField the weightField to set
     */
    public void setWeightField(TextField weightField) {
        this.weightField = weightField;
    }

    /**
     * @return the heightField
     */
    public TextField getHeightField() {
        return heightField;
    }

    /**
     * @param heightField the heightField to set
     */
    public void setHeightField(TextField heightField) {
        this.heightField = heightField;
    }

    /**
     * @return the prescriptionField
     */
    public TextArea getPrescriptionField() {
        return prescriptionField;
    }

    /**
     * @param prescriptionField the prescriptionField to set
     */
    public void setPrescriptionField(TextArea prescriptionField) {
        this.prescriptionField = prescriptionField;
    }

    /**
     * @return the patientName
     */
    public Label getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(Label patientName) {
        this.patientName = patientName;
    }

    /**
     * @return the cancelButton
     */
    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * @param cancelButton the cancelButton to set
     */
    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    /**
     * @return the saveButton
     */
    public Button getSaveButton() {
        return saveButton;
    }

    /**
     * @param saveButton the saveButton to set
     */
    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    /**
     * @return the messageLabel
     */
    public Label getMessageLabel() {
        return messageLabel;
    }

    /**
     * @param messageLabel the messageLabel to set
     */
    public void setMessageLabel(Label messageLabel) {
        this.messageLabel = messageLabel;
    }

}

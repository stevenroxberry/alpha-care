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
import javafx.stage.Stage;
import model.Account;
import model.CovidSurvey;
import model.PatientList;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class PatientDashboardCntl implements Initializable
{

    private PatientList patientList;
    private int currentIndex;

    @FXML
    private Button logoutButton;
    
    @FXML
    private Button surveyStart;
    
    @FXML
    private Button surveyReset;
            
    @FXML
    private Label covidHeadingLabel;
    
    @FXML
    private Label covidText;

    @FXML
    private Label alphaCareLabel;

    @FXML
    private Label patientHeightText;

    @FXML
    private Label patientWeightText;

    @FXML
    private Label patientGenderText;

    @FXML
    private Label patientBloodTypeText;

    @FXML
    private Label patientInsuranceText;

    @FXML
    private Label patientCovidImmunizedText;

    @FXML
    private ListView patientPrescriptionsText;

    @FXML
    private Label patientIDText;

    @FXML
    private Label patientNameText;

    @FXML
    private Label patientEmailText;

    @FXML
    private Label patientPhoneNumberText;

    @FXML
    private Label patientLocationText;
    
    @FXML
    private Label questionOneLabel;
    
    @FXML
    private Label questionTwoLabel;
    
    @FXML
    private Label questionThreeLabel;
    
    @FXML
    private Label riskAssessmentLabel;
    
    @FXML
    private Label answerOneLabel;
    
    @FXML
    private Label answerTwoLabel;
    
    @FXML
    private Label answerThreeLabel;
    
    @FXML
    private Label answerFourLabel;

    
    public PatientDashboardCntl()
    {
        patientList = new PatientList();

//        String[] patientPrescription11211 = {"Sildenafil", "Ibuprofen", "Azithromycin"};
//        String[] patientPrescription11311 = {"Metoprolol", "Omeprazole", "Prednisone", "Bupropion"};
//        String[] patientPrescription11411 = {"Losartan", "Albuterol", "Metformin", "Atorvastatin", "Oxycodone", "Tamsulosin", "Dextroamphetamine", "Bupropion", "Rosuvastatin"};
//        
//        MedicalRecord patientRecord11211 = new MedicalRecord(true, "O-", "HMS", patientPrescription11211, "Male", "5' 11''", "180 lbs");
//        MedicalRecord patientRecord11311 = new MedicalRecord(false, "AB+", "Blood Cross Blue Shield", patientPrescription11311, "Male", "6' 2''", "145 lbs");
//        MedicalRecord patientRecord11411 = new MedicalRecord(false, "B-", "AETNA", patientPrescription11411, "Female", "5' 0''", "360 lbs");
//
//        Patient patient11211 = new Patient(11211, "Kurtis Miles", "kurtisemail@email.com", "814-555-5555", "Chicago, IL", patientRecord11211, new CovidSurvey());
//        Patient patient11311 = new Patient(11311, "John Doe", "johndoe@email.com", "814-555-5555", "Nowhere, PA", patientRecord11311, new CovidSurvey());
//        Patient patient11411 = new Patient(11411, "Sally Mae", "sallymae@email.com", "814-555-5555", "Nowhere, NY", patientRecord11411, new CovidSurvey());
//
//        patientList.getPatientList().add(patient11211);
//        patientList.getPatientList().add(patient11311);
//        patientList.getPatientList().add(patient11411);
//       
//        patientList.saveXMLList();

        patientList.loadXMLList();


        for (int i = 0; i < patientList.getPatientList().size(); ++i)
        {
            if (patientList.getPatientList().get(i).getPatientId() == Account.getAccount().getAccountID()) {
                this.setCurrentIndex(i);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        //initialize labels in Medical Record tab with patient info
        this.getPatientHeightText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getHeight());
        this.getPatientWeightText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getWeight());
        this.getPatientGenderText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getGender());
        this.getPatientBloodTypeText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getBloodType());
        this.getPatientInsuranceText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getInsuranceInfo());
        this.getPatientInsuranceText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getInsuranceInfo());
        this.getPatientCovidImmunizedText().setText(String.valueOf(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().isCovidImmunized()));

        for (int i = 0; i < this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getPrescriptions().length; ++i) {
            this.getPatientPrescriptionsText().getItems().add(this.getPatientList().getPatient(getCurrentIndex()).getPatientRecord().getPrescriptions()[i]);
        }

        //initialize labels in Dashboard tab with patient info
        this.getPatientIDText().setText(String.valueOf(this.getPatientList().getPatient(getCurrentIndex()).getPatientId()));
        this.getPatientNameText().setText(this.getPatientList().getPatient(getCurrentIndex()).getName());
        this.getPatientEmailText().setText(this.getPatientList().getPatient(getCurrentIndex()).getEmail());
        this.getPatientPhoneNumberText().setText(this.getPatientList().getPatient(getCurrentIndex()).getPhoneNumber());
        this.getPatientLocationText().setText(this.getPatientList().getPatient(getCurrentIndex()).getLocation());
        
        //conditionally render covid survey
        if (this.getPatientList().getPatient(getCurrentIndex()).getPatientSurvey().getRiskAssessment() != -1)
        {
            this.getCovidText().setOpacity(0);
            this.getSurveyStart().setOpacity(0);
            this.getSurveyStart().setDisable(true);
            
            this.getSurveyReset().setOpacity(1);
            this.getQuestionOneLabel().setOpacity(1);
            this.getQuestionTwoLabel().setOpacity(1);
            this.getQuestionThreeLabel().setOpacity(1);
            this.getRiskAssessmentLabel().setOpacity(1);
            
            this.getAnswerOneLabel().setOpacity(1);
            this.getAnswerTwoLabel().setOpacity(1);
            this.getAnswerThreeLabel().setOpacity(1);
            this.getAnswerFourLabel().setOpacity(1);
            
            this.getAnswerOneLabel().setText(String.valueOf(this.getPatientList().getPatient(this.getCurrentIndex()).getPatientSurvey().isQuestion1()));
            this.getAnswerTwoLabel().setText(String.valueOf(this.getPatientList().getPatient(this.getCurrentIndex()).getPatientSurvey().isQuestion2()));
            this.getAnswerThreeLabel().setText(String.valueOf(this.getPatientList().getPatient(this.getCurrentIndex()).getPatientSurvey().isQuestion3()));
            this.getAnswerFourLabel().setText(String.valueOf(this.getPatientList().getPatient(this.getCurrentIndex()).getPatientSurvey().getRiskAssessment()));
              
        }   
    }

    //return to homescreen and refresh application
    public void navigateHome(Event event) throws IOException
    {
        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/PatientDashboard.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }

    //return to logout screen
    public void logout(ActionEvent event) throws IOException
    {
        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }
    
    //navigate to Covid Survey
    public void navigateSurvey(ActionEvent event) throws IOException
    {  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CovidSurvey.fxml"));
        loader.setController(new CovidSurveyUICntl(this.getPatientList(), this.getCurrentIndex())); 
        Parent fileViewParent = loader.load();
       
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(fileView);
        window.show();
    }
    
    //for testing purposes only
    public void resetSurvey(Event event) throws IOException
    {
        this.getPatientList().getPatient(getCurrentIndex()).setPatientSurvey(new CovidSurvey());
        this.getPatientList().saveXMLList();
        
        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/PatientDashboard.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }

    public void exportMedicalRecord(ActionEvent event) throws IOException
    {
        this.getPatientList().printPatient(getCurrentIndex());
    }

    /**
     * @return the currentIndex
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * @param currentIndex the currentIndex to set
     */
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
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
     * @return the patientWeightText
     */
    public Label getPatientWeightText() {
        return patientWeightText;
    }

    /**
     * @param patientWeightText the patientWeightText to set
     */
    public void setPatientWeightText(Label patientWeightText) {
        this.patientWeightText = patientWeightText;
    }

    /**
     * @return the patientGenderText
     */
    public Label getPatientGenderText() {
        return patientGenderText;
    }

    /**
     * @param patientGenderText the patientGenderText to set
     */
    public void setPatientGenderText(Label patientGenderText) {
        this.patientGenderText = patientGenderText;
    }

    /**
     * @return the patientBloodTypeText
     */
    public Label getPatientBloodTypeText() {
        return patientBloodTypeText;
    }

    /**
     * @param patientBloodTypeText the patientBloodTypeText to set
     */
    public void setPatientBloodTypeText(Label patientBloodTypeText) {
        this.patientBloodTypeText = patientBloodTypeText;
    }

    /**
     * @return the patientInsuranceText
     */
    public Label getPatientInsuranceText() {
        return patientInsuranceText;
    }

    /**
     * @param patientInsuranceText the patientInsuranceText to set
     */
    public void setPatientInsuranceText(Label patientInsuranceText) {
        this.patientInsuranceText = patientInsuranceText;
    }

    /**
     * @return the patientCovidImmunizedText
     */
    public Label getPatientCovidImmunizedText() {
        return patientCovidImmunizedText;
    }

    /**
     * @param patientCovidImmunizedText the patientCovidImmunizedText to set
     */
    public void setPatientCovidImmunizedText(Label patientCovidImmunizedText) {
        this.patientCovidImmunizedText = patientCovidImmunizedText;
    }

    /**
     * @return the patientHeightText
     */
    public Label getPatientHeightText() {
        return patientHeightText;
    }

    /**
     * @param patientHeightText the patientHeightText to set
     */
    public void setPatientHeightText(Label patientHeightText) {
        this.patientHeightText = patientHeightText;
    }

    /**
     * @return the patientPrescriptionsText
     */
    public ListView getPatientPrescriptionsText() {
        return patientPrescriptionsText;
    }

    /**
     * @param patientPrescriptionsText the patientPrescriptionsText to set
     */
    public void setPatientPrescriptionsText(ListView patientPrescriptionsText) {
        this.patientPrescriptionsText = patientPrescriptionsText;
    }

    /**
     * @return the patientIDText
     */
    public Label getPatientIDText() {
        return patientIDText;
    }

    /**
     * @param patientIDText the patientIDText to set
     */
    public void setPatientIDText(Label patientIDText) {
        this.patientIDText = patientIDText;
    }

    /**
     * @return the patientNameText
     */
    public Label getPatientNameText() {
        return patientNameText;
    }

    /**
     * @param patientNameText the patientNameText to set
     */
    public void setPatientNameText(Label patientNameText) {
        this.patientNameText = patientNameText;
    }

    /**
     * @return the patientEmailText
     */
    public Label getPatientEmailText() {
        return patientEmailText;
    }

    /**
     * @param patientEmailText the patientEmailText to set
     */
    public void setPatientEmailText(Label patientEmailText) {
        this.patientEmailText = patientEmailText;
    }

    /**
     * @return the patientPhoneNumberText
     */
    public Label getPatientPhoneNumberText() {
        return patientPhoneNumberText;
    }

    /**
     * @param patientPhoneNumberText the patientPhoneNumberText to set
     */
    public void setPatientPhoneNumberText(Label patientPhoneNumberText) {
        this.patientPhoneNumberText = patientPhoneNumberText;
    }

    /**
     * @return the patientLocationText
     */
    public Label getPatientLocationText() {
        return patientLocationText;
    }

    /**
     * @param patientLocationText the patientLocationText to set
     */
    public void setPatientLocationText(Label patientLocationText) {
        this.patientLocationText = patientLocationText;
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
     * @return the surveyStart
     */
    public Button getSurveyStart() {
        return surveyStart;
    }

    /**
     * @param surveyStart the surveyStart to set
     */
    public void setSurveyStart(Button surveyStart) {
        this.surveyStart = surveyStart;
    }

    /**
     * @return the covidHeadingLabel
     */
    public Label getCovidHeadingLabel() {
        return covidHeadingLabel;
    }

    /**
     * @param covidHeadingLabel the covidHeadingLabel to set
     */
    public void setCovidHeadingLabel(Label covidHeadingLabel) {
        this.covidHeadingLabel = covidHeadingLabel;
    }

    /**
     * @param covidText the covidText to set
     */
    public void setCovidText(Label covidText) {
        this.setCovidText(covidText);
    }

    /**
     * @return the covidText
     */
    public Label getCovidText() {
        return covidText;
    }

    /**
     * @return the questionOneLabel
     */
    public Label getQuestionOneLabel() {
        return questionOneLabel;
    }

    /**
     * @param questionOneLabel the questionOneLabel to set
     */
    public void setQuestionOneLabel(Label questionOneLabel) {
        this.questionOneLabel = questionOneLabel;
    }

    /**
     * @return the questionTwoLabel
     */
    public Label getQuestionTwoLabel() {
        return questionTwoLabel;
    }

    /**
     * @param questionTwoLabel the questionTwoLabel to set
     */
    public void setQuestionTwoLabel(Label questionTwoLabel) {
        this.questionTwoLabel = questionTwoLabel;
    }

    /**
     * @return the questionThreeLabel
     */
    public Label getQuestionThreeLabel() {
        return questionThreeLabel;
    }

    /**
     * @param questionThreeLabel the questionThreeLabel to set
     */
    public void setQuestionThreeLabel(Label questionThreeLabel) {
        this.questionThreeLabel = questionThreeLabel;
    }

    /**
     * @return the riskAssessmentLabel
     */
    public Label getRiskAssessmentLabel() {
        return riskAssessmentLabel;
    }

    /**
     * @param riskAssessmentLabel the riskAssessmentLabel to set
     */
    public void setRiskAssessmentLabel(Label riskAssessmentLabel) {
        this.riskAssessmentLabel = riskAssessmentLabel;
    }

    /**
     * @return the answerOneLabel
     */
    public Label getAnswerOneLabel() {
        return answerOneLabel;
    }

    /**
     * @param answerOneLabel the answerOneLabel to set
     */
    public void setAnswerOneLabel(Label answerOneLabel) {
        this.answerOneLabel = answerOneLabel;
    }

    /**
     * @return the answerTwoLabel
     */
    public Label getAnswerTwoLabel() {
        return answerTwoLabel;
    }

    /**
     * @param answerTwoLabel the answerTwoLabel to set
     */
    public void setAnswerTwoLabel(Label answerTwoLabel) {
        this.answerTwoLabel = answerTwoLabel;
    }

    /**
     * @return the answerThreeLabel
     */
    public Label getAnswerThreeLabel() {
        return answerThreeLabel;
    }

    /**
     * @param answerThreeLabel the answerThreeLabel to set
     */
    public void setAnswerThreeLabel(Label answerThreeLabel) {
        this.answerThreeLabel = answerThreeLabel;
    }

    /**
     * @return the answerFourLabel
     */
    public Label getAnswerFourLabel() {
        return answerFourLabel;
    }

    /**
     * @param answerFourLabel the answerFourLabel to set
     */
    public void setAnswerFourLabel(Label answerFourLabel) {
        this.answerFourLabel = answerFourLabel;
    }

    /**
     * @return the surveyReset
     */
    public Button getSurveyReset() {
        return surveyReset;
    }

    /**
     * @param surveyReset the surveyReset to set
     */
    public void setSurveyReset(Button surveyReset) {
        this.surveyReset = surveyReset;
    }

}

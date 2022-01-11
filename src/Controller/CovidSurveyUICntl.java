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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import model.CovidSurvey;
import model.PatientList;

/**
 * FXML Controller class
 *
 * @author apple
 */

public class CovidSurveyUICntl implements Initializable
{

    private CovidSurvey survey;
    private PatientList patientList;
    private int currentIndex;

    @FXML
    private RadioButton questionOneYes;

    @FXML
    private RadioButton questionOneNo;

    @FXML
    private RadioButton questionTwoYes;

    @FXML
    private RadioButton questionTwoNo;

    @FXML
    private RadioButton questionThreeYes;

    @FXML
    private RadioButton questionThreeNo;

    @FXML
    private Button formSubmit;

    @FXML
    private Label surveyErrorLabel;

    //empty controller
    public CovidSurveyUICntl() {}
    
    public CovidSurveyUICntl(PatientList patientList, int currentIndex)
    {
        survey = new CovidSurvey();
        this.setPatientList(patientList);
        this.setCurrentIndex(currentIndex);
        
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    public void navigateHome(Event event) throws IOException
    {
        Parent fileViewParent = FXMLLoader.load(getClass().getResource("/View/PatientDashboard.fxml"));
        Scene fileView = new Scene(fileViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fileView);
        window.show();
    }

    /**
     * toggle the other radio button off if it is selected, needed to not have
     * questions selected as yes and no at same time
     */
    public void disableOtherRadio(ActionEvent event)
    {
        //remove error message if it is shown
        this.getSurveyErrorLabel().setOpacity(0);

        //question 1
        if (event.getSource() == this.getQuestionOneYes())
        {
            this.getQuestionOneNo().setSelected(false);
        } else if (event.getSource() == this.getQuestionOneNo())
        {
            this.getQuestionOneYes().setSelected(false);
        } //question 2
        else if (event.getSource() == this.getQuestionTwoYes())
        {
            this.getQuestionTwoNo().setSelected(false);
        } else if (event.getSource() == this.getQuestionTwoNo())
        {
            this.getQuestionTwoYes().setSelected(false);
        } //question 3
        else if (event.getSource() == this.getQuestionThreeYes())
        {
            this.getQuestionThreeNo().setSelected(false);
        } else if (event.getSource() == this.getQuestionThreeNo())
        {
            this.getQuestionThreeYes().setSelected(false);
        }
    }

    //validate form method, returns false if any question isn`t answered
    public boolean validateForm()
    {
        //if any questions are not selected
        if ((this.getQuestionOneYes().isSelected() == false && this.getQuestionOneNo().isSelected() == false)
                || (this.getQuestionTwoYes().isSelected() == false && this.getQuestionTwoNo().isSelected() == false)
                || (this.getQuestionThreeYes().isSelected() == false && this.getQuestionThreeNo().isSelected() == false)) {
            return false;
        } else {
            return true;
        }
    }

    public void submitForm(ActionEvent event) throws IOException
    {
        if (validateForm())
        {
            this.getSurveyErrorLabel().setOpacity(0);

            //set survey question 1 to true or false depending on input
            if (this.getQuestionOneYes().isSelected())
            {
                this.getSurvey().setQuestion1(true);
            } else {
                this.getSurvey().setQuestion1(false);
            }

            //set survey question 2 to true or false depending on input
            if (this.getQuestionTwoYes().isSelected())
            {
                this.getSurvey().setQuestion2(true);
            } else {
                this.getSurvey().setQuestion2(false);
            }

            //set survey question 3 to true or false depending on input
            if (this.getQuestionThreeYes().isSelected())
            {
                this.getSurvey().setQuestion3(true);
            } else {
                this.getSurvey().setQuestion3(false);
            }

            this.getSurvey().calculateRiskAssessment();
            this.getPatientList().getPatient(this.getCurrentIndex()).setPatientSurvey(this.getSurvey());
            this.getPatientList().saveXMLList();
            
            navigateHome(event);

        } 
        //display error message
        else {
            this.getSurveyErrorLabel().setOpacity(1);
        }
    }

    /**
     * @return the testSurvey
     */
    public CovidSurvey getSurvey()
    {
        return survey;
    }

    /**
     * @param testSurvey the testSurvey to set
     */
    public void setSurvey(CovidSurvey survey)
    {
        this.survey = survey;
    }

    /**
     * @return the questionOneYes
     */
    public RadioButton getQuestionOneYes()
    {
        return questionOneYes;
    }

    /**
     * @param questionOneYes the questionOneYes to set
     */
    public void setQuestionOneYes(RadioButton questionOneYes)
    {
        this.questionOneYes = questionOneYes;
    }

    /**
     * @return the questionOneNo
     */
    public RadioButton getQuestionOneNo()
    {
        return questionOneNo;
    }

    /**
     * @param questionOneNo the questionOneNo to set
     */
    public void setQuestionOneNo(RadioButton questionOneNo)
    {
        this.questionOneNo = questionOneNo;
    }

    /**
     * @return the questionTwoYes
     */
    public RadioButton getQuestionTwoYes()
    {
        return questionTwoYes;
    }

    /**
     * @param questionTwoYes the questionTwoYes to set
     */
    public void setQuestionTwoYes(RadioButton questionTwoYes)
    {
        this.questionTwoYes = questionTwoYes;
    }

    /**
     * @return the questionTwoNo
     */
    public RadioButton getQuestionTwoNo()
    {
        return questionTwoNo;
    }

    /**
     * @param questionTwoNo the questionTwoNo to set
     */
    public void setQuestionTwoNo(RadioButton questionTwoNo)
    {
        this.questionTwoNo = questionTwoNo;
    }

    /**
     * @return the questionThreeYes
     */
    public RadioButton getQuestionThreeYes()
    {
        return questionThreeYes;
    }

    /**
     * @param questionThreeYes the questionThreeYes to set
     */
    public void setQuestionThreeYes(RadioButton questionThreeYes)
    {
        this.questionThreeYes = questionThreeYes;
    }

    /**
     * @return the questionThreeNo
     */
    public RadioButton getQuestionThreeNo()
    {
        return questionThreeNo;
    }

    /**
     * @param questionThreeNo the questionThreeNo to set
     */
    public void setQuestionThreeNo(RadioButton questionThreeNo)
    {
        this.questionThreeNo = questionThreeNo;
    }

    /**
     * @return the formSubmit
     */
    public Button getFormSubmit()
    {
        return formSubmit;
    }

    /**
     * @param formSubmit the formSubmit to set
     */
    public void setFormSubmit(Button formSubmit)
    {
        this.formSubmit = formSubmit;
    }

    /**
     * @return the surveyErrorLabel
     */
    public Label getSurveyErrorLabel()
    {
        return surveyErrorLabel;
    }

    /**
     * @param surveyErrorLabel the surveyErrorLabel to set
     */
    public void setSurveyErrorLabel(Label surveyErrorLabel)
    {
        this.surveyErrorLabel = surveyErrorLabel;
    }

    /**
     * @return the patientList
     */
    public PatientList getPatientList()
    {
        return patientList;
    }

    /**
     * @param patientList the patientList to set
     */
    public void setPatientList(PatientList patientList)
    {
        this.patientList = patientList;
    }

    /**
     * @return the currentIndex
     */
    public int getCurrentIndex()
    {
        return currentIndex;
    }

    /**
     * @param currentIndex the currentIndex to set
     */
    public void setCurrentIndex(int currentIndex)
    {
        this.currentIndex = currentIndex;
    }

}

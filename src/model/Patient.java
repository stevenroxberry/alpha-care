/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kurtis
 */
public class Patient {
    
    private int patientId;
    private String name;
    private String email;
    private String phoneNumber;
    private String location;
    
    private MedicalRecord patientRecord;
    private CovidSurvey patientSurvey;
    
    /**
     * Default constructor for the Patient
     */
    public Patient(){}
    
    public Patient(int patientID, String name, String email,
            String phoneNumber, String location, MedicalRecord patientRecord,
            CovidSurvey patientSurvey)
    {
        this.patientId = patientID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.patientRecord = patientRecord;
        this.patientSurvey = patientSurvey;
        
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the patientRecord
     */
    public MedicalRecord getPatientRecord() {
        return patientRecord;
    }

    /**
     * @param patientRecord the patientRecord to set
     */
    public void setPatientRecord(MedicalRecord patientRecord) {
        this.patientRecord = patientRecord;
    }

    /**
     * @return the patientSurvey
     */
    public CovidSurvey getPatientSurvey() {
        return patientSurvey;
    }

    /**
     * @param patientSurvey the patientSurvey to set
     */
    public void setPatientSurvey(CovidSurvey patientSurvey) {
        this.patientSurvey = patientSurvey;
    }

    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}

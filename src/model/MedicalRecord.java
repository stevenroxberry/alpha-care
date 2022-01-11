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
public class MedicalRecord {
    
    private boolean covidImmunized;
    private String bloodType;
    private String insuranceInfo;
    private String[] prescriptions;
    private String gender;
    private String height;
    private String weight;
    
     /**
     * Default constructor for the MedicalRecord
     */
    public MedicalRecord(){}
    
    public MedicalRecord(boolean covidImmunized, String bloodType,
            String insuranceInfo, String[] prescriptions, String gender,
            String height, String weight){
        this.covidImmunized = covidImmunized;
        this.bloodType = bloodType;
        this.insuranceInfo = insuranceInfo;
        this.prescriptions = prescriptions;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    /**
     * @return the covidImmunized
     */
    public boolean isCovidImmunized() {
        return covidImmunized;
    }

    /**
     * @param covidImmunized the covidImmunized to set
     */
    public void setCovidImmunized(boolean covidImmunized) {
        this.covidImmunized = covidImmunized;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return the insuranceInfo
     */
    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    /**
     * @param insuranceInfo the insuranceInfo to set
     */
    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    /**
     * @return the prescriptions
     */
    public String[] getPrescriptions() {
        return prescriptions;
    }

    /**
     * @param prescriptions the prescriptions to set
     */
    public void setPrescriptions(String[] prescriptions) {
        this.prescriptions = prescriptions;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }
}

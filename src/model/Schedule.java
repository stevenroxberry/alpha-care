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
public class Schedule {
    
    private String address;
    private Patient scheduledPatient;
    private int assignedDoctor;
    private String purpose;
    
    /**
     * Default constructor for Schedule
     */
    public Schedule(){
    }
    
    public Schedule(Patient scheduledPatient){
        this.scheduledPatient = scheduledPatient;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the scheduledPatient
     */
    public Patient getScheduledPatient() {
        return scheduledPatient;
    }

    /**
     * @param scheduledPatient the scheduledPatient to set
     */
    public void setScheduledPatient(Patient scheduledPatient) {
        this.scheduledPatient = scheduledPatient;
    }

    /**
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * @param assignedDoctor the assignedDoctor to set
     */
    public void setAssignedDoctor(int assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    /**
     * @return the assignedDoctor
     */
    public int getAssignedDoctor() {
        return assignedDoctor;
    }

}

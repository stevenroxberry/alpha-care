/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kurtis
 */

/** bad smell number 10, class contains poor documentation with modules
 *  that may require documentation to fully understand
 */ 
public class PatientList implements XMLData, Printable {

    private ArrayList<Patient> patientList;

    /**
     * Default constructor for the PatientList
     */
    public PatientList() {
        patientList = new ArrayList<Patient>();
    }

    /**
     * @return the patientList
     */
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    /**
     * @param patientList the patientList to set
     */
    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    /**
     * @return the Patient in PatientList at position
     */
    public Patient getPatient(int position) {
        return patientList.get(position);
    }

    /**
     * SSet Patient of Patient List at position
     */
    public void setPatient(int position, Patient patient) {
        this.getPatientList().set(position, patient);
    }

    @Override
    public void loadXMLList() {
        try {
            XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("patients.xml")));
            setPatientList((ArrayList<Patient>) de.readObject());
            de.close();

        } catch (Exception xx) {
            System.out.println("Unable to load XML file");
        }
    }

    @Override
    public void saveXMLList() {
        try {
            XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("patients.xml")));
            xe.writeObject(getPatientList());
            xe.close();

        } catch (Exception xx) {
            System.out.println("Unable to save XML file");
        }
    }

    @Override
    public void printPatient(int currentIndex) {
        try {
            System.out.println("Printing Medical Record to File");

            PrintWriter pw = new PrintWriter(new FileWriter(this.getPatientList().get(currentIndex).getName() + ".txt"));
            pw.printf("Patient Name: %s", this.getPatientList().get(currentIndex).getName());
            pw.printf("\nPatient Height: %s", this.getPatientList().get(currentIndex).getPatientRecord().getHeight());
            pw.printf("\nPatient Weight: %s", this.getPatientList().get(currentIndex).getPatientRecord().getWeight());
            pw.printf("\nPatient Gender: %s", this.getPatientList().get(currentIndex).getPatientRecord().getGender());
            pw.printf("\nPatient Blood Type: %s", this.getPatientList().get(currentIndex).getPatientRecord().getBloodType());
            pw.printf("\nPatient Insurance Info: %s", this.getPatientList().get(currentIndex).getPatientRecord().getInsuranceInfo());
            pw.printf("\nPatient Covid Immunized: %s", String.valueOf(this.getPatientList().get(currentIndex).getPatientRecord().isCovidImmunized()));

            StringBuilder prescriptionsBuilder = new StringBuilder("");

            for (int i = 0; i < this.getPatientList().get(currentIndex).getPatientRecord().getPrescriptions().length; ++i) {
                prescriptionsBuilder.append(this.getPatientList().get(currentIndex).getPatientRecord().getPrescriptions()[i]);

                //Add comma and space to all but last prescription
                if (i < this.getPatientList().get(currentIndex).getPatientRecord().getPrescriptions().length - 1) {
                    prescriptionsBuilder.append(", ");
                }
            }
            String allPrescriptions = prescriptionsBuilder.toString();

            pw.printf("\nPatient Prescriptions: %s", allPrescriptions);

            System.out.println("Successfully Printed Record to File: " + this.getPatientList().get(currentIndex).getName() + ".txt");
            pw.close();

        } catch (IOException ex) {
            System.out.println("Error Unable to Print Record to File: " + ex);
        }
    }

}

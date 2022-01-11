/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package testharness;

import Controller.CovidSurveyUICntl;
import Controller.DoctorDashboardCntl;
import Controller.LoginUICntl;
import Controller.PatientDashboardCntl;
import Controller.ScheduleUICntl;
import model.Account;
import model.CovidSurvey;
import model.MedicalRecord;
import model.Patient;
import model.Schedule;


public class testharness {


    public static void main(String[] args) {

        LoginUICntl testLoginControl = new LoginUICntl();

        int passCount = 0;

        //=================
        //Start Doctor Test
        //=================
        
        //break
        System.out.println("===============================================");
        System.out.println("Beginning Doctor Tests Now...");

        //Test Login   
        Boolean testLogin = Account.getAccount().AuthenticateDoctor("doctor", "test");

        if (testLogin) {
            System.out.println("Doctor Login Test: Passed");
            passCount++;
        } else {
            System.out.println("Doctor Login Test: Failed");
        };

        //Test Doctor Dashboard
        DoctorDashboardCntl testDoctorDashboardControl = new DoctorDashboardCntl();

        Patient patient1 = new Patient(1, "Bob");
        Patient patient2 = new Patient(2, "Tim");

        testDoctorDashboardControl.getTestList().getPatientList().add(patient1);
        testDoctorDashboardControl.getTestList().getPatientList().add(patient2);

        if ((testDoctorDashboardControl.getTestList().getPatient(0) == patient1) && (testDoctorDashboardControl.getTestList().getPatient(1) == patient2)) {
            System.out.println("Doctor Dashboard Add Patient Test: Passed");
            passCount++;
        } else {
            System.out.println("Doctor Dashboard Add Patient Test: Failed");
        };

        testDoctorDashboardControl.getTestList().getPatient(0).setName("Sally");
        if (testDoctorDashboardControl.getTestList().getPatient(0).getName() == "Sally") {
            System.out.println("Doctor Dashboard Change Patient Info Test: Passed");
            passCount++;
        } else {
            System.out.println("Doctor Dashboard Change Patient Info Test: Failed");
        }

        //Test Scheduling
        ScheduleUICntl testScheduler = new ScheduleUICntl();

        Schedule schedule1 = new Schedule(patient1);
        Schedule schedule2 = new Schedule(patient2);
        Schedule schedule3 = new Schedule(new Patient(3, "Remove me"));

        testScheduler.getTestList().addSchedule(schedule1, 9);
        testScheduler.getTestList().addSchedule(schedule2, 10);
        testScheduler.getTestList().addSchedule(schedule3, 11);

        if ((testScheduler.getTestList().getCurrentDay().get(9)) == schedule1 && (testScheduler.getTestList().getCurrentDay().get(10) == schedule2)) {
            System.out.println("Doctor Add Schedule Test: Passed");
            passCount++;
        } else {
            System.out.println("Doctor Add Schedule Test: Failed");
        }

        testScheduler.getTestList().removeSchedule(11);
        if (!testScheduler.getTestList().getCurrentDay().containsKey(11)) {
            System.out.println("Doctor Remove Schedule Test: Passed");
            passCount++;
        } else {
            System.out.println("Doctor Remove Schedule Test: Failed");
        }

        System.out.println("Doctor Tests Complete");

        //break
        System.out.println("===============================================");

        //==================
        //Start Patient Test
        //==================
        System.out.println("Beginning Patient Tests Now...");

        //Test Login   
        testLogin = Account.getAccount().AuthenticatePatient("patient", "test");

        if (testLogin) {
            System.out.println("Patient Login Test: Passed");
            passCount++;
        } else {
            System.out.println("Patient Login Test: Failed");
        };

        //Test Patient
        MedicalRecord patientRecord1 = new MedicalRecord();
        patientRecord1.setBloodType("O+");
        patientRecord1.setCovidImmunized(false);
        patientRecord1.setGender("Male");
        patientRecord1.setHeight("6 ft 1 in");
        patientRecord1.setInsuranceInfo("Blue Cross Blue Shield");
        patientRecord1.setWeight("200 lbs");

        MedicalRecord patientRecord2 = new MedicalRecord();
        patientRecord2.setBloodType("O-");
        patientRecord2.setCovidImmunized(true);
        patientRecord2.setGender("Male");
        patientRecord2.setHeight("5 ft 11 in");
        patientRecord2.setInsuranceInfo("HMR PPO");
        patientRecord2.setWeight("165 lbs");

        patient1.setPatientRecord(patientRecord1);
        patient2.setPatientRecord(patientRecord2);

        if (patient1.getPatientRecord().equals(patientRecord1) && (patient2.getPatientRecord().equals(patientRecord2))) {
            System.out.println("Patient Record Assignment Test: Passed");
            passCount++;
        } else {
            System.out.println("Patient Record Assignment Test: Failed");
        }

        if (patient1.getPatientRecord().getBloodType().equals("O+") && (!patient1.getPatientRecord().isCovidImmunized())
                && patient1.getPatientRecord().getGender() == "Male" && patient1.getPatientRecord().getHeight() == "6 ft 1 in"
                && patient1.getPatientRecord().getInsuranceInfo() == "Blue Cross Blue Shield" && patient1.getPatientRecord().getWeight() == "200 lbs") {
            System.out.println("Patient Record Retrieval Test: Passed");
            passCount++;
        } else {
            System.out.println("Patient Record Retrieval Test: Failed");
        }

        //Test Patient Dashboard
        PatientDashboardCntl patientDashboard = new PatientDashboardCntl();

        patientDashboard.getTestList().getPatientList().add(patient1);
        patientDashboard.getTestList().getPatientList().add(patient2);

        if (patientDashboard.getTestList().getPatient(0) == patient1 && patientDashboard.getTestList().getPatient(1) == patient2) {
            System.out.println("Patient Dashboard Test: Passed");
            passCount++;
        } else {
            System.out.println("Patient Dashboard Test: Failed");
        }

        //Test Patient Survey
        CovidSurvey testSurvey = new CovidSurvey();
        testSurvey.setQuestion1(true);
        testSurvey.setQuestion2(true);
        testSurvey.setQuestion3(true);
        testSurvey.calculateRiskAssessment();
        
        if (testSurvey.getRiskAssessment() == 3) {
            System.out.println("Patient Survey Test: Passed");
            passCount++;
        } else {
            System.out.println("Patient Survey Test: Failed");
        }

        //Test Patient Survey Controller
        CovidSurveyUICntl testSurveyControl = new CovidSurveyUICntl();

        testSurveyControl.setTestSurvey(testSurvey);

        if (testSurveyControl.getTestSurvey().equals(testSurvey)) {
            System.out.println("Patient Survey Controller Test: Passed");
            passCount++;
        } else {
            System.out.println("Patient Survey Controller Test: Failed");
        }

        System.out.println("Patient Tests Complete");

        //break
        System.out.println("===============================================");

        System.out.println("All Tests Complete");
        
        System.out.println("Tests Passed: " + passCount + "/11");

    }

} 

*/



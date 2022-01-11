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
public class Account {

    private static Account account = new Account();

    private int accountID;
    private boolean doctorStatus;

    /**
     * Default constructor for the Account class
     */
    private Account() {
    }

    //singleton implementation
    public static Account getAccount() {
        if (account == null) {
            account = new Account();
        }

        return account;
    }

    /**
     * Check database for Doctor of Patient credentials, if found set accountID
     * and doctorStatus for user
     */
    public boolean AuthenticatePatient(String username, String password) {
        //check database and then set accountID and doctor status if found
        if (username.equals("kurtismiles") && password.equals("test")) {
            this.accountID = 11211;
            this.doctorStatus = false;
            return true;
        } else if (username.equals("johndoe") && password.equals("test")) {
            this.accountID = 11311;
            this.doctorStatus = false;
            return true;
        } else if (username.equals("sallymae") && password.equals("test")) {
            this.accountID = 11411;
            this.doctorStatus = false;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Check database for Doctor of Patient credentials, if found set accountID
     * and doctorStatus for user
     */
    public boolean AuthenticateDoctor(String username, String password) {
        //check database and then set accountID and doctor status if found
        if (username.equals("doctor") && password.equals("test")) {
            this.accountID = 22122;
            this.doctorStatus = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    /**
     * @return the doctorStatus
     */
    public boolean isDoctorStatus() {
        return doctorStatus;
    }

    /**
     * @param doctorStatus the doctorStatus to set
     */
    public void setDoctorStatus(boolean doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

}

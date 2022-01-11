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
public class CovidSurvey {

    private boolean question1;
    private boolean question2;
    private boolean question3;

    private int riskAssessment;

    public CovidSurvey() {
        this.setRiskAssessment(-1);
    }

     /**
     * use question1, question2, question3 to calculate
     * and set riskAssessment
     */
    public void calculateRiskAssessment(){
        
        this.setRiskAssessment(0);
        
        if (this.isQuestion1())
        {
            this.setRiskAssessment(this.getRiskAssessment() + 1);
        }
        
        if (this.isQuestion2())
        {
            this.setRiskAssessment(this.getRiskAssessment() + 1);
        }
        
        if (this.isQuestion3())
        {
            this.setRiskAssessment(this.getRiskAssessment() + 1);
        }
    };

    /**
     * @return the riskAssessment value
     */
    public int getRiskAssessment() {
        return riskAssessment;
    }
    
    /**
    * @param riskAssessment the riskAssessment to set
    */
    public void setRiskAssessment(int riskAssessment) {
        this.riskAssessment = riskAssessment;
    }

    /**
     * @return the question1
     */
    public boolean isQuestion1() {
        return question1;
    }

    /**
     * @param question1 the question1 to set
     */
    public void setQuestion1(boolean question1) {
        this.question1 = question1;
    }

    /**
     * @return the question2
     */
    public boolean isQuestion2() {
        return question2;
    }

    /**
     * @param question2 the question2 to set
     */
    public void setQuestion2(boolean question2) {
        this.question2 = question2;
    }

    /**
     * @return the question3
     */
    public boolean isQuestion3() {
        return question3;
    }

    /**
     * @param question3 the question3 to set
     */
    public void setQuestion3(boolean question3) {
        this.question3 = question3;
    }  
}

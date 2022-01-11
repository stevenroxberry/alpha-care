/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Kurtis
 */
public class ScheduleList {
    
    private HashMap CurrentDay;
    
    /**
     * Default constructor for the ScheduleController
     */
    public ScheduleList()
    {
        CurrentDay = new HashMap(){};
    }
    
    /**
     * Add a schedule to the CurrentDay Map
     */
    public void addSchedule(Schedule addedSchedule, int time)
    {
        this.getCurrentDay().put(time, addedSchedule);
    }
    
    /**
     * Remove a schedule from the CurrentDay Map
     */
    public void removeSchedule(int time)
    {
        this.getCurrentDay().remove(time);
    }    

    /**
     * @return the CurrentDay
     */
    public HashMap getCurrentDay() {
        return CurrentDay;
    }

    /**
     * @param CurrentDay the CurrentDay to set
     */
    public void setCurrentDay(HashMap CurrentDay) {
        this.CurrentDay = CurrentDay;
    }
}

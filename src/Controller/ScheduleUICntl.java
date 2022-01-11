/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.ScheduleList;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class ScheduleUICntl implements Initializable
{

    private ScheduleList testList;
    
    public ScheduleUICntl()
    {
        testList = new ScheduleList();
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @return the testList
     */
    public ScheduleList getTestList() {
        return testList;
    }

    /**
     * @param testList the testList to set
     */
    public void setTestList(ScheduleList testList) {
        this.testList = testList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import Controller.LoginUICntl;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Kurtis
 */
public class AlphaCare extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        //FXMLLoader root = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("AlphaCare");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import database.base.MySQL;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Deepanshu Sahu
 */
public class MasterController extends Application {
    
    public static Stage primaryStage;
    public static boolean IS_DARK_THEME = true;
    public MasterController()
    {
        primaryStage = null;
    }
    
    @Override
    public void start(Stage stage)
    {
        
        primaryStage = stage;
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
	primaryStage.setWidth(700);
        primaryStage.setHeight(500);
        /*AnchorPane root = new AnchorPane();
        Text text = new Text("Deepanshu Sahu");
        root.getChildren().add(text);
        text.setLayoutX(100);
        text.setLayoutY(100);
        Scene scene = new Scene(root);
        */
        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("LoginPage.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MasterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaryStage.setScene(scene);
        MySQL.makeConnection("timetableautomation", "root", "");
        /*loading the welcome page*/
//        loadLoginPage();
///        MySQL.makeConnection("timetable", "root", "");
	primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/app_icon02.png")));
	primaryStage.setTitle("Time Table Maker");
	primaryStage.show();
        primaryStage.setMaximized(true);
        
	//new Bounce(text).setDelay(Duration.ONE).play();
       
    }
    public void loadLoginPage()
    {
	//primaryStage.setScene(new LoginPage().loadLoginPage(primaryStage));
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}

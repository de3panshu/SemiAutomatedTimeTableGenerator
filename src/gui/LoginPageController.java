/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import animatefx.animation.AnimationFX;
import animatefx.animation.FadeInUp;
import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.base.Configuration;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class LoginPageController implements Initializable {

    @FXML
    private ImageView bgImage;
    @FXML
    private Text welcomeText;
    private AnchorPane loginContent;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton cancelButton;
    @FXML
    private FontAwesomeIconView gear;
    @FXML
    private AnchorPane settingContent;
    @FXML
    private JFXTextField oldUsername;
    @FXML
    private JFXPasswordField oldPassword;
    @FXML
    private JFXTextField newUsername;
    @FXML
    private JFXPasswordField newPassword;
    @FXML
    private JFXPasswordField newPasswordConfirm;
    @FXML
    private JFXButton backButton;
    @FXML
    private FontAwesomeIconView back;
    @FXML
    private JFXButton arrowButton;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton gearButton;
    
    private PopupNotification notify;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bgImage.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        bgImage.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        
        notify = new PopupNotification();
        animateSettingUIInvisible();
        //gear button transition
        RotateTransition rotate = new RotateTransition();  
        rotate.setAxis(Rotate.Z_AXIS); 
        rotate.setByAngle(360);
        rotate.setRate(.1);
        rotate.setDelay(Duration.ZERO);
        rotate.setCycleCount(10);
        rotate.setNode(gear);
        rotate.play();
        rotate.setOnFinished(e->{
            rotate.setCycleCount(5);
            rotate.play();
         });
        new FadeInUp(welcomeText).setDelay(Duration.millis(200)).setCycleCount(1).play();
        
        animateLoginUIAppear();
        //Text icon = FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.ANDROID);
//        Text fontAwesomeIcon =
//  FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.ANGELLIST);
//        username.setText(username.getText());
        //fa fa-user
        //FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.ANDROID);
        
    }    

    @FXML
    private void loginButtonActionEvent(ActionEvent event) {
        Configuration credentials = new Configuration();
        credentials.setUsername(username.getText());
        credentials.setPassword(password.getText());
        
        if(credentials.isValidUser())
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                Scene scene = new Scene(root);
                MasterController.primaryStage.setScene(scene);
                MasterController.primaryStage.setMaximized(true);
            } catch (IOException ex) {
                Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            notify.alert("Invalid Credentials !!!","Try Again ");
            username.clear();
            password.clear();
            
        }
    }

    @FXML
    private void cancelButtonActionEvent(ActionEvent event) {
        username.clear();
        password.clear();
    }

    @FXML
    private void settingButtonActionEvent(ActionEvent event) {
        animateLoginUIInvisible();
        //loginContent.setVisible(false);
        //settingContent.setVisible(true);
        animateSettingUIAppear();
    }

    @FXML
    private void saveButtonActionEvent(ActionEvent event) {
        Configuration credentials = new Configuration();
        credentials.setUsername(oldUsername.getText());
        credentials.setPassword(oldPassword.getText());
        
        if(credentials.isValidUser())
        {
            if(newPassword.getText().equals(newPasswordConfirm.getText()) && !newPassword.getText().isEmpty())
            {
                if(!newUsername.getText().isEmpty())
                {
                    credentials.setUsername(newUsername.getText());
                    credentials.setPassword(newPassword.getText());
                    credentials.configure();
                    notify.confirm("Saving SuccessFull", "");
                }
                else
                {
                    notify.alert("Enter Username", "");
                }
            }
            else
            {
                notify.warning("Password Mismatched or Empty", "");
            }
        }
        else
        {
            notify.alert("Invalid Credentials !!!","Try Again ");
            oldUsername.clear();
            oldPassword.clear();
            
        }        
    }

    @FXML
    private void backButtonActionEvent(ActionEvent event) {
        animateSettingUIInvisible();
        //settingContent.setVisible(false);
        //loginContent.setVisible(true);
        animateLoginUIAppear();
    }
    private void animateLoginUIAppear()
    {
        gearButton.setVisible(true);
        loginButton.setVisible(true);
        cancelButton.setVisible(true);
        new ZoomIn(username).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(gearButton).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(password).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(loginButton).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(cancelButton).setDelay(Duration.millis(200)).setCycleCount(1).play();
       // new FadeInUp(loginButton).setDelay(Duration.millis(800)).setCycleCount(1).play();
       // new FadeInUp(cancelButton).setDelay(Duration.millis(800)).setCycleCount(20).play();
      
    }
    private void animateLoginUIInvisible()
    {
        AnimationFX loginBtn = new ZoomOut(loginButton).setDelay(Duration.millis(200)).setCycleCount(1);
        AnimationFX gearBtn = new ZoomOut(gearButton).setDelay(Duration.millis(200)).setCycleCount(1);
        AnimationFX cancelBtn = new ZoomOut(cancelButton).setDelay(Duration.millis(200)).setCycleCount(1);
        loginBtn.setOnFinished((ActionEvent e)->{loginButton.setVisible(false);});
        gearBtn.setOnFinished((ActionEvent e)->{gearButton.setVisible(false);});
        cancelBtn.setOnFinished((ActionEvent e)->{cancelButton.setVisible(false);});
        new ZoomOut(username).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomOut(password).setDelay(Duration.millis(200)).setCycleCount(1).play();
        loginBtn.play();
        gearBtn.play();
        cancelBtn.play();
        
        
    }
    private void animateSettingUIAppear()
    {
        saveButton.setVisible(true);
        backButton.setVisible(true);
        arrowButton.setVisible(true);
        new ZoomIn(oldUsername).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(oldPassword).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(newUsername).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(newPassword).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(newPasswordConfirm).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(saveButton).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(backButton).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomIn(arrowButton).setDelay(Duration.millis(200)).setCycleCount(1).play();
        
    }
    private void animateSettingUIInvisible()
    {
        AnimationFX saveBtn = new ZoomOut(saveButton).setDelay(Duration.millis(200)).setCycleCount(1);
        AnimationFX backBtn = new ZoomOut(backButton).setDelay(Duration.millis(200)).setCycleCount(1);
        AnimationFX arrowBtn = new ZoomOut(arrowButton).setDelay(Duration.millis(200)).setCycleCount(1);
        saveBtn.setOnFinished(e->{saveButton.setVisible(false);});
        backBtn.setOnFinished(e->{backButton.setVisible(false);});
        arrowBtn.setOnFinished(e->{arrowButton.setVisible(false);});
        
        new ZoomOut(oldUsername).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomOut(oldPassword).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomOut(newUsername).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomOut(newPassword).setDelay(Duration.millis(200)).setCycleCount(1).play();
        new ZoomOut(newPasswordConfirm).setDelay(Duration.millis(200)).setCycleCount(1).play();
        saveBtn.play();
        arrowBtn.play();
        backBtn.play();       
    }

}

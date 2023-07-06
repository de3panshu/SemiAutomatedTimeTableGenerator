/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.teacher;

import database.base.TeacherList;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import gui.PopupNotification;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class TeacherListPageController implements Initializable {
    PopupNotification popup;
    
    @FXML
    TextField fullNameTextField;
    @FXML
    TextField nickNameTextField;
    @FXML
    private VBox fullNameView;
    @FXML
    private VBox nickNameView;
    @FXML
    private VBox fullNameDelete;
    @FXML
    private VBox nickNameDelete;
    @FXML
    private VBox crossButtonVBox;
    @FXML
    private BorderPane root;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button resetButton;
    @FXML
    private TextField emailTextField;
    
    
    
   @FXML
    private void submitButtonEvent(ActionEvent e)
    {
        if(uploadData())
        {
            loadTeacherList();
            restoreToDefault();
            popup.confirm("Data saved", "Successful");
        }
    }
    @FXML
    private void cancelButtonEvent(ActionEvent e)
    {
        restoreToDefault();
    }
    @FXML
    private void resetButtonEvent(ActionEvent e)
    {
        Thread resetButtonThread = new Thread()
            {
                @Override
                public void run()
                {
                    new TeacherList().deleteAll();
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        fullNameView.getChildren().clear();
        nickNameView.getChildren().clear();
        fullNameDelete.getChildren().clear();
        nickNameDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadTeacherList();
       popup = new PopupNotification();
    } 
    
    
    private void loadTeacherList()
    {  
        TeacherList teacherList = new TeacherList();
	FontAwesomeIconView icon;
        int  noOfRecord = teacherList.count();
        Label [] forTeacherFullNameView = new Label[noOfRecord];       
        Label [] forTeacherNickNameView = new Label[noOfRecord];       
        
        Label [] forTeacherFullNameDelete = new Label[noOfRecord];       
        Label [] forTeacherNickNameDelete = new Label[noOfRecord];       
        
        Separator [] separator1View = new Separator[noOfRecord];
        Separator [] separator2View = new Separator[noOfRecord];
        Separator [] separator1Delete = new Separator[noOfRecord];
        Separator [] separator2Delete = new Separator[noOfRecord];
        
        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        fullNameView.getChildren().clear();
        nickNameView.getChildren().clear();
        fullNameDelete.getChildren().clear();
        nickNameDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            teacherList.display();
                 
            forTeacherFullNameView[i] = new Label((teacherList.getTeacherFullName()).replaceAll("_", " "));
            forTeacherNickNameView[i] = new Label(teacherList.getTeacherNickName());
            forTeacherFullNameDelete[i] = new Label((teacherList.getTeacherFullName()).replaceAll("_", " "));
            forTeacherNickNameDelete[i] = new Label(teacherList.getTeacherNickName());
                    
            forCrossButtonVBox[i] =  new Button();
            
            icon = new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
            icon.setGlyphSize(22);
            icon.setStroke(Paint.valueOf("RED"));
            forCrossButtonVBox[i].setGraphic(icon);
            //forCrossButtonVBox[i]
            
            separator1View[i] = new Separator();
            separator1View[i].setMaxWidth(Double.MAX_VALUE);
            separator2View[i] = new Separator();
            separator2View[i].setMaxWidth(Double.MAX_VALUE);
            separator1Delete[i] = new Separator();
            separator1Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator2Delete[i] = new Separator();
            separator2Delete[i].setMaxWidth(Double.MAX_VALUE);
            separatorCrossButton[i] = new Separator();
            separatorCrossButton[i].setMaxWidth(Double.MAX_VALUE);
                   
            separator1View[i].getStyleClass().add("divider");
            separator2View[i].getStyleClass().add("divider");
            separator1Delete[i].getStyleClass().add("divider");
            separator2Delete[i].getStyleClass().add("divider");
            separatorCrossButton[i].getStyleClass().add("divider");
                   
            forTeacherFullNameView[i].getStyleClass().add("colData");
            forTeacherNickNameView[i].getStyleClass().add("colData");
            forTeacherFullNameDelete[i].getStyleClass().add("colData");
            forTeacherNickNameDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
           
            forTeacherFullNameView[i].setMaxWidth(Double.MAX_VALUE);
            forTeacherNickNameView[i].setMaxWidth(Double.MAX_VALUE);
            forTeacherFullNameDelete[i].setMaxWidth(Double.MAX_VALUE);
            forTeacherNickNameDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String fullName = (forTeacherFullNameDelete[i].getText()).replaceAll(" ", "_");
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                new TeacherList().delete(fullName);
                loadTeacherList();
            });
        }
        for(int i=0;i<noOfRecord;i++)
        {
            fullNameView.getChildren().add(forTeacherFullNameView[i]);
            fullNameView.getChildren().add(separator1View[i]);
            nickNameView.getChildren().add(forTeacherNickNameView[i]);
            nickNameView.getChildren().add(separator2View[i]);
                    
            fullNameDelete.getChildren().add(forTeacherFullNameDelete[i]);
            fullNameDelete.getChildren().add(separator1Delete[i]);
            nickNameDelete.getChildren().add(forTeacherNickNameDelete[i]);
            nickNameDelete.getChildren().add(separator2Delete[i]);
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }
    private boolean uploadData()
    {
        boolean success = false;
        String fullNameData = fullNameTextField.getText();
        String nickNameData = nickNameTextField.getText();
        if(fullNameData != null) fullNameData = fullNameData.replaceAll(" ", "_");
        final String fullName = fullNameData;
        final String nickName = nickNameData;
        Thread uploadDataThread = new Thread(){
           @Override
           public void run()
           {
                TeacherList teacherList = new TeacherList();
                teacherList.setData(fullName,nickName,emailTextField.getText());
            }
        };
        /*if-else mechanism for checking the atleast two courses and one coursecode is selected before uploading the data to database.*/
        if( fullName != null && nickName != null)
        {
           uploadDataThread.start();
           while(uploadDataThread.isAlive()); /*wait untill the uploadData thread has finished*/
           success = true;
        }
       else
           popup.alert("Invalid Data Set ", "Unable to Save Data!");
       return success;
    }
    private void restoreToDefault()
    {
        fullNameTextField.clear();
        nickNameTextField.clear();
        emailTextField.clear();
    }
 
}

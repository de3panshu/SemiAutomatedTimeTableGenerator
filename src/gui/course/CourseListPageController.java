/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.course;

/**
 *
 * @author Deepanshu Sahu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import database.base.CourseList;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class CourseListPageController implements Initializable {

      
    PopupNotification popup;
    
    @FXML
    TextField courseCodeTextField;
    @FXML
    TextField creditTextField;
    @FXML
    private VBox courseCodeView;
    @FXML
    private VBox creditView;
    @FXML
    private VBox courseCodeDelete;
    @FXML
    private VBox creditDelete;
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
    private void submitButtonEvent(ActionEvent e)
    {
        if(uploadData())
        {
            loadCourseList();
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
                    new CourseList().deleteAll();
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        courseCodeView.getChildren().clear();
        creditView.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        creditDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadCourseList();
       popup = new PopupNotification();
    } 
    
    
    private void loadCourseList()
    {  
        CourseList courseList = new CourseList();
	FontAwesomeIconView icon;
        int  noOfRecord = courseList.count();
        Label [] forCourseCodeView = new Label[noOfRecord];       
        Label [] forCreditView = new Label[noOfRecord];       
        
        Label [] forCourseCodeDelete = new Label[noOfRecord];       
        Label [] forCreditDelete = new Label[noOfRecord];       
        
        Separator [] separator1View = new Separator[noOfRecord];
        Separator [] separator2View = new Separator[noOfRecord];
        Separator [] separator1Delete = new Separator[noOfRecord];
        Separator [] separator2Delete = new Separator[noOfRecord];
        
        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        courseCodeView.getChildren().clear();
        creditView.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        creditDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            courseList.display();
                 
            forCourseCodeView[i] = new Label(courseList.getCourseCode());
            forCreditView[i] = new Label(""+ courseList.getLecture()+"+"+courseList.getTutorial()+"+"+courseList.getPractical());
            forCourseCodeDelete[i] = new Label((courseList.getCourseCode()));
            forCreditDelete[i] = new Label(""+ courseList.getLecture()+"+"+courseList.getTutorial()+"+"+courseList.getPractical());
                    
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
                   
            forCourseCodeView[i].getStyleClass().add("colData");
            forCreditView[i].getStyleClass().add("colData");
            forCourseCodeDelete[i].getStyleClass().add("colData");
            forCreditDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
           
            forCourseCodeView[i].setMaxWidth(Double.MAX_VALUE);
            forCreditView[i].setMaxWidth(Double.MAX_VALUE);
            forCourseCodeDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCreditDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String courseCode = forCourseCodeDelete[i].getText();
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                new CourseList().delete(courseCode);
                loadCourseList();
            });
        }
        for(int i=0;i<noOfRecord;i++)
        {
            courseCodeView.getChildren().add(forCourseCodeView[i]);
            courseCodeView.getChildren().add(separator1View[i]);
            creditView.getChildren().add(forCreditView[i]);
            creditView.getChildren().add(separator2View[i]);
                    
            courseCodeDelete.getChildren().add(forCourseCodeDelete[i]);
            courseCodeDelete.getChildren().add(separator1Delete[i]);
            creditDelete.getChildren().add(forCreditDelete[i]);
            creditDelete.getChildren().add(separator2Delete[i]);
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }
    private boolean uploadData()
    {
        boolean success = false;
        String courseCodeData = courseCodeTextField.getText();
        char [] creditData = (creditTextField.getText()).toCharArray();        
        final String courseCode = courseCodeData;
        final int practical = Character.getNumericValue(creditData[2]);
        final int tutorial = Character.getNumericValue(creditData[1]);
        final int lecture  = Character.getNumericValue(creditData[0]);
        Thread uploadDataThread = new Thread(){
           @Override
           public void run()
           {
                CourseList courseList = new CourseList();
                courseList.setData(courseCode,"",lecture,tutorial,practical );
            }
        };
        /*if-else mechanism for checking the atleast two courses and one coursecode is selected before uploading the data to database.*/
        if( courseCode != null && Character.isDigit(creditData[0]) && Character.isDigit(creditData[1]) && Character.isDigit(creditData[2]) && creditData.length == 3 )
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
        courseCodeTextField.clear();
        creditTextField.clear();
    }

}

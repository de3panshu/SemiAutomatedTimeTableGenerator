/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.particularcourselist;

import database.base.CourseList;
import database.base.ParticularProgramCourseList;
import database.base.ProgramList;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import gui.PopupNotification;
import gui.tools.autocompletecombobox.AutoCompleteBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class ParticularProgramCourseListPageController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    String activeProgramName;
    PopupNotification popup;
    
    
    @FXML
    private ComboBox<String> courseCodeComboBox ;
    @FXML
    private ComboBox<String> selectProgramNameComboBox ;
    @FXML
    private VBox courseCodeView;
    @FXML
    private VBox courseCodeDelete;
    @FXML
    private VBox crossButtonVBox;
    
    
    
    @FXML
    private void submitButtonEvent(ActionEvent e)
    {
        if(uploadData())
        {  
            loadParticularProgramCourseList();
            restoreToDefault();
            popup.confirm("Data Saved","Successful");
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
                    new ParticularProgramCourseList(activeProgramName).deleteAll();
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        courseCodeView.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       mainApp = ParticularProgramCourseListPage.primaryStage;
       loadProgramList();
       loadCourseCodeList();
       
       // programName combobox event
       selectProgramNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeProgramName = newValue.replaceAll(" ", "_");
           loadParticularProgramCourseList();
       });
       popup = new PopupNotification();
    } 
    
    
    private void loadProgramList()
    {
        ObservableList<String> programList = FXCollections.observableArrayList();
        Thread programListThread = new Thread(){
            @Override
            public void run()
	    {
                /*loading all the data stored in PROGRAMLIST in database*/
                ProgramList pl = new ProgramList();
                int counter = pl.count();
                for(int i=0;i<counter;i++)
                {
                    pl.getData();
                    programList.add((pl.getProgramName()+pl.getSemester()).replaceAll("_", " "));
                }
                /*adding the data into comboboxes*/
                selectProgramNameComboBox.setItems(programList);
            }
	};
        programListThread.start();
        //waiting till programList thread complete.
        while(programListThread.isAlive());
        new AutoCompleteBox(selectProgramNameComboBox);
       
    }
    private void loadCourseCodeList()
    {
        ObservableList<String> courseCodeList = FXCollections.observableArrayList();
        Thread courseCodeListThread = new Thread(){
            @Override
            public void run()
            {
                /*loading all the data stored in COURSELIST in database*/
                CourseList cl = new CourseList();
                int counter = cl.count();
                for(int i=0;i<counter;i++)
                {
                    cl.getData();
                    courseCodeList.add(cl.getCourseCode());
                }
                /*adding the data into combobox*/
                courseCodeComboBox.setItems(courseCodeList);
                
            }
        };
        courseCodeListThread.start();
         //waiting till courseCodeList thread complete.
        while(courseCodeListThread.isAlive());
        new AutoCompleteBox(courseCodeComboBox);
    }
    private void loadParticularProgramCourseList()
    {  
        ParticularProgramCourseList ppcl = new ParticularProgramCourseList(activeProgramName+"_cl");
	FontAwesomeIconView icon;
        int  noOfRecord = ppcl.count();
        Label [] forCourseCodeView = new Label[noOfRecord];
        Label [] forCourseCodeDelete = new Label[noOfRecord];
        Separator [] separator4View = new Separator[noOfRecord];
        Separator [] separator4Delete = new Separator[noOfRecord];

        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        courseCodeView.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            ppcl.display();
                 
            forCourseCodeView[i] = new Label(ppcl.getCourseCode());
            forCourseCodeDelete[i] = new Label(ppcl.getCourseCode());
                
            forCrossButtonVBox[i] =  new Button();
            
            icon = new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
            icon.setGlyphSize(22);
            icon.setStroke(Paint.valueOf("RED"));
            forCrossButtonVBox[i].setGraphic(icon);
            
                    
            separator4View[i] = new Separator();
            separator4View[i].setMaxWidth(Double.MAX_VALUE);
            separator4Delete[i] = new Separator();
            separator4Delete[i].setMaxWidth(Double.MAX_VALUE);
            separatorCrossButton[i] = new Separator();
            separatorCrossButton[i].setMaxWidth(Double.MAX_VALUE);
                    
                    
            separator4View[i].getStyleClass().add("divider");
            separator4Delete[i].getStyleClass().add("divider");
            separatorCrossButton[i].getStyleClass().add("divider");
                   
            forCourseCodeView[i].getStyleClass().add("colData");
            forCourseCodeDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
            
                    
            forCourseCodeView[i].setMaxWidth(Double.MAX_VALUE);
            forCourseCodeDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String courseCode = forCourseCodeDelete[i].getText();
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                 new ParticularProgramCourseList(activeProgramName+"_cl").delete( courseCode);
                 loadParticularProgramCourseList();
            });
        }
        
        for(int i=0;i<noOfRecord;i++)
        {
            courseCodeView.getChildren().add(forCourseCodeView[i]);
            courseCodeView.getChildren().add(separator4View[i]);
                   
            courseCodeDelete.getChildren().add(forCourseCodeDelete[i]);
            courseCodeDelete.getChildren().add(separator4Delete[i]);
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }    
    @SuppressWarnings("empty-statement")
        
    private boolean uploadData()
    {
        boolean success = false;
        final String courseCodeData = courseCodeComboBox.getSelectionModel().getSelectedItem();
        Thread uploadDataThread = new Thread(){
           @Override
           public void run()
           {
               ParticularProgramCourseList ppcl = new ParticularProgramCourseList(activeProgramName+"_cl");
               ppcl.setData( courseCodeData);
           }
        };
        /*if-else mechanism for checking the atleast two programs and one coursecode is selected before uploading the data to database.*/
        if(courseCodeData != null && activeProgramName != null)
        {
           
           uploadDataThread.start();
           while(uploadDataThread.isAlive()); /*wait untill the uploadData thread has finished*/
           success = true;
        }
       else
           popup.alert("Invalid Data Set", "Unable To Save Data!");
       return success;
    }
    
    private void restoreToDefault()
    {
        courseCodeComboBox.getSelectionModel().clearSelection();
        courseCodeComboBox.setValue(null);
    }
}


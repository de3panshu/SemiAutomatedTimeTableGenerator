/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.combineclasses;

import database.base.CourseList;
import database.base.ProgramList;
import database.intermediate.CombineClasses;
import database.intermediate.ParticularProgramSchedule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import gui.PopupNotification;
import gui.tools.autocompletecombobox.AutoCompleteBox;
import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class CombineClassPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    PopupNotification popup;
    
    @FXML
    private ComboBox<String> programName1ComboBox ;
    @FXML
    private ComboBox<String> programName2ComboBox ;
    @FXML
    private ComboBox<String> programName3ComboBox ;
    @FXML
    private ComboBox<String> courseCodeComboBox ;
    @FXML
    private VBox programName1View;
    @FXML
    private VBox programName2View;
    @FXML
    private VBox programName3View;
    @FXML
    private VBox courseCodeView;
    @FXML
    private VBox programName1Delete;
    @FXML
    private VBox programName2Delete;
    @FXML
    private VBox programName3Delete;
    @FXML
    private VBox courseCodeDelete;
    @FXML
    private VBox crossButtonVBox;
    
    
    
    @FXML
    private void submitButtonEvent(ActionEvent e)
    {
        if(uploadData())
        {
            loadCombineClassList();
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
                    new CombineClasses().deleteAll();
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        programName1View.getChildren().clear();
        programName2View.getChildren().clear();
        programName3View.getChildren().clear();
        courseCodeView.getChildren().clear();
        programName1Delete.getChildren().clear();
        programName2Delete.getChildren().clear();
        programName3Delete.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadProgramList();
       loadCourseCodeList();
       loadCombineClassList();
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
                programName1ComboBox.setItems(programList);
                programName2ComboBox.setItems(programList);
                programName3ComboBox.setItems(programList);
            }
	};
        programListThread.start();
        while(programListThread.isAlive());
        new AutoCompleteBox(programName1ComboBox);
        new AutoCompleteBox(programName2ComboBox);
        new AutoCompleteBox(programName3ComboBox);
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
        while(courseCodeListThread.isAlive());
        new AutoCompleteBox(courseCodeComboBox);
    }
    private void loadCombineClassList()
    {  
        CombineClasses combineClassList = new CombineClasses();
	FontAwesomeIconView icon;
        int  noOfRecord = combineClassList.count();
        Label [] forProgramName1View = new Label[noOfRecord];       
        Label [] forProgramName2View = new Label[noOfRecord];       
        Label [] forProgramName3View = new Label[noOfRecord];       
        Label [] forCourseCodeView = new Label[noOfRecord];
        Label [] forProgramName1Delete = new Label[noOfRecord];       
        Label [] forProgramName2Delete = new Label[noOfRecord];       
        Label [] forProgramName3Delete = new Label[noOfRecord];       
        Label [] forCourseCodeDelete = new Label[noOfRecord];
        Separator [] separator1View = new Separator[noOfRecord];
        Separator [] separator2View = new Separator[noOfRecord];
        Separator [] separator3View = new Separator[noOfRecord];
        Separator [] separator4View = new Separator[noOfRecord];
        Separator [] separator1Delete = new Separator[noOfRecord];
        Separator [] separator2Delete = new Separator[noOfRecord];
        Separator [] separator3Delete = new Separator[noOfRecord];
        Separator [] separator4Delete = new Separator[noOfRecord];

        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        programName1View.getChildren().clear();
        programName2View.getChildren().clear();
        programName3View.getChildren().clear();
        courseCodeView.getChildren().clear();
        programName1Delete.getChildren().clear();
        programName2Delete.getChildren().clear();
        programName3Delete.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            combineClassList.display();
                 
            forProgramName1View[i] = new Label(combineClassList.getProgramName1());
            forProgramName2View[i] = new Label(combineClassList.getProgramName2());
            forProgramName3View[i] = new Label(combineClassList.getProgramName3());
            forCourseCodeView[i] = new Label(combineClassList.getCourseCode());
            forProgramName1Delete[i] = new Label(combineClassList.getProgramName1());
            forProgramName2Delete[i] = new Label(combineClassList.getProgramName2());
            forProgramName3Delete[i] = new Label(combineClassList.getProgramName3());
            forCourseCodeDelete[i] = new Label(combineClassList.getCourseCode());
                    
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
            separator3View[i] = new Separator();
            separator3View[i].setMaxWidth(Double.MAX_VALUE);
            separator4View[i] = new Separator();
            separator4View[i].setMaxWidth(Double.MAX_VALUE);
            separator1Delete[i] = new Separator();
            separator1Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator2Delete[i] = new Separator();
            separator2Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator3Delete[i] = new Separator();
            separator3Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator4Delete[i] = new Separator();
            separator4Delete[i].setMaxWidth(Double.MAX_VALUE);
            separatorCrossButton[i] = new Separator();
            separatorCrossButton[i].setMaxWidth(Double.MAX_VALUE);
                   
            separator1View[i].getStyleClass().add("divider");
            separator2View[i].getStyleClass().add("divider");
            separator3View[i].getStyleClass().add("divider");
            separator4View[i].getStyleClass().add("divider");
            separator1Delete[i].getStyleClass().add("divider");
            separator2Delete[i].getStyleClass().add("divider");
            separator3Delete[i].getStyleClass().add("divider");
            separator4Delete[i].getStyleClass().add("divider");
            separatorCrossButton[i].getStyleClass().add("divider");
                   
            forProgramName1View[i].getStyleClass().add("colData");
            forProgramName2View[i].getStyleClass().add("colData");
            forProgramName3View[i].getStyleClass().add("colData");
            forCourseCodeView[i].getStyleClass().add("colData");
            forProgramName1Delete[i].getStyleClass().add("colData");
            forProgramName2Delete[i].getStyleClass().add("colData");
            forProgramName3Delete[i].getStyleClass().add("colData");
            forCourseCodeDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
           
            forProgramName1View[i].setMaxWidth(Double.MAX_VALUE);
            forProgramName2View[i].setMaxWidth(Double.MAX_VALUE);
            forProgramName3View[i].setMaxWidth(Double.MAX_VALUE);
            forCourseCodeView[i].setMaxWidth(Double.MAX_VALUE);
            forProgramName1Delete[i].setMaxWidth(Double.MAX_VALUE);
            forProgramName2Delete[i].setMaxWidth(Double.MAX_VALUE);
            forProgramName3Delete[i].setMaxWidth(Double.MAX_VALUE);
            forCourseCodeDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String programName1 = forProgramName1Delete[i].getText();
            final String programName2 = forProgramName2Delete[i].getText();
            final String programName3 = forProgramName3Delete[i].getText();
            final String courseCode = forCourseCodeDelete[i].getText();
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                new CombineClasses().delete(programName1, programName2, programName3, courseCode);
                loadCombineClassList();
            });
        }
        for(int i=0;i<noOfRecord;i++)
        {
            programName1View.getChildren().add(forProgramName1View[i]);
            programName1View.getChildren().add(separator1View[i]);
            programName2View.getChildren().add(forProgramName2View[i]);
            programName2View.getChildren().add(separator2View[i]);
            programName3View.getChildren().add(forProgramName3View[i]);
            programName3View.getChildren().add(separator3View[i]);
            courseCodeView.getChildren().add(forCourseCodeView[i]);
            courseCodeView.getChildren().add(separator4View[i]);
                    
            programName1Delete.getChildren().add(forProgramName1Delete[i]);
            programName1Delete.getChildren().add(separator1Delete[i]);
            programName2Delete.getChildren().add(forProgramName2Delete[i]);
            programName2Delete.getChildren().add(separator2Delete[i]);
            programName3Delete.getChildren().add(forProgramName3Delete[i]);
            programName3Delete.getChildren().add(separator3Delete[i]);
            courseCodeDelete.getChildren().add(forCourseCodeDelete[i]);
            courseCodeDelete.getChildren().add(separator4Delete[i]);
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }
    private boolean uploadData()
    {
        boolean success = false;
        String programName1Data = programName1ComboBox.getSelectionModel().getSelectedItem();
        String programName2Data = programName2ComboBox.getSelectionModel().getSelectedItem();
        String programName3Data = programName3ComboBox.getSelectionModel().getSelectedItem();
        
        if(programName1Data != null)
            programName1Data = programName1Data.replaceAll(" ", "_");
        if(programName2Data != null)
            programName2Data = programName2Data.replaceAll(" ", "_");
        if(programName3Data != null)
            programName3Data = programName3Data.replaceAll(" ", "_");
        
        final String program1 = programName1Data;
        final String program2 = programName2Data;
        final String program3 = programName3Data;
        final String courseCodeData = courseCodeComboBox.getSelectionModel().getSelectedItem();
        Thread uploadDataThread = new Thread(){
           @Override
           public void run()
           {
              CombineClasses combineClassList = new CombineClasses();
                if(program1 == null)
                    combineClassList.setData("", program2, program3, courseCodeData);
                else if(program2 == null)
                    combineClassList.setData(program1, "", program3, courseCodeData);
                else if(program3 == null)
                    combineClassList.setData(program1, program2,"", courseCodeData);
                else
                    combineClassList.setData(program1, program2,program3, courseCodeData);
            }
        };
        /*if-else mechanism for checking the atleast two programs and one coursecode is selected before uploading the data to database.*/
        if(courseCodeData != null)
        {
            if( programName1Data != null && programName2Data !=null)
            {
                if(new ParticularProgramSchedule(programName1Data+"_cs").search(courseCodeData) && new ParticularProgramSchedule(programName2Data+"_cs").search(courseCodeData))
                    success = true;
            }
            else if(programName2Data != null && programName3Data !=null) 
            {
                if(new ParticularProgramSchedule(programName3Data+"_cs").search(courseCodeData) && new ParticularProgramSchedule(programName2Data+"_cs").search(courseCodeData))
                    success = true;
            }
            else if(programName1Data != null && programName3Data !=null) 
            {
                if(new ParticularProgramSchedule(programName1Data+"_cs").search(courseCodeData) && new ParticularProgramSchedule(programName3Data+"_cs").search(courseCodeData))
                    success = true;
            }
            else
            {
                popup.alert("Invalid Data Set ", "Unable to Save Data!");
            }
        }
        else
           popup.alert("Invalid Data Set ", "Unable to Save Data!");
        if(success)
        {
            uploadDataThread.start();
        }
       return success;
    }
    private void restoreToDefault()
    {
        programName1ComboBox.getSelectionModel().clearSelection();
        programName1ComboBox.setValue(null);
        
        programName2ComboBox.getSelectionModel().clearSelection();
        programName2ComboBox.setValue(null);
        
        programName3ComboBox.getSelectionModel().clearSelection();
        programName3ComboBox.setValue(null);
        
        courseCodeComboBox.getSelectionModel().clearSelection();
        courseCodeComboBox.setValue(null);
    }
}

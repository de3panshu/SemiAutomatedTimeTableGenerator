/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.particularTeacherAllotment;

import database.base.CourseList;
import database.base.ParticularProgramCourseList;
import database.base.ProgramList;
import database.base.TeacherList;
import database.intermediate.ParticularProgramSchedule;
import database.superclass.ParticularProgramTimeTable;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class ParticularProgramSchedulePageController implements Initializable 
{

    PopupNotification popup;
    String activeProgramName;
    String activeCourseCode;
    @FXML
    private ComboBox<String> programNameComboBox ;
    @FXML
    private ComboBox<String> lectureTeacher1ComboBox ;
    @FXML
    private ComboBox<String> lectureTeacher2ComboBox ;
    @FXML
    private ComboBox<String> tutorialTeacherComboBox ;
    @FXML
    private ComboBox<String> practicalTeacher1ComboBox ;
    @FXML
    private ComboBox<String> practicalTeacher2ComboBox ;
    @FXML
    private ComboBox<String> practicalTeacher3ComboBox ;
    @FXML
    private ComboBox<String> courseCodeComboBox ;
    @FXML
    private ComboBox<String> typeComboBox ;
    @FXML
    private VBox courseCodeView;
    @FXML
    private VBox lectureTeacherView;
    @FXML
    private VBox tutorialTeacherView;
    @FXML
    private VBox practicalTeacherView;
    @FXML
    private VBox typeView;
    @FXML
    private VBox courseCodeDelete;
    @FXML
    private VBox lectureTeacherDelete;
    @FXML
    private VBox tutorialTeacherDelete;
    @FXML
    private VBox practicalTeacherDelete;    
    @FXML
    private VBox typeDelete;
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
        {   createSticker();
            loadParticularProgramScheduleList();
            restoreToDefault(true);
            makeDisable();
            
            popup.confirm("Data saved", "Successful");
        }
    }
    @FXML
    private void cancelButtonEvent(ActionEvent e)
    {
        restoreToDefault(true);
    }
    @FXML
    private void resetButtonEvent(ActionEvent e)
    {
        Thread resetButtonThread = new Thread()
                {
                    @Override
                    public void run()
                {
                    new ParticularProgramSchedule(activeProgramName+"_cs").deleteAll();
                    new ParticularProgramTimeTable(activeProgramName+"_tt_st").deleteAllSticker();
                    
                    
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        courseCodeView.getChildren().clear();
        lectureTeacherView.getChildren().clear();
        tutorialTeacherView.getChildren().clear();
        practicalTeacherView.getChildren().clear();
        typeView.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        lectureTeacherDelete.getChildren().clear();
        tutorialTeacherDelete.getChildren().clear();
        practicalTeacherDelete.getChildren().clear();
        typeDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       popup = new PopupNotification();
        loadProgramList();
       loadTeacherList();
       makeDisable();
       activeProgramName = "";
       activeCourseCode = "";
       // programName combobox event
       programNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeProgramName = newValue.replaceAll(" ", "_");
           loadParticularProgramScheduleList();
          
       });
       courseCodeComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeCourseCode = newValue;
           restoreToDefault(false);
           makeDisable();
       });
       /*adding the items in typeComboBox*/
       typeComboBox.setItems(FXCollections.observableArrayList("+","||"));
      
       /*events that judge when typeComboBox is enabled and when disabled...*/ 
      lectureTeacher1ComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           if(lectureTeacher2ComboBox.getSelectionModel().getSelectedItem() != null)
               typeComboBox.setDisable(false);
       });
      lectureTeacher2ComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           if(lectureTeacher1ComboBox.getSelectionModel().getSelectedItem() != null)
               typeComboBox.setDisable(false);
       });
      practicalTeacher1ComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           if(practicalTeacher2ComboBox.getSelectionModel().getSelectedItem() != null || practicalTeacher3ComboBox.getSelectionModel().getSelectedItem() != null)
               typeComboBox.setDisable(false);
       });
      practicalTeacher2ComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           if(practicalTeacher1ComboBox.getSelectionModel().getSelectedItem() != null || practicalTeacher3ComboBox.getSelectionModel().getSelectedItem() != null)
               typeComboBox.setDisable(false);
       });
      practicalTeacher3ComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           if(practicalTeacher1ComboBox.getSelectionModel().getSelectedItem() != null || practicalTeacher2ComboBox.getSelectionModel().getSelectedItem() != null)
               typeComboBox.setDisable(false);
       });
      
      
      
      
       new AutoCompleteBox(programNameComboBox);
       new AutoCompleteBox(courseCodeComboBox);
       new AutoCompleteBox(lectureTeacher1ComboBox);
       new AutoCompleteBox(lectureTeacher2ComboBox);
       new AutoCompleteBox(tutorialTeacherComboBox);
       new AutoCompleteBox(practicalTeacher1ComboBox);
       new AutoCompleteBox(practicalTeacher2ComboBox);
       new AutoCompleteBox(practicalTeacher3ComboBox);
       new AutoCompleteBox(typeComboBox);
        
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
                programNameComboBox.setItems(programList);                
            }
	};
        programListThread.start();
        while(programListThread.isAlive());        
    }
    private void loadTeacherList()
    {
        ObservableList<String> teacherList = FXCollections.observableArrayList();
        Thread teacherListThread = new Thread(){
            @Override
            public void run()
	    {
                /*loading all the data stored in PROGRAMLIST in database*/
                TeacherList tl = new TeacherList();
                int counter = tl.count();
                for(int i=0;i<counter;i++)
                {
                    tl.getData();
                    teacherList.add((tl.getTeacherFullName()).replaceAll("_", " "));
                }
                /*adding the data into comboboxes*/
                lectureTeacher1ComboBox.setItems(teacherList);                
                lectureTeacher2ComboBox.setItems(teacherList);                
                tutorialTeacherComboBox.setItems(teacherList);          
                practicalTeacher1ComboBox.setItems(teacherList);                
                practicalTeacher2ComboBox.setItems(teacherList);                
                practicalTeacher3ComboBox.setItems(teacherList);                
            }
	};
        teacherListThread.start();
        while(teacherListThread.isAlive());        
    }
    private void loadCourseCodeList()
    {
        ObservableList<String> courseCodeList = FXCollections.observableArrayList();
        Thread courseCodeListThread = new Thread(){
            @Override
            public void run()
            {
                /*loading all the data stored in COURSELIST in database*/
                ParticularProgramCourseList ppcl = new ParticularProgramCourseList(activeProgramName+"_cl");
                ParticularProgramSchedule pps = new ParticularProgramSchedule(activeProgramName+"_cs");
                while( ppcl.getData())
                {
                   
                    if(!pps.search(ppcl.getCourseCode()))
                        courseCodeList.add(ppcl.getCourseCode());
                }
                /*adding the data into combobox*/
                courseCodeComboBox.setItems(courseCodeList);
            }
        };
        courseCodeListThread.start();
        while(courseCodeListThread.isAlive());
    }
    private void loadParticularProgramScheduleList()
    {  
        loadCourseCodeList();
        ParticularProgramSchedule pps = new ParticularProgramSchedule(activeProgramName+"_cs");
        TeacherList teacher = new TeacherList();
	FontAwesomeIconView icon;
        int  noOfRecord = pps.count();
        
        Label [] forCourseCodeView = new Label[noOfRecord];
        Label [] forLectureTeacherView = new Label[noOfRecord];       
        Label [] forTutorialTeacherView = new Label[noOfRecord];       
        Label [] forPracticalTeacherView = new Label[noOfRecord];       
        Label [] forTypeView = new Label[noOfRecord];
        
        Label [] forCourseCodeDelete = new Label[noOfRecord];
        Label [] forLectureTeacherDelete = new Label[noOfRecord];       
        Label [] forTutorialTeacherDelete = new Label[noOfRecord];       
        Label [] forPracticalTeacherDelete = new Label[noOfRecord];       
        Label [] forTypeDelete = new Label[noOfRecord];
        Separator [] separator1View = new Separator[noOfRecord];
        Separator [] separator2View = new Separator[noOfRecord];
        Separator [] separator3View = new Separator[noOfRecord];
        Separator [] separator4View = new Separator[noOfRecord];
        Separator [] separator5View = new Separator[noOfRecord];
        Separator [] separator1Delete = new Separator[noOfRecord];
        Separator [] separator2Delete = new Separator[noOfRecord];
        Separator [] separator3Delete = new Separator[noOfRecord];
        Separator [] separator4Delete = new Separator[noOfRecord];
        Separator [] separator5Delete = new Separator[noOfRecord];

        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        courseCodeView.getChildren().clear();
        lectureTeacherView.getChildren().clear();
        tutorialTeacherView.getChildren().clear();
        practicalTeacherView.getChildren().clear();
        typeView.getChildren().clear();
        courseCodeDelete.getChildren().clear();
        lectureTeacherDelete.getChildren().clear();
        tutorialTeacherDelete.getChildren().clear();
        practicalTeacherDelete.getChildren().clear();
        typeDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            pps.display();
               
            String lectureTeacher1Data = (pps.getLectureTeacher1()).replaceAll("_", " ");
            String lectureTeacher2Data = (pps.getLectureTeacher2()).replaceAll("_", " ");
            String tutorialTeacherData = (pps.getTutorialTeacher()).replaceAll("_", " ");
            String practicalTeacher1Data = (pps.getPracticalTeacher1()).replaceAll("_", " ");
            String practicalTeacher2Data = (pps.getPracticalTeacher2()).replaceAll("_", " ");
            String practicalTeacher3Data = (pps.getPracticalTeacher3()).replaceAll("_", " ");
            String typeData;
            switch (pps.getType()) {
                case 0:
                    typeData = "";
                    break;
                case 1:
                    typeData = "+";
                    break;
                default:
                    typeData = "||";
                    break;
            }
            
            forCourseCodeView[i] = new Label(pps.getCourseCode());
            forLectureTeacherView[i] = new Label(lectureTeacher1Data+"  "+lectureTeacher2Data);
            forTutorialTeacherView[i] = new Label(tutorialTeacherData);
            forPracticalTeacherView[i] = new Label(practicalTeacher1Data+"  "+practicalTeacher2Data+"  "+practicalTeacher3Data);
            forTypeView[i] = new Label(typeData);
            
            forCourseCodeDelete[i] = new Label(pps.getCourseCode());
            forLectureTeacherDelete[i] = new Label(lectureTeacher1Data+" "+lectureTeacher2Data);
            forTutorialTeacherDelete[i] = new Label(tutorialTeacherData);
            forPracticalTeacherDelete[i] = new Label(practicalTeacher1Data+"  "+practicalTeacher2Data+"  "+practicalTeacher3Data);
            forTypeDelete[i] = new Label(typeData);
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
            separator5View[i] = new Separator();
            separator5View[i].setMaxWidth(Double.MAX_VALUE);
            separator1Delete[i] = new Separator();
            separator1Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator2Delete[i] = new Separator();
            separator2Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator3Delete[i] = new Separator();
            separator3Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator4Delete[i] = new Separator();
            separator4Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator5Delete[i] = new Separator();
            separator5Delete[i].setMaxWidth(Double.MAX_VALUE);
            separatorCrossButton[i] = new Separator();
            separatorCrossButton[i].setMaxWidth(Double.MAX_VALUE);
                   
            separator1View[i].getStyleClass().add("divider");
            separator2View[i].getStyleClass().add("divider");
            separator3View[i].getStyleClass().add("divider");
            separator4View[i].getStyleClass().add("divider");
            separator5View[i].getStyleClass().add("divider");
            separator1Delete[i].getStyleClass().add("divider");
            separator2Delete[i].getStyleClass().add("divider");
            separator3Delete[i].getStyleClass().add("divider");
            separator4Delete[i].getStyleClass().add("divider");
            separator5Delete[i].getStyleClass().add("divider");
            separatorCrossButton[i].getStyleClass().add("divider");
                   
            forLectureTeacherView[i].getStyleClass().add("colData");
            forTutorialTeacherView[i].getStyleClass().add("colData");
            forPracticalTeacherView[i].getStyleClass().add("colData");
            forCourseCodeView[i].getStyleClass().add("colData");
            forTypeView[i].getStyleClass().add("colData");
            forLectureTeacherDelete[i].getStyleClass().add("colData");
            forTutorialTeacherDelete[i].getStyleClass().add("colData");
            forPracticalTeacherDelete[i].getStyleClass().add("colData");
            forCourseCodeDelete[i].getStyleClass().add("colData");
            forTypeDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
  
            forLectureTeacherView[i].setMaxWidth(Double.MAX_VALUE);
            forTutorialTeacherView[i].setMaxWidth(Double.MAX_VALUE);
            forPracticalTeacherView[i].setMaxWidth(Double.MAX_VALUE);
            forCourseCodeView[i].setMaxWidth(Double.MAX_VALUE);
            forTypeView[i].setMaxWidth(Double.MAX_VALUE);
            forLectureTeacherDelete[i].setMaxWidth(Double.MAX_VALUE);
            forTutorialTeacherDelete[i].setMaxWidth(Double.MAX_VALUE);
            forPracticalTeacherDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCourseCodeDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
            forTypeDelete[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String courseCode = forCourseCodeDelete[i].getText();
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                pps.delete(courseCode);
                loadParticularProgramScheduleList();
                new ParticularProgramTimeTable(activeProgramName+"_tt_st").delete(courseCode);
            });
        }
        for(int i=0;i<noOfRecord;i++)
        {
            courseCodeView.getChildren().add(forCourseCodeView[i]);
            courseCodeView.getChildren().add(separator4View[i]);
            lectureTeacherView.getChildren().add(forLectureTeacherView[i]);
            lectureTeacherView.getChildren().add(separator1View[i]);
            tutorialTeacherView.getChildren().add(forTutorialTeacherView[i]);
            tutorialTeacherView.getChildren().add(separator2View[i]);
            practicalTeacherView.getChildren().add(forPracticalTeacherView[i]);
            practicalTeacherView.getChildren().add(separator3View[i]);
            typeView.getChildren().add(forTypeView[i]);
            typeView.getChildren().add(separator5View[i]);
            
            courseCodeDelete.getChildren().add(forCourseCodeDelete[i]);
            courseCodeDelete.getChildren().add(separator4Delete[i]);
            lectureTeacherDelete.getChildren().add(forLectureTeacherDelete[i]);
            lectureTeacherDelete.getChildren().add(separator1Delete[i]);
            tutorialTeacherDelete.getChildren().add(forTutorialTeacherDelete[i]);
            tutorialTeacherDelete.getChildren().add(separator2Delete[i]);
            practicalTeacherDelete.getChildren().add(forPracticalTeacherDelete[i]);
            practicalTeacherDelete.getChildren().add(separator3Delete[i]);
            typeDelete.getChildren().add(forTypeDelete[i]);
            typeDelete.getChildren().add(separator5Delete[i]);
            
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }
    private boolean uploadData()
    {
        boolean success = false;
        TeacherList teacher = new TeacherList();
        String lectureTeacher1Data = lectureTeacher1ComboBox.getSelectionModel().getSelectedItem();
        String lectureTeacher2Data = lectureTeacher2ComboBox.getSelectionModel().getSelectedItem();
        String tutorialTeacherData = tutorialTeacherComboBox.getSelectionModel().getSelectedItem();
        String practicalTeacher1Data = practicalTeacher1ComboBox.getSelectionModel().getSelectedItem();
        String practicalTeacher2Data = practicalTeacher2ComboBox.getSelectionModel().getSelectedItem();
        String practicalTeacher3Data = practicalTeacher3ComboBox.getSelectionModel().getSelectedItem();
        String typeData = typeComboBox.getSelectionModel().getSelectedItem();

        lectureTeacher1Data = lectureTeacher1Data == null? "" : lectureTeacher1Data.replaceAll(" ", "_");
        lectureTeacher2Data = lectureTeacher2Data == null? "" : lectureTeacher2Data.replaceAll(" ", "_");
        tutorialTeacherData = tutorialTeacherData == null? "" : tutorialTeacherData.replaceAll(" ", "_");
        practicalTeacher1Data = practicalTeacher1Data == null? "" : practicalTeacher1Data.replaceAll(" ", "_");
        practicalTeacher2Data = practicalTeacher2Data == null? "" : practicalTeacher2Data.replaceAll(" ", "_");
        practicalTeacher3Data = practicalTeacher3Data == null? "" : practicalTeacher3Data.replaceAll(" ", "_");
        typeData =  typeData == null? "" : typeData;
        
        final String lectureTeacher1 = lectureTeacher1Data;
        final String lectureTeacher2 = lectureTeacher2Data;
        final String tutorialTeacher = tutorialTeacherData;
        final String practicalTeacher1 = practicalTeacher1Data;
        final String practicalTeacher2 = practicalTeacher2Data;
        final String practicalTeacher3 = practicalTeacher3Data;
        final int type = "".equals(typeData)?0: "+".equals(typeData)?1:2;
        final String courseCode = courseCodeComboBox.getSelectionModel().getSelectedItem();
        Thread uploadDataThread = new Thread(){
            @Override
            public void run()
            {
                ParticularProgramSchedule pps = new ParticularProgramSchedule(activeProgramName+"_cs");
                pps.setData(courseCode, lectureTeacher1, lectureTeacher2, tutorialTeacher,practicalTeacher1,practicalTeacher2,practicalTeacher3,type);
            }
        };
        /*if-else mechanism for checking the atleast two programs and one coursecode is selected before uploading the data to database.*/
        if( check(lectureTeacher1,lectureTeacher2,tutorialTeacher,practicalTeacher1,practicalTeacher2,practicalTeacher3,courseCode))
        {
           uploadDataThread.start();
           while(uploadDataThread.isAlive()); /*wait untill the uploadData thread has finished*/
           success = true;
       }
       else
           popup.alert("Invalid Data Set ", "Unable to Save Data!");
        return success;
    }
    private void restoreToDefault(boolean forAll)
    {
        lectureTeacher1ComboBox.getSelectionModel().clearSelection();
        lectureTeacher1ComboBox.setValue(null);
        lectureTeacher2ComboBox.getSelectionModel().clearSelection();
        lectureTeacher2ComboBox.setValue(null);
        
        tutorialTeacherComboBox.getSelectionModel().clearSelection();
        tutorialTeacherComboBox.setValue(null);
        
        practicalTeacher1ComboBox.getSelectionModel().clearSelection();
        practicalTeacher1ComboBox.setValue(null);
        
        practicalTeacher2ComboBox.getSelectionModel().clearSelection();
        practicalTeacher2ComboBox.setValue(null);
        
        practicalTeacher3ComboBox.getSelectionModel().clearSelection();
        practicalTeacher3ComboBox.setValue(null);
        if(forAll)
        {
            courseCodeComboBox.getSelectionModel().clearSelection();
            courseCodeComboBox.setValue(null);
        }
        
        
        typeComboBox.getSelectionModel().clearSelection();
        typeComboBox.setValue(null);
    }
    private boolean check(String lectureTeacher1,String lectureTeacher2,String tutorialTeacher,String practicalTeacher1,String practicalTeacher2,String  practicalTeacher3, String courseCode)
    {
        boolean success = false;
        if(!lectureTeacher1ComboBox.isDisable() && (lectureTeacher1 != "" || lectureTeacher2 != ""))
        {
            success = true;
            System.out.println("1");
        }
        else 
            if(!practicalTeacher1ComboBox.isDisable() && (practicalTeacher1 != "" || practicalTeacher2 != "" || practicalTeacher3 !=""))
            {
                success = true;
                System.out.println("2");
            }  
        else
             if(!tutorialTeacherComboBox.isDisable() && tutorialTeacher != "")
             {
                 success = true;
                 System.out.println("3");
             }
        System.out.println("lecture: "+lectureTeacher1ComboBox.isDisable()+"\nPractical Teacher:"+practicalTeacher1ComboBox.isDisable()+"\nTutorial:"+tutorialTeacherComboBox.isDisable());
        if(!(success && courseCode != null))
            success = false;
        System.out.println(courseCode);
        return success;
    }
    private void makeDisable()
    {
        lectureTeacher1ComboBox.setDisable(true);
        lectureTeacher2ComboBox.setDisable(true);
        tutorialTeacherComboBox.setDisable(true);
        practicalTeacher1ComboBox.setDisable(true);
        practicalTeacher2ComboBox.setDisable(true);
        practicalTeacher3ComboBox.setDisable(true);
        typeComboBox.setDisable(true);
       
        if(activeCourseCode != null)
        { 
            CourseList courseList = new CourseList();
            courseList.getData(activeCourseCode);
            if(courseList.getLecture()>0)
            {
                lectureTeacher1ComboBox.setDisable(false);
                lectureTeacher2ComboBox.setDisable(false);
            }
            if(courseList.getTutorial()>0)
                tutorialTeacherComboBox.setDisable(false);
            if(courseList.getPractical()>0)
            {
                practicalTeacher1ComboBox.setDisable(false);
                practicalTeacher2ComboBox.setDisable(false);
                practicalTeacher3ComboBox.setDisable(false);
            }
        }
    }
    private void createSticker()
    {
        Thread makeSticker = new Thread()
        {
            @Override
            public void run()
            {
                ParticularProgramSchedule pps = new ParticularProgramSchedule(activeProgramName+"_cs");
                TeacherList  teacherList = new TeacherList();
                pps.search(activeCourseCode);
                ParticularProgramTimeTable timeTableSticker = new ParticularProgramTimeTable(activeProgramName+"_tt_st");
                String courseCode = pps.getCourseCode();
                String lectureTeacher1 = teacherList.getTeacherNickName(pps.getLectureTeacher1());
                String lectureTeacher2 = teacherList.getTeacherNickName(pps.getLectureTeacher2());
                String tutorialTeacher = teacherList.getTeacherNickName(pps.getTutorialTeacher());
                String practicalTeacher1 = teacherList.getTeacherNickName(pps.getPracticalTeacher1());
                String practicalTeacher2 = teacherList.getTeacherNickName(pps.getPracticalTeacher2());
                String practicalTeacher3 = teacherList.getTeacherNickName(pps.getPracticalTeacher3());
                int typeInInt = pps.getType();
                String type;
                switch(typeInInt)
                {
                    case 1:type="+";break;
                    case 2:type="||";break;
                    default: type="";break;
                }
                System.out.println("CourseCode : "+courseCode);
                System.out.println("Lecture Teacher1 : "+lectureTeacher1);
                System.out.println("Lecture Teacher2 : "+lectureTeacher2);
                System.out.println("tutorial Teacher : "+tutorialTeacher);
                System.out.println("practical Teacher1 : "+practicalTeacher1);
                System.out.println("practical Teacher2 : "+practicalTeacher2);
                System.out.println("practical Teacher3 : "+practicalTeacher3);
                System.out.println("type: "+type);
                //making the main teacher
                String mainTeacher = lectureTeacher1;
                if(mainTeacher == null)
                {
                    mainTeacher = lectureTeacher2;
                    if(mainTeacher == null)
                    {    mainTeacher = tutorialTeacher;
                        if(mainTeacher == null)
                        {    mainTeacher = practicalTeacher1;
                            if(mainTeacher == null)
                            {    mainTeacher = practicalTeacher2;
                                if(mainTeacher == null)
                                    mainTeacher = practicalTeacher3;
                            }        
                        }
                    }    
                }
                /*serializing lecture Classes*/
                if((lectureTeacher2 != "" || lectureTeacher2 != null )&& (lectureTeacher1 == "" || lectureTeacher1 == null))
                {
                    lectureTeacher1 = lectureTeacher2;
                    lectureTeacher2 = "";
                }
                else if((lectureTeacher1 == "" || lectureTeacher1 == null)&& (lectureTeacher2 == "" || lectureTeacher2 == null))
                {
                    lectureTeacher1 = mainTeacher;
                    lectureTeacher2 = "";
                }
                else if(lectureTeacher2 == "" || lectureTeacher2 == null) 
                    lectureTeacher2 = "";
                    
                /*serailising tutorialClasses*/
                if(tutorialTeacher.equals("") || tutorialTeacher == null)
                    tutorialTeacher = mainTeacher;
                
                /*seralising practical teacher*/
                if((practicalTeacher3 != "" || practicalTeacher3 != null)&& (practicalTeacher2 == "" || practicalTeacher2 == null))
                {
                    practicalTeacher2 = practicalTeacher3;
                    practicalTeacher3 = "";
                }
                else if(practicalTeacher3 == "" || practicalTeacher3 == null)
                {
                    practicalTeacher3 = "";
                }
                if((practicalTeacher2 != "" || practicalTeacher2 != null) && (practicalTeacher1 == "" || practicalTeacher1 == null))
                {
                    practicalTeacher1 = practicalTeacher2;
                    practicalTeacher2 = "";
                }
                else if(practicalTeacher2 == "" || practicalTeacher2 == null)
                {
                    practicalTeacher2 = "";
                }
                if(practicalTeacher1 == "" || practicalTeacher1 == null)
                {
                    practicalTeacher1 = mainTeacher;
                }
                
                if(type == "" || type == null)
                    type = "";
                CourseList courseList = new CourseList();
                courseList.getData(courseCode);
                int lectureClass = courseList.getLecture();
                int tutorialClass = courseList.getTutorial();
                int practicalClass = courseList.getPractical();
                
                
                System.out.println("Main Teacher :"+mainTeacher);
                System.out.println("Lecture Teacher1 : "+lectureTeacher1);
                System.out.println("Lecture Teacher2 : "+lectureTeacher2);
                System.out.println("tutorial Teacher : "+tutorialTeacher);
                System.out.println("practical Teacher1 : "+practicalTeacher1);
                System.out.println("practical Teacher2 : "+practicalTeacher2);
                System.out.println("practical Teacher3 : "+practicalTeacher3);
                System.out.println("type: "+type);
                
                if(type.equals("||"))
                {
                    if(lectureTeacher2.equals(""))
                        lectureTeacher2 = lectureTeacher1;
                    for(int i=0;i<lectureClass;i++)
                    {
                        if(i%2 == 0)
                            timeTableSticker.setData(0,courseCode,"Lecture","",lectureTeacher1,"","");
                        else
                            timeTableSticker.setData(0,courseCode,"Lecture","",lectureTeacher2,"","");
                    }
                    for(int i=0;i<tutorialClass;i++)
                    {
                        timeTableSticker.setData(0,courseCode,"Tutorial","",tutorialTeacher,"","");
                    }
                    if(practicalTeacher3.equals(""))
                        practicalTeacher3 = practicalTeacher1;
                    if(practicalTeacher2.equals(""))
                        practicalTeacher2 = practicalTeacher1;
                    int decisionParameter = 0;
                    for(int i=0;i<practicalClass;i++)
                    {
                        switch (decisionParameter) {
                            case 0:
                                timeTableSticker.setData(0,courseCode,"Practical","",practicalTeacher1,"","");
                                decisionParameter = 1;
                                break;
                            case 1:
                                timeTableSticker.setData(0,courseCode,"Practical","",practicalTeacher2,"","");
                                decisionParameter = 2;
                                break;
                            default:
                                timeTableSticker.setData(0,courseCode,"Practical","",practicalTeacher3,"","");
                                decisionParameter = 0;
                                break;
                        }
                    }
                }
                else
                { 
                    for(int i=0;i<lectureClass;i++)
                    {
                        timeTableSticker.setData(0, courseCode,"Lecture", "", lectureTeacher1, lectureTeacher2,"");
                    }
                    for(int i=0;i<tutorialClass;i++)
                    {
                        timeTableSticker.setData(0,courseCode,"Tutorial","",tutorialTeacher,"","");
                    }
                    for(int i=0;i<practicalClass;i++)
                    {
                        timeTableSticker.setData(0,courseCode,"Practical","",practicalTeacher1,practicalTeacher2,practicalTeacher3);
                    }
                }
                
               
            }
        };
        makeSticker.start();
        while(makeSticker.isAlive());
    }
}
/**
 * 1. before resetting select any program
 */
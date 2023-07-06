/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.timetable;
import database.base.CourseList;
import database.base.ParticularTeacher;
import database.base.ParticularVenue;
import database.base.ProgramList;
import database.base.TeacherList;
import database.base.VenueList;
import database.intermediate.CombineClasses;
import database.superclass.ParticularProgramTimeTable;
import database.superclass.ParticularProgramTimeTableData;
import database.superclass.ParticularTeacherTimeTable;
import database.superclass.ParticularTeacherTimeTableData;
import database.superclass.ParticularVenueTimeTable;
import database.superclass.ParticularVenueTimeTableData;
import gui.MasterController;
import gui.PopupNotification;
import gui.tools.autocompletecombobox.AutoCompleteBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class TimeTableController implements Initializable {

    @FXML
    private Button submitButton;
    @FXML
    private ComboBox<String> programNameComboBox;
    @FXML
    private ComboBox<String> venueNameComboBox;
    @FXML
    private ComboBox<String> teacherNameComboBox;
    @FXML
    private Button homeButton;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab programTab;
    @FXML
    private TabPane timeTableTabPane;
    @FXML
    private Tab slot8tab;
    @FXML
    private Label slot8cell0;
    @FXML
    private Label slot8cell1;
    @FXML
    private Label slot8cell2;
    @FXML
    private Label slot8cell3;
    @FXML
    private Label slot8cell4;
    @FXML
    private Label slot8cell5;
    @FXML
    private Label slot8cell6;
    @FXML
    private Label slot8cell7;
    @FXML
    private Label slot8cell8;
    @FXML
    private Label slot8cell9;
    @FXML
    private Label slot8cell10;
    @FXML
    private Label slot8cell11;
    @FXML
    private Label slot8cell12;
    @FXML
    private Label slot8cell13;
    @FXML
    private Label slot8cell14;
    @FXML
    private Label slot8cell15;
    @FXML
    private Label slot8cell16;
    @FXML
    private Label slot8cell17;
    @FXML
    private Label slot8cell18;
    @FXML
    private Label slot8cell19;
    @FXML
    private Label slot8cell20;
    @FXML
    private Label slot8cell21;
    @FXML
    private Label slot8cell22;
    @FXML
    private Label slot8cell23;
    @FXML
    private Label slot8cell24;
    @FXML
    private Label slot8cell25;
    @FXML
    private Label slot8cell26;
    @FXML
    private Label slot8cell27;
    @FXML
    private Label slot8cell28;
    @FXML
    private Label slot8cell29;
    @FXML
    private Label slot8cell30;
    @FXML
    private Label slot8cell31;
    @FXML
    private Label slot8cell32;
    @FXML
    private Label slot8cell33;
    @FXML
    private Label slot8cell34;
    @FXML
    private Label slot8cell35;
    @FXML
    private Label slot8cell36;
    @FXML
    private Label slot8cell37;
    @FXML
    private Label slot8cell38;
    @FXML
    private Label slot8cell39;
    @FXML
    private Label slot8cell40;
    @FXML
    private Label slot8cell41;
    @FXML
    private Label slot8cell42;
    @FXML
    private Label slot8cell43;
    @FXML
    private Label slot8cell44;
    @FXML
    private Label slot12cell0;
    @FXML
    private Label slot12cell1;
    @FXML
    private Label slot12cell2;
    @FXML
    private Label slot12cell3;
    @FXML
    private Label slot12cell4;
    @FXML
    private Label slot12cell5;
    @FXML
    private Label slot12cell6;
    @FXML
    private Label slot12cell7;
    @FXML
    private Label slot12cell8;
    @FXML
    private Label slot12cell9;
    @FXML
    private Label slot12cell10;
    @FXML
    private Label slot12cell11;
    @FXML
    private Label slot12cell12;
    @FXML
    private Label slot12cell13;
    @FXML
    private Label slot12cell14;
    @FXML
    private Label slot12cell15;
    @FXML
    private Label slot12cell16;
    @FXML
    private Label slot12cell17;
    @FXML
    private Label slot12cell18;
    @FXML
    private Label slot12cell19;
    @FXML
    private Label slot12cell20;
    @FXML
    private Label slot12cell21;
    @FXML
    private Label slot12cell22;
    @FXML
    private Label slot12cell23;
    @FXML
    private Label slot12cell24;
    @FXML
    private Label slot12cell25;
    @FXML
    private Label slot12cell26;
    @FXML
    private Label slot12cell27;
    @FXML
    private Label slot12cell28;
    @FXML
    private Label slot12cell29;
    @FXML
    private Label slot12cell30;
    @FXML
    private Label slot12cell31;
    @FXML
    private Label slot12cell32;
    @FXML
    private Label slot12cell33;
    @FXML
    private Label slot12cell34;
    @FXML
    private Label t0;
    @FXML
    private Label t1;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label t4;
    @FXML
    private Label t5;
    @FXML
    private Label t6;
    @FXML
    private Label t7;
    @FXML
    private Label t8;
    @FXML
    private Label t9;
    @FXML
    private Label t10;
    @FXML
    private Label t11;
    @FXML
    private Label t12;
    @FXML
    private Label t13;
    @FXML
    private Label t14;
    @FXML
    private Label t15;
    @FXML
    private Label t16;
    @FXML
    private Label t17;
    @FXML
    private Label t18;
    @FXML
    private Label t19;
    @FXML
    private Label t20;
    @FXML
    private Label t21;
    @FXML
    private Label t22;
    @FXML
    private Label t23;
    @FXML
    private Label t24;
    @FXML
    private Label t25;
    @FXML
    private Label t26;
    @FXML
    private Label t27;
    @FXML
    private Label t28;
    @FXML
    private Label t29;
    @FXML
    private Label t30;
    @FXML
    private Label t31;
    @FXML
    private Label t32;
    @FXML
    private Label t33;
    @FXML
    private Label t34;
    @FXML
    private Label t35;
    @FXML
    private Label t36;
    @FXML
    private Label t37;
    @FXML
    private Label t38;
    @FXML
    private Label t39;
    @FXML
    private Label t40;
    @FXML
    private Label t41;
    @FXML
    private Label t42;
    @FXML
    private Label t43;
    @FXML
    private Label t44;
    @FXML
    private Label v0;
    @FXML
    private Label v1;
    @FXML
    private Label v2;
    @FXML
    private Label v3;
    @FXML
    private Label v4;
    @FXML
    private Label v5;
    @FXML
    private Label v6;
    @FXML
    private Label v7;
    @FXML
    private Label v8;
    @FXML
    private Label v9;
    @FXML
    private Label v10;
    @FXML
    private Label v11;
    @FXML
    private Label v12;
    @FXML
    private Label v13;
    @FXML
    private Label v14;
    @FXML
    private Label v15;
    @FXML
    private Label v16;
    @FXML
    private Label v17;
    @FXML
    private Label v18;
    @FXML
    private Label v19;
    @FXML
    private Label v20;
    @FXML
    private Label v21;
    @FXML
    private Label v22;
    @FXML
    private Label v23;
    @FXML
    private Label v24;
    @FXML
    private Label v25;
    @FXML
    private Label v26;
    @FXML
    private Label v27;
    @FXML
    private Label v28;
    @FXML
    private Label v29;
    @FXML
    private Label v30;
    @FXML
    private Label v31;
    @FXML
    private Label v32;
    @FXML
    private Label v33;
    @FXML
    private Label v34;
    @FXML
    private Label v35;
    @FXML
    private Label v36;
    @FXML
    private Label v37;
    @FXML
    private Label v38;
    @FXML
    private Label v39;
    @FXML
    private Label v40;
    @FXML
    private Label v41;
    @FXML
    private Label v42;
    @FXML
    private Label v43;
    @FXML
    private Label v44;
    @FXML
    private Label teacher1Label;
    @FXML
    private Label teacher2Label;
    @FXML
    private Label teacher3Label;
    @FXML
    private Label courseCodeLabel;
    @FXML
    private Label venueLabel;
    @FXML
    private Label classTypeLabel;
    @FXML
    private ComboBox<String> teacherName1ComboBoxCurrent;
    @FXML
    private ComboBox<String> teacherName2ComboBoxCurrent;
    @FXML
    private ComboBox<String> teacherName3ComboBoxCurrent;
    @FXML
    private ComboBox<String> courseCodeComboBoxCurrent;
    
    @FXML
    private ComboBox<String> classTypeComboBoxCurrent;
    @FXML
    private Button createButton;
    @FXML
    private Label stickerLabel0;
    @FXML
    private Label stickerLabel1;
    @FXML
    private Label stickerLabel2;
    @FXML
    private Label stickerLabel3;
    @FXML
    private Label stickerLabel4;
    @FXML
    private Label stickerLabel5;
    @FXML
    private Label stickerLabel6;
    @FXML
    private Label stickerLabel7;
    @FXML
    private Label stickerLabel8;
    @FXML
    private Label stickerLabel9;
    @FXML
    private Label stickerLabel10;
    @FXML
    private Label stickerLabel11;
    @FXML
    private Label stickerLabel12;
    @FXML
    private Label stickerLabel13;
    @FXML
    private Label stickerLabel14;
    @FXML
    private Label stickerLabel15;
    @FXML
    private Label stickerLabel16;
    @FXML
    private Label stickerLabel17;
    @FXML
    private Label stickerLabel18;
    @FXML
    private Label stickerLabel19;
    @FXML
    private Label stickerLabel20;
    @FXML
    private Label stickerLabel21;
    @FXML
    private Label stickerLabel22;
    @FXML
    private Label stickerLabel23;
    @FXML
    private Label stickerLabel24;
    @FXML
    private Label stickerLabel25;
    @FXML
    private Label stickerLabel26;
    @FXML
    private Label stickerLabel27;
    @FXML
    private Label stickerLabel28;
    @FXML
    private Label stickerLabel29;
    @FXML
    private Label stickerLabel30;
    @FXML
    private Label stickerLabel31;
    @FXML
    private Label stickerLabel32;
    @FXML
    private Label stickerLabel33;
    @FXML
    private Label stickerLabel34;
    @FXML
    private Label stickerLabel35;
    @FXML
    private Label stickerLabel36;
    @FXML
    private Label stickerLabel37;
    @FXML
    private Label stickerLabel38;
    @FXML
    private Label stickerLabel39;
    @FXML
    private Label stickerLabel40;
    @FXML
    private Label stickerLabel41;
    @FXML
    private Label stickerLabel42;
    @FXML
    private Label stickerLabel43;
    @FXML
    private Label stickerLabel44;
    @FXML
    private Label newLabel;
    @FXML
    private Tab slot12tab;
    
    private Label[] programTimeTableLabelSlot8;
    private Label[] programTimeTableLabelSlot12;
    private Label[] teacherTimeTableLabel;
    private Label[] venueTimeTableLabel;
    private Label[] stickerLabel;
    private ParticularProgramTimeTableData newLabelData;
    
    
    private ParticularProgramTimeTableData [] currentProgramTimeTableData;
    private ParticularProgramTimeTableData [] currentProgramStickerData;
    String activeProgramName;
    String activeVenueName;
    String activeTeacherName;
    
    PopupNotification popup;
    
    // for drag drop gesture....
    private Label sourceLabel;
    private int activeLabelIndex;
    private String activeLabel;
    
    //for database....
    private int teacherAvailablityArray[][];    
    private int venueAvailablityArray[][];
    private String teacherFullNameArray[];
    private String teacherNickNameArray[];
    private String venueNameArray[];
    private String programNameArray[];
    private ParticularProgramTimeTableData [][] programTimeTable;
    private ParticularTeacherTimeTableData [][] teacherTimeTable;
    private ParticularVenueTimeTableData [][] venueTimeTable;
    private ParticularProgramTimeTableData [][] stickerTimeTable;
    
    private boolean practicalPlacedAtTop;

    @FXML
    private void submitButtonAction(ActionEvent event) {
        ParticularProgramTimeTable program;
        ParticularProgramTimeTable sticker;
        
       new ParticularProgramTimeTable("").deleteAll();
       new ParticularProgramTimeTable("").deleteAllSticker();
       new ParticularTeacherTimeTable("").deleteAll();
       new ParticularTeacher("").deleteAll();
       new ParticularVenueTimeTable("").deleteAll();
       new ParticularVenue("").deleteAll();
       
       
        for(int i=0;i<programNameArray.length;i++)
        {
            program = new ParticularProgramTimeTable(programNameArray[i]+"_tt");
            sticker = new ParticularProgramTimeTable(programNameArray[i]+"_tt_st");
            
            
            for(int j=0;j<45;j++)
            {
                if(!programTimeTable[i][j].getCourseCode().equals(""))
                {
                    program.setData(j, programTimeTable[i][j].getCourseCode(),programTimeTable[i][j].getClassType(),programTimeTable[i][j].getVenue(), programTimeTable[i][j].getTeacher1(), programTimeTable[i][j].getTeacher2(), programTimeTable[i][j].getTeacher3());
                    System.err.println(program.getString()+ " at index:"+j+" (timetable)");
                }
                if(!stickerTimeTable[i][j].getCourseCode().equals(""))
                {
                    sticker.setData(j, stickerTimeTable[i][j].getCourseCode(), stickerTimeTable[i][j].getClassType(), stickerTimeTable[i][j].getVenue(), stickerTimeTable[i][j].getTeacher1(), stickerTimeTable[i][j].getTeacher2(),stickerTimeTable[i][j].getTeacher3());
                    System.err.println(sticker.getString()+ " at index:"+j+" (sticker)");
                }
            }
            if(sticker.count() == 0)
            {
                // write a code to set done = 1 in programList at specific row also write the code for done = 0 at ppcs or on pptt buttons.
            }
        } 
        ParticularTeacherTimeTable teacher;
        ParticularTeacher pTeacher;
        for(int i=0;i<teacherFullNameArray.length;i++)
        {
            teacher = new ParticularTeacherTimeTable(teacherFullNameArray[i]+"_tt");
            pTeacher = new ParticularTeacher(teacherFullNameArray[i]);
            for(int j=0;j<45;j++)
            {
                if(!teacherTimeTable[i][j].getCourseCode().equals(""))
                {
                    teacher.setData(j, teacherTimeTable[i][j].getCourseCode(), teacherTimeTable[i][j].getClassType(), teacherTimeTable[i][j].getVenue(), teacherTimeTable[i][j].getProgram1(), teacherTimeTable[i][j].getProgram2(),teacherTimeTable[i][j].getProgram3());
                }
            }
            for(int k=0;k<500;k++)
            {
                if(teacherAvailablityArray[i][k] == 1)
                {
                    pTeacher.setData(k);
                }
            }
        }
        ParticularVenueTimeTable venue;
        ParticularVenue pVenue;
        for(int i=0;i<venueNameArray.length;i++)
        {
            venue = new ParticularVenueTimeTable(venueNameArray[i]+"_tt");
            pVenue = new ParticularVenue(venueNameArray[i]);
            for(int j=0;j<45;j++)
            {
                if(!venueTimeTable[i][j].getCourseCode().equals(""))
                {
                    venue.setData(j, venueTimeTable[i][j].getCourseCode(), venueTimeTable[i][j].getClassType(),venueTimeTable[i][j].getTeacher1(),venueTimeTable[i][j].getTeacher2(),venueTimeTable[i][j].getTeacher3(), venueTimeTable[i][j].getProgram1(), venueTimeTable[i][j].getProgram2(),venueTimeTable[i][j].getProgram3());
                }
            }
            for(int k=0;k<500;k++)
            {
                if(venueAvailablityArray[i][k] == 1)
                {
                    pVenue.setData(k);
                }
            }
        }
        popup.confirm("saving", "Successful");
    }

    @FXML
    private void homeButtonEvent(ActionEvent event) {
        try {
//            MasterController.primaryStage.setScene(FXMLLoader.load(getClass().getResource("../DashBoard.fxml")));
MasterController.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/gui/DashBoard.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(TimeTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleDragStart(MouseEvent event) {
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if(event.getDragboard().hasString())
            event.acceptTransferModes(TransferMode.ANY);
        event.consume();
    }

    @FXML
    private void handleDragDrop(DragEvent event) {
    }

    @FXML
    private void createButtonEvent(ActionEvent event) {
        String teacher1 = teacherName1ComboBoxCurrent.getSelectionModel().getSelectedItem();
        String teacher2 = teacherName2ComboBoxCurrent.getSelectionModel().getSelectedItem();
        String teacher3 = teacherName3ComboBoxCurrent.getSelectionModel().getSelectedItem();
        String courseCode = courseCodeComboBoxCurrent.getSelectionModel().getSelectedItem();
        String classType = classTypeComboBoxCurrent.getSelectionModel().getSelectedItem();
        if(teacher1 == null || courseCode == null ||  classType == null)
            popup.alert("Error", "Choose the options correctly");
        else
        {
            newLabelData.setData(activeLabelIndex, activeLabel, teacher1, teacher1, teacher1, teacher2, teacher3);
            newLabel.setText(newLabelData.getData());
        }
    }
    @SuppressWarnings("empty-statement")
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
        new AutoCompleteBox(programNameComboBox);
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
                teacherNameComboBox.setItems(teacherList);                
                teacherName1ComboBoxCurrent.setItems(teacherList);                
                teacherName2ComboBoxCurrent.setItems(teacherList);                
                teacherName3ComboBoxCurrent.setItems(teacherList);                
            }
	};
        teacherListThread.start();
        while(teacherListThread.isAlive());        
        new AutoCompleteBox(teacherNameComboBox);
        new AutoCompleteBox(teacherName1ComboBoxCurrent);
        new AutoCompleteBox(teacherName2ComboBoxCurrent);
        new AutoCompleteBox(teacherName3ComboBoxCurrent);
    }
    
    private void loadCourseList()
    {
        ObservableList<String> courseCodeList = FXCollections.observableArrayList();
        Thread courseCodeListThread = new Thread(){
            @Override
            public void run()
            {
                /*loading all the data stored in COURSELIST in database*/
                CourseList cl = new CourseList();
                while( cl.getData())
                {
                    courseCodeList.add(cl.getCourseCode());
                }
                /*adding the data into combobox*/
                courseCodeComboBoxCurrent.setItems(courseCodeList);
            }
        };
        courseCodeListThread.start();
        while(courseCodeListThread.isAlive());
        new AutoCompleteBox(courseCodeComboBoxCurrent);
    }
    
    private void loadVenueList()
    {
        ObservableList<String> venueList = FXCollections.observableArrayList();
        Thread venueListThread = new Thread(){
            @Override
            public void run()
            {
                /*loading all the data stored in COURSELIST in database*/
                VenueList vl = new VenueList();
                int counter = vl.count();
                while( counter > 0)
                {
                    vl.getData();
                    venueList.add((vl.getVenueName()).replaceAll("_"," "));
                    counter--;
                }
                /*adding the data into combobox*/
                venueNameComboBox.setItems(venueList);
            }
        };
        venueListThread.start();
        while(venueListThread.isAlive());
        new AutoCompleteBox(venueNameComboBox);
    }
    
    private void changeTab()
    {
        int slotLength = new ProgramList().getSlotLength(activeProgramName);
        if(slotLength == 9)
        {
            timeTableTabPane.getSelectionModel().select(slot8tab);
        }
        else
        {
            timeTableTabPane.getSelectionModel().select(slot12tab);
        }
    }
    
    private void loadActiveTeacherTimeTable()
    {
        for(int i=0;i<45;i++)
        {
            teacherTimeTableLabel[i].setText(teacherTimeTable[activeTeacherIndex][i].getData());
        }       
    }
    
    private void loadActiveVenueTimeTable()
    {
        for(int i=0;i<45;i++)
        {
            venueTimeTableLabel[i].setText(venueTimeTable[venueIndex][i].getData());
        }
       
    }
    
    private void loadCurrentProgramTimeTable() 
    {
        if(new ProgramList().getSlotLength(activeProgramName) == 9)
        {
            for(int i=0;i<45;i++)
            {
                programTimeTableLabelSlot8[i].setText(programTimeTable[program1Index][i].getData());
            }
        }
        else
        {
            for(int i=0;i<35;i++)
            {
                programTimeTableLabelSlot12[i].setText(programTimeTable[program1Index][i].getData());
            }
        }
       
    }
    
    private void loadCurrentProgramSticker()
    {
       for(int i=0;i<45;i++)
        {
            stickerLabel[i].setText(stickerTimeTable[program1Index][i].getData());
        }
    }
    
    String teacher1;
    String teacher2;
    String teacher3;
    String combinedProgram1;
    String combinedProgram2;
    int [] feasibleCellArray;
    private void loadDragDropGesture()
    {
        newLabel.setOnDragDetected((MouseEvent event) ->{
            activeLabel = "newLabel";
            Dragboard db = newLabel.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString(newLabel.getText());
            db.setContent(cb);
            loadFeasibleCell(newLabelData);
            event.consume();
         });
        for(int i=0;i<45;i++)
        {
            final int index = i;
            stickerLabel[i].setOnDragDetected((MouseEvent event) -> {
                sourceLabel  = (Label)event.getSource();
                activeLabelIndex = index;
                activeLabel = "sticker";
                //popup.warning("Sticker Label", "dragStart");
                Dragboard db = sourceLabel.startDragAndDrop(TransferMode.ANY);
                ClipboardContent cb = new ClipboardContent();
                cb.putString(sourceLabel.getText());
                db.setContent(cb);
                loadFeasibleCell(stickerTimeTable[program1Index][index]);
                event.consume();
            });
            programTimeTableLabelSlot8[i].setOnDragDetected((MouseEvent event) -> {
                //System.err.println("********************Drag Start here...*****************************************************************************");
                sourceLabel  = (Label)event.getSource();
                
                activeLabelIndex = index;
                activeLabel = "slot8";
                if(programTimeTable[program1Index][index].getCourseCode().equals("Do"))
                {
                    activeLabelIndex -= 5;
                 
                }
                //popup.warning("Slot 8  Label", "dragStart");
                Dragboard db = sourceLabel.startDragAndDrop(TransferMode.ANY);
                ClipboardContent cb = new ClipboardContent();
                cb.putString(sourceLabel.getText());
                db.setContent(cb);
                loadFeasibleCell(programTimeTable[program1Index][activeLabelIndex]);
                //System.err.println("Active Label Index: "+activeLabelIndex);
                event.consume();
            });
            teacherTimeTableLabel[i].setOnDragDetected((MouseEvent event) -> {
                //System.err.println("********************Drag Start here...*****************************************************************************");
                if(new ProgramList().getSlotLength(programNameArray[program1Index]) == 9)
                {
                    sourceLabel  = (Label)event.getSource();
                
                
                activeLabelIndex = index;
                activeLabel = "teacher";
                if(teacherTimeTable[activeTeacherIndex][index].getCourseCode().equals("Do"))
                {
                    activeLabelIndex -= 5;
                 
                }
                popup.warning("teacher Label", "dragStart");
                Dragboard db = sourceLabel.startDragAndDrop(TransferMode.ANY);
                ClipboardContent cb = new ClipboardContent();
                cb.putString(sourceLabel.getText());
                db.setContent(cb);
                loadFeasibleCell(programTimeTable[getProgramIndex(teacherTimeTable[activeTeacherIndex][activeLabelIndex].getProgram1())][activeLabelIndex]);
                
                //System.err.println("Active Label Index: "+activeLabelIndex);
                event.consume();
                }
            });
            venueTimeTableLabel[i].setOnDragDetected((MouseEvent event) -> {
                //System.err.println("********************Drag Start here...*****************************************************************************");
                if(new ProgramList().getSlotLength(programNameArray[program1Index]) == 9)
                {
                sourceLabel  = (Label)event.getSource();
                
                activeLabelIndex = index;
                activeLabel = "venue";
                if(venueTimeTable[venueIndex][index].getCourseCode().equals("Do"))
                { 
                    activeLabelIndex -= 5;
                 
                }
                
                popup.warning("venue Label", "dragStart");
                Dragboard db = sourceLabel.startDragAndDrop(TransferMode.ANY);
                ClipboardContent cb = new ClipboardContent();
                cb.putString(sourceLabel.getText());
                db.setContent(cb);
                loadFeasibleCell(programTimeTable[getProgramIndex(venueTimeTable[venueIndex][activeLabelIndex].getProgram1())][activeLabelIndex]);
                //System.err.println("Active Label Index: "+activeLabelIndex);
                event.consume();
                }
            });
            if(i<35)
            {
                
                programTimeTableLabelSlot12[i].setOnDragDetected((MouseEvent event) -> {
                    sourceLabel  = (Label)event.getSource();
                    activeLabelIndex = index;
                    activeLabel = "slot12";
                    if(programTimeTable[program1Index][index].getCourseCode().equals("Do"))
                    {
                        activeLabelIndex -= 5;
                    }
                    popup.warning("Slot 12  Label", "dragStart");
                    Dragboard db = sourceLabel.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent cb = new ClipboardContent();
                    cb.putString(sourceLabel.getText());
                    db.setContent(cb);
                    loadFeasibleCell(programTimeTable[program1Index][activeLabelIndex]);
                    event.consume();
                });
            }
            
            stickerLabel[i].setOnDragDropped((DragEvent event)->{
                refreshCell();
                if(activeLabel.equals("sticker"))
                {
                    stickerTimeTable[program1Index][index].swap(stickerTimeTable[program1Index][activeLabelIndex]);
                    stickerLabel[index].setText(stickerTimeTable[program1Index][index].getData());
                    stickerLabel[activeLabelIndex].setText(stickerTimeTable[program1Index][activeLabelIndex].getData());
                }
                else if(activeLabel.equals("newLabel"))
                {
                    if(stickerTimeTable[program1Index][index].getCourseCode().equals(""))
                    {
                        stickerTimeTable[program1Index][index].copy(newLabelData);
                        stickerLabel[index].setText(stickerTimeTable[program1Index][index].getData());
                    }
                }
                else
                {
                    if((stickerTimeTable[program1Index][index].getCourseCode().equals(""))) //if that target Label has no data only then it is swapped.
                    {
                        int oldVenueIndex = getVenueIndex(programTimeTable[program1Index][activeLabelIndex].getVenue().replace("-","_"));
                        stickerTimeTable[program1Index][index].swap(programTimeTable[program1Index][activeLabelIndex]);
                        stickerTimeTable[program1Index][index].setVenue("");
                        stickerLabel[index].setText(stickerTimeTable[program1Index][index].getData());
                           
                        if(activeLabel.equals("slot8"))
                        {
                            programTimeTableLabelSlot8[activeLabelIndex].setText(programTimeTable[program1Index][activeLabelIndex].getData());
                        }
                        else
                        {
                            programTimeTableLabelSlot12[activeLabelIndex].setText(programTimeTable[program1Index][activeLabelIndex].getData());
                        }
                        if(program2Index < programNameArray.length)
                        {
                            programTimeTable[program2Index][activeLabelIndex].setData(activeLabelIndex, "", "", "", "", "", "");
                        }
                        if(program3Index < programNameArray.length)
                        {
                            programTimeTable[program3Index][activeLabelIndex].setData(activeLabelIndex, "", "", "", "", "", "");
                        }
                        teacherTimeTable[teacher1Index][activeLabelIndex].setData(activeLabelIndex, "", "", "", "", "", "");
                        if(teacher2Index < teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][activeLabelIndex].setData(activeLabelIndex, "", "", "", "", "", "");
                        }
                        if(teacher3Index < teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][activeLabelIndex].setData(activeLabelIndex, "", "", "", "", "", "");
                        }
                        venueTimeTable[oldVenueIndex][activeLabelIndex].setData(activeLabelIndex,"","","","","","","","");
                        // code for free up the allotment array of venue,teacher and programTT.
                        updateTeacherAllotmentArray(teacher1Index,activeLabelIndex,0);
                        updateTeacherAllotmentArray(teacher2Index,activeLabelIndex,0);
                        updateTeacherAllotmentArray(teacher3Index,activeLabelIndex,0);
                        updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex,0);
                        //finally add it to sticker tables ..for program1Index it is already done at starting
                        addToSticker(stickerTimeTable[program1Index][index]);
                        //if practical Class then free up the doubled occupy the venue at current_Position + 5
                        if(stickerTimeTable[program1Index][index].getClassType().equals("Practical"))
                        {
                            if(activeLabel.equals("slot8"))
                        {
                            programTimeTableLabelSlot8[activeLabelIndex+5].setText("");
                        }
                        else
                        {
                            programTimeTableLabelSlot12[activeLabelIndex+5].setText("");
                        }
                            programTimeTable[program1Index][activeLabelIndex+5].setData(activeLabelIndex+5, "", "", "", "", "", "");
                        if(program2Index < programNameArray.length)
                        {
                            programTimeTable[program2Index][activeLabelIndex+5].setData(activeLabelIndex+5, "", "", "", "", "", "");
                        }
                        if(program3Index < programNameArray.length)
                        {
                            programTimeTable[program3Index][activeLabelIndex+5].setData(activeLabelIndex+5, "", "", "", "", "", "");
                        }
                        teacherTimeTable[teacher1Index][activeLabelIndex+5].setData(activeLabelIndex+5, "", "", "", "", "", "");
                        if(teacher2Index < teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][activeLabelIndex+5].setData(activeLabelIndex+5, "", "", "", "", "", "");
                        }
                        if(teacher3Index < teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][activeLabelIndex+5].setData(activeLabelIndex+5, "", "", "", "", "", "");
                        }
                        venueTimeTable[oldVenueIndex][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","","","");
                        
                        // code for free up the allotment array of venue,teacher and programTT.
                        updateTeacherAllotmentArray(teacher1Index,activeLabelIndex+5,0);
                        updateTeacherAllotmentArray(teacher2Index,activeLabelIndex+5,0);
                        updateTeacherAllotmentArray(teacher3Index,activeLabelIndex+5,0);
                        updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex+5,0);
                        
                        //finally add it to sticker tables ..for program1Index it is already done at starting
                        }
                        loadActiveVenueTimeTable();
                        loadActiveTeacherTimeTable();
                        loadCurrentProgramTimeTable();
                    }
                }
                popup.warning("drag", "drop");
                
                event.consume();
            });
            teacherTimeTableLabel[i].setOnDragDropped((DragEvent event)->
            { refreshCell();
              if(feasibleCellArray[index] == 0 )  
              {
                  if(activeLabel.equals("teacher"))
                  {    int oldVenueIndex = getVenueIndex(programTimeTable[program1Index][activeLabelIndex].getVenue().replaceAll("-", "_"));
                        programTimeTable[program1Index][index].swap(programTimeTable[program1Index][activeLabelIndex]);
                        programTimeTable[program1Index][index].setVenue(venueNameArray[venueIndex]);
                        
                        if(program2Index<programNameArray.length)
                            programTimeTable[program2Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                        if(program3Index<programNameArray.length)
                            programTimeTable[program3Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                           
                        teacherTimeTable[teacher1Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                        updateTeacherAllotmentArray(teacher1Index,activeLabelIndex,0);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher2Index,activeLabelIndex,0);
                        }
                        if(teacher3Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher3Index,activeLabelIndex,0);
                        }
                            
                        venueTimeTable[oldVenueIndex][activeLabelIndex].setData(activeLabelIndex,"","","","","","","","");
                        updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex,0);
                        
                        if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                        {
                            System.err.println("Class type is  practical.");
                            programTimeTable[program1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            if(program2Index<programNameArray.length)
                                programTimeTable[program2Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                            if(program3Index<programNameArray.length)
                                programTimeTable[program3Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                           
                            teacherTimeTable[teacher1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            updateTeacherAllotmentArray(teacher1Index,activeLabelIndex+5,0);
                            if(teacher2Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher2Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher2Index,activeLabelIndex+5,0);
                            }
                            if(teacher3Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher3Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher3Index,activeLabelIndex+5,0);
                            }  
                            
                            venueTimeTable[oldVenueIndex][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","","","");
                            updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex+5,0);
                                
                            programTimeTableLabelSlot8[activeLabelIndex+5].setText("");
                        }
                    
                    //programTimeTableLabelSlot8[index].setText(programTimeTable[program1Index][index].getData());
                    if(program2Index<programNameArray.length)
                        programTimeTable[program2Index][index].copy(programTimeTable[program1Index][index]);
                    if(program3Index<programNameArray.length)
                        programTimeTable[program3Index][index].copy(programTimeTable[program1Index][index]);
                     
                    teacherTimeTable[teacher1Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateTeacherAllotmentArray(teacher1Index,index,1);
                    if(teacher2Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher2Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher2Index,index,1);
                    }
                    if(teacher3Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher3Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher3Index,index,1);
                    }
                    venueTimeTable[venueIndex][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),teacherNickNameArray[teacher1Index],teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateVenueAllotmentArray(venueIndex,index,1);
                    
                    if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                    {
                        programTimeTable[program1Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        if(program2Index<programNameArray.length)
                        {
                            programTimeTable[program2Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        if(program3Index<programNameArray.length)
                        {
                            programTimeTable[program3Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        programTimeTableLabelSlot8[index+5].setText("Do");
                                
                        teacherTimeTable[teacher1Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        updateTeacherAllotmentArray(teacher1Index,index+5,1);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher2Index,index+5,1);
                        }
                        if(teacher3Index<programNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher3Index,index+5,1);
                        }
                        venueTimeTable[venueIndex][index+5].setData(index + 5, "Do", "", "", "", "", "","","");
                        updateVenueAllotmentArray(venueIndex,index+5,1);
                    }
                    loadCurrentProgramTimeTable();
                    loadActiveVenueTimeTable();
                    loadActiveTeacherTimeTable();
              }
              }
            });
            venueTimeTableLabel[i].setOnDragDropped((DragEvent event)->
            {
                refreshCell();
              if(feasibleCellArray[index] == 0 )  
              {
                  if(activeLabel.equals("venue"))
                  {    int oldVenueIndex = getVenueIndex(programTimeTable[program1Index][activeLabelIndex].getVenue().replaceAll("-", "_"));
                        programTimeTable[program1Index][index].swap(programTimeTable[program1Index][activeLabelIndex]);
                        programTimeTable[program1Index][index].setVenue(venueNameArray[venueIndex]);
                        
                        if(program2Index<programNameArray.length)
                            programTimeTable[program2Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                        if(program3Index<programNameArray.length)
                            programTimeTable[program3Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                           
                        teacherTimeTable[teacher1Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                        updateTeacherAllotmentArray(teacher1Index,activeLabelIndex,0);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher2Index,activeLabelIndex,0);
                        }
                        if(teacher3Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher3Index,activeLabelIndex,0);
                        }
                            
                        venueTimeTable[oldVenueIndex][activeLabelIndex].setData(activeLabelIndex,"","","","","","","","");
                        updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex,0);
                        
                        if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                        {
                            System.err.println("Class type is  practical.");
                            programTimeTable[program1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            if(program2Index<programNameArray.length)
                                programTimeTable[program2Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                            if(program3Index<programNameArray.length)
                                programTimeTable[program3Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                           
                            teacherTimeTable[teacher1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            updateTeacherAllotmentArray(teacher1Index,activeLabelIndex+5,0);
                            if(teacher2Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher2Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher2Index,activeLabelIndex+5,0);
                            }
                            if(teacher3Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher3Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher3Index,activeLabelIndex+5,0);
                            }  
                            
                            venueTimeTable[oldVenueIndex][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","","","");
                            updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex+5,0);
                                
                            programTimeTableLabelSlot8[activeLabelIndex+5].setText("");
                        }
                    
                    //programTimeTableLabelSlot8[index].setText(programTimeTable[program1Index][index].getData());
                    if(program2Index<programNameArray.length)
                        programTimeTable[program2Index][index].copy(programTimeTable[program1Index][index]);
                    if(program3Index<programNameArray.length)
                        programTimeTable[program3Index][index].copy(programTimeTable[program1Index][index]);
                     
                    teacherTimeTable[teacher1Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateTeacherAllotmentArray(teacher1Index,index,1);
                    if(teacher2Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher2Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher2Index,index,1);
                    }
                    if(teacher3Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher3Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher3Index,index,1);
                    }
                    venueTimeTable[venueIndex][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),teacherNickNameArray[teacher1Index],teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateVenueAllotmentArray(venueIndex,index,1);
                    
                    if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                    {
                        programTimeTable[program1Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        if(program2Index<programNameArray.length)
                        {
                            programTimeTable[program2Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        if(program3Index<programNameArray.length)
                        {
                            programTimeTable[program3Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        programTimeTableLabelSlot8[index+5].setText("Do");
                                
                        teacherTimeTable[teacher1Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        updateTeacherAllotmentArray(teacher1Index,index+5,1);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher2Index,index+5,1);
                        }
                        if(teacher3Index<programNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher3Index,index+5,1);
                        }
                        venueTimeTable[venueIndex][index+5].setData(index + 5, "Do", "", "", "", "", "","","");
                        updateVenueAllotmentArray(venueIndex,index+5,1);
                    }
                    loadCurrentProgramTimeTable();
                    loadActiveVenueTimeTable();
                    loadActiveTeacherTimeTable();
              }
              }
            });
            programTimeTableLabelSlot8[i].setOnDragDropped((DragEvent event)->{
                refreshCell();
                if(feasibleCellArray[index] == 0 ) //i.e. if feasible cell array is free.
                { 
                    if(activeLabel.equals("sticker"))
                    {   
                        programTimeTable[program1Index][index].swap(stickerTimeTable[program1Index][activeLabelIndex]);
                        programTimeTable[program1Index][index].setVenue(venueNameArray[venueIndex]);
                        stickerLabel[activeLabelIndex].setText(stickerTimeTable[program1Index][activeLabelIndex].getData()); 
                            
                        removeToSticker(programTimeTable[program1Index][index]);
                    }
                    else if(activeLabel.equals("newLabel"))
                    {
                        programTimeTable[program1Index][index].copy(newLabelData);
                        programTimeTable[program1Index][index].setVenue(activeVenueName.replaceAll("_", "-"));
                    }
                    else
                    {
                        int oldVenueIndex = getVenueIndex(programTimeTable[program1Index][activeLabelIndex].getVenue().replaceAll("-", "_"));
                        programTimeTable[program1Index][index].swap(programTimeTable[program1Index][activeLabelIndex]);
                        programTimeTable[program1Index][index].setVenue(venueNameArray[venueIndex]);
                        
                        if(program2Index<programNameArray.length)
                            programTimeTable[program2Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                        if(program3Index<programNameArray.length)
                            programTimeTable[program3Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                           
                        teacherTimeTable[teacher1Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                        updateTeacherAllotmentArray(teacher1Index,activeLabelIndex,0);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher2Index,activeLabelIndex,0);
                        }
                        if(teacher3Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher3Index,activeLabelIndex,0);
                        }
                            
                        venueTimeTable[oldVenueIndex][activeLabelIndex].setData(activeLabelIndex,"","","","","","","","");
                        updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex,0);
                        
                        if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                        {
                            System.err.println("Class type is  practical.");
                            programTimeTable[program1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            if(program2Index<programNameArray.length)
                                programTimeTable[program2Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                            if(program3Index<programNameArray.length)
                                programTimeTable[program3Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                           
                            teacherTimeTable[teacher1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            updateTeacherAllotmentArray(teacher1Index,activeLabelIndex+5,0);
                            if(teacher2Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher2Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher2Index,activeLabelIndex+5,0);
                            }
                            if(teacher3Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher3Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher3Index,activeLabelIndex+5,0);
                            }  
                            
                            venueTimeTable[oldVenueIndex][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","","","");
                            updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex+5,0);
                                
                            programTimeTableLabelSlot8[activeLabelIndex+5].setText("");
                        }
                    }
                    //programTimeTableLabelSlot8[index].setText(programTimeTable[program1Index][index].getData());
                    if(program2Index<programNameArray.length)
                        programTimeTable[program2Index][index].copy(programTimeTable[program1Index][index]);
                    if(program3Index<programNameArray.length)
                        programTimeTable[program3Index][index].copy(programTimeTable[program1Index][index]);
                     
                    teacherTimeTable[teacher1Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateTeacherAllotmentArray(teacher1Index,index,1);
                    if(teacher2Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher2Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher2Index,index,1);
                    }
                    if(teacher3Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher3Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher3Index,index,1);
                    }
                    venueTimeTable[venueIndex][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),teacherNickNameArray[teacher1Index],teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateVenueAllotmentArray(venueIndex,index,1);
                    
                    if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                    {
                        programTimeTable[program1Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        if(program2Index<programNameArray.length)
                        {
                            programTimeTable[program2Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        if(program3Index<programNameArray.length)
                        {
                            programTimeTable[program3Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        programTimeTableLabelSlot8[index+5].setText("Do");
                                
                        teacherTimeTable[teacher1Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                        updateTeacherAllotmentArray(teacher1Index,index+5,1);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher2Index,index+5,1);
                        }
                        if(teacher3Index<programNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][index+5].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher3Index,index+5,1);
                        }
                        venueTimeTable[venueIndex][index+5].setData(index + 5, "Do", "", "", "", "", "","","");
                        updateVenueAllotmentArray(venueIndex,index+5,1);
                    }
                    loadCurrentProgramTimeTable();
                    loadActiveVenueTimeTable();
                    loadActiveTeacherTimeTable();
                }
                
                event.consume();
            });
            if(i<35)
            {
                programTimeTableLabelSlot12[i].setOnDragDropped((DragEvent event)->
                {
                    refreshCell();
                if(feasibleCellArray[index] == 0) //i.e. if feasible cell array is free.
                { 
                    if(activeLabel.equals("sticker"))
                    {   
                        programTimeTable[program1Index][index].swap(stickerTimeTable[program1Index][activeLabelIndex]);
                        programTimeTable[program1Index][index].setVenue(venueNameArray[venueIndex]);
                        stickerLabel[activeLabelIndex].setText(stickerTimeTable[program1Index][activeLabelIndex].getData()); 
                            
                        removeToSticker(programTimeTable[program1Index][index]);
                    }
                    else if(activeLabel.equals("newLabel"))
                    {
                        programTimeTable[program1Index][index].copy(newLabelData);
                        programTimeTable[program1Index][index].setVenue(activeVenueName.replaceAll("_", "-"));
                    }
                    else
                    {
                        int oldVenueIndex = getVenueIndex(programTimeTable[program1Index][activeLabelIndex].getVenue().replaceAll("-", "_"));
                        programTimeTable[program1Index][index].swap(programTimeTable[program1Index][activeLabelIndex]);
                        programTimeTable[program1Index][index].setVenue(venueNameArray[venueIndex]);
                        programTimeTableLabelSlot12[activeLabelIndex].setText(programTimeTable[program1Index][activeLabelIndex].getData()); 
                        
                        if(program2Index<programNameArray.length)
                        programTimeTable[program2Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                        if(program3Index<programNameArray.length)
                        programTimeTable[program3Index][activeLabelIndex].copy(programTimeTable[program1Index][activeLabelIndex]);
                           
                        teacherTimeTable[teacher1Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                        updateTeacherAllotmentArray(teacher1Index,activeLabelIndex,0);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher1Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher2Index,activeLabelIndex,0);
                        }
                        if(teacher3Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][activeLabelIndex].setData(activeLabelIndex,"","","","","","");
                            updateTeacherAllotmentArray(teacher3Index,activeLabelIndex,0);
                        }
                            
                        venueTimeTable[oldVenueIndex][activeLabelIndex].setData(activeLabelIndex,"","","","","","","","");
                        updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex,0);
                        
                        if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                        {
                            programTimeTable[program1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            if(program2Index<programNameArray.length)
                                programTimeTable[program2Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                            if(program3Index<programNameArray.length)
                                programTimeTable[program3Index][activeLabelIndex+5].copy(programTimeTable[program1Index][activeLabelIndex+5]);
                           
                            teacherTimeTable[teacher1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                            updateTeacherAllotmentArray(teacher1Index,activeLabelIndex+5,0);
                            if(teacher2Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher1Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher2Index,activeLabelIndex+5,0);
                            }
                            if(teacher3Index<teacherFullNameArray.length)
                            {
                                teacherTimeTable[teacher3Index][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","");
                                updateTeacherAllotmentArray(teacher3Index,activeLabelIndex+5,0);
                            }
                            
                            venueTimeTable[oldVenueIndex][activeLabelIndex+5].setData(activeLabelIndex+5,"","","","","","","","");
                            updateVenueAllotmentArray(oldVenueIndex,activeLabelIndex+5,0);
                                
                            programTimeTableLabelSlot12[activeLabelIndex+5].setText("");
                        }
                    }
                    programTimeTableLabelSlot12[index].setText(programTimeTable[program1Index][index].getData());
                    if(program2Index<programNameArray.length)
                        programTimeTable[program2Index][index].copy(programTimeTable[program1Index][index]);
                    if(program3Index<programNameArray.length)
                        programTimeTable[program3Index][index].copy(programTimeTable[program1Index][index]);
                    
                    teacherTimeTable[teacher1Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateTeacherAllotmentArray(teacher1Index,index,1);
                    if(teacher2Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher2Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher2Index,index,1);
                    }
                    if(teacher3Index<teacherFullNameArray.length)
                    {
                        teacherTimeTable[teacher3Index][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),venueNameArray[venueIndex],programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                        updateTeacherAllotmentArray(teacher3Index,index,1);
                    }
                    venueTimeTable[venueIndex][index].setData(index,programTimeTable[program1Index][index].getCourseCode(),programTimeTable[program1Index][index].getClassType(),teacherNickNameArray[teacher1Index],teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",teacher2Index<teacherNickNameArray.length?teacherNickNameArray[teacher2Index]:"",programNameArray[program1Index],program2Index<programNameArray.length?programNameArray[program2Index]:"",program3Index<programNameArray.length?programNameArray[program3Index]:"");
                    updateVenueAllotmentArray(venueIndex,index,1);
                    
                    if(programTimeTable[program1Index][index].getClassType().equals("Practical"))
                    {
                        programTimeTable[program1Index][index].setData(index + 5, "Do", "", "", "", "", "");
                        if(program2Index<programNameArray.length)
                        {
                            programTimeTable[program2Index][index].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        if(program3Index<programNameArray.length)
                        {
                            programTimeTable[program3Index][index].setData(index + 5, "Do", "", "", "", "", "");
                        }
                        programTimeTableLabelSlot12[index+5].setText("Do");
                                
                        teacherTimeTable[teacher1Index][index].setData(index + 5, "Do", "", "", "", "", "");
                        updateTeacherAllotmentArray(teacher1Index,index+5,1);
                        if(teacher2Index<teacherFullNameArray.length)
                        {
                            teacherTimeTable[teacher2Index][index].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher2Index,index+5,1);
                        }
                        if(teacher3Index<programNameArray.length)
                        {
                            teacherTimeTable[teacher3Index][index].setData(index + 5, "Do", "", "", "", "", "");
                            updateTeacherAllotmentArray(teacher3Index,index+5,1);
                        }
                        venueTimeTable[venueIndex][index].setData(index + 5, "Do", "", "", "", "", "","","");
                        updateVenueAllotmentArray(venueIndex,index+5,1);
                    }
                    loadCurrentProgramTimeTable();
                    loadActiveVenueTimeTable();
                    loadActiveTeacherTimeTable();
                }
                event.consume();
            });
            }
        }
    }
    private int activeTeacherIndex;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
//        TimeTablePage.primaryStage.getScene().setCursor(Cursor.WAIT);
        //making the respective arrays of various label types.
        programTimeTableLabelSlot8 = new Label[]{slot8cell0,slot8cell1,slot8cell2,slot8cell3,slot8cell4,slot8cell5,slot8cell6,slot8cell7,slot8cell8,slot8cell9,slot8cell10,slot8cell11,slot8cell12,slot8cell13,slot8cell14,slot8cell15,slot8cell16,slot8cell17,slot8cell18,slot8cell19,slot8cell20,slot8cell21,slot8cell22,slot8cell23,slot8cell24,slot8cell25,slot8cell26,slot8cell27,slot8cell28,slot8cell29,slot8cell30,slot8cell31,slot8cell32,slot8cell33,slot8cell34,slot8cell35,slot8cell36,slot8cell37,slot8cell38,slot8cell39,slot8cell40,slot8cell41,slot8cell42,slot8cell43,slot8cell44};
        programTimeTableLabelSlot12 = new Label[]{slot12cell0,slot12cell1,slot12cell2,slot12cell3,slot12cell4,slot12cell5,slot12cell6,slot12cell7,slot12cell8,slot12cell9,slot12cell10,slot12cell11,slot12cell12,slot12cell13,slot12cell14,slot12cell15,slot12cell16,slot12cell17,slot12cell18,slot12cell19,slot12cell20,slot12cell21,slot12cell22,slot12cell23,slot12cell24,slot12cell25,slot12cell26,slot12cell27,slot12cell28,slot12cell29,slot12cell30,slot12cell31,slot12cell32,slot12cell33,slot12cell34};
        teacherTimeTableLabel = new Label[]{t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,t42,t43,t44};
        venueTimeTableLabel = new Label[]{v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,v35,v36,v37,v38,v39,v40,v41,v42,v43,v44};
        stickerLabel = new Label[]{stickerLabel0,stickerLabel1,stickerLabel2,stickerLabel3,stickerLabel4,stickerLabel5,stickerLabel6,stickerLabel7,stickerLabel8,stickerLabel9,stickerLabel10,stickerLabel11,stickerLabel12,stickerLabel13,stickerLabel14,stickerLabel15,stickerLabel16,stickerLabel17,stickerLabel18,stickerLabel19,stickerLabel20,stickerLabel21,stickerLabel22,stickerLabel23,stickerLabel24,stickerLabel25,stickerLabel26,stickerLabel27,stickerLabel28,stickerLabel29,stickerLabel30,stickerLabel31,stickerLabel32,stickerLabel33,stickerLabel34,stickerLabel35,stickerLabel36,stickerLabel37,stickerLabel38,stickerLabel39,stickerLabel40,stickerLabel41,stickerLabel42,stickerLabel43,stickerLabel44};
        loadDatabase();
        popup = new PopupNotification();
        submitButton.setDisable(true);
        
        feasibleCellArray = new int[45];
        // combobox  events.
        programNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeProgramName = newValue.replaceAll(" ", "_");
           slotLength = new ProgramList().getSlotLength(activeProgramName);
           changeTab();
           program1Index = getProgramIndex(newValue.replaceAll(" ", "_"));
           loadCurrentProgramTimeTable();
           loadCurrentProgramSticker();
           submitButton.setDisable(false);
        
        });
        
        venueNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeVenueName = newValue.replaceAll(" ", "_");
           venueIndex = getVenueIndex(newValue.replaceAll(" ", "_"));
           loadActiveVenueTimeTable();
        });
        
        teacherNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
            activeTeacherName = newValue.replaceAll(" ", "_");
            activeTeacherIndex = getTeacherIndex(newValue.replaceAll(" ", "_"));
            loadActiveTeacherTimeTable();
        });
        
        loadProgramList();
        loadCourseList();
        loadVenueList();
        loadTeacherList();
        
        loadDragDropGesture();
//        TimeTablePage.primaryStage.getScene().setCursor(Cursor.DEFAULT);
        venueNameComboBox.getSelectionModel().select(0);
    }
    private int teacher1Index;
    private int teacher2Index;
    private int teacher3Index;
    private int venueIndex;
    private int program1Index;
    private int program2Index;
    private int program3Index;
    private int slotLength; //initialise it in combobox listener.
    
    private void loadFeasibleCell(ParticularProgramTimeTableData cell)
    {
        refreshCell();
        teacher1Label.setText(cell.getTeacher1());
        teacher2Label.setText(cell.getTeacher2());
        teacher3Label.setText(cell.getTeacher3());
        courseCodeLabel.setText(cell.getCourseCode());
        classTypeLabel.setText(cell.getClassType());
        teacher1Index = getTeacherIndex(cell.getTeacher1());
        teacher2Index = getTeacherIndex(cell.getTeacher2());
        teacher3Index = getTeacherIndex(cell.getTeacher3());
        CombineClasses combineClass = new CombineClasses();
        combineClass.getCombination(cell.getCourseCode(), activeProgramName);
        program2Index = getProgramIndex(combineClass.getProgramName2());
        program3Index = getProgramIndex(combineClass.getProgramName3());
        System.err.println("********************program2: "+program2Index+" ****Program3: "+program3Index+"****program1:"+program1Index);
        popup.alert("indexes","proram1:"+program1Index+", 2:"+program2Index+", 3:"+program3Index);
        String classType = cell.getClassType();
        int extraIndexValue = classType.equals("Practical") ? 5 : 0;  // this will we used for checking the availability of one more free cell.
        int index;
        for(int row = 0; row < 9 ; row++)
        {
            for(int coloum = 0; coloum < 5; coloum++)
            {
                index = row*5+coloum;
                if(extraIndexValue > 0)
                {
                    if(slotLength == 9 && (row == 4 || row == 8) )
                    {
                        feasibleCellArray[index] = 1;
                    }
                    else if(slotLength == 12 &&  (row == 3 || row == 6))
                    {
                        feasibleCellArray[index] = 1;
                    }
                    else if(isTeacherFree(teacher1Index, index) && isTeacherFree(teacher2Index, index) && isTeacherFree(teacher3Index, index) && isVenueFree(venueIndex, index) && isProgramFree(program1Index,index) && isProgramFree(program2Index,index) && isProgramFree(program3Index,index) && isTeacherFree(teacher1Index, index+extraIndexValue) && isTeacherFree(teacher2Index, index+extraIndexValue) && isTeacherFree(teacher3Index, index+extraIndexValue) && isVenueFree(venueIndex, index+extraIndexValue) && isProgramFree(program1Index,index+extraIndexValue) && isProgramFree(program2Index,index+extraIndexValue) && isProgramFree(program3Index,index+extraIndexValue) )
                    {
                        feasibleCellArray[index] = 0;
                    }
                    else
                    {
                        feasibleCellArray[index] = 1;
                    }
                    
                }
                else
                {
                    if(isTeacherFree(teacher1Index, index) && isTeacherFree(teacher2Index, index) && isTeacherFree(teacher3Index, index) && isVenueFree(venueIndex, index) && isProgramFree(program1Index,index) && isProgramFree(program2Index,index) && isProgramFree(program3Index,index) )
                    {
                        feasibleCellArray[index] = 0;
                    }
                    else
                    {
                        feasibleCellArray[index] = 1;
                    }
                }
            }
        }
        if(slotLength == 9)
        {
            for(int row = 0; row < 9 ; row++)
            {
                for(int coloum = 0; coloum < 5; coloum++)
                {
                    if(feasibleCellArray[row*5+coloum] == 0)
                    { 
            //            System.out.println("FeasibelCellArray is free at ["+row+"]["+coloum+"]");
                        
                        programTimeTableLabelSlot8[row*5+coloum].getStyleClass().remove("slotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().remove("slotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().remove("slotCell");
                        programTimeTableLabelSlot8[row*5+coloum].getStyleClass().add("feasibleSlotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().add("feasibleSlotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().add("feasibleSlotCell");
                    }
                    else
                    {
              //           System.out.println("FeasibelCellArray is filled at ["+row+"]["+coloum+"] ");
                        programTimeTableLabelSlot8[row*5+coloum].getStyleClass().remove("feasibleSlotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().remove("feasibleSlotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().remove("feasibleSlotCell");
                        programTimeTableLabelSlot8[row*5+coloum].getStyleClass().add("slotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().add("slotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().add("slotCell");
                    }
                }
            }
        }
        else
        {
            for(int row = 0; row < 7 ; row++)
            {
                for(int coloum = 0; coloum < 5; coloum++)
                {
                    if(feasibleCellArray[row*5+coloum] == 0)
                    { 
                //       System.out.println("FeasibelCellArray is free at ["+row+"]["+coloum+"] ");
                        programTimeTableLabelSlot12[row*5+coloum].getStyleClass().remove("slotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().remove("slotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().remove("slotCell");
                        programTimeTableLabelSlot12[row*5+coloum].getStyleClass().add("feasibleSlotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().add("feasibleSlotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().add("feasibleSlotCell");
                    }
                    else
                    {
                  //      System.out.println("FeasibelCellArray is filled at ["+row+"]["+coloum+"]");
                        programTimeTableLabelSlot12[row*5+coloum].getStyleClass().remove("feasibleSlotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().remove("feasibleSlotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().remove("feasibleSlotCell");
                        programTimeTableLabelSlot12[row*5+coloum].getStyleClass().add("slotCell");
                        teacherTimeTableLabel[row*5+coloum].getStyleClass().add("slotCell");
                        venueTimeTableLabel[row*5+coloum].getStyleClass().add("slotCell");
                    }
                }
            }
        }
    }
    

    private void refreshCell() 
    {
     //   popup.warning("Refresh","Refresh method is called");
//        System.out.println("Refreshing all the cells:..................");
        if(new ProgramList().getSlotLength(activeProgramName) == 9)
        {
            for(int i=0 ;i<45;i++)
            {
                programTimeTableLabelSlot8[i].getStyleClass().remove("feasibleSlotCell");
                teacherTimeTableLabel[i].getStyleClass().remove("feasibleSlotCell");
                venueTimeTableLabel[i].getStyleClass().remove("feasibleSlotCell");
                programTimeTableLabelSlot8[i].getStyleClass().add("slotCell");
                teacherTimeTableLabel[i].getStyleClass().add("slotCell");
                venueTimeTableLabel[i].getStyleClass().add("slotCell");
  //              System.out.println("Slot 8: "+i);
            }
        }
        else
        {
            for(int i=0 ;i<35;i++)
            {
                programTimeTableLabelSlot12[i].getStyleClass().remove("feasibleSlotCell");
                teacherTimeTableLabel[i].getStyleClass().remove("feasibleSlotCell");
                venueTimeTableLabel[i].getStyleClass().remove("feasibleSlotCell");
                programTimeTableLabelSlot12[i].getStyleClass().add("slotCell");
                teacherTimeTableLabel[i].getStyleClass().add("slotCell");
                venueTimeTableLabel[i].getStyleClass().add("slotCell");
    //            System.out.println("Slot 12: "+i);
            }
        }
    }
    private void loadDatabase()
    {
        teacherFullNameArray = new String[new TeacherList().count()];
        teacherNickNameArray = new String[new TeacherList().count()];
        venueNameArray = new String[new VenueList().count()];
        programNameArray = new String [new ProgramList().count()];
        teacherAvailablityArray = new int[teacherFullNameArray.length][500];
        venueAvailablityArray = new int[venueNameArray.length][500];
        programTimeTable = new ParticularProgramTimeTableData[programNameArray.length][45];
        teacherTimeTable = new ParticularTeacherTimeTableData[teacherFullNameArray.length][45];
        venueTimeTable = new ParticularVenueTimeTableData[venueNameArray.length][45];
        stickerTimeTable = new ParticularProgramTimeTableData[programNameArray.length][45];
        TeacherList teacherList = new TeacherList();
        for(int i=0; i<teacherFullNameArray.length; i++)
        {
            teacherList.getData();
            teacherFullNameArray[i] = teacherList.getTeacherFullName();
            teacherNickNameArray[i] = teacherList.getTeacherNickName();
        }
        
        VenueList venueList = new VenueList();
        for(int i=0; i<venueNameArray.length; i++)
        {
            venueList.getData();
            venueNameArray[i] = venueList.getVenueName();
        }
        ProgramList programList = new ProgramList();
        for(int i=0; i<programNameArray.length; i++)
        {
            programList.getData();
            programNameArray[i] = programList.getProgramName()+programList.getSemester();
        }
        
        ParticularTeacher particularTeacher;
        for(int i=0; i<teacherFullNameArray.length; i++)
        {
            particularTeacher = new ParticularTeacher(teacherFullNameArray[i]);
            for(int j=0; j<500; j++)
            {
                teacherAvailablityArray[i][j] = 0;
            }
            while(particularTeacher.getData())
            {
                teacherAvailablityArray[i][particularTeacher.getSno()] = 1;
            }
        }
        
        ParticularVenue particularVenue;
        for(int i=0; i<venueNameArray.length; i++)
        {
            particularVenue = new ParticularVenue(venueNameArray[i]);
            for(int j=0; j<500; j++)
            {
                venueAvailablityArray[i][j] = 0;
            }
            while(particularVenue.getData())
            {
                venueAvailablityArray[i][particularVenue.getSno()] = 1;
            }
        }
        ParticularProgramTimeTable particularProgramTimeTable;
        for(int i=0;i<programNameArray.length;i++)
        {
            particularProgramTimeTable = new ParticularProgramTimeTable(programNameArray[i]+"_tt");
            for(int j=0; j<45; j++)
            {
                programTimeTable[i][j] =  new  ParticularProgramTimeTableData(); 
            }
            while(particularProgramTimeTable.getData())
            {
                programTimeTable[i][particularProgramTimeTable.getSno()].setData(particularProgramTimeTable);
            }
        }
        ParticularTeacherTimeTable particularTeacherTimeTable;
        for(int i=0;i<teacherFullNameArray.length;i++)
        {
            particularTeacherTimeTable = new ParticularTeacherTimeTable(teacherFullNameArray[i]+"_tt");
            for(int j=0; j<45; j++)
            {
                teacherTimeTable[i][j] =  new  ParticularTeacherTimeTableData(); 
            }
            while(particularTeacherTimeTable.getData())
            {
                teacherTimeTable[i][particularTeacherTimeTable.getSno()].setData(particularTeacherTimeTable);
            }
        }
        ParticularVenueTimeTable particularVenueTimeTable;
        for(int i=0;i<venueNameArray.length;i++)
        {
            particularVenueTimeTable = new ParticularVenueTimeTable(venueNameArray[i]+"_tt");
            for(int j=0; j<45; j++)
            {
                venueTimeTable[i][j] =  new  ParticularVenueTimeTableData(); 
            }
            while(particularVenueTimeTable.getData())
            {
                venueTimeTable[i][particularVenueTimeTable.getSno()].setData(particularVenueTimeTable);
            }
        }
        ParticularProgramTimeTable particularStickerTimeTable;
        for(int i=0;i<programNameArray.length;i++)
        {
            particularStickerTimeTable = new ParticularProgramTimeTable(programNameArray[i]+"_tt_st");
            for(int j=0; j<45; j++)
            {
                stickerTimeTable[i][j] =  new  ParticularProgramTimeTableData(); 
            }
            int j=0;
            while(particularStickerTimeTable.getData())
            {
                stickerTimeTable[i][j].setData(particularStickerTimeTable);
                j++;
            }
        } 
    }
    private int getVenueIndex(String venueName)
    {
        int i;
        for( i=0; i<venueNameArray.length;i++)
        {
            if(venueNameArray[i].equals(venueName))
                break;
        }
        return i;
    }
    private int getProgramIndex(String programName)
    {
        int i;
        for( i=0; i<programNameArray.length;i++)
        {
            if(programNameArray[i].equals(programName))
                break;
        }
        return i;
    }
    private int getTeacherIndex(String teacherNickName)
    {
        int i;
        for( i=0; i<teacherNickNameArray.length;i++)
        {
            if(teacherNickNameArray[i].equals(teacherNickName))
                break;
        }
        if(i==teacherNickNameArray.length)
        {
            for( i=0; i<teacherNickNameArray.length;i++)
            {
                if(teacherFullNameArray[i].equals(teacherNickName))
                    break;
            }
        }
        return i;
    }
    private boolean isTeacherFree(int teacherIndex,int cellIndex)
    {
        boolean res = true;
        if(teacherIndex<teacherFullNameArray.length)
        {
            if(slotLength == 9)
            {
                if(!teacherTimeTable[teacherIndex][cellIndex].getCourseCode().equals(""))
                {
                    res = false;
                }
            }
            else
            {
                int realIndex;
                int jIndex = cellIndex%5;
                int iIndex = (cellIndex-jIndex)/5;
                int upperLimit;
                int lowerLimit;
        
                upperLimit = SLOT12UPPER[iIndex];
                lowerLimit = SLOT12LOWER[iIndex];
                for(int i=lowerLimit; i<=upperLimit; i++)
                {
                    realIndex = jIndex*100+i;
                    if(teacherAvailablityArray[teacherIndex][i] == 1)
                    {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
    private boolean isVenueFree(int venueIndex,int cellIndex)
    {
        boolean res = true;
        if(venueIndex<venueNameArray.length)
        {
            if(slotLength == 9)
            {
                if(!venueTimeTable[venueIndex][cellIndex].getCourseCode().equals(""))
                {
                    res = false;
                }
            }
            else
            {
                int realIndex;
                int jIndex = cellIndex%5;
                int iIndex = (cellIndex-jIndex)/5;
                int upperLimit;
                int lowerLimit;
        
                upperLimit = SLOT12UPPER[iIndex];
                lowerLimit = SLOT12LOWER[iIndex];
                for(int i=lowerLimit; i<=upperLimit; i++)
                {
                    realIndex = jIndex*100+i;
                    if(venueAvailablityArray[venueIndex][i] == 1)
                    {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
    private boolean isProgramFree(int programIndex,int cellIndex)
    {
        boolean res = true;
        if(programIndex < programNameArray.length)
        if(!programTimeTable[programIndex][cellIndex].getCourseCode().equals(""))
        {
            res = false;
        }
        return res;
    }
    private static final int [] SLOT8LOWER = new int[]{1,11,21,31,51,61,71,81,91};
    private static final int [] SLOT8UPPER = new int[]{9,19,29,39,59,69,79,89,99};
    private static final int [] SLOT12LOWER = new int[]{1,14,27,40,61,74,87};
    private static final int [] SLOT12UPPER = new int[]{12,25,38,51,72,85,98};
    
    private void updateTeacherAllotmentArray(int teacherIndex,int atIndex,int updateValue)
    {
        if(teacherIndex<teacherFullNameArray.length)
        {
            int jIndex = atIndex%5;
        int iIndex = (atIndex-jIndex)/5;
        int upperLimit;
        int lowerLimit;
        
        if(slotLength == 9)
        {
            upperLimit = SLOT8UPPER[iIndex];
            lowerLimit = SLOT8LOWER[iIndex];
        }
        else
        {
            upperLimit = SLOT12UPPER[iIndex];
            lowerLimit = SLOT12LOWER[iIndex];
        }
        if(updateValue == 0)
        {
            for(int i=lowerLimit;i<= upperLimit;i++)
            {
                teacherAvailablityArray[teacherIndex][jIndex*100+i] = 0;
            }
        }
        else
        {
            for(int i=lowerLimit;i<= upperLimit;i++)
            {
                teacherAvailablityArray[teacherIndex][jIndex*100+i] = 1;
            }
        }
        }
    }
    private void updateVenueAllotmentArray(int venueIndex,int atIndex,int updateValue)
    {
        if(venueIndex<venueNameArray.length)
        {
            int jIndex = atIndex%5;
        int iIndex = (atIndex-jIndex)/5;
        int upperLimit;
        int lowerLimit;
        
        if(slotLength == 9)
        {
            upperLimit = SLOT8UPPER[iIndex];
            lowerLimit = SLOT8LOWER[iIndex];
        }
        else
        {
            upperLimit = SLOT12UPPER[iIndex];
            lowerLimit = SLOT12LOWER[iIndex];
        }
        if(updateValue == 0)
        {
            for(int i=lowerLimit;i<= upperLimit;i++)
            {
                venueAvailablityArray[venueIndex][jIndex*100+i] = 0;
            }
        }
        else
        {
            for(int i=lowerLimit;i<= upperLimit;i++)
            {
                venueAvailablityArray[venueIndex][jIndex*100+i] = 1;
            }
        }
        }
    }
    private void addToSticker(ParticularProgramTimeTableData cell)
    {
        //adding data for combined program2 after finding a free cell.
        if(program2Index<programNameArray.length)
        {
            for(int i=0;i<45;i++)
            {
                if(stickerTimeTable[program2Index][i].getCourseCode().equals(""))
                {
                    stickerTimeTable[program2Index][i].copy(cell);
                    break;
                }
            }
        }
        
        //adding data for combined program3 after finding a free cell.
        if(program3Index<programNameArray.length)
        {
            for(int i=0;i<45;i++)
            {
                if(stickerTimeTable[program3Index][i].getCourseCode().equals(""))
                {
                    stickerTimeTable[program3Index][i].copy(cell);
                    break;
                }
            }
        }
    }
    private void removeToSticker(ParticularProgramTimeTableData cell)
    {
        //adding data for combined program2 after finding a free cell.
        if(program2Index<programNameArray.length)
        {
            for(int i=0;i<45;i++)
            {
                if(stickerTimeTable[program2Index][i].isEquals(cell))
                {
                    stickerTimeTable[program2Index][i] = new ParticularProgramTimeTableData();
                    popup.alert("found for program 2", "index = "+i);
                    break;
                }
            }
        }
        
        //adding data for combined program3 after finding a free cell.
        if(program3Index<programNameArray.length)
        {
            for(int i=0;i<45;i++)
            {
                if(stickerTimeTable[program3Index][i].isEquals(cell))
                {
                    stickerTimeTable[program3Index][i] = new ParticularProgramTimeTableData();
                    popup.alert("found for program 3", "index = "+i);
                    break;
                }
            }
        }
    }
}  
/**
 * get genuine index
 * mail mechanism
 * how to send image file.
 * improve print mechanism+-
 */
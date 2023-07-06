/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.print;

import database.base.ProgramList;
import database.base.TeacherList;
import database.base.VenueList;
import database.superclass.ParticularProgramTimeTable;
import database.superclass.ParticularProgramTimeTableData;
import database.superclass.ParticularTeacherTimeTable;
import database.superclass.ParticularTeacherTimeTableData;
import database.superclass.ParticularVenueTimeTable;
import database.superclass.ParticularVenueTimeTableData;
import gui.MasterController;
import gui.PopupNotification;
import gui.tools.autocompletecombobox.AutoCompleteBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class ProgramTimeTableController implements Initializable {

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
    private TextArea slot8cell0;
    @FXML
    private TextArea slot8cell1;
    @FXML
    private TextArea slot8cell2;
    @FXML
    private TextArea slot8cell3;
    @FXML
    private TextArea slot8cell4;
    @FXML
    private TextArea slot8cell5;
    @FXML
    private TextArea slot8cell6;
    @FXML
    private TextArea slot8cell7;
    @FXML
    private TextArea slot8cell8;
    @FXML
    private TextArea slot8cell9;
    @FXML
    private TextArea slot8cell10;
    @FXML
    private TextArea slot8cell11;
    @FXML
    private TextArea slot8cell12;
    @FXML
    private TextArea slot8cell13;
    @FXML
    private TextArea slot8cell14;
    @FXML
    private TextArea slot8cell15;
    @FXML
    private TextArea slot8cell16;
    @FXML
    private TextArea slot8cell17;
    @FXML
    private TextArea slot8cell18;
    @FXML
    private TextArea slot8cell19;
    @FXML
    private TextArea slot8cell20;
    @FXML
    private TextArea slot8cell21;
    @FXML
    private TextArea slot8cell22;
    @FXML
    private TextArea slot8cell23;
    @FXML
    private TextArea slot8cell24;
    @FXML
    private TextArea slot8cell25;
    @FXML
    private TextArea slot8cell26;
    @FXML
    private TextArea slot8cell27;
    @FXML
    private TextArea slot8cell28;
    @FXML
    private TextArea slot8cell29;
    @FXML
    private TextArea slot8cell30;
    @FXML
    private TextArea slot8cell31;
    @FXML
    private TextArea slot8cell32;
    @FXML
    private TextArea slot8cell33;
    @FXML
    private TextArea slot8cell34;
    @FXML
    private TextArea slot8cell35;
    @FXML
    private TextArea slot8cell36;
    @FXML
    private TextArea slot8cell37;
    @FXML
    private TextArea slot8cell38;
    @FXML
    private TextArea slot8cell39;
    @FXML
    private TextArea slot8cell40;
    @FXML
    private TextArea slot8cell41;
    @FXML
    private TextArea slot8cell42;
    @FXML
    private TextArea slot8cell43;
    @FXML
    private  TextArea slot8cell44;
    @FXML
    private Tab slot12tab;
    @FXML
    private TextArea slot12cell0;
    @FXML
    private TextArea slot12cell1;
    @FXML
    private TextArea slot12cell2;
    @FXML
    private TextArea slot12cell3;
    @FXML
    private TextArea slot12cell4;
    @FXML
    private TextArea slot12cell5;
    @FXML
    private TextArea slot12cell6;
    @FXML
    private TextArea slot12cell7;
    @FXML
    private TextArea slot12cell8;
    @FXML
    private TextArea slot12cell9;
    @FXML
    private TextArea slot12cell10;
    @FXML
    private TextArea slot12cell11;
    @FXML
    private TextArea slot12cell12;
    @FXML
    private TextArea slot12cell13;
    @FXML
    private TextArea slot12cell14;
    @FXML
    private TextArea slot12cell15;
    @FXML
    private TextArea slot12cell16;
    @FXML
    private TextArea slot12cell17;
    @FXML
    private TextArea slot12cell18;
    @FXML
    private TextArea slot12cell19;
    @FXML
    private TextArea slot12cell20;
    @FXML
    private TextArea slot12cell21;
    @FXML
    private TextArea slot12cell22;
    @FXML
    private TextArea slot12cell23;
    @FXML
    private TextArea slot12cell24;
    @FXML
    private TextArea slot12cell25;
    @FXML
    private TextArea slot12cell26;
    @FXML
    private TextArea slot12cell27;
    @FXML
    private TextArea slot12cell28;
    @FXML
    private TextArea slot12cell29;
    @FXML
    private TextArea slot12cell30;
    @FXML
    private TextArea slot12cell31;
    @FXML
    private TextArea slot12cell32;
    @FXML
    private TextArea slot12cell33;
    @FXML
    private TextArea slot12cell34;
    @FXML
    private TextArea t0;
    @FXML
    private TextArea t1;
    @FXML
    private TextArea t2;
    @FXML
    private TextArea t3;
    @FXML
    private TextArea t4;
    @FXML
    private TextArea t5;
    @FXML
    private TextArea t6;
    @FXML
    private TextArea t7;
    @FXML
    private TextArea t8;
    @FXML
    private TextArea t9;
    @FXML
    private TextArea t10;
    @FXML
    private TextArea t11;
    @FXML
    private TextArea t12;
    @FXML
    private TextArea t13;
    @FXML
    private TextArea t14;
    @FXML
    private TextArea t15;
    @FXML
    private TextArea t16;
    @FXML
    private TextArea t17;
    @FXML
    private TextArea t18;
    @FXML
    private TextArea t19;
    @FXML
    private TextArea t20;
    @FXML
    private TextArea t21;
    @FXML
    private TextArea t22;
    @FXML
    private TextArea t23;
    @FXML
    private TextArea t24;
    @FXML
    private TextArea t25;
    @FXML
    private TextArea t26;
    @FXML
    private TextArea t27;
    @FXML
    private TextArea t28;
    @FXML
    private TextArea t29;
    @FXML
    private TextArea t30;
    @FXML
    private TextArea t31;
    @FXML
    private TextArea t32;
    @FXML
    private TextArea t33;
    @FXML
    private TextArea t34;
    @FXML
    private TextArea t35;
    @FXML
    private TextArea t36;
    @FXML
    private TextArea t37;
    @FXML
    private TextArea t38;
    @FXML
    private TextArea t39;
    @FXML
    private TextArea t40;
    @FXML
    private TextArea t41;
    @FXML
    private TextArea t42;
    @FXML
    private TextArea t43;
    @FXML
    private TextArea t44;
    @FXML
    private TextArea v0;
    @FXML
    private TextArea v1;
    @FXML
    private TextArea v2;
    @FXML
    private TextArea v3;
    @FXML
    private TextArea v4;
    @FXML
    private TextArea v5;
    @FXML
    private TextArea v6;
    @FXML
    private TextArea v7;
    @FXML
    private TextArea v8;
    @FXML
    private TextArea v9;
    @FXML
    private TextArea v10;
    @FXML
    private TextArea v11;
    @FXML
    private TextArea v12;
    @FXML
    private TextArea v13;
    @FXML
    private TextArea v14;
    @FXML
    private TextArea v15;
    @FXML
    private TextArea v16;
    @FXML
    private TextArea v17;
    @FXML
    private TextArea v18;
    @FXML
    private TextArea v19;
    @FXML
    private TextArea v20;
    @FXML
    private TextArea v21;
    @FXML
    private TextArea v22;
    @FXML
    private TextArea v23;
    @FXML
    private TextArea v24;
    @FXML
    private TextArea v25;
    @FXML
    private TextArea v26;
    @FXML
    private TextArea v27;
    @FXML
    private TextArea v28;
    @FXML
    private TextArea v29;
    @FXML
    private TextArea v30;
    @FXML
    private TextArea v31;
    @FXML
    private TextArea v32;
    @FXML
    private TextArea v33;
    @FXML
    private TextArea v34;
    @FXML
    private TextArea v35;
    @FXML
    private TextArea v36;
    @FXML
    private TextArea v37;
    @FXML
    private TextArea v38;
    @FXML
    private TextArea v39;
    @FXML
    private TextArea v40;
    @FXML
    private TextArea v41;
    @FXML
    private TextArea v42;
    @FXML
    private TextArea v43;
    @FXML
    private TextArea v44;

    /**
     * Initializes the controller class.
     */
    
    private PopupNotification popup;
    private String activeTeacherName;
    private String activeProgramName;
    private String activeVenueName;
    private TextArea[] programTimeTableLabelSlot12;
    private TextArea[] teacherTimeTableLabel;
    private TextArea[] venueTimeTableLabel;
    private ParticularProgramTimeTableData [] currentProgramTimeTableData;
    @FXML
    private GridPane program8TimeTable;
    @FXML
    private ScrollPane root;
    @FXML
    private GridPane program12TimeTable;
    @FXML
    private GridPane venueTimeTable;
    @FXML
    private GridPane teacherTimeTable;
    private TextArea[] programTimeTableLabelSlot8;
    @FXML
    private BarChart<?, ?> graph;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    private XYChart.Series set1;
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
               
            }
	};
        teacherListThread.start();
        while(teacherListThread.isAlive());        
        new AutoCompleteBox(teacherNameComboBox);
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
       ParticularTeacherTimeTable teacherTimeTable = new ParticularTeacherTimeTable(activeTeacherName.replaceAll(" ", "_")+"_tt"); 
       ParticularTeacherTimeTableData [] activeTeacherTimeTableData = new ParticularTeacherTimeTableData[45];
       Thread loadTeacherThread  = new Thread()
       {
         @Override
         public void run()
         {
            int noOfRecord = teacherTimeTable.count();
            System.out.println("no of records in "+activeTeacherName+"_tt :"+noOfRecord);
                for(int i=0;i<45;i++)
                {
                    activeTeacherTimeTableData[i] = new ParticularTeacherTimeTableData();
                    activeTeacherTimeTableData[i].setData(i,"","","","","","");
                }
                teacherTimeTable.getData();
                for(int i=0;i<noOfRecord;i++)
                {
                    
                    teacherTimeTable.getData();
                    activeTeacherTimeTableData[teacherTimeTable.getSno()].setData(teacherTimeTable.getSno(),teacherTimeTable.getCourseCode(),
                                                                            teacherTimeTable.getClassType(),
                                                                            teacherTimeTable.getVenue(),
                                                                            teacherTimeTable.getProgram1(),
                                                                            teacherTimeTable.getProgram2(),
                                                                            teacherTimeTable.getProgram3()
                                                                               );
                    //System.out.println(activeTeacherTimeTableData[i].getData());
                }
            }
        };    
        loadTeacherThread.start();
        while(loadTeacherThread.isAlive());
        for(int i=0;i<45;i++)
        {
            teacherTimeTableLabel[i].setText(activeTeacherTimeTableData[i].getData());
        }
       
    }
    
    private void loadActiveVenueTimeTable()
    {
       ParticularVenueTimeTable venueTimeTable = new ParticularVenueTimeTable(activeVenueName.replaceAll(" ", "_")+"_tt"); 
       ParticularVenueTimeTableData [] activeVenueTimeTableData = new ParticularVenueTimeTableData[45];
       Thread loadVenueThread  = new Thread()
       {
         @Override
         public void run()
         {
            int noOfRecord = venueTimeTable.count();
            System.out.println("no of records in "+activeVenueName+"_tt :"+noOfRecord);
                for(int i=0;i<45;i++)
                {
                    activeVenueTimeTableData[i] = new ParticularVenueTimeTableData();
                    activeVenueTimeTableData[i].setData(i,"","","","","","","","");
                }
                venueTimeTable.getData();
                for(int i=0;i<noOfRecord;i++)
                {
                    
                    venueTimeTable.getData();
                    activeVenueTimeTableData[venueTimeTable.getSno()].setData(venueTimeTable.getSno(),venueTimeTable.getCourseCode(),
                                                                            venueTimeTable.getClassType(),
                                                                            venueTimeTable.getTeacher1(),
                                                                            venueTimeTable.getTeacher2(),
                                                                            venueTimeTable.getTeacher3(),
                                                                            venueTimeTable.getProgram1(),
                                                                            venueTimeTable.getProgram2(),
                                                                            venueTimeTable.getProgram3()
                                                                               );
                    //System.out.println(activeTeacherTimeTableData[i].getData());
                }
            }
        };    
        loadVenueThread.start();
        while(loadVenueThread.isAlive());
        for(int i=0;i<45;i++)
        {
            venueTimeTableLabel[i].setText(activeVenueTimeTableData[i].getData());
        }
       
    }
    
    private void loadCurrentProgramTimeTable() 
    {
       ParticularProgramTimeTable programTimeTable = new ParticularProgramTimeTable(activeProgramName.replaceAll(" ", "_")+"_tt"); 
       currentProgramTimeTableData = new ParticularProgramTimeTableData[45];
       Thread loadProgramThread  = new Thread()
       {
         @Override
         public void run()
         {
            int noOfRecord = programTimeTable.count();
            System.out.println("no of records in "+activeProgramName+"_tt :"+noOfRecord);
                for(int i=0;i<45;i++)
                {
                    currentProgramTimeTableData[i] = new ParticularProgramTimeTableData();
                    currentProgramTimeTableData[i].setData(i,"","","","","","");
                }
                programTimeTable.getData();
                for(int i=0;i<noOfRecord;i++)
                {
                    
                    programTimeTable.getData();
                    currentProgramTimeTableData[programTimeTable.getSno()].setData(programTimeTable.getSno(),programTimeTable.getCourseCode(),
                                                                            programTimeTable.getClassType(),
                                                                            programTimeTable.getVenue(),
                                                                            programTimeTable.getTeacher1(),
                                                                            programTimeTable.getTeacher2(),
                                                                            programTimeTable.getTeacher3()  
                                                                               );
                    //System.out.println(currentProgramTimeTableData[i].getData());
                }
            }
        };    
        loadProgramThread.start();
        while(loadProgramThread.isAlive());
        if(new ProgramList().getSlotLength(activeProgramName) == 9)
        {
            for(int i=0;i<45;i++)
            {
                programTimeTableLabelSlot8[i].setText(currentProgramTimeTableData[i].getData());
                
            }
        }
        else
        {
            for(int i=0;i<35;i++)
            {
                programTimeTableLabelSlot12[i].setText(currentProgramTimeTableData[i].getData());
            }
        }
       
    }
    String myAccountEmail;
    String password;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //making the respective arrays of various label types.
        programTimeTableLabelSlot8 = new TextArea[]{slot8cell0,slot8cell1,slot8cell2,slot8cell3,slot8cell4,slot8cell5,slot8cell6,slot8cell7,slot8cell8,slot8cell9,slot8cell10,slot8cell11,slot8cell12,slot8cell13,slot8cell14,slot8cell15,slot8cell16,slot8cell17,slot8cell18,slot8cell19,slot8cell20,slot8cell21,slot8cell22,slot8cell23,slot8cell24,slot8cell25,slot8cell26,slot8cell27,slot8cell28,slot8cell29,slot8cell30,slot8cell31,slot8cell32,slot8cell33,slot8cell34,slot8cell35,slot8cell36,slot8cell37,slot8cell38,slot8cell39,slot8cell40,slot8cell41,slot8cell42,slot8cell43,slot8cell44};
        programTimeTableLabelSlot12 = new TextArea[]{slot12cell0,slot12cell1,slot12cell2,slot12cell3,slot12cell4,slot12cell5,slot12cell6,slot12cell7,slot12cell8,slot12cell9,slot12cell10,slot12cell11,slot12cell12,slot12cell13,slot12cell14,slot12cell15,slot12cell16,slot12cell17,slot12cell18,slot12cell19,slot12cell20,slot12cell21,slot12cell22,slot12cell23,slot12cell24,slot12cell25,slot12cell26,slot12cell27,slot12cell28,slot12cell29,slot12cell30,slot12cell31,slot12cell32,slot12cell33,slot12cell34};
        teacherTimeTableLabel = new TextArea[]{t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,t42,t43,t44};
        venueTimeTableLabel = new TextArea[]{v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,v35,v36,v37,v38,v39,v40,v41,v42,v43,v44};
        
        myAccountEmail = "sahu.deepanshu0101@gmail.com";
        password = "Games@google1";
        popup = new PopupNotification();
        // combobox  events.
        programNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeProgramName = newValue.replaceAll(" ", "_");
           changeTab();
           loadCurrentProgramTimeTable();
           
        });
        
        venueNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
           activeVenueName = newValue.replaceAll(" ", "_");
           loadActiveVenueTimeTable();
        });
        
        teacherNameComboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, final String oldValue, final String newValue) -> {
            activeTeacherName = newValue.replaceAll(" ", "_");
            loadActiveTeacherTimeTable();
        });
        set1 = new XYChart.Series<>();
       loadGraph();
        loadProgramList();
        loadVenueList();
        loadTeacherList();
    }    
    @SuppressWarnings("empty-statement")
    private void loadGraph()
    {
        Thread graphLoader = new Thread()
        {
            @Override
            public void run()
            {
                TeacherList teacherList = new TeacherList();
                ParticularTeacherTimeTable particularTeacher;
                int loopCounter = teacherList.count();
                for(int i=0; i<loopCounter; i++)
                {
                    teacherList.getData();
                    particularTeacher = new ParticularTeacherTimeTable(teacherList.getTeacherFullName()+"_tt");
                    set1.getData().add(new XYChart.Data(teacherList.getTeacherNickName(),particularTeacher.count()));
                }
            }
        };
        graphLoader.start();
        while(graphLoader.isAlive());
        
                graph.getData().addAll(set1);
        
    }

    @FXML
    private void homeButtonEvent(ActionEvent event) {
        try {
            MasterController.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/gui/DashBoard.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(ProgramTimeTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void printAllButtonAction(ActionEvent event) {
        int maxValue = new ProgramList().count();
        try
        {
            MasterController.primaryStage.getScene().setCursor(Cursor.WAIT);
            for(int i=0; i<maxValue; i++)
            {
                programNameComboBox.getSelectionModel().select(i);
                System.out.println("activeProgramName: "+activeProgramName);
                if(activeProgramName != null)
                {
                    WritableImage image;
                    if(new ProgramList().getSlotLength(activeProgramName) == 9)
                    {
                        image= program8TimeTable.snapshot(new SnapshotParameters(), null);
                    }
                    else
                    {
                        image = program12TimeTable.snapshot(new SnapshotParameters(), null);
                    }
                    File file = new File("..\\images\\program\\"+activeProgramName+".jpg");
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                }
            }
            maxValue = new TeacherList().count();
            for(int i=0; i<maxValue; i++)
            {
                teacherNameComboBox.getSelectionModel().select(i);
                if(activeTeacherName != null)
                {
                    WritableImage image;
                    image = teacherTimeTable.snapshot(new SnapshotParameters(), null);
                    File file = new File("..\\images\\teacher\\"+activeTeacherName+".jpg");
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                }
                else
                {
                    popup.alert("Unable To Print", "Please select a Teacher first!");
                }
            }
            maxValue = new VenueList().count();
            for(int i=0; i<maxValue; i++)
            {
                venueNameComboBox.getSelectionModel().select(i);
                if(activeVenueName != null)
                {
                    WritableImage image;
                    image = venueTimeTable.snapshot(new SnapshotParameters(), null);
                    File file = new File("..\\images\\venue\\"+activeVenueName+".jpg");
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                }
                else
                {
                    popup.alert("Unable To Print", "Please select a Venue first!");
                }
            }
            popup.confirm("Saving Done", "Completed...");
        }
        catch(IOException e)
        {
            popup.alert("Unable To Save", "Something Went Wrong!");
        }
        finally
        {
            MasterController.primaryStage.getScene().setCursor(Cursor.DEFAULT);
        }
    }
    @FXML
    private void resetButtonAction(ActionEvent event) {
        
        Thread resetButtonThread = new Thread()
                {
                    @Override
                    public void run()
                {
                    new ParticularProgramTimeTable(activeProgramName+"_tt").deleteAll();
                    
                }
                };
        resetButtonThread.start();
    }

    @FXML
    private void printProgramButtonAction(ActionEvent event) 
    {
        if(activeProgramName != null)
        {
            
            WritableImage image;
            if(new ProgramList().getSlotLength(activeProgramName) == 9)
            {
                image= program8TimeTable.snapshot(new SnapshotParameters(), null);
            }
            else
            {
                image = program12TimeTable.snapshot(new SnapshotParameters(), null);
            }
            File file = new File("..\\images\\program\\"+activeProgramName+".jpg");
            try 
            {
                
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
            catch (IOException e) 
            {
                popup.alert("Unable To Print", "Something Went Wrong!");
            }
            popup.confirm("Saved", "Time Table for "+activeProgramName+" is saved.");
        }
        else
        {
            popup.alert("Unable To Print", "Please select a program first!");
        }
    }

    @FXML
    private void printTeacherButtonAction(ActionEvent event) {
        if(activeTeacherName != null)
        {
            WritableImage image;
            image = teacherTimeTable.snapshot(new SnapshotParameters(), null);
            File file = new File("..\\images\\teacher\\"+activeTeacherName+".jpg");
            try 
            {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
            catch (IOException e) 
            {
                popup.alert("Unable To Print", "Something Went Wrong!");
            }
            popup.confirm("Saved", "Time Table for "+activeTeacherName+" is saved.");
        }
        else
        {
            popup.alert("Unable To Print", "Please select a Teacher first!");
        }
    }

    @FXML
    private void printVenueButtonAction(ActionEvent event) {
        if(activeVenueName != null)
        {
            WritableImage image;
            image = venueTimeTable.snapshot(new SnapshotParameters(), null);
            File file = new File("..\\images\\venue\\"+activeVenueName+".jpg");
            try 
            {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
            catch (IOException e) 
            {
                popup.alert("Unable To Print", "Something Went Wrong!");
            }
            popup.confirm("Saved", "Time Table for "+activeVenueName+" is saved.");
        }
        else
        {
            popup.alert("Unable To Print", "Please select a Venue first!");
        }
    }

    @FXML
    private void sendAllButtonAction(ActionEvent event) {
        try {
            TeacherList teacher = new TeacherList();
            String [] emailAddArray = new String[teacher.count()];
            for(int i=0; i<emailAddArray.length; i++)
            {
                teacher.getData();
                emailAddArray[i]= teacher.getEmail();
            }
            sendMail(emailAddArray);
            popup.confirm("Successful", "Mail Send Successfully");
        } catch (Exception ex) {
            popup.alert("Fail", "Something Went Wrong!!!");
        }
    }

    @FXML
    private void sendTeacherButtonAction(ActionEvent event) {
        try {
            TeacherList teacher = new TeacherList();
            String [] emailAddArray = new String [1];
            teacher.search(teacherNameComboBox.getSelectionModel().getSelectedItem().replaceAll(" ", "_"));
            emailAddArray[0] = teacher.getEmail();
            popup.warning("at Button", teacher.getTeacherNickName()+" "+teacher.getEmail());
            System.err.println("at Button"+teacher.getTeacherNickName()+" "+teacher.getEmail());
            
            /*need to delete*/
//            emailAddArray[0] = "sahu.deepanshu42637@gmail.com";
            
            sendMail(emailAddArray);
            
            popup.confirm("Successful", "Mail Send Successfully");
        } catch (Exception ex) {
            popup.alert("Fail", "Something Went Wrong!!!");
            try {
                sendMail(new String[]{"sahu.deepanshu42637@gmail.com"});
            } catch (Exception ex1) {
                popup.alert("Fail to send ownwer", "Something Went Wrong!!!");
            }
            
        }
        
    }
    
    public  void sendMail(String [] recepient) throws Exception
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        
        Session session  = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(myAccountEmail,password);
                
            }
        });
        for (String recepient1 : recepient) {
            Message message = prepareMessage(session, recepient1);
            Transport.send(message);
        }
        
    }
    
    
    public  Message  prepareMessage(Session session,String recepient)
    {
        TeacherList teacher = new TeacherList();
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Your's new TimeTable");
            Multipart emailContent  = new MimeMultipart();
            
            MimeBodyPart text = new MimeBodyPart();
            text.setText("Download the timetable send by CSIT dept.");
            
            MimeBodyPart image = new MimeBodyPart();
            //teacher.searchMail(recepient);
            teacher.set("Deepanshu sahu","","sahu.deepanshu42637@gmail.com");
            popup.warning("prepare", teacher.getTeacherFullName());
            popup.warning("preparing email","");
            System.err.println("prepare"+ teacher.getTeacherFullName());
            System.err.println("preparing  email");
            image.attachFile("..\\images\\teacher\\"+teacher.getTeacherFullName()+".jpg");
            
            emailContent.addBodyPart(text);
            emailContent.addBodyPart(image);
            message.setContent(emailContent);
            return message;
       } 
        catch (MessagingException ex) {
            popup.alert("Fail", "Something Went Wrong!!!");
            
        } catch (IOException ex) {
            popup.alert("Fail", "image file not found!!!");
        }
        return null;
    }
    
}
 
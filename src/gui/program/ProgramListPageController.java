/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.program;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import database.base.ProgramList;
import gui.PopupNotification;
import gui.tools.autocompletecombobox.AutoCompleteBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class ProgramListPageController implements Initializable {

      
    PopupNotification popup;
    @FXML
    private BorderPane root;
    @FXML
    private VBox programNameView;
    @FXML
    private VBox semesterView;
    @FXML
    private VBox slotLengthView;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ComboBox<String> semesterComboBox;
    @FXML
    private TextField programNameTextField;
    @FXML
    private ComboBox<String> slotLengthComboBox;
    @FXML
    private VBox programNameDelete;
    @FXML
    private VBox semesterDelete;
    @FXML
    private VBox crossButtonVBox;
    @FXML
    private VBox slotLengthDelete;
    @FXML
    private Button resetButton;
    
    
    
    @FXML
    private void submitButtonEvent(ActionEvent e)
    {
        if(uploadData())
        {
            loadProgramList();
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
                    new ProgramList().deleteAll();
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        programNameView.getChildren().clear();
        semesterView.getChildren().clear();
        slotLengthView.getChildren().clear();
        programNameDelete.getChildren().clear();
        semesterDelete.getChildren().clear();
        slotLengthDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadProgramList();
       popup = new PopupNotification();
       
       slotLengthComboBox.setItems(FXCollections.observableArrayList("9","12"));
       semesterComboBox.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8"));
       
       new AutoCompleteBox(semesterComboBox);
       new AutoCompleteBox(slotLengthComboBox  );
    } 
    
    
    private void loadProgramList()
    {  
        ProgramList programList = new ProgramList();
	FontAwesomeIconView icon;
        int  noOfRecord = programList.count();
        Label [] forProgramNameView = new Label[noOfRecord];       
        Label [] forSemesterView = new Label[noOfRecord];       
        Label [] forSlotLengthView = new Label[noOfRecord];       
        
        Label [] forProgramNameDelete = new Label[noOfRecord];       
        Label [] forSemesterDelete = new Label[noOfRecord];       
        Label [] forSlotLengthDelete = new Label[noOfRecord];       
        
        Separator [] separator1View = new Separator[noOfRecord];
        Separator [] separator2View = new Separator[noOfRecord];
        Separator [] separator3View = new Separator[noOfRecord];
        Separator [] separator1Delete = new Separator[noOfRecord];
        Separator [] separator2Delete = new Separator[noOfRecord];
        Separator [] separator3Delete = new Separator[noOfRecord];
        
        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        programNameView.getChildren().clear();
        semesterView.getChildren().clear();
        slotLengthView.getChildren().clear();
        programNameDelete.getChildren().clear();
        semesterDelete.getChildren().clear();
        slotLengthDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            programList.display();
                 
            forProgramNameView[i] = new Label((programList.getProgramName()).replaceAll("_"," "));
            forSemesterView[i] = new Label(""+ programList.getSemester());
            forSlotLengthView[i] = new Label(""+programList.getSlotLength());
            forProgramNameDelete[i] = new Label((programList.getProgramName()).replaceAll("_"," "));
            forSemesterDelete[i] = new Label(""+programList.getSemester());
            forSlotLengthDelete[i] = new Label(""+programList.getSlotLength());
                    
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
            separator1Delete[i] = new Separator();
            separator1Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator2Delete[i] = new Separator();
            separator2Delete[i].setMaxWidth(Double.MAX_VALUE);
            separator3Delete[i] = new Separator();
            separator3Delete[i].setMaxWidth(Double.MAX_VALUE);
            separatorCrossButton[i] = new Separator();
            separatorCrossButton[i].setMaxWidth(Double.MAX_VALUE);
                   
            separator1View[i].getStyleClass().add("divider");
            separator2View[i].getStyleClass().add("divider");
            separator3View[i].getStyleClass().add("divider");
            separator1Delete[i].getStyleClass().add("divider");
            separator2Delete[i].getStyleClass().add("divider");
            separator3Delete[i].getStyleClass().add("divider");
            separatorCrossButton[i].getStyleClass().add("divider");
                   
            forProgramNameView[i].getStyleClass().add("colData");
            forSemesterView[i].getStyleClass().add("colData");
            forSlotLengthView[i].getStyleClass().add("colData");
            forProgramNameDelete[i].getStyleClass().add("colData");
            forSemesterDelete[i].getStyleClass().add("colData");
            forSlotLengthDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
           
            forProgramNameView[i].setMaxWidth(Double.MAX_VALUE);
            forSemesterView[i].setMaxWidth(Double.MAX_VALUE);
            forSlotLengthView[i].setMaxWidth(Double.MAX_VALUE);
            forProgramNameDelete[i].setMaxWidth(Double.MAX_VALUE);
            forSemesterDelete[i].setMaxWidth(Double.MAX_VALUE);
            forSlotLengthDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String programName = (forProgramNameDelete[i].getText()).replaceAll(" ","_");
            final String semester = forSemesterDelete[i].getText();
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                new ProgramList().delete(programName, semester);
                loadProgramList();
            });
        }
        for(int i=0;i<noOfRecord;i++)
        {
            programNameView.getChildren().add(forProgramNameView[i]);
            programNameView.getChildren().add(separator1View[i]);
            semesterView.getChildren().add(forSemesterView[i]);
            semesterView.getChildren().add(separator2View[i]);
            slotLengthView.getChildren().add(forSlotLengthView[i]);
            slotLengthView.getChildren().add(separator3View[i]);
                    
            programNameDelete.getChildren().add(forProgramNameDelete[i]);
            programNameDelete.getChildren().add(separator1Delete[i]);
            semesterDelete.getChildren().add(forSemesterDelete[i]);
            semesterDelete.getChildren().add(separator2Delete[i]);
            slotLengthDelete.getChildren().add(forSlotLengthDelete[i]);
            slotLengthDelete.getChildren().add(separator3Delete[i]);
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }
    private boolean uploadData()
    {
        boolean success = false;
        String programNameData = programNameTextField.getText();
        String semesterData = semesterComboBox.getSelectionModel().getSelectedItem();
        String slotLengthData = slotLengthComboBox.getSelectionModel().getSelectedItem();
        
        if(programNameData != null)
            programNameData = programNameData.replaceAll(" ", "_");
        semesterData = semesterData != null ? semesterData : "0";
        slotLengthData = slotLengthData != null ? slotLengthData : "0";
        
        final String programName = programNameData;
        final int semester = Integer.parseInt(semesterData);
        final int slotLength = Integer.parseInt(slotLengthData);
         
        Thread uploadDataThread = new Thread(){
           @Override
           public void run()
           {
                ProgramList programList = new ProgramList();
                programList.setData(programName, semester, 0 ,slotLength );
            }
        };
        /*if-else mechanism for checking the atleast two programs and one coursecode is selected before uploading the data to database.*/
        if( programName != null && semester > 0 && slotLength > 0)
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
        programNameTextField.clear();
        
        semesterComboBox.getSelectionModel().clearSelection();
        semesterComboBox.setValue(null);       
    }

}

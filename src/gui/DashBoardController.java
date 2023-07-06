/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class DashBoardController implements Initializable {

    
    @FXML
    private StackPane mainWindow;
    @FXML
    private JFXButton courseButton;
    @FXML
    private JFXButton subjectButton;
    @FXML
    private JFXButton teacherButton;
    @FXML
    private JFXButton venueButton;
    @FXML
    private JFXButton subjectAllotmentButton;
    @FXML
    private JFXButton teacherAllotmentButton;
    @FXML
    private JFXButton combineClassButton;
    @FXML
    private JFXButton timetableButton;
    @FXML
    private JFXButton teacherLoadButton;
    @FXML
    private JFXButton printButton;
    private JFXButton preSidebarButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("LoginPage.fxml")));
//        } catch (IOException ex) {
//            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    preSidebarButton = null;
    }    

    @FXML
    private void courseButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("program/ProgramListPage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        courseButton.getStyleClass().add("sidebarsBtn");
        courseButton.getStyleClass().add("activeBtn");
        preSidebarButton = courseButton;
    }

    @FXML
    private void subjectButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("course/CourseListPage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        subjectButton.getStyleClass().add("sidebarsBtn");
        subjectButton.getStyleClass().add("activeBtn");
        preSidebarButton = subjectButton;
    }

    @FXML
    private void teacherButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("teacher/TeacherListPage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        teacherButton.getStyleClass().add("sidebarsBtn");
        teacherButton.getStyleClass().add("activeBtn");
        preSidebarButton = teacherButton;
    }

    @FXML
    private void venueButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("venue/VenueListPage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        venueButton.getStyleClass().add("sidebarsBtn");
        venueButton.getStyleClass().add("activeBtn");
        preSidebarButton = venueButton;
    }

    @FXML
    private void subjectAllotmentButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("particularcourselist/ParticularProgramCourseListPage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        subjectAllotmentButton.getStyleClass().add("sidebarsBtn");
        subjectAllotmentButton.getStyleClass().add("activeBtn");
        preSidebarButton = subjectAllotmentButton;
    }

    @FXML
    private void teacherAllotmentButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("particularTeacherAllotment/ParticularProgramSchedulePage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        teacherAllotmentButton.getStyleClass().add("sidebarsBtn");
        teacherAllotmentButton.getStyleClass().add("activeBtn");
        preSidebarButton = teacherAllotmentButton;
    }

    @FXML
    private void combineClassButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            mainWindow.getChildren().add(FXMLLoader.load(getClass().getResource("combineclasses/CombineClassPage.fxml")));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        combineClassButton.getStyleClass().add("sidebarsBtn");
        combineClassButton.getStyleClass().add("activeBtn");
        preSidebarButton = combineClassButton;
    }

    @FXML
    private void tiimeTableButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            MasterController.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("timetable/TimeTable.fxml"))));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        timetableButton.getStyleClass().add("sidebarsBtn");
        timetableButton.getStyleClass().add("activeBtn");
        preSidebarButton = timetableButton;
    }

    @FXML
    private void teacherLoadButtonActionEvent(ActionEvent event) {
    }

    @FXML
    private void printButtonActionEvent(ActionEvent event) {
        if(preSidebarButton!=null)
        {
            preSidebarButton.getStyleClass().remove("activeBtn");
            //preSidebarButton.getStyleClass().add("sidebarsBtn");
        }
        mainWindow.getChildren().clear();
        try {
            MasterController.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("print/ProgramTimeTable.fxml"))));
                    } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        printButton.getStyleClass().add("sidebarsBtn");
        printButton.getStyleClass().add("activeBtn");
        preSidebarButton = printButton;
    }
    
}
/**
 *1) It is assume that sidebar button may have 1 or 2 style classes and the second one will be the .activeBtn
 */
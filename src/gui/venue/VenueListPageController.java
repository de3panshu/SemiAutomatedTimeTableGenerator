/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venue;

import database.base.VenueList;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class VenueListPageController implements Initializable {
    PopupNotification popup;
    
    @FXML
    TextField venueNameTextField;
    @FXML
    private VBox venueNameView;
    @FXML
    private VBox venueNameDelete;
    @FXML
    private VBox crossButtonVBox;
    
    
    
   @FXML
    private void submitButtonEvent(ActionEvent e)
    {
        if(uploadData())
        {
            loadVenueList();
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
                    new VenueList().deleteAll();
                }
                };
        resetButtonThread.start();
        // now clearing all the data stored in VBoxes.
        venueNameView.getChildren().clear();
        venueNameDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
        popup.confirm("Data Erased", "Successful");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadVenueList();
       popup = new PopupNotification();
    } 
    
    
    private void loadVenueList()
    {  
        VenueList venueList = new VenueList();
	FontAwesomeIconView icon;
        int  noOfRecord = venueList.count();
        Label [] forVenueNameView = new Label[noOfRecord];       
        
        Label [] forVenueNameDelete = new Label[noOfRecord];       
        
        Separator [] separator1View = new Separator[noOfRecord];
        Separator [] separator1Delete = new Separator[noOfRecord];
        
        Button [] forCrossButtonVBox = new Button[noOfRecord];
        Separator [] separatorCrossButton = new Separator[noOfRecord];

        /*Existing data are now deleted completely before adding the new data...*/
        venueNameView.getChildren().clear();
        venueNameDelete.getChildren().clear();
        crossButtonVBox.getChildren().clear();
               
        /*data are now get added after retrieving from databse to the Vboxes*/
        for(int i=0;i<noOfRecord;i++)
        {
            venueList.display();
                 
            forVenueNameView[i] = new Label((venueList.getVenueName()).replaceAll("_"," "));
            forVenueNameDelete[i] = new Label((venueList.getVenueName()).replaceAll("_"," "));
                    
            forCrossButtonVBox[i] =  new Button();
            
            icon = new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
            icon.setGlyphSize(22);
            icon.setStroke(Paint.valueOf("RED"));
            forCrossButtonVBox[i].setGraphic(icon);
            //forCrossButtonVBox[i]
            
            separator1View[i] = new Separator();
            separator1View[i].setMaxWidth(Double.MAX_VALUE);
            separator1Delete[i] = new Separator();
            separator1Delete[i].setMaxWidth(Double.MAX_VALUE);
            separatorCrossButton[i] = new Separator();
            separatorCrossButton[i].setMaxWidth(Double.MAX_VALUE);
                   
            separator1View[i].getStyleClass().add("divider");
            separator1Delete[i].getStyleClass().add("divider");
            separatorCrossButton[i].getStyleClass().add("divider");
                   
            forVenueNameView[i].getStyleClass().add("colData");
            forVenueNameDelete[i].getStyleClass().add("colData");
            forCrossButtonVBox[i].getStyleClass().add("crossButton");
           
            forVenueNameView[i].setMaxWidth(Double.MAX_VALUE);
            forVenueNameDelete[i].setMaxWidth(Double.MAX_VALUE);
            forCrossButtonVBox[i].setMaxWidth(Double.MAX_VALUE);
                   
            final String venueName = (forVenueNameDelete[i].getText()).replaceAll(" ","_");
            /*close button event...*/
            forCrossButtonVBox[i].setOnAction((ActionEvent event) -> 
            {
                new VenueList().delete(venueName);
                loadVenueList();
            });
        }
        for(int i=0;i<noOfRecord;i++)
        {
            venueNameView.getChildren().add(forVenueNameView[i]);
            venueNameView.getChildren().add(separator1View[i]);
                    
            venueNameDelete.getChildren().add(forVenueNameDelete[i]);
            venueNameDelete.getChildren().add(separator1Delete[i]);
            crossButtonVBox.getChildren().add(forCrossButtonVBox[i]);
            crossButtonVBox.getChildren().add(separatorCrossButton[i]);
        }
    }
    private boolean uploadData()
    {
        boolean success = false;
        String venueNameData = venueNameTextField.getText();
        if(venueNameData != null) venueNameData = (venueNameData).replaceAll(" ","_");
        final String venueName = venueNameData;
        Thread uploadDataThread = new Thread(){
           @Override
           public void run()
           {
                VenueList venueList = new VenueList();
                venueList.setData(venueName );
            }
        };
        /*if-else mechanism for checking the atleast two courses and one coursecode is selected before uploading the data to database.*/
        if( venueName != null )
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
        venueNameTextField.clear();
    }
 
}

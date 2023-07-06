/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author HD
 */
public class PopupNotification {
    
    public void confirm(String title,String text)
    {
        Notifications notification  = Notifications.create()
                                        .title(title)
                                        .graphic(new ImageView(new Image(getClass().getResourceAsStream("/gui/resources/tick.png"))))
                                        .text(text)
                                        .hideAfter(Duration.seconds(8))
                                        .position(Pos.BOTTOM_RIGHT).owner(MasterController.primaryStage);
   
        notification.showInformation();
    }
    public void alert(String title,String text)
    {
        Notifications notification  = Notifications.create()
                                        .title(title)
                                        .graphic(null)
                                        .text(text)
                                        .hideAfter(Duration.seconds(3))
                                        .position(Pos.BOTTOM_RIGHT).owner(MasterController.primaryStage);
   

        notification.showError();
    }
    public void warning(String title,String text)
    {
        Notifications notification  = Notifications.create()
                                        .title(title)
                                        .graphic(null)
                                        .text(text)
                                        .hideAfter(Duration.seconds(6))
                                        .position(Pos.BOTTOM_RIGHT).owner(MasterController.primaryStage);
   
        notification.showWarning();
        
        
    }
}

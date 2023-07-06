/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particularvenue;

import database.base.MySQL;
import database.base.ParticularVenue;
import database.base.VenueList;


/**
 *
 * @author Deepanshu Sahu
 */
public class TestParticularVenue {
     public static void main(String  [] args)
    {
        /*ParticularVenue pv;
        VenueList vl = new VenueList();
        int [] venueAllotmentArray = new int[500];
        for(int j=0;j<500;j++)
            venueAllotmentArray[j] = 0;
        //connecting to all venue one by one and making its table
        int i=vl.count();
        while(i>0)
        {
            vl.getData();
            pv = new ParticularVenue(vl.getVenueName());
            if(!pv.isExist())
            {
                if(pv.createTable())
                {
                    System.out.println(i+". table created successfully...");
                }
            }
            else
            {
                pv.setData(venueAllotmentArray);
            }
            
            i--;
        }*/
        /*code for drop all created table by the above code. Use it before commenting the upper code...*/
        ParticularVenue pv;
        VenueList vl = new VenueList();
        MySQL mysql = new MySQL();
        int i=vl.count();
        if(mysql.startConnection("timetable", "root", ""))
        while(i>0)
        {
            vl.display();
            pv = new ParticularVenue(vl.getVenueName());
            if(pv.isExist())
            {
                if(mysql.deleteAll(vl.getVenueName()))
                {
                    System.out.println(i+". table data deleted successfully...");
                }
            }
            i--;
        }
    }
}

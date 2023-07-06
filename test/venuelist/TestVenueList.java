/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venuelist;

import database.base.MySQL;
import database.base.VenueList;


/**
 *
 * @author Deepanshu Sahu
 */
public class TestVenueList {
    public static void main(String [] args)
    {
                        MySQL.makeConnection("timetable", "root", "");

        	VenueList v = new VenueList();
		if(!v.isExist())
			v.createTable();
		int i;
		for( i=1;i<19;i++)
			v.setData("ET_"+i);
		v.setData("Hall_1");
		v.setData("Hall_2");
		v.setData("Lab_1");
		v.setData("Lab_2");
		v.setData("Lab_3");
		v.setData("Lab_4");
		v.setData("Lab_5");
		v.setData("Lab_6");
	
                
    }
}

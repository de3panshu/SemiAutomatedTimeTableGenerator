/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programlist;

import database.base.MySQL;
import database.base.ProgramList;



/**
 *
 * @author Deepanshu Sahu
 */
public class TestProgramList {
    public static void main(String [] args)
    {
                        MySQL.makeConnection("timetableautomation", "root", "");

    	ProgramList p = new ProgramList();
	if(!p.isExist())
                if(p.createTable())
                {
			p.setData("BCA",1,0,9);
			p.setData("BCA",3,0,9);
			p.setData("BCA",5,0,9);
			p.setData("MCA",1,0,9);
			p.setData("MCA",3,0,9);
			p.setData("MCA",5,0,9);
			p.setData("M_Tech_CS",1,0,9);
			p.setData("M_Tech_CS",3,0,12);
			p.setData("M_Sc_CS",1,0,9);
			p.setData("M_Sc_CS",3,0,9);
			p.setData("B_Sc_CS",1,0,9);
			p.setData("B_Sc_CS",3,0,9);
			p.setData("B_Sc_CS",5,0,9);
			p.setData("B_Tech_CS",1,0,9);
			p.setData("B_Tech_CS",3,0,12);
			p.setData("B_Tech_CS",5,0,9);
			p.setData("B_Tech_CS",7,0,12);
			p.setData("B_Sc_PMCS",1,0,9);
			p.setData("B_Sc_PMCS",3,0,9);
			p.setData("B_Sc_PMCS",5,0,9);
         }	
       p.setData("BCA",1,0,9);
			p.setData("BCA",3,0,9);
			p.setData("BCA",5,0,9);
			p.setData("MCA",1,0,9);
			p.setData("MCA",3,0,9);
			p.setData("MCA",5,0,9);
			p.setData("M_Tech_CS",1,0,9);
			p.setData("M_Tech_CS",3,0,12);
			p.setData("M_Sc_CS",1,0,9);
			p.setData("M_Sc_CS",3,0,9);
			p.setData("B_Sc_CS",1,0,9);
			p.setData("B_Sc_CS",3,0,9);
			p.setData("B_Sc_CS",5,0,9);
			p.setData("B_Tech_CS",1,0,9);
			p.setData("B_Tech_CS",3,0,12);
	        p.setData("B_Tech_CS",5,0,9);
			p.setData("B_Tech_CS",7,0,12);
			p.setData("B_Sc_PMCS",1,0,9);
			p.setData("B_Sc_PMCS",3,0,9);
			p.setData("B_Sc_PMCS",5,0,9);
	
    System.out.println("No of records in programList: "+p.count());
    }
    
}

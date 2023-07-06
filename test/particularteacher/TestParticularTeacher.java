/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particularteacher;

import database.base.MySQL;
import database.base.ParticularTeacher;
import database.base.TeacherList;


/**
 *
 * @author Deepanshu Sahu
 */
public class TestParticularTeacher {
    public static void main(String  [] args)
    {
        /*ParticularTeacher pt;
        TeacherList tl = new TeacherList();
        int [] teacherAllotmentArray = new int[500];
        for(int j=0;j<500;j++)
            teacherAllotmentArray[j] = 0;
        //connecting to all teacher one by one and making its table
        int i=tl.count();
        while(i>0)
        {
            tl.getData();
            pt = new ParticularTeacher(tl.getTeacherFullName());
            if(!pt.isExist())
            {
                if(pt.createTable())
                {
                    System.out.println(i+". table created successfully...");
                }
            }
            else
            {
                pt.setData(teacherAllotmentArray);
            }
            
            i--;
        }*/
        /*code for drop all created table by the above code. Use it before commenting the upper code...*/
        ParticularTeacher pt;
        TeacherList tl = new TeacherList();
        MySQL mysql = new MySQL();
        //connecting to all teacher one by one and making its table
        int i=tl.count();
        if(mysql.startConnection("timetable", "root", ""))
        while(i>0)
        {
            tl.getData();
            pt = new ParticularTeacher(tl.getTeacherFullName());
            if(pt.isExist())
            {
                if(mysql.deleteAll(tl.getTeacherFullName()))
                {
                    System.out.println(i+". table data deleted successfully...");
                    
                }
            }
        
            
            i--;
        }
    }
}

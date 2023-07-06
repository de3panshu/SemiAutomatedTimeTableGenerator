/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.superclass;

import database.base.MySQL;
import database.base.MySQLRead;
import database.base.TeacherList;
import database.base.VenueList;

/**
 *
 * @author Deepanshu Sahu
 */
public class ParticularVenueTimeTable implements MySQLRead
{   
	private int sno;  //it must start from 0 and max value is 44;
	private String courseCode;
	private String classType;
	private String teacher1;
        private String teacher3;
        private String teacher2;
	private String program1;
        private String program2;
        private String program3;
	private String tableName;//it is served as the name for particular teacherFullName+"_tt".
	private  MySQL mysql;

	
	public void setTableName(String tableName)
	{
		this.tableName=tableName;
	}
	public boolean createTable(String tableName)
	{
		return mysql.createTable(tableName+"(sno int(2),courseCode char(10),classType char(10),teacher1 char(20),teacher2 char(20),teacher3 char(20),program1 char(20),program2 char(20),program3 char(20));");
	}
	public boolean createTable()
	{
		return mysql.createTable(getTableName()+"(sno int(2),courseCode char(10),classType char(10),teacher1 char(10),teacher2 char(10),teacher3 char(10),program1 char(20),program2 char(20),program3 char(20));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		this.sno=Integer.parseInt(valueList[0]);
		this.courseCode=valueList[1];
		this.classType=valueList[2];
		this.teacher1=valueList[3];
		this.teacher2=valueList[4];
		this.teacher3=valueList[5];
		this.program1=valueList[6];
                this.program2=valueList[7];
                this.program3=valueList[8];
	}

/*
	public ParticularProgram()
	{
		
	}
*/
   public ParticularVenueTimeTable(String tableName)
	{
	   this.tableName=tableName;
	   this.sno=0;
	   this.courseCode=null;
	   this.classType=null;
	   this.teacher1=null;
	   this.teacher2=null;
	   this.teacher3=null;
	   this.program1=null;
           this.program2=null;
           this.program3=null;
	   	if(!tableName.equals("_tt"))
           {
           mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                else
                {
                    if(!isExist())
                    createTable(tableName);
                }
	}}
	
	public void setData(int sno,String courseCode,String classType,String teacher1,String teacher2,String teacher3,String program1,String program2,String program3)
	{
	   this.sno=sno;
	   this.courseCode=courseCode;
	   this.classType=classType;
	   this.teacher1=teacher1;
	   this.teacher2=teacher2;
	   this.teacher3=teacher3;
	   this.program1=program1;
           this.program2=program2;
           this.program3=program3;

            if(!tableName.equals("_tt"))
           {
           	int res=mysql.insertData(tableName,sno+",'"+courseCode+"','"+classType+"','"+teacher1+"','"+teacher2+"','"+teacher3+"','"+program1+"','"+program2+"','"+program3+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
           }                    
	}
	public boolean  getData()
	{
		boolean res = false;
    if(!tableName.equals("_tt"))
           {
                           res=mysql.readData(this,tableName,"int","sno","String","courseCode","String","classType","String","teacher1","String","teacher2","String","teacher3","String","program1","String","program2","String","program3");  
           }	return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		{	
		 System.out.println(this.tableName+":");
		 System.out.println("Sno: "+this.sno);
		 System.out.println("course code: "+this.courseCode);
		 System.out.println("class type: "+this.classType);
		 System.out.println("teacher: "+this.teacher1+" "+this.teacher2+" "+this.teacher3);
		 System.out.println("Teacher: "+new TeacherList().getTeacherFullName(this.program1));
                 System.out.println("Teacher: "+new TeacherList().getTeacherFullName(this.program2));
                 System.out.println("Teacher: "+new TeacherList().getTeacherFullName(this.program3));
		} 
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getTableName()
	{
		return this.tableName;
	}
	public int getSno()
	{
		return sno;
	}
	public String getCourseCode()
	{
		return this.courseCode;
	}
	public String getClassType()
	{
		return this.classType;
	}
	public String getTeacher1()
	{
		return this.teacher1;
	}
	public String getTeacher2()
	{
		return this.teacher2;
	}
	public String getTeacher3()
	{
		return this.teacher3;
	}
 	public String getProgram1()
 	{
 		return this.program1;
 	}
        public String getProgram3()
 	{
 		return this.program3;
 	}
        public String getProgram2()
 	{
 		return this.program2;
 	}
 	public boolean isExist()
 	{
 		return mysql.tableExist(this.tableName);
 	}
 	public  boolean isExist(String tableName)
 	{
            this.createTable();
 		return mysql.tableExist(tableName);
 	}
 	public int count()
	{
		
		return mysql.count(this.tableName);		

	}
        public boolean delete(int sno)
        {
            boolean res = true;
            if(!tableName.equals("_tt"))
           {
              res = mysql.delete(this.tableName, " sno = "+sno);
           }
            return res;
        }
        public boolean deleteAll()
        {
            MySQL newMysql = new MySQL();
                VenueList venueList = new VenueList();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
                    success  = true; 
                    while(venueList.getData() && success)
                        if(isExist(venueList.getVenueName()+"_tt"))
                            success = newMysql.deleteAll(venueList.getVenueName()+"_tt");
                        else
                            success = true;
		}
		return success;
           
        }
        public boolean isFree(int index)
        {
            boolean res = true;
            if(!tableName.equals("_tt"))
            {
                if(mysql.search(this,this.tableName, " sno = "+index,"int","sno","String","courseCode","String","classType","String","teacher1","String","teacher2","String","teacher3","String","program1","String","program2","String","program3"))
                    res = false;
            }
            return res;
        }

}

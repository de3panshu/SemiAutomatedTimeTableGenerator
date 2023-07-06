/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.intermediate;

import database.base.MySQL;
import database.base.MySQLRead;
import database.base.ProgramList;


/**
 *
 * @author Deepanshu Sahu
 */
public final class ParticularProgramSchedule implements MySQLRead
{
	private String tableName;
	private String courseCode;
	private String lectureTeacher1;
	private String lectureTeacher2;
	private String tutorialTeacher;
	private String practicalTeacher1;
	private String practicalTeacher2;
	private String practicalTeacher3;
	private int type;


	private static MySQL mysql;

	public boolean createTable(String tableName)
	{
		return mysql.createTable(tableName+"(courseCode char(15),lectureTeacher1 char(30),lectureTeacher2 char(30),tutorialTeacher char(30),practicalTeacher1 char(30),practicalTeacher2 char(30), practicalTeacher3 char(30),type int(1))"); 
	}
	public boolean createTable()
	{
		return mysql.createTable(this.tableName+"(courseCode char(15),lectureTeacher1 char(30),lectureTeacher2 char(30),tutorialTeacher char(30),practicalTeacher1 char(30),practicalTeacher2 char(30), practicalTeacher3 char(30),type int(1))");
	}
        @Override
	public void setValue(String [] valueList)
	{
		courseCode = valueList[0];
		lectureTeacher1 = valueList[1];
		lectureTeacher2 = valueList[2];
		tutorialTeacher = valueList[3];
		practicalTeacher1 = valueList[4];
		practicalTeacher2 = valueList[5];
		practicalTeacher3 = valueList[6];
		type = Integer.parseInt(valueList[7]);
	}


	public ParticularProgramSchedule(String tableName)
	{
		courseCode = null;
		lectureTeacher1 = null;
		lectureTeacher2 = null;
		tutorialTeacher = null;
		practicalTeacher1 = null;
		practicalTeacher2 = null;
		practicalTeacher3 = null;
		type = 0;

		this.tableName = tableName;
		
		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                if(!isExist())
                    createTable();
	}

/*   public Venue(  String tableName)
	{
	   
	   
	}
*/	
	public void setData(String courseCode,String lectureTeacher1,String lectureTeacher2,String tutorialTeacher,String practicalTeacher1,String practicalTeacher2, String practicalTeacher3,int type)
	{
	   this.courseCode = courseCode;
		int res=mysql.insertData(tableName,"'"+courseCode+"','"+lectureTeacher1+"','"+lectureTeacher2+"','"+tutorialTeacher+"','"+practicalTeacher1+"','"+practicalTeacher2+"','"+practicalTeacher3+"',"+type);
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,tableName,"String","courseCode","String","lectureTeacher1","String","lectureTeacher2","String","tutorialTeacher","String","practicalTeacher1","String","practicalTeacher2","String","practicalTeacher3","int","type");  
		return res;
	}
        public boolean  search(String courseCode)
	{
		boolean res=mysql.search(this,tableName, "courseCode ='"+courseCode+"'" ,"String","courseCode","String","lectureTeacher1","String","lectureTeacher2","String","tutorialTeacher","String","practicalTeacher1","String","practicalTeacher2","String","practicalTeacher3","int","type");  
                if(res)
                    System.out.println("course Code:"+courseCode+" exist in pps.search()");
                else
                    System.out.println("course Code:"+courseCode+" not exist in pps.search()");
		return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		{	
		 System.out.println("course Code: "+this.courseCode+"\n");
		 System.out.println("lecture Teachers: "+lectureTeacher1+"   "+lectureTeacher2);
		 System.out.println("tutorialTeacher: "+tutorialTeacher);

		 System.out.println("practicalTeacher: "+practicalTeacher1+"  "+practicalTeacher2+"  "+practicalTeacher3);
		} 
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getCourseCode()
	{
		return courseCode;
	}
	public String getLectureTeacher1()
	{
		return lectureTeacher1;
	}
	public String getLectureTeacher2()
	{
		return lectureTeacher2;
	}
	public  String getTutorialTeacher()
	{
		return tutorialTeacher;
	}

	public String getPracticalTeacher1()
	{
		return  practicalTeacher1;
	}
	public String getPracticalTeacher2()
	{
		return practicalTeacher2;
	}
	public String getPracticalTeacher3()
	{
		return practicalTeacher3;
	}
	public int getType()
	{
		return type;
	}
	public boolean isExist()
 	{
            this.createTable(tableName);
 		return mysql.tableExist(tableName);
 	}
	public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count(tableName);
            else
                return 0;
   	}
        public boolean delete(String courseCode)
	{
		MySQL newMysql = new MySQL();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
			if(newMysql.delete(this.tableName," courseCode ='"+courseCode+"'"))
				success = true;
		}
		return success;
	}
	public boolean deleteAll()
	{
		MySQL newMysql = new MySQL();
                ProgramList programList = new ProgramList();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
                    success  = true;
                    while(programList.getData())
                        success = newMysql.deleteAll(programList.getProgramName()+programList.getSemester()+"_cs");
		}
		return success;
	}
}
 
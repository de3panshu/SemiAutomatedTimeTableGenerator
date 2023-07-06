/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.superclass;

import database.base.MySQL;
import database.base.MySQLRead;
import database.base.TeacherList;



/**
 *
 * @author Deepanshu Sahu
 */
public class ParticularTeacherTimeTable implements MySQLRead
{   
	private int sno;  //it must start from 0 and max value is 44;
	private String courseCode;
	private String classType;
	private String venue;
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
		return mysql.createTable(tableName+"(sno int(2),courseCode char(10),classType char(10),venue char(10),program1 char(20),program2 char(20),program3 char(20));");
	}
	public boolean createTable()
	{
		return mysql.createTable(getTableName()+"(sno int(2),courseCode char(10),classType char(10),venue char(10),program1 char(20),program2 char(20),program3 char(20));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		this.sno=Integer.parseInt(valueList[0]);
		this.courseCode=valueList[1];
		this.classType=valueList[2];
		this.venue=valueList[3];
		this.program1=valueList[4];
                this.program2=valueList[5];
                this.program3=valueList[6];
	}

/*
	public ParticularProgram()
	{
		
	}
*/
   public ParticularTeacherTimeTable(String tableName)
	{
	       this.tableName=tableName;
	   this.sno=0;
	   this.courseCode="";
	   this.classType="";
	   this.venue="";
	   this.program1="";
           this.program2="";
           this.program3="";
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
           }
	}
	
	public void setData(int sno,String courseCode,String classType,String venue,String program1,String program2,String program3)
	{
	   if(!this.tableName.equals("_tt"))
           {
               this.sno=sno;
	   this.courseCode=courseCode;
	   this.classType=classType;
	   this.venue=venue;
	   this.program1=program1;
           this.program2=program2;
           this.program3=program3;

		int res=mysql.insertData(tableName,sno+",'"+courseCode+"','"+classType+"','"+venue+"','"+program1+"','"+program2+"','"+program3+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
           }
	}
	public boolean  getData()
	{
		boolean res = false;
                if(!this.tableName.equals("_tt"))
                {
                    res=mysql.readData(this,tableName,"int","sno","String","courseCode","String","classType","String","venue","String","program1","String","program2","String","program3");
                }  
		return res;
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
		 System.out.println("venue: "+this.venue);
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
	public String getVenue()
	{
		return this.venue;
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
            this.createTable();
 		return mysql.tableExist(this.tableName);
 	}
 	public  boolean isExist(String tableName)
 	{
 		return mysql.tableExist(tableName);
 	}
 	public int count()
	{
		int counter = 0;
                if(!this.tableName.equals("_tt"))
                {
                    counter = mysql.count(this.tableName);		
                }
		return counter;

	}
        public boolean delete(int sno)
        {
            boolean res = true;
            if(!this.tableName.equals("_tt"))
            {
                res = mysql.delete(this.tableName, " sno = "+sno);
            }
            return res;
        }
        public boolean deleteAll()
        {
            MySQL newMysql = new MySQL();
                TeacherList teacherList = new TeacherList();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
                    success  = true; 
                    while(teacherList.getData() && success)
                        if(isExist(teacherList.getTeacherFullName()+"_tt"))
                            success = newMysql.deleteAll(teacherList.getTeacherFullName()+"_tt");
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
                if(mysql.search(this,this.tableName, " sno = "+index,"int","sno","String","courseCode","String","classType","String","venue","String","program1","String","program2","String","program3"))
                    res = false;
            }
            return res;
        }
        
}

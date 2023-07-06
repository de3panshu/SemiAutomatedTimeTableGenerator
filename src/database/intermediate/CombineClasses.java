/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.intermediate;

import database.base.MySQL;
import database.base.MySQLRead;

/**
 *
 * @author Deepanshu Sahu
 */
public class CombineClasses implements MySQLRead
{
	private int sno;
	private String programName1;// programName+semester
	private String programName2;// programName+semester
	private String programName3;// programName+semester
	private String courseCode;

	private static MySQL mysql;

	public  boolean createTable()
	{
		return mysql.createTable("CombineClasses(sno int(3),programName1 char(15), programName2 char(15),programName3 char(15),courseCode char(10));");
	}
	public void setValue(String [] valueList)
	{
		this.sno=Integer.parseInt(valueList[0]);
		this.programName1=valueList[1];
		this.programName2=valueList[2];
		this.programName3=valueList[3];
		this.courseCode=valueList[4];	
	}


	public CombineClasses()
	{
		this.sno=0;
		this.programName1="";
		this.programName2="";
		this.programName3="";
		this.courseCode=null;
		
		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                if(!isExist())
                {
                    createTable(); 
                }
	}
	/*public CombineClasses(String programName1,String ProgramName2,String courseCode)
	{
		this.programName1=programName1;
		this.programName1=programName1;
		this.courseCode=courseCode;
	}
	*/
	public void setData(String programName1,String programName2,String programName3,String courseCode)
	{
		this.programName2=programName1;
		this.programName2=programName2;
		this.programName3=programName3;
		this.courseCode=courseCode;

		int res=mysql.insertData("CombineClasses",this.count()+1+",'"+programName1+"','"+programName2+"','"+programName3+"','"+courseCode+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,"CombineClasses","int","sno","String","programName1","String","programName2","String","programName3","String","courseCode");  
		return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		 System.out.println(this.sno+"  "+this.programName1+"+"+this.programName2+"+"+this.programName3 + ", course:"+this.courseCode);
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getProgramName1()
	{
		return this.programName1;
	}
	public String getProgramName2()
	{
		return this.programName2;
	}
	public String getProgramName3()
	{
		return this.programName3;
	}
	public int getSno()
	{
		return sno;
	}
	public String  getCourseCode()
	{
		return this.courseCode;
	}
	public boolean getCombination(String courseCode,String programName)
	{
                String condition = "courseCode ='"+courseCode+"' &&(programName1 ='"+programName+"' || programName2 = '"+programName+"' || programName3 = '"+programName+"')";
                System.out.println("Condition is: "+condition);
		boolean found = mysql.search(this,"CombineClasses", condition ,"int","sno","String","programName1","String","programName2","String","programName3","String","courseCode");  
                if(found)
                {
                    System.out.println("course Code:"+courseCode+" exist in combineClasses.search()");
                    rearrange(programName);
                }
                else
                    System.out.println("course Code:"+courseCode+" not exist in combineClasses.search()");
		return found;
	}
	public boolean isExist()   
 	{
            this.createTable();
 		return mysql.tableExist("CombineClasses");
 	}
	public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count("CombineClasses");
            else
                return 0;
   	}
	public boolean delete(String programName1,String programName2,String programName3,String courseCode)
	{
		MySQL newMysql = new MySQL();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
			if(newMysql.delete("CombineClasses","programName1 = '"+programName1+"' && programName2 = '"+programName2+"' && programName3 = '"+programName3+"' && courseCode ='"+courseCode+"'"))
				success = true;
		}
		return success;
	}
	public boolean deleteAll()
	{
		MySQL newMysql = new MySQL();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
			if(newMysql.deleteAll("CombineClasses"))
				success = true;
		}
		return success;
	}
        private void rearrange(String programName)
        {
            if(programName2.equals(programName))
            {
                programName2 = programName1;
                programName1 = programName;
            }
            else if(programName3.equals(programName))
            {
                programName3 = programName1;
                programName1 = programName;
            }
        }
}



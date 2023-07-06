/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.superclass;

import database.base.MySQL;
import database.base.MySQLRead;
import database.base.ProgramList;



/**
 *
 * @author Deepanshu Sahu
 */
public class ParticularProgramTimeTable implements MySQLRead
{   
	private int sno;  //it must start from 0 and max value is 44;
	private String courseCode;
	private String classType;
	private String venue;
	private String teacher1;
        private String teacher2;
        private String teacher3;
	private String tableName;//it is served as the name for particular programName+semester+"tt".
	private  MySQL mysql;

	
	public void setTableName(String tableName)
	{
		this.tableName=tableName;
	}
	public boolean createTable(String tableName)
	{
		return mysql.createTable(tableName+"(sno int(2),courseCode char(10),classType char(10),venue char(10),teacher1 char(20),teacher2 char(20),teacher3 char(20));");
	}
	public boolean createTable()
	{
		return mysql.createTable(getTableName()+"(sno int(2),courseCode char(10),classType char(10),venue char(10),teacher1 char(20),teacher2 char(20),teacher3 char(20));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		this.sno=Integer.parseInt(valueList[0]);
		this.courseCode=valueList[1];
		this.classType=valueList[2];
		this.venue=valueList[3];
		this.teacher1=valueList[4];
                this.teacher2=valueList[5];
                this.teacher3=valueList[6];
	}

/*
	public ParticularProgram()
	{
		
	}
*/
   public ParticularProgramTimeTable(String tableName)
	{
	   this.tableName=tableName;
	   this.sno=0;
	   this.courseCode="";
	   this.classType="";
	   this.venue="";
	   this.teacher1="";
           this.teacher2="";
           this.teacher3="";
	   	if(!tableName.equals("_tt") && !tableName.equals("_tt_st"))
           {
           mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                
                if(!isExist())
                    createTable();
	}}
	
	public void setData(int sno,String courseCode,String classType,String venue,String teacher1,String teacher2,String teacher3)
	{
           this.sno=sno;
	   this.courseCode=courseCode;
	   this.classType=classType;
	   this.venue=venue;
	   this.teacher1=teacher1;
           this.teacher2=teacher2;
           this.teacher3=teacher3;

		if(!tableName.equals("_tt") && !tableName.equals("_tt_st"))
           {
           int res=mysql.insertData(tableName,sno+",'"+courseCode+"','"+classType+"','"+venue+"','"+teacher1+"','"+teacher2+"','"+teacher3+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...in"+tableName);// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}}
        public void putData(String courseCode,String classType,String venue,String teacher1,String teacher2,String teacher3)
	{
	   this.courseCode=courseCode;
	   this.classType=classType;
	   this.venue=venue;
	   this.teacher1=teacher1;
           this.teacher2=teacher2;
           this.teacher3=teacher3;
        }
	public boolean  getData()
	{
		boolean res=false;
                if(!tableName.equals("_tt")&& !tableName.equals("_tt_st"))
           {
           res = mysql.readData(this,tableName,"int","sno","String","courseCode","String","classType","String","venue","String","teacher1","String","teacher2","String","teacher3");  
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
                 System.out.println("teacher : "+teacher1+" "+teacher2+" "+teacher3);
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
 	public String getTeacher1()
 	{
 		return this.teacher1;
 	}
        public String getTeacher3()
 	{
 		return this.teacher3;
 	}
        public String getTeacher2()
 	{
 		return this.teacher2;
 	}
        public String  getString()
        {
            String data=this.getCourseCode()+"  "+this.getVenue()+"\n"+this.getTeacher1()+" "+this.getTeacher2()+" "+this.getTeacher3()+"\n"+this.getClassType();
            return data;
        }
 	public boolean isExist()
 	{
                this.createTable();
 		return mysql.tableExist(this.tableName);
 	}
 	public  boolean isExist(String tableName)
 	{
 		System.out.println("tableName: "+tableName+"pptt");
                return mysql.tableExist(tableName);
 	}
 	public int count()
	{
            int counter = 0;
		if(!tableName.equals("_tt")&& !tableName.equals("_tt_st"))
           {
           counter =  mysql.count(this.tableName);		
           }     return counter;

	}
        public boolean delete(int sno)
        {
            boolean res = true;
            if(!tableName.equals("_tt")&& !tableName.equals("_tt_st"))
           {
           res=  mysql.delete(this.tableName, " sno = "+sno);
           }
            return res;
        }
        public boolean delete(String courseCode)
        {
            boolean res = true;
            if(!tableName.equals("_tt")&& !tableName.equals("_tt_st"))
           {
           res = mysql.delete(this.tableName, " courseCode = '"+courseCode+"'");
           }
            return res;
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
                    {
                        
                        if(isExist(programList.getProgramName()+programList.getSemester()+"_tt"))
                            success = newMysql.deleteAll(programList.getProgramName()+programList.getSemester()+"_tt");
                        else
                            success = true;
                    }
		}
		return success;
           
        }
        public boolean deleteAllSticker()
        {
            MySQL newMysql = new MySQL();
                ProgramList programList = new ProgramList();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
                    success  = true; 
                    while(programList.getData() )
                    {
                        System.out.println(programList.getProgramName()+programList.getSemester()+"_tt_st in deleteAllSticker");
                       // if(isExist(programList.getProgramName()+programList.getSemester()+"_tt_st"))
                            success = newMysql.deleteAll(programList.getProgramName()+programList.getSemester()+"_tt_st");
                        //else
                          //  success = true;
                    }
		}
		return success;
           
        }

    public void deleteFirst(String courseCode, String classType) 
    {
        if(!tableName.equals("_tt")&& !tableName.equals("_tt_st"))
           {
           mysql.delete(this.tableName, " courseCode = '"+courseCode+"'"+" && classType = '"+classType+"' LIMIT 1");
           }
    }
    public boolean isFree(int index)
    {
        boolean res = true;
        if(!tableName.equals("_tt")&& !tableName.equals("_tt_st"))
        {
            if(mysql.search(this,this.tableName, " sno = "+index,"int","sno","String","courseCode","String","classType","String","venue","String","teacher1","String","teacher2","String","teacher3"))
                res = false;
        }
        return res;
    }

}
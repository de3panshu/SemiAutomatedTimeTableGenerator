/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.base;


/**
 *
 * @author Deepanshu Sahu
 */
public final class ParticularProgramCourseList implements MySQLRead
{
	private String tableName;
	private String courseCode;

	private static MySQL mysql;

	public boolean createTable(String tableName)
	{
		return mysql.createTable(tableName+"(courseCode char(15));");
	}
        public boolean createTable()
	{
		return mysql.createTable(tableName+"(courseCode char(15));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		courseCode = valueList[0];
	}


	public ParticularProgramCourseList(String tableName)
	{
		courseCode = null;
		this.tableName = tableName;
		
		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");		
                if(!isExist())
                {
                    createTable();
                }
	}

/*   public Venue(  String tableName)
	{
	   
	   
	}
*/	
	public void setData(String courseCode)
	{
	   this.courseCode = courseCode;
		int res=mysql.insertData(tableName,"'"+courseCode+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,tableName,"String","courseCode");  
		return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		{	
		 System.out.println("course Code: "+this.courseCode+"\n");
		} 
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getCourseCode()
	{
		return courseCode;
	}
	public boolean isExist()
 	{
            this.createTable();
 		
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
                    while(programList.getData() && success)
                        success = newMysql.deleteAll(programList.getProgramName()+programList.getSemester()+"_cl");
		}
		return success;
	}
}

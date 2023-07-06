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


public class CourseList implements MySQLRead
{
	private String courseCode;// this will be a tableNAme of a particular Course
	private String courseTitle;
	private int lecture;
	private int tutorial;
	private int practical;

	private MySQL mysql;

	public  boolean createTable()
	{
		return mysql.createTable("CourseList(courseCode char(15),CourseTitle char(60),lecture int(1),tutorial int(1),practical int(1));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		courseCode = valueList[0];
		courseTitle = valueList[1];
		lecture = Integer.parseInt(valueList[2]); 
		tutorial = Integer.parseInt(valueList[3]); 
		practical = Integer.parseInt(valueList[4]); 
	}
	
	public CourseList()
	{
		courseCode = null;
		courseTitle = null;
		lecture = 0;
		tutorial = 0;
		practical = 0;

		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                if(!this.isExist())
                    this.createTable();
	}
	public CourseList(String courseCode, String courseTitle, int lecture, int tutorial, int practical)
	{
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.lecture = lecture;
		this.tutorial = tutorial;
		this.practical = practical;
		
		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
	
	}
	
	public void setData(String courseCode, String courseTitle, int lecture, int tutorial, int practical)
	{
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.lecture = lecture;
		this.tutorial = tutorial;
		this.practical = practical;

		int res=mysql.insertData("CourseList","'"+courseCode+"','"+courseTitle+"',"+lecture+","+tutorial+","+practical);
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,"CourseList","String","courseCode","String","courseTitle","int","lecture","int","tutorial","int","practical");  
		return res;
	}
	public boolean getData(String courseCode)
	{
            boolean res=mysql.search(this,"CourseList","courseCode = '"+courseCode+"'","String","courseCode","String","courseTitle","int","lecture","int","tutorial","int","practical");  
            return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		 System.out.println(this.courseCode+": "+this.courseTitle+"  ("+this.lecture+"+"+this.tutorial+"+"+this.practical+")");
		else
		 System.out.println("No more data....");	
		return res;
	}
	public boolean display(String courseCode)
	{
		boolean res= getData(courseCode);
		if(res)
		 System.out.println(this.courseCode+": "+this.courseTitle+"  ("+this.lecture+"+"+this.tutorial+"+"+this.practical+")");
		else
		 System.out.println("No more data....");	
		return res;
	}
	public void show()
	{
		System.out.println(this.courseCode+": "+this.courseTitle+"  ("+this.lecture+"+"+this.tutorial+"+"+this.practical+")");
	}
	public String getCourseCode()
	{
		return courseCode;
	}
	public String getCourseTitle()
	{
		return courseTitle;
	}
	public int getLecture()
	{
		return lecture;
	}
	public int getTutorial()
	{
		return tutorial;
	}
	public int getPractical()
	{
		return practical;
	}
	public boolean isExist()
 	{
            this.createTable();
 		
 		return mysql.tableExist("CourseList");
 	}
	public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count("CourseList");
            else
                return 0;
   	}
        public boolean deleteAll()
        {
            return mysql.deleteAll("CourseList");
        }
        public boolean delete(String courseCode)
        {
            return mysql.delete("courseList"," courseCode = '"+ courseCode+"'");
        }

}

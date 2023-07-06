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

public class TeacherList implements MySQLRead
{

	private String teacherFullName;// this will be a tableNAme of a particular teacher
	private String teacherNickName;
        private String mail;

	private MySQL mysql;

        public  void set(String f,String n,String m)
        {
            this.teacherFullName =f;
            this.teacherNickName=n;
            this.mail=m;
        }
	public  boolean createTable()
	{
		return mysql.createTable("TeacherList(teacherFullName char(30),teacherNickName char(20),email char(50));");
	}
        @Override
	public void setValue(String [] valueList)
	{
            this.teacherFullName=valueList[0];
            this.teacherNickName=valueList[1];	
            this.mail = valueList[2];
                    
	}
	
	public TeacherList()
	{
		
		this.teacherFullName="";
		this.teacherNickName="";
                this.mail = "";
			mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                if(!this.isExist())
                    this.createTable();
	}
	public TeacherList(String teacherFullName,String teacherNickName,String mail)
	{
		this.teacherFullName=teacherFullName;
		this.teacherNickName=teacherNickName;
                this.mail = mail;
			mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
	
	}
	
	public void setData(String teacherFullName,String teacherNickName,String mail)
	{
		this.teacherFullName=teacherFullName;
		this.teacherNickName=teacherNickName;
                this.mail = mail;
		int res=mysql.insertData("TeacherList","'"+teacherFullName+"','"+teacherNickName+"','"+mail+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,"TeacherList","String","teacherFullName","String","teacherNickName","String","email");  
		return res;
	}
        public boolean search(String teacherFullName)
        {
            boolean res = mysql.search(this,"TeacherList","teacherFullName = '"+teacherFullName+"'","String","teacherFullName","String","teacherNickName","String","email");   
            return res;
        }
        public boolean display()
	{
		boolean res= getData();
		if(res)
		 System.out.println(this.teacherFullName+"  ("+this.teacherNickName+")");
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getTeacherFullName()
	{
		return this.teacherFullName;
	}
        public String getTeacherFullName(String teacherNickName)
	{
            boolean res = mysql.search(this,"TeacherList","teacherNickName = '"+teacherNickName+"'","String","teacherFullName","String","teacherNickName","String","email");  
            if(res)
		return this.teacherFullName;
            else
                return "";
	}
	public String  getTeacherNickName()
	{
		return this.teacherNickName;
	}
        public String getTeacherNickName(String teacherFullName)
	{
            boolean res = false; 
            if(!teacherFullName.equals(""))
            {
                res= mysql.search(this,"TeacherList","teacherFullName = '"+teacherFullName+"'","String","teacherFullName","String","teacherNickName","String","email");
            }  
            if(res)
		return this.teacherNickName;
            else
                return "";
	}        
	public boolean isExist()
 	{
                this.createTable();
 		
 		return mysql.tableExist("teacherlist");
 	}
	public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count("TeacherList");
            else
                return 0;
   	}
        public boolean delete(String teacherFullName)
        {
            return mysql.delete("TeacherList", " teacherFullName = '"+teacherFullName+"'");
        }
        public boolean deleteAll()
        {
            return mysql.deleteAll("TeacherList");
        }

    public void searchMail(String recepient) {
              mysql.search(this,"TeacherList","email= '"+recepient+"'","String","teacherFullName","String","teacherNickName","String","email");
            
    }

    public String getEmail() {
        return this.mail;
    }
}

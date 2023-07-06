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
public class ProgramList implements MySQLRead{
    private String programName;
	private int semester;
	private int done;
        private int slotLength;

	private  MySQL mysql;

	
	public  boolean createTable()
	{
		return mysql.createTable("ProgramList(programName char(15), semester int(2),done int(2), slotLength int(3));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		this.programName=valueList[0];
		this.semester=Integer.parseInt(valueList[1]);
		this.done=Integer.parseInt(valueList[2]);	
                this.slotLength=Integer.parseInt(valueList[3]);	
	}
	public ProgramList()
	{
		this.programName=null;
		this.semester=0;
		this.done=0;
                this.slotLength = 0;
			mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");
                if(!isExist())
                    this.createTable();
	}
	public ProgramList(String programName,int semester,int done,int slotLength)
	{
                this();
		this.programName=programName;
		this.semester=semester;
		this.done=done;
                this.slotLength = slotLength;
	}
	
	public void setData(String programName,int semester,int done,int slotLength)
	{
		this.programName=programName;
		this.semester=semester;
		this.done=done;
                this.slotLength = slotLength;

		int res=mysql.insertData("ProgramList","'"+programName+"',"+semester+","+done+","+slotLength);
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,"ProgramList","String","programName","int","semester","int","done","int","slotLength");  
		return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		 System.out.println("Program: "+this.programName+"-"+this.semester+", done:"+this.done+",slot Length: "+slotLength);
		else
		 System.out.println("No more data....");	
		return res;
	}
	public void show()
	{
		System.out.println("Program: "+this.programName+"-"+this.semester+", done:"+this.done+", slotLength: "+slotLength);
	}
	public String getProgramName()
	{
		return this.programName;
	}
	public int getSemester()
	{
		return this.semester;
	}
	public int getDone()
	{
		return this.done;
	}
        public int getSlotLength()
        {
            return this.slotLength;
        }
        public int getSlotLength(String programNameAndSemester)
        {
            MySQL mysql=new MySQL();
            
            boolean res = true;
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to search anything...");
		else
		{
			do
			{
				res=mysql.readData(this,"ProgramList","String","programName","int","semester","int","done","int","slotLength");
				if((this.programName +  this.semester).equals(programNameAndSemester))//
				{
						res=false;
						
					}	
				show();	
			}while(res);				
		}
		
            return this.slotLength;
        }
	public boolean searchProgramName(String programName,int semester)//didn.t needed now delete it when completed...
	{
		MySQL mysql=new MySQL();
		boolean res,success=false;
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to search anything...");
		else
		{
			do
			{
				res=mysql.readData(this,"ProgramList","String","programName","int","semester","int","done","int","slotLength");
				if(this.programName.equals(programName) && this.semester==semester)//
					{
						res=false;
						success=true;
					}	
				show();	
			}while(res);				
		}
		return success;
	}
	public boolean isExist()
 	{       
                this.createTable();
 		return mysql.tableExist("ProgramList");
 	}
	public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count("ProgramList");
            else
                return 0;
   	}
        public boolean delete(String programName,String semester)
        {
            return mysql.delete("programList"," programName = '"+programName+"' && semester = "+ semester);
        }
        public boolean deleteAll()
        {
            return mysql.deleteAll("programList");
        }
}

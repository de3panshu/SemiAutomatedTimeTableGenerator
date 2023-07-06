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
public class VenueList implements MySQLRead
{
	private String venueName;

	private static MySQL mysql;

	public boolean createTable()
	{
		return mysql.createTable("VenueList(venueName char(10));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		venueName = valueList[0];
	}


	public VenueList()
	{
            venueName=null;
		
		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");		
                if(!this.isExist())
                    this.createTable();
	}

/*   public Venue(  String tableName)
	{
	   
	   
	}
*/	
	public void setData(String venueName)
        {
	   this.venueName = venueName;
		int res=mysql.insertData("VenueList","'"+venueName+"'");
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,"VenueList","String","venueName");  
		return res;
	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		{	
		 System.out.println("Venue Name: "+this.venueName+"\n");
		} 
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getVenueName()
	{
          	return venueName;
	}	
		public boolean isExist()
 	{
                this.createTable();
 		
 		return mysql.tableExist("venuelist");
 	}
	public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count("VenueList");
            else
                return 0;
   	}
        public boolean delete(String venueName)
        {
            return  mysql.delete("VenueList"," venueName = '"+venueName+"'");
        }
        public boolean deleteAll()
        {
            return mysql.deleteAll("VenueList");
        }
}

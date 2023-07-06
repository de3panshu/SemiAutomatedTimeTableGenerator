/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.superclass;



/**
 *
 * @author Deepanshu Sahu
 */
public class ParticularVenueTimeTableData
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

	
	
	
        public ParticularVenueTimeTableData()
	{
	   this.sno=-1;
	   this.courseCode="";
	   this.classType="";
	   this.teacher1="";
	   this.teacher2="";
	   this.teacher3="";
	   this.program1="";
           this.program2="";
           this.program3="";
	}
	
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
        }
        public void setData(ParticularVenueTimeTable pvtt)
	{
	   this.sno=pvtt.getSno();
	   this.courseCode=pvtt.getCourseCode();
	   this.classType=pvtt.getClassType();
	   this.teacher1=pvtt.getTeacher1();
	   this.teacher2=pvtt.getTeacher2();
	   this.teacher3=pvtt.getTeacher3();
	   this.program1=pvtt.getProgram1();
           this.program2=pvtt.getProgram2();
           this.program3=pvtt.getProgram3();
        }
	public String  getData()
	{
            String data = this.getCourseCode()+"\n"+this.getTeacher1()+" "+this.getTeacher2()+" "+this.getTeacher3()+"\n"+this.getProgram1()+" "+this.getProgram2()+" "+this.getProgram3();
            return data;
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

    public void swap(ParticularVenueTimeTableData particularVenueTimeTableData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

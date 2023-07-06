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
public class ParticularTeacherTimeTableData
{   
	private int sno;  //it must start from 0 and max value is 44;
	private String courseCode;
	private String classType;
	private String venue;
	private String program1;
        private String program2;
        private String program3;
	
        public ParticularTeacherTimeTableData()
	{
	   this.sno=-1;
	   this.courseCode="";
	   this.classType="";
	   this.venue="";
	   this.program1="";
           this.program2="";
           this.program3="";
	}
	
	public void setData(int sno,String courseCode,String classType,String venue,String program1,String program2,String program3)
	{
	   this.sno=sno;
	   this.courseCode=courseCode;
	   this.classType=classType;
	   this.venue=venue;
	   this.program1=program1;
           this.program2=program2;
           this.program3=program3;
        }
        public void setData(ParticularTeacherTimeTable pt3)
	{
	   this.sno=pt3.getSno();
	   this.courseCode=pt3.getCourseCode();
	   this.classType=pt3.getClassType();
	   this.venue=pt3.getVenue();
	   this.program1=pt3.getProgram1();
           this.program2=pt3.getProgram2();
           this.program3=pt3.getProgram3();
        }
	
        
	public String  getData()
	{
            String data = getCourseCode()+" "+this.getVenue()+"\n"+this.getProgram1()+" "+this.getProgram2()+" "+getProgram3();
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

    public void swap(ParticularTeacherTimeTableData particularTeacherTimeTableData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

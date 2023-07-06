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
public class ParticularProgramTimeTableData {
        private int sno;
	private String courseCode;
	private String classType;
	private String venue;
	private String teacher1;
        private String teacher2;
        private String teacher3;
	

	
	public ParticularProgramTimeTableData()
	{
           this.sno = -1;
           this.courseCode="";
	   this.classType="";
	   this.venue="";
	   this.teacher1="";
           this.teacher2="";
           this.teacher3="";
        }
	
	public void setData(int sno,String courseCode,String classType,String venue,String teacher1,String teacher2,String teacher3)
	{
           this.sno = sno;
           this.courseCode=courseCode;
	   this.classType=classType;
	   this.venue=venue;
	   this.teacher1=teacher1;
           this.teacher2=teacher2;
           this.teacher3=teacher3;
        }
        public void setData(ParticularProgramTimeTable p2t2)
	{
           this.sno = p2t2.getSno();
           this.courseCode=p2t2.getCourseCode();
	   this.classType=p2t2.getClassType();
	   this.venue=p2t2.getVenue();
	   this.teacher1=p2t2.getTeacher1();
           this.teacher2=p2t2.getTeacher2();
           this.teacher3=p2t2.getTeacher3();
        }
        public int getSno()
        {
            return this.sno;
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
        public void setSno(int sno)
        {
            this.sno = sno;
        }
        public void setCourseCode(String courseCode)
        {
            this.courseCode = courseCode;
        }
        public void setClassType(String classType)
        {
            this.classType = classType;
        }
        public void setVenue(String venue)
        {
            this.venue = venue;            
        }
        public void setTeacher1(String teacher1)
        {
            this.teacher1 = teacher1;
        }
        public void setTeacher2(String teacher2)
        {
            this.teacher2 = teacher2;
        }
        public void setTeacher3(String teacher3)
        {
            this.teacher3 = teacher3;
        }
        public String  getData()
        {
            String data=this.getCourseCode()+"  "+this.getVenue()+System.lineSeparator()+this.getTeacher1()+" "+this.getTeacher2()+" "+this.getTeacher3()+"\n"+this.getClassType();
            return data;
        }
        public void  swap(ParticularProgramTimeTableData p2t2d)
        {
            //int sno = p2t2d.getSno(); it may generates eerorr
            String courseCode = p2t2d.getCourseCode();
            String venue = p2t2d.getVenue();
            String classType = p2t2d.getClassType();
            String teacher1 = p2t2d.getTeacher1();
            String teacher2 = p2t2d.getTeacher2();
            String teacher3 = p2t2d.getTeacher3();
            
            p2t2d.setData(this.getSno(),this.getCourseCode(),this.getClassType(),this.getVenue(),this.getTeacher1(),this.getTeacher2(),this.getTeacher3());
            
            this.setData(sno,courseCode,classType,venue,teacher1,teacher2,teacher3);
        }
        public void  copy(ParticularProgramTimeTableData p2t2d)
        {
            int sno = p2t2d.getSno();
            String courseCode = p2t2d.getCourseCode();
            String venue = p2t2d.getVenue();
            String classType = p2t2d.getClassType();
            String teacher1 = p2t2d.getTeacher1();
            String teacher2 = p2t2d.getTeacher2();
            String teacher3 = p2t2d.getTeacher3();
            
            this.setData(sno,courseCode,classType,venue,teacher1,teacher2,teacher3);
        }
        public boolean isEquals(ParticularProgramTimeTableData p2t2d)
        {
            boolean res = false;
            if(p2t2d.getCourseCode().equals(this.getCourseCode()))
            {
                if(p2t2d.getClassType().equals(this.getClassType()))
                {
                    if(p2t2d.getTeacher1().equals(this.getTeacher1()))
                    {
                        if(p2t2d.getTeacher2().equals(this.getTeacher2()))
                        {
                            if(p2t2d.getTeacher3().equals(this.getTeacher3()))
                            {
                                res=true;
                            }
                        }
                    }
                }
            }
            return res;
        }
    
    }

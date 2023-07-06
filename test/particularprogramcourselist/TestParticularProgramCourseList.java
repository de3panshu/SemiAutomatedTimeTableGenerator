/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particularprogramcourselist;

import database.base.ParticularProgramCourseList;



/**
 *
 * @author Deepanshu Sahu
 */
class TestParticularProgramCourseList
{
	public static void main(String[] args) 
	{
		ParticularProgramCourseList	p;
		
		p = new ParticularProgramCourseList("BCA1_cl");
		if(!p.isExist())
			p.createTable();
		p.setData("CSIT-404");
		p.setData("CSIT-405");
		p.setData("CSIT-409");
		p.setData("LNG-301");
		p.setData("GPT-301");
		p.setData("MAS-341");
		p.setData("BAM-327");
		p.setData("ECE-310");
		p.setData("PSY-302");
		p.setData("NSS-318");
		
		p = new ParticularProgramCourseList("BCA3_cl");
		if(!p.isExist())
			p.createTable();
		p.setData("CSIT-408");
		p.setData("CSIT-416");
		p.setData("CSIT-418");
		p.setData("CSIT-503");
		p.setData("NSS-319");
		p.setData("BAM-302");
		p.setData("BAM-317");
		p.setData("MAS-621");
		p.setData("ENV-416");

		p = new ParticularProgramCourseList("BCA5_cl");
		if(!p.isExist())
			p.createTable();
		p.setData("CSIT-507");
		p.setData("CSIT-506");
		p.setData("CSIT-517");
		p.setData("CSIT-510");
		p.setData("CSIT-641");
		p.setData("CSIT-699a");
		p.setData("BAM-544");
		p.setData("NSS-319");
		p.setData("CSIT-");
		p.setData("-");
		
	}
}
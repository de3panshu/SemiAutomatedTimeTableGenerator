/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courselist;

import database.base.CourseList;
import database.base.MySQL;

/**
 *
 * @author Deepanshu Sahu
 */
class TestCourseList
{
	public static void main(String[] args) 
	{
                MySQL.makeConnection("timetable", "root", "");
		CourseList c = new CourseList();
		if(!c.isExist())
			c.createTable();
			
		c.setData("CSIT-301","Introduction to Computer Applications",2,0,1);			
		c.setData("CSIT-308","Programming for Problem Solving",2,1,2);	
		c.setData("CSIT-309","Agriculture Informatics",1,0,2);
		c.setData("CSIT-310","Information and Communication Technology",1,0,1);
		c.setData("CSIT-400","Training I",0,0,1);
		c.setData("CSIT-401","Computer and Languages",2,1,1);
		c.setData("CSIT-404","Problem Solving and Programming in C",2,1,2);
		c.setData("CSIT-405","Fundamentals of Computer Science",3,1,1);//211 
		c.setData("CSIT-408","Fundamentals of Database Management System",3,1,0);
		c.setData("CSIT-409","Principles of Programming Languages",3,1,0);
		c.setData("CSIT-410","Data Structure Using C",2,1,1);
		c.setData("CSIT-413","Web Technology",2,1,1);
		c.setData("CSIT-414","Principles of Operating System",3,1,1);
		c.setData("CSIT-416","System Analysis and Design",3,1,0);
		c.setData("CSIT-417","Fundamentals of Operating System",3,1,1);
		c.setData("CSIT-418","Information Security",2,0,0);
		c.setData("CSIT-425","Object Oriented Systems through C++",3,0,1);
		c.setData("CSIT-427","Data Structure and Algorithms",3,0,2);
		c.setData("CSIT-428","Programming and Data Structure",1,0,2);
		c.setData("CSIT-429","Web Designing and Internet Applicatio",1,0,2);
		c.setData("CSIT-430","ICT Applications in Food Industry",1,0,2);
		c.setData("CSIT-431","IT Workshop",1,0,2);
		c.setData("CSIT-432","Computer Organisation and Architecture",3,1,1);
		c.setData("CSIT-435","Basic of Computer",1,0,2);
		c.setData("CSIT-500","Training II",0,0,1);
		c.setData("CSIT-501","Application of Information Technology",2,1,1);
		c.setData("CSIT-503","Object Oriented Systems",3,1,1);
		c.setData("CSIT-504","Advance Web Development and Design",2,0,1);
		c.setData("CSIT-506","Principles of Artificial Intelligence",3,1,0);
		c.setData("CSIT-507","Computer Graphics and Multimedia",3,1,1);
		c.setData("CSIT-510",".NET Framework and C#",3,1,1);
		c.setData("CSIT-511","Principles of Computer Network",3,1,1);
		c.setData("CSIT-512","Design and Analysis of Algorithms",3,1,1);
		c.setData("CSIT-513","Microprocessors and Applications",2,1,1);
		c.setData("CSIT-514","Theory of Automata and Formal Languages",3,1,0);
		c.setData("CSIT-517","Computer Architecture",3,1,0);
		c.setData("CSIT-580","Seminar I",0,0,1);
		c.setData("CSIT-603","Software Project Management",3,1,0);
		c.setData("CSIT-604","System Programming",3,1,1);
		c.setData("CSIT-606",".NET Framework and C#",2,1,1);
		c.setData("CSIT-607","Data Warehousing and Data Mining",3,1,0);
		c.setData("CSIT-608","Artificial Intelligence",2,1,1);
		c.setData("CSIT-610","Data Communication and Networking",3,0,1);
		c.setData("CSIT-641","XML Applications",3,1,0);
		c.setData("CSIT-699a","Project(Project Formulation)",0,0,2);
		c.setData("CSIT-701","Computer Orientation",2,0,1);
		c.setData("CSIT-702","Computer Programming",2,0,1);
		c.setData("CSIT-704","IT Application in Management",2,0,1);
		c.setData("CSIT-709","Programming and Problem Solving with C",2,1,2);
		c.setData("CSIT-710","Introduction to Softwares",3,0,1);
		c.setData("CSIT-711","Computer Organisation and Architecture",3,1,0);
		c.setData("CSIT-718","Database Management Systems",3,0,1);
		c.setData("CSIT-719","Software Engineering",2,1,0);
		c.setData("CSIT-720","Design and Analysis of Algorithms",2,1,0);
		c.setData("CSIT-721","Computer Networks",2,1,1);
		c.setData("CSIT-722","Object Modeling Techniques and UML",3,0,1);
		c.setData("CSIT-723","Advance Data Structures",2,1,1);
		c.setData("CSIT-724","Advance Object Oriented Systems",2,1,0);
		c.setData("CSIT-733",".NET Programming",2,0,2);
		c.setData("CSIT-734","Principles of Compiler Design",2,1,0);
		c.setData("CSIT-780","Seminar I",0,0,1);
		c.setData("CSIT-804","Network Programming",2,1,1);
		c.setData("CSIT-805","Computer Graphics and Multimedia",2,1,1);
		c.setData("CSIT-807","Distributed Computing",2,1,0);
		c.setData("CSIT-811","Data Mining Techniques",2,1,0);
		c.setData("CSIT-814","Mobile Ad-hoc Networks",2,1,0);
		c.setData("CSIT-818","Digital Image Processing",2,1,0);
		c.setData("CSIT-880","Seminar II",0,0,1);
		c.setData("CSIT-881","Special Study",0,0,2);
		

		c.setData("LNG-301","Structured and Spoken English",2,1,0);	
		c.setData("LNG-302","Professional Communication I",2,1,0);
		c.setData("LNG-410","Effective Technical Communication",2,1,0);	

		c.setData("GPT-301","Moral and Value Education",2,0,0);

		c.setData("MAS-321","Differential Equation and Vector Calculus",3,0,0);
		c.setData("MAS-322","Differential and Integral Calculus",3,0,0);
		c.setData("MAS-341","Foundation Course in Mathematics",4,0,0);
		c.setData("MAS-416","Mathematics I",3,1,0);
		c.setData("MAS-418","Mathematics II",3,0,0);
		c.setData("MAS-621","Discerete Mathematics",3,0,0);
		c.setData("MAS-651","Principles of Operation Research",3,1,0);
		c.setData("MAS-721","Operation Research",4,0,0);
		c.setData("MAS-781","Advance Engineering Mathematics",3,0,0);

		c.setData("BAM-302","Principles of Accounting",2,1,0);
		c.setData("BAM-315","Elements of Economics and Priciples of Management Science",3,1,0);
		c.setData("BAM-317","Organisation Behavior",3,0,0);
		c.setData("BAM-327","Business Communication",2,1,0);
		c.setData("BAM-544","Management Information System",2,1,0);
		c.setData("BAM-752","Business Communication",2,1,0);
		c.setData("BAM-796","Accounting and Finance Management",2,1,0);

		c.setData("ECE-301","Basic Electronics",3,0,1);
		c.setData("ECE-310","Basic Electronics",2,1,1);
		c.setData("ECE-504","Analog and Digital Circuits",3,0,1);
		c.setData("ECE-641","Embedded Systems",3,0,0);
		c.setData("ECE-707","Neural Network and Fuzzy Logic",3,0,0);

		c.setData("PSY-302","Psychology",1,1,0);


		c.setData("NSS-318","NSS",0,0,1);
		c.setData("NSS-319","NSS",0,0,1);
		

		c.setData("ENV-415","Environment Studies I",2,0,0);
		c.setData("ENV-416","Environment Studies II",2,0,0);

		c.setData("PHY-309","Basic Physics",3,0,0);

		c.setData("CHEM-417","Chemistry",3,1,1);

		c.setData("ME-304","Workshop Practice and Technology",1,0,2);

		//Insert the remaining of the program name offered to other departments.
		System.out.println("Data are....");
		//while(c.getData());
		if(c.getData("BAM-302"))
			c.show();
		else
		{
			System.out.println("No such Data found..."); c.show();
		}
		System.out.println("No of records: "+c.count());
			
			
			
	}
}

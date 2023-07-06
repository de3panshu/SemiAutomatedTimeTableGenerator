/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.base;

import database.superclass.ParticularTeacherTimeTable;




/**
 *
 * @author Deepanshu Sahu
 */
public class ParticularTeacher implements MySQLRead
{
    private int sno;
    private String tableName;
    private static MySQL mysql;
    private static final int [] SLOT8LOWER = new int[]{1,11,21,31,51,61,71,81,91};
    private static final int [] SLOT8UPPER = new int[]{9,19,29,39,59,69,79,89,99};
    private static final int [] SLOT12LOWER = new int[]{1,14,27,40,61,74,87};
    private static final int [] SLOT12UPPER = new int[]{12,25,38,51,72,85,98};

    @Override
    public void setValue(String... valueList) 
    {
        this.sno = Integer.parseInt(valueList[0]);
    }
    public boolean getData()
    {
        boolean res = false;
        if(!tableName.equals(""))
            res = mysql.readData(this, tableName, "int","sno");
        return res;
    }
    public int getSno()
    {
        return this.sno;
    }
    public ParticularTeacher(String tableName)
    {
        this.tableName = tableName;
        if(!tableName.equals(""))
        {
            mysql=new MySQL();
            if(!mysql.startConnection("timetable","root",""))
            {
                System.out.println("Unable to establish conection with database...");
            }   
            if(!isExist())
            {
                createTable();
            }
        }
    }
    public boolean createTable(String tableName)
    {
        boolean res = mysql.createTable(tableName + "(sno int(1));");
        return res;
    }
    public boolean createTable()
    {
        boolean res = mysql.createTable(tableName + "(sno int(1));");
        return res;
    }
    public boolean isExist()
    {
        this.createTable();
 		
        return mysql.tableExist(this.tableName);
    }
    
    public void setData(int sno)
    {
        if(!this.tableName.equals(""))
        {
            int res=mysql.insertData(tableName,sno+"");  
            if(res!=0)
                System.out.println("Row inserted successfully...");// delete when complete....
            else
		System.out.println("Row couldn't be inserted....");// delete when complete....
        }
    }
    public void delete(int sno)
    {
        mysql.delete(tableName, " sno = "+sno);
    }
    public void updateTeacherAllotmentArray(int index, int updateValue, int slotLength) 
    {
        if(!this.tableName.equals(""))
        {
            int jIndex = index%5;
            int iIndex = (index-jIndex)/5;
            int upperLimit;
            int lowerLimit;
        
            if(slotLength == 9)
            {
                upperLimit = SLOT8UPPER[iIndex];
                lowerLimit = SLOT8LOWER[iIndex];
            }
            else
            {
                upperLimit = SLOT12UPPER[iIndex];
                lowerLimit = SLOT12LOWER[iIndex];
            }
            if(updateValue == 0)
            {
                for(int i=lowerLimit;i<= upperLimit;i++)
                {
                    delete(jIndex*100+i);
                }
            }
            else
            {
                for(int i=lowerLimit;i<= upperLimit;i++)
                {
                    setData(jIndex*100+i);
                }
            }
        }
    }
    public boolean isFree(int index, int slotLength)
    {
        boolean res = true;
        System.out.println("isFree():;::Checking for the feasibility:"+tableName); 
        if(!this.tableName.equals(""))
        {
            if(slotLength == 9)
            {
                res = new ParticularTeacherTimeTable(tableName+"_tt").isFree(index);
            }
            else
            {
                            int realIndex;
            int jIndex = index%5;
            int iIndex = (index-jIndex)/5;
            int upperLimit;
            int lowerLimit;
        
            upperLimit = SLOT12UPPER[iIndex];
            lowerLimit = SLOT12LOWER[iIndex];
            for(int i=lowerLimit; i<=upperLimit; i++)
            {
                realIndex = jIndex*100+i;
                System.out.println("cheaking at place: "+i);
                if(mysql.search(this, tableName, "sno = "+realIndex, "int","sno"))
                {
                    res = false;
                    System.out.println(tableName+" busy at "+i);
                    break;
                }
            }

            }
        }
        return res;
    }
    public int count()
	{
            MySQL newMysql = new MySQL();
            if(newMysql.startConnection("timetable","root",""))
                return newMysql.count(tableName);
            else
                return 0;
   	}
         public boolean deleteAll()
        {
            MySQL newMysql = new MySQL();
                TeacherList teacherList = new TeacherList();
		boolean success = false;
		if(newMysql.startConnection("timetable","root",""))
		{
                    success  = true; 
                    while(teacherList.getData() )
                            success = newMysql.deleteAll(teacherList.getTeacherFullName());
                        
		}
		return success;
           
        }
       
}


/*public class ParticularTeacher implements MySQLRead
{
	private int m0,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23,m24,m25,m26,m27,m28,m29,m30,m31,m32,m33,m34,m35,m36,m37,m38,m39,m40,m41,m42,m43,m44,m45,m46,m47,m48,m49,m50,m51,m52,m53,m54,m55,m56,m57,m58,m59,m60,m61,m62,m63,m64,m65,m66,m67,m68,m69,m70,m71,m72,m73,m74,m75,m76,m77,m78,m79,m80,m81,m82,m83,m84,m85,m86,m87,m88,m89,m90,m91,m92,m93,m94,m95,m96,m97,m98,m99;
	private int t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,t42,t43,t44,t45,t46,t47,t48,t49,t50,t51,t52,t53,t54,t55,t56,t57,t58,t59,t60,t61,t62,t63,t64,t65,t66,t67,t68,t69,t70,t71,t72,t73,t74,t75,t76,t77,t78,t79,t80,t81,t82,t83,t84,t85,t86,t87,t88,t89,t90,t91,t92,t93,t94,t95,t96,t97,t98,t99;
	private int w0,w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14,w15,w16,w17,w18,w19,w20,w21,w22,w23,w24,w25,w26,w27,w28,w29,w30,w31,w32,w33,w34,w35,w36,w37,w38,w39,w40,w41,w42,w43,w44,w45,w46,w47,w48,w49,w50,w51,w52,w53,w54,w55,w56,w57,w58,w59,w60,w61,w62,w63,w64,w65,w66,w67,w68,w69,w70,w71,w72,w73,w74,w75,w76,w77,w78,w79,w80,w81,w82,w83,w84,w85,w86,w87,w88,w89,w90,w91,w92,w93,w94,w95,w96,w97,w98,w99;
	private int th0,th1,th2,th3,th4,th5,th6,th7,th8,th9,th10,th11,th12,th13,th14,th15,th16,th17,th18,th19,th20,th21,th22,th23,th24,th25,th26,th27,th28,th29,th30,th31,th32,th33,th34,th35,th36,th37,th38,th39,th40,th41,th42,th43,th44,th45,th46,th47,th48,th49,th50,th51,th52,th53,th54,th55,th56,th57,th58,th59,th60,th61,th62,th63,th64,th65,th66,th67,th68,th69,th70,th71,th72,th73,th74,th75,th76,th77,th78,th79,th80,th81,th82,th83,th84,th85,th86,th87,th88,th89,th90,th91,th92,th93,th94,th95,th96,th97,th98,th99;
	private int f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39,f40,f41,f42,f43,f44,f45,f46,f47,f48,f49,f50,f51,f52,f53,f54,f55,f56,f57,f58,f59,f60,f61,f62,f63,f64,f65,f66,f67,f68,f69,f70,f71,f72,f73,f74,f75,f76,f77,f78,f79,f80,f81,f82,f83,f84,f85,f86,f87,f88,f89,f90,f91,f92,f93,f94,f95,f96,f97,f98,f99;
	
	private int [] teacherAllotmentArray;

	private final String tableName;//it is served as Teacher Name for a table.
        private static MySQL mysql;
        int [] buttonSlot8Lower = new int[]{1,11,21,31,51,61,71,81,91};
        int [] buttonSlot8Upper = new int[]{9,19,29,39,59,69,79,89,99};
        int [] buttonSlot12Lower = new int[]{1,14,27,40,61,74,87};
        int [] buttonSlot12Upper = new int[]{12,25,38,51,72,85,98};
                

	public boolean createTable(String tableName)
	{
            boolean res = mysql.createTable(tableName+"(m0 int(1),m1 int(1),m2 int(1),m3 int(1),m4 int(1),m5 int(1),m6 int(1),m7 int(1),m8 int(1),m9 int(1),m10 int(1),m11 int(1),m12 int(1),m13 int(1),m14 int(1),m15 int(1),m16 int(1),m17 int(1),m18 int(1),m19 int(1),m20 int(1),m21 int(1),m22 int(1),m23 int(1),m24 int(1),m25 int(1),m26 int(1),m27 int(1),m28 int(1),m29 int(1),m30 int(1),m31 int(1),m32 int(1),m33 int(1),m34 int(1),m35 int(1),m36 int(1),m37 int(1),m38 int(1),m39 int(1),m40 int(1),m41 int(1),m42 int(1),m43 int(1),m44 int(1),m45 int(1),m46 int(1),m47 int(1),m48 int(1),m49 int(1),m50 int(1),m51 int(1),m52 int(1),m53 int(1),m54 int(1),m55 int(1),m56 int(1),m57 int(1),m58 int(1),m59 int(1),m60 int(1),m61 int(1),m62 int(1),m63 int(1),m64 int(1),m65 int(1),m66 int(1),m67 int(1),m68 int(1),m69 int(1),m70 int(1),m71 int(1),m72 int(1),m73 int(1),m74 int(1),m75 int(1),m76 int(1),m77 int(1),m78 int(1),m79 int(1),m80 int(1),m81 int(1),m82 int(1),m83 int(1),m84 int(1),m85 int(1),m86 int(1),m87 int(1),m88 int(1),m89 int(1),m90 int(1),m91 int(1),m92 int(1),m93 int(1),m94 int(1),m95 int(1),m96 int(1),m97 int(1),m98 int(1),m99 int(1),t0 int(1),t1 int(1),t2 int(1),t3 int(1),t4 int(1),t5 int(1),t6 int(1),t7 int(1),t8 int(1),t9 int(1),t10 int(1),t11 int(1),t12 int(1),t13 int(1),t14 int(1),t15 int(1),t16 int(1),t17 int(1),t18 int(1),t19 int(1),t20 int(1),t21 int(1),t22 int(1),t23 int(1),t24 int(1),t25 int(1),t26 int(1),t27 int(1),t28 int(1),t29 int(1),t30 int(1),t31 int(1),t32 int(1),t33 int(1),t34 int(1),t35 int(1),t36 int(1),t37 int(1),t38 int(1),t39 int(1),t40 int(1),t41 int(1),t42 int(1),t43 int(1),t44 int(1),t45 int(1),t46 int(1),t47 int(1),t48 int(1),t49 int(1),t50 int(1),t51 int(1),t52 int(1),t53 int(1),t54 int(1),t55 int(1),t56 int(1),t57 int(1),t58 int(1),t59 int(1),t60 int(1),t61 int(1),t62 int(1),t63 int(1),t64 int(1),t65 int(1),t66 int(1),t67 int(1),t68 int(1),t69 int(1),t70 int(1),t71 int(1),t72 int(1),t73 int(1),t74 int(1),t75 int(1),t76 int(1),t77 int(1),t78 int(1),t79 int(1),t80 int(1),t81 int(1),t82 int(1),t83 int(1),t84 int(1),t85 int(1),t86 int(1),t87 int(1),t88 int(1),t89 int(1),t90 int(1),t91 int(1),t92 int(1),t93 int(1),t94 int(1),t95 int(1),t96 int(1),t97 int(1),t98 int(1),t99 int(1),w0 int(1),w1 int(1),w2 int(1),w3 int(1),w4 int(1),w5 int(1),w6 int(1),w7 int(1),w8 int(1),w9 int(1),w10 int(1),w11 int(1),w12 int(1),w13 int(1),w14 int(1),w15 int(1),w16 int(1),w17 int(1),w18 int(1),w19 int(1),w20 int(1),w21 int(1),w22 int(1),w23 int(1),w24 int(1),w25 int(1),w26 int(1),w27 int(1),w28 int(1),w29 int(1),w30 int(1),w31 int(1),w32 int(1),w33 int(1),w34 int(1),w35 int(1),w36 int(1),w37 int(1),w38 int(1),w39 int(1),w40 int(1),w41 int(1),w42 int(1),w43 int(1),w44 int(1),w45 int(1),w46 int(1),w47 int(1),w48 int(1),w49 int(1),w50 int(1),w51 int(1),w52 int(1),w53 int(1),w54 int(1),w55 int(1),w56 int(1),w57 int(1),w58 int(1),w59 int(1),w60 int(1),w61 int(1),w62 int(1),w63 int(1),w64 int(1),w65 int(1),w66 int(1),w67 int(1),w68 int(1),w69 int(1),w70 int(1),w71 int(1),w72 int(1),w73 int(1),w74 int(1),w75 int(1),w76 int(1),w77 int(1),w78 int(1),w79 int(1),w80 int(1),w81 int(1),w82 int(1),w83 int(1),w84 int(1),w85 int(1),w86 int(1),w87 int(1),w88 int(1),w89 int(1),w90 int(1),w91 int(1),w92 int(1),w93 int(1),w94 int(1),w95 int(1),w96 int(1),w97 int(1),w98 int(1),w99 int(1),th0 int(1),th1 int(1),th2 int(1),th3 int(1),th4 int(1),th5 int(1),th6 int(1),th7 int(1),th8 int(1),th9 int(1),th10 int(1),th11 int(1),th12 int(1),th13 int(1),th14 int(1),th15 int(1),th16 int(1),th17 int(1),th18 int(1),th19 int(1),th20 int(1),th21 int(1),th22 int(1),th23 int(1),th24 int(1),th25 int(1),th26 int(1),th27 int(1),th28 int(1),th29 int(1),th30 int(1),th31 int(1),th32 int(1),th33 int(1),th34 int(1),th35 int(1),th36 int(1),th37 int(1),th38 int(1),th39 int(1),th40 int(1),th41 int(1),th42 int(1),th43 int(1),th44 int(1),th45 int(1),th46 int(1),th47 int(1),th48 int(1),th49 int(1),th50 int(1),th51 int(1),th52 int(1),th53 int(1),th54 int(1),th55 int(1),th56 int(1),th57 int(1),th58 int(1),th59 int(1),th60 int(1),th61 int(1),th62 int(1),th63 int(1),th64 int(1),th65 int(1),th66 int(1),th67 int(1),th68 int(1),th69 int(1),th70 int(1),th71 int(1),th72 int(1),th73 int(1),th74 int(1),th75 int(1),th76 int(1),th77 int(1),th78 int(1),th79 int(1),th80 int(1),th81 int(1),th82 int(1),th83 int(1),th84 int(1),th85 int(1),th86 int(1),th87 int(1),th88 int(1),th89 int(1),th90 int(1),th91 int(1),th92 int(1),th93 int(1),th94 int(1),th95 int(1),th96 int(1),th97 int(1),th98 int(1),th99 int(1),f0 int(1),f1 int(1),f2 int(1),f3 int(1),f4 int(1),f5 int(1),f6 int(1),f7 int(1),f8 int(1),f9 int(1),f10 int(1),f11 int(1),f12 int(1),f13 int(1),f14 int(1),f15 int(1),f16 int(1),f17 int(1),f18 int(1),f19 int(1),f20 int(1),f21 int(1),f22 int(1),f23 int(1),f24 int(1),f25 int(1),f26 int(1),f27 int(1),f28 int(1),f29 int(1),f30 int(1),f31 int(1),f32 int(1),f33 int(1),f34 int(1),f35 int(1),f36 int(1),f37 int(1),f38 int(1),f39 int(1),f40 int(1),f41 int(1),f42 int(1),f43 int(1),f44 int(1),f45 int(1),f46 int(1),f47 int(1),f48 int(1),f49 int(1),f50 int(1),f51 int(1),f52 int(1),f53 int(1),f54 int(1),f55 int(1),f56 int(1),f57 int(1),f58 int(1),f59 int(1),f60 int(1),f61 int(1),f62 int(1),f63 int(1),f64 int(1),f65 int(1),f66 int(1),f67 int(1),f68 int(1),f69 int(1),f70 int(1),f71 int(1),f72 int(1),f73 int(1),f74 int(1),f75 int(1),f76 int(1),f77 int(1),f78 int(1),f79 int(1),f80 int(1),f81 int(1),f82 int(1),f83 int(1),f84 int(1),f85 int(1),f86 int(1),f87 int(1),f88 int(1),f89 int(1),f90 int(1),f91 int(1),f92 int(1),f93 int(1),f94 int(1),f95 int(1),f96 int(1),f97 int(1),f98 int(1),f99 int(1));");
            if(res)
                this.setData(new int[500]);
            return res;
	}
	public boolean createTable()
	{
		return mysql.createTable(getTableName()+"(m0 int(1),m1 int(1),m2 int(1),m3 int(1),m4 int(1),m5 int(1),m6 int(1),m7 int(1),m8 int(1),m9 int(1),m10 int(1),m11 int(1),m12 int(1),m13 int(1),m14 int(1),m15 int(1),m16 int(1),m17 int(1),m18 int(1),m19 int(1),m20 int(1),m21 int(1),m22 int(1),m23 int(1),m24 int(1),m25 int(1),m26 int(1),m27 int(1),m28 int(1),m29 int(1),m30 int(1),m31 int(1),m32 int(1),m33 int(1),m34 int(1),m35 int(1),m36 int(1),m37 int(1),m38 int(1),m39 int(1),m40 int(1),m41 int(1),m42 int(1),m43 int(1),m44 int(1),m45 int(1),m46 int(1),m47 int(1),m48 int(1),m49 int(1),m50 int(1),m51 int(1),m52 int(1),m53 int(1),m54 int(1),m55 int(1),m56 int(1),m57 int(1),m58 int(1),m59 int(1),m60 int(1),m61 int(1),m62 int(1),m63 int(1),m64 int(1),m65 int(1),m66 int(1),m67 int(1),m68 int(1),m69 int(1),m70 int(1),m71 int(1),m72 int(1),m73 int(1),m74 int(1),m75 int(1),m76 int(1),m77 int(1),m78 int(1),m79 int(1),m80 int(1),m81 int(1),m82 int(1),m83 int(1),m84 int(1),m85 int(1),m86 int(1),m87 int(1),m88 int(1),m89 int(1),m90 int(1),m91 int(1),m92 int(1),m93 int(1),m94 int(1),m95 int(1),m96 int(1),m97 int(1),m98 int(1),m99 int(1),t0 int(1),t1 int(1),t2 int(1),t3 int(1),t4 int(1),t5 int(1),t6 int(1),t7 int(1),t8 int(1),t9 int(1),t10 int(1),t11 int(1),t12 int(1),t13 int(1),t14 int(1),t15 int(1),t16 int(1),t17 int(1),t18 int(1),t19 int(1),t20 int(1),t21 int(1),t22 int(1),t23 int(1),t24 int(1),t25 int(1),t26 int(1),t27 int(1),t28 int(1),t29 int(1),t30 int(1),t31 int(1),t32 int(1),t33 int(1),t34 int(1),t35 int(1),t36 int(1),t37 int(1),t38 int(1),t39 int(1),t40 int(1),t41 int(1),t42 int(1),t43 int(1),t44 int(1),t45 int(1),t46 int(1),t47 int(1),t48 int(1),t49 int(1),t50 int(1),t51 int(1),t52 int(1),t53 int(1),t54 int(1),t55 int(1),t56 int(1),t57 int(1),t58 int(1),t59 int(1),t60 int(1),t61 int(1),t62 int(1),t63 int(1),t64 int(1),t65 int(1),t66 int(1),t67 int(1),t68 int(1),t69 int(1),t70 int(1),t71 int(1),t72 int(1),t73 int(1),t74 int(1),t75 int(1),t76 int(1),t77 int(1),t78 int(1),t79 int(1),t80 int(1),t81 int(1),t82 int(1),t83 int(1),t84 int(1),t85 int(1),t86 int(1),t87 int(1),t88 int(1),t89 int(1),t90 int(1),t91 int(1),t92 int(1),t93 int(1),t94 int(1),t95 int(1),t96 int(1),t97 int(1),t98 int(1),t99 int(1),w0 int(1),w1 int(1),w2 int(1),w3 int(1),w4 int(1),w5 int(1),w6 int(1),w7 int(1),w8 int(1),w9 int(1),w10 int(1),w11 int(1),w12 int(1),w13 int(1),w14 int(1),w15 int(1),w16 int(1),w17 int(1),w18 int(1),w19 int(1),w20 int(1),w21 int(1),w22 int(1),w23 int(1),w24 int(1),w25 int(1),w26 int(1),w27 int(1),w28 int(1),w29 int(1),w30 int(1),w31 int(1),w32 int(1),w33 int(1),w34 int(1),w35 int(1),w36 int(1),w37 int(1),w38 int(1),w39 int(1),w40 int(1),w41 int(1),w42 int(1),w43 int(1),w44 int(1),w45 int(1),w46 int(1),w47 int(1),w48 int(1),w49 int(1),w50 int(1),w51 int(1),w52 int(1),w53 int(1),w54 int(1),w55 int(1),w56 int(1),w57 int(1),w58 int(1),w59 int(1),w60 int(1),w61 int(1),w62 int(1),w63 int(1),w64 int(1),w65 int(1),w66 int(1),w67 int(1),w68 int(1),w69 int(1),w70 int(1),w71 int(1),w72 int(1),w73 int(1),w74 int(1),w75 int(1),w76 int(1),w77 int(1),w78 int(1),w79 int(1),w80 int(1),w81 int(1),w82 int(1),w83 int(1),w84 int(1),w85 int(1),w86 int(1),w87 int(1),w88 int(1),w89 int(1),w90 int(1),w91 int(1),w92 int(1),w93 int(1),w94 int(1),w95 int(1),w96 int(1),w97 int(1),w98 int(1),w99 int(1),th0 int(1),th1 int(1),th2 int(1),th3 int(1),th4 int(1),th5 int(1),th6 int(1),th7 int(1),th8 int(1),th9 int(1),th10 int(1),th11 int(1),th12 int(1),th13 int(1),th14 int(1),th15 int(1),th16 int(1),th17 int(1),th18 int(1),th19 int(1),th20 int(1),th21 int(1),th22 int(1),th23 int(1),th24 int(1),th25 int(1),th26 int(1),th27 int(1),th28 int(1),th29 int(1),th30 int(1),th31 int(1),th32 int(1),th33 int(1),th34 int(1),th35 int(1),th36 int(1),th37 int(1),th38 int(1),th39 int(1),th40 int(1),th41 int(1),th42 int(1),th43 int(1),th44 int(1),th45 int(1),th46 int(1),th47 int(1),th48 int(1),th49 int(1),th50 int(1),th51 int(1),th52 int(1),th53 int(1),th54 int(1),th55 int(1),th56 int(1),th57 int(1),th58 int(1),th59 int(1),th60 int(1),th61 int(1),th62 int(1),th63 int(1),th64 int(1),th65 int(1),th66 int(1),th67 int(1),th68 int(1),th69 int(1),th70 int(1),th71 int(1),th72 int(1),th73 int(1),th74 int(1),th75 int(1),th76 int(1),th77 int(1),th78 int(1),th79 int(1),th80 int(1),th81 int(1),th82 int(1),th83 int(1),th84 int(1),th85 int(1),th86 int(1),th87 int(1),th88 int(1),th89 int(1),th90 int(1),th91 int(1),th92 int(1),th93 int(1),th94 int(1),th95 int(1),th96 int(1),th97 int(1),th98 int(1),th99 int(1),f0 int(1),f1 int(1),f2 int(1),f3 int(1),f4 int(1),f5 int(1),f6 int(1),f7 int(1),f8 int(1),f9 int(1),f10 int(1),f11 int(1),f12 int(1),f13 int(1),f14 int(1),f15 int(1),f16 int(1),f17 int(1),f18 int(1),f19 int(1),f20 int(1),f21 int(1),f22 int(1),f23 int(1),f24 int(1),f25 int(1),f26 int(1),f27 int(1),f28 int(1),f29 int(1),f30 int(1),f31 int(1),f32 int(1),f33 int(1),f34 int(1),f35 int(1),f36 int(1),f37 int(1),f38 int(1),f39 int(1),f40 int(1),f41 int(1),f42 int(1),f43 int(1),f44 int(1),f45 int(1),f46 int(1),f47 int(1),f48 int(1),f49 int(1),f50 int(1),f51 int(1),f52 int(1),f53 int(1),f54 int(1),f55 int(1),f56 int(1),f57 int(1),f58 int(1),f59 int(1),f60 int(1),f61 int(1),f62 int(1),f63 int(1),f64 int(1),f65 int(1),f66 int(1),f67 int(1),f68 int(1),f69 int(1),f70 int(1),f71 int(1),f72 int(1),f73 int(1),f74 int(1),f75 int(1),f76 int(1),f77 int(1),f78 int(1),f79 int(1),f80 int(1),f81 int(1),f82 int(1),f83 int(1),f84 int(1),f85 int(1),f86 int(1),f87 int(1),f88 int(1),f89 int(1),f90 int(1),f91 int(1),f92 int(1),f93 int(1),f94 int(1),f95 int(1),f96 int(1),f97 int(1),f98 int(1),f99 int(1));");
	}
        @Override
	public void setValue(String [] valueList)
	{
		for(int i=0;i<valueList.length;i++)
		   this.teacherAllotmentArray[i]=Integer.parseInt(valueList[i]);
	}

/*
	public ParticularProgram()
	{
		
	}
*/
  /* public ParticularTeacher(String tableName)
	{
	   this.tableName=tableName;
	   teacherAllotmentArray = new int[500];
		
		mysql=new MySQL();
		if(!mysql.startConnection("timetable","root",""))
			System.out.println("Unable to establish conection with database...");   
	}
	
	public void setData(int [] teacherAllotmentArray)
	{
	   StringBuilder teacherAllotmentArrayData = new StringBuilder();		
	   for(int i=0;i<teacherAllotmentArray.length-1;i++)
	   {
		   this.teacherAllotmentArray[i]=teacherAllotmentArray[i];
		   teacherAllotmentArrayData.append(teacherAllotmentArray[i]+",");
	   }
       this.teacherAllotmentArray[teacherAllotmentArray.length-1]=teacherAllotmentArray[teacherAllotmentArray.length-1];
	   teacherAllotmentArrayData.append(teacherAllotmentArray[teacherAllotmentArray.length-1]);
	   	   
		int res=mysql.insertData(getTableName(),teacherAllotmentArrayData.toString());  
			if(res!=0)
				System.out.println("Row inserted successfully...");// delete when complete....
			else
				System.out.println("Row couldn't be inserted....");// delete when complete....
	}
	public boolean  getData()
	{
		boolean res=mysql.readData(this,getTableName(),"int","m0","int","m1","int","m2","int","m3","int","m4","int","m5","int","m6","int","m7","int","m8","int","m9","int","m10","int","m11","int","m12","int","m13","int","m14","int","m15","int","m16","int","m17","int","m18","int","m19","int","m20","int","m21","int","m22","int","m23","int","m24","int","m25","int","m26","int","m27","int","m28","int","m29","int","m30","int","m31","int","m32","int","m33","int","m34","int","m35","int","m36","int","m37","int","m38","int","m39","int","m40","int","m41","int","m42","int","m43","int","m44","int","m45","int","m46","int","m47","int","m48","int","m49","int","m50","int","m51","int","m52","int","m53","int","m54","int","m55","int","m56","int","m57","int","m58","int","m59","int","m60","int","m61","int","m62","int","m63","int","m64","int","m65","int","m66","int","m67","int","m68","int","m69","int","m70","int","m71","int","m72","int","m73","int","m74","int","m75","int","m76","int","m77","int","m78","int","m79","int","m80","int","m81","int","m82","int","m83","int","m84","int","m85","int","m86","int","m87","int","m88","int","m89","int","m90","int","m91","int","m92","int","m93","int","m94","int","m95","int","m96","int","m97","int","m98","int","m99","int","t0","int","t1","int","t2","int","t3","int","t4","int","t5","int","t6","int","t7","int","t8","int","t9","int","t10","int","t11","int","t12","int","t13","int","t14","int","t15","int","t16","int","t17","int","t18","int","t19","int","t20","int","t21","int","t22","int","t23","int","t24","int","t25","int","t26","int","t27","int","t28","int","t29","int","t30","int","t31","int","t32","int","t33","int","t34","int","t35","int","t36","int","t37","int","t38","int","t39","int","t40","int","t41","int","t42","int","t43","int","t44","int","t45","int","t46","int","t47","int","t48","int","t49","int","t50","int","t51","int","t52","int","t53","int","t54","int","t55","int","t56","int","t57","int","t58","int","t59","int","t60","int","t61","int","t62","int","t63","int","t64","int","t65","int","t66","int","t67","int","t68","int","t69","int","t70","int","t71","int","t72","int","t73","int","t74","int","t75","int","t76","int","t77","int","t78","int","t79","int","t80","int","t81","int","t82","int","t83","int","t84","int","t85","int","t86","int","t87","int","t88","int","t89","int","t90","int","t91","int","t92","int","t93","int","t94","int","t95","int","t96","int","t97","int","t98","int","t99","int","w0","int","w1","int","w2","int","w3","int","w4","int","w5","int","w6","int","w7","int","w8","int","w9","int","w10","int","w11","int","w12","int","w13","int","w14","int","w15","int","w16","int","w17","int","w18","int","w19","int","w20","int","w21","int","w22","int","w23","int","w24","int","w25","int","w26","int","w27","int","w28","int","w29","int","w30","int","w31","int","w32","int","w33","int","w34","int","w35","int","w36","int","w37","int","w38","int","w39","int","w40","int","w41","int","w42","int","w43","int","w44","int","w45","int","w46","int","w47","int","w48","int","w49","int","w50","int","w51","int","w52","int","w53","int","w54","int","w55","int","w56","int","w57","int","w58","int","w59","int","w60","int","w61","int","w62","int","w63","int","w64","int","w65","int","w66","int","w67","int","w68","int","w69","int","w70","int","w71","int","w72","int","w73","int","w74","int","w75","int","w76","int","w77","int","w78","int","w79","int","w80","int","w81","int","w82","int","w83","int","w84","int","w85","int","w86","int","w87","int","w88","int","w89","int","w90","int","w91","int","w92","int","w93","int","w94","int","w95","int","w96","int","w97","int","w98","int","w99","int","th0","int","th1","int","th2","int","th3","int","th4","int","th5","int","th6","int","th7","int","th8","int","th9","int","th10","int","th11","int","th12","int","th13","int","th14","int","th15","int","th16","int","th17","int","th18","int","th19","int","th20","int","th21","int","th22","int","th23","int","th24","int","th25","int","th26","int","th27","int","th28","int","th29","int","th30","int","th31","int","th32","int","th33","int","th34","int","th35","int","th36","int","th37","int","th38","int","th39","int","th40","int","th41","int","th42","int","th43","int","th44","int","th45","int","th46","int","th47","int","th48","int","th49","int","th50","int","th51","int","th52","int","th53","int","th54","int","th55","int","th56","int","th57","int","th58","int","th59","int","th60","int","th61","int","th62","int","th63","int","th64","int","th65","int","th66","int","th67","int","th68","int","th69","int","th70","int","th71","int","th72","int","th73","int","th74","int","th75","int","th76","int","th77","int","th78","int","th79","int","th80","int","th81","int","th82","int","th83","int","th84","int","th85","int","th86","int","th87","int","th88","int","th89","int","th90","int","th91","int","th92","int","th93","int","th94","int","th95","int","th96","int","th97","int","th98","int","th99","int","f0","int","f1","int","f2","int","f3","int","f4","int","f5","int","f6","int","f7","int","f8","int","f9","int","f10","int","f11","int","f12","int","f13","int","f14","int","f15","int","f16","int","f17","int","f18","int","f19","int","f20","int","f21","int","f22","int","f23","int","f24","int","f25","int","f26","int","f27","int","f28","int","f29","int","f30","int","f31","int","f32","int","f33","int","f34","int","f35","int","f36","int","f37","int","f38","int","f39","int","f40","int","f41","int","f42","int","f43","int","f44","int","f45","int","f46","int","f47","int","f48","int","f49","int","f50","int","f51","int","f52","int","f53","int","f54","int","f55","int","f56","int","f57","int","f58","int","f59","int","f60","int","f61","int","f62","int","f63","int","f64","int","f65","int","f66","int","f67","int","f68","int","f69","int","f70","int","f71","int","f72","int","f73","int","f74","int","f75","int","f76","int","f77","int","f78","int","f79","int","f80","int","f81","int","f82","int","f83","int","f84","int","f85","int","f86","int","f87","int","f88","int","f89","int","f90","int","f91","int","f92","int","f93","int","f94","int","f95","int","f96","int","f97","int","f98","int","f99");  
		return res;
 	}

	public boolean display()
	{
		boolean res= getData();
		if(res)
		{	
		 System.out.println("Teacher Name: "+getTableName()+"\n");
		 for (int i=0;i<100 ;i++ )
		 {
		 	for (int j=0;j<5;j++ ) 
		 	{
		 	 System.out.print(teacherAllotmentArray[i*j+j]+"\t");		
		 	}	
		 	System.out.print("\n");
		 }
		} 
		else
		 System.out.println("No more data....");	
		return res;
	}
	public String getTableName()
	{
		return this.tableName;
	}
	public int[] getTeacherAllotmentArray()
	{
		return this.teacherAllotmentArray;
	}
	public int getAvailability(int linearIndex)
	{
		if (linearIndex<500)
			return teacherAllotmentArray[linearIndex];
		else
			return -1;
	}
	public int getAvailability(int slotIndex,int dayIndex )//(100X5)
	{
		if(slotIndex*dayIndex+dayIndex<500)
			return teacherAllotmentArray[slotIndex*5+dayIndex];
		else
			return -1;
	}
	public boolean isExist()
 	{
 		return mysql.tableExist(this.tableName);
 	}
 	public static boolean isExist(String tableName)
 	{
 		return mysql.tableExist(tableName);
 	}

    public void updateTeacherAllotmentArray(int index, int i, int slotLength) 
    {
      int jIndex = index%5;
        int iIndex = (index-jIndex)/5;
        int upperLimit;
        int lowerLimit;
        
        System.out.println("Update Teacher Method----------------------------------------------------------------------------");
        System.out.println("index "+index);        
        System.out.println("index-j "+jIndex);        
        System.out.println("index-i "+iIndex);

        if(currentTimeTableData.length == 45)
        {
            upperLimit = buttonSlot8Upper[iIndex];
            lowerLimit = buttonSlot8Lower[iIndex];
        }
        else
        {
            upperLimit = buttonSlot12Upper[iIndex];
            lowerLimit = buttonSlot12Lower[iIndex];
        }
        for(int i=lowerLimit;i<= upperLimit;i++)
        {
            
            int temp = jIndex*100+i;
            System.out.println("updating teacher "+teacherNameArray[forTeacher1Sno]+" at index"+i+"  i.e. "+temp);
            
        }
      
    }

}
*/
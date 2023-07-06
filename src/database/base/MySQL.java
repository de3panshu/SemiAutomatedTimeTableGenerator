/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Deepanshu Sahu
 */
public class MySQL {
    private static Connection connectionObject;
    private PreparedStatement preparedStatementObject;
    public static String dbName;
    ResultSet rs = null;
    private static boolean connection;
    public boolean startConnection(String dbName, String username, String password)//use to start the connection with the DB.
    {
        
        return connection;
    }
    public static boolean makeConnection(String dbName, String username, String password)
    {
        connection  = false;
        connectionObject = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                        MySQL.dbName = dbName;

            System.out.println("Driver Loaded...");  //comment this line        jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

            connectionObject = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, username, password);
            System.out.println("Connection Establish...");  //comment this line
            connection  = true;
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("------Exception: " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
            return false;
        }
    }
    public int insertData(String tableName, String values)//it is use to insert the data into TABLE with values VALUES. It return the no: of rows affected.
    {
        preparedStatementObject = null;
        int nor = 0;//no: of rows affected.
        try {
            preparedStatementObject = connectionObject.prepareStatement("insert into " + tableName + " values(" + values + ");");
            nor = preparedStatementObject.executeUpdate();
        } catch (SQLException e)//youtu.b/RZlofbDJOGw         
        {
            System.out.println("------SQL Exception: "+tableName+"---------" + e.getMessage());
        } finally {
            System.out.println(nor + " rows inserted..."+tableName+"---------");//comment it.
          
        }
          return nor;
    }

    public boolean createTable(/*String dbName,*/String tableStructure)//it is use to a TABLE with values database name & its structure. It return the 1 on success and 0 on failure.
    {
        preparedStatementObject = null;
        boolean nor = false;//no: of rows affected.
        try {
            System.out.println("createtable IF NOT EXISTS " + dbName + " ." + tableStructure);//to be comment...
            preparedStatementObject = connectionObject.prepareStatement("create table " + dbName + "." + tableStructure);
            /*nor=*/
            preparedStatementObject.executeUpdate();
            nor = true;
            System.out.println("Table created successfully...");
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
            System.out.println("table creation unsuccessful!!!");
            
        } finally {
            //System.out.println(nor+" Table Created...");//comment it.
            
        }
        return nor;
    }

    public boolean deleteTable(String tableName)//it is use to delete a currrent TABLE.
    {
        preparedStatementObject = null;
        boolean nor = false;//no: of rows affected.
        try {
            System.out.println("deleting table " + dbName + " ." + tableName);//to be comment...
            preparedStatementObject = connectionObject.prepareStatement("drop table " + dbName + "." + tableName + ";");
            /*nor=*/
            preparedStatementObject.executeUpdate();
            nor = true;
            System.out.println("Table deleted successfully...");
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            //System.out.println(nor+" Table Created...");//comment it.
            
        }
        return nor;
    }

    public int updateData(String tableName, String updateExpression, String condition)//it is use to update the data of the TABLE. It return the no: of rows affected.
    {
        preparedStatementObject = null;
        int nor = 0;//no: of rows affected.
        try {
            preparedStatementObject = connectionObject.prepareStatement("update " + tableName + " set " + updateExpression + " where " + condition + ";");
            nor = preparedStatementObject.executeUpdate();
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            System.out.println(nor + " rows updated...");//comment it.
            
        }
        return nor;
    }

    public int updateData(String tableName, String updateExpression)//it is use to update the data of the TABLE. It return the no: of rows affected.
    {
        preparedStatementObject = null;
        int nor = 0;//no: of rows affected.
        try {
            preparedStatementObject = connectionObject.prepareStatement("update " + tableName + " set " + updateExpression + ";");
            nor = preparedStatementObject.executeUpdate();
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            System.out.println(nor + " rows updated...");//comment it.
           
        }
         return nor;
    }
  
    public boolean readData(/*String dbName,*/MySQLRead obj, String tableName, String... parameterList)// ( do opposite) insert parameter as (class_object, table_name, class_var_type1, table_var1, class_var_type2,table_var2,..........)
    /*the class type must be "Int" ,"Float", "String" only...*/ {
        preparedStatementObject = null;
        boolean nor = false;
        try {
            if (rs == null) {
                String query = getSelectQuery(tableName,null, parameterList);
                preparedStatementObject = connectionObject.prepareStatement(query);
                rs = preparedStatementObject.executeQuery();
            }
            if (rs.next()) {
                obj.setValue(getValueList(parameterList));
                nor = true;
            } else {
                rs = null;
                nor = false;
            }

        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            if (nor) {
             //  System.out.println(" reading successfull...");//comment it.
            } else {
               // System.out.println(" no more records are available...");//comment it.	
            }
           
        }
         return nor;

    }
    public boolean searchAll(/*String dbName,*/MySQLRead obj, String tableName,String condition, String... parameterList)// ( do opposite) insert parameter as (class_object, table_name, class_var_type1, table_var1, class_var_type2,table_var2,..........)
    /*the class type must be "Int" ,"Float", "String" only...*/ {
        preparedStatementObject = null;
        boolean nor = false;
        try {
            if (rs == null) {
                String query = getSelectQuery(tableName,condition, parameterList);
                System.out.println(query);
                preparedStatementObject = connectionObject.prepareStatement(query);
                rs = preparedStatementObject.executeQuery();
            }
            if (rs.next()) {
                obj.setValue(getValueList(parameterList));
                nor = true;
            } else {
                rs = null;
                nor = false;
            }

        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            if (nor) {
             //  System.out.println(" reading successfull...");//comment it.
            } else {
               // System.out.println(" no more records are available...");//comment it.	
            }
           
        }
         return nor;

    }
    public boolean search(/*String dbName,*/MySQLRead obj, String tableName,String condition, String... parameterList)// ( do opposite) insert parameter as (class_object, table_name, class_var_type1, table_var1, class_var_type2,table_var2,..........)
    /*the class type must be "Int" ,"Float", "String" only...*/ {
        preparedStatementObject = null;
        boolean nor = false;
        try {
            if (rs == null) {
                String query = getSelectQuery(tableName,condition, parameterList);
                System.out.println(query);
                preparedStatementObject = connectionObject.prepareStatement(query);
                rs = preparedStatementObject.executeQuery();
                
            }
            if (rs.next()) {
                obj.setValue(getValueList(parameterList));
                nor = true;
                
            }
            rs = null;

        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            if (nor) {
             //  System.out.println(" reading successfull...");//comment it.
            } else {
               // System.out.println(" no more records are available...");//comment it.	
            }
           
        }
         return nor;

    }

    private String getSelectQuery(String tableName,String condition, String... strings)//cv0 , tv0 , cv1 , tv1 , cv2 , tv2 , .....
    {
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        for (int i = 1; i < strings.length; i += 2) {
            if (i != strings.length - 1) {
                sb.append(strings[i]).append(",");
            } else {
                sb.append(strings[i]);
            }
        }
        if(condition == null)
            sb.append(" from ").append(tableName).append(";");
        else
            sb.append(" from ").append(tableName).append(" where ").append(condition).append(";");
        return sb.toString();
    }

    private String[] getValueList(String... strings) {

        String[] valueList = new String[strings.length / 2];
        try {
            for (int i = 0, j = 0; j < valueList.length; i += 2, j++) {
                if (strings[i].equals("int")) {
                    valueList[j] = String.valueOf(rs.getInt(strings[i + 1]));

                } else if (strings[i].equals("String") ){
                    valueList[j] = rs.getString(strings[i + 1]);

                } else if (strings[i].equals("float")) {
                    valueList[j] = String.valueOf(rs.getFloat(strings[i + 1]));
                } else {
                    System.out.println("*************** NO VALUE MATCHED........");//comment it.
                }
            }
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } 
            return valueList;
        
    }

    public boolean tableExist(String tableName) {
        boolean tExist = false;
        try (ResultSet rs = connectionObject.getMetaData().getTables(null, null, tableName, null)) {
            System.out.println(" to upper: " + tableName.toUpperCase());
            System.out.println(" to Lower: " + tableName.toLowerCase());
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && (tName.equals(tableName.toUpperCase()) || tName.equals(tableName.toLowerCase()))) {
                {   
                    System.out.println("TNAME: "+tName);
                    tExist = true;
                    break;
                }
                }
            }
        } catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } finally {
            System.out.println("Table existance: "+tExist);
            return tExist;
        }
    }

    public boolean deleteAll(String tableName) {
        boolean success = false;
        try {
            String query = "delete from " + tableName + ";";
            preparedStatementObject = connectionObject.prepareStatement(query);
            preparedStatementObject.execute();
            success = true;
        } catch (SQLException e) {
            System.out.println(".....SQL Exceptiop: " + e.getMessage());
        } finally {
            return success;
        }
    }

    public boolean delete(String tableName, String condition) {
        boolean success = false;
        try {
            String query = "delete from " + tableName + " where " + condition + ";";
            preparedStatementObject = connectionObject.prepareStatement(query);
            preparedStatementObject.execute();
            success = true;
        } catch (SQLException e) {
            System.out.println(".....SQL Exceptiop: " + e.getMessage());
        } finally {
            return success;
        }
    }    
    public int count(String tableName)
    {
        String query = "select count(*) from "+tableName+";";
        preparedStatementObject = null;
        int noOfRows = 0;
        try 
        {
            preparedStatementObject = connectionObject.prepareStatement(query);
            rs = preparedStatementObject.executeQuery();
        
            while(rs.next()) noOfRows = rs.getInt("count(*)");

        } 
        catch (SQLException e) {
            System.out.println("------SQL Exception: " + e.getMessage());
        } 
        return noOfRows;
      }
}

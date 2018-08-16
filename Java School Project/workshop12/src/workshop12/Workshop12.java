/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop12;


/**
 *
 * @author Jason
 */
import java.util.ArrayList;
import java.sql.*;

public class Workshop12 {
    public static final String user="root";
    public static final String pass="root";
    public static final String URL="jdbc:mysql://localhost:3306/firstDB";
    public static final String Driver_CLASS_MYSQLO="com.mysql.jdbc.Driver";
    
    
    public static void main(String[] args) {        
        ArrayList<Account> accList=new ArrayList();
        accList=new readObj().readAndPrintFile();
        new frame(accList);
        
        //========Mysql======================
        Connection con=null;
        Statement stmt=null;
        
        try{
        con=DriverManager.getConnection(URL,user,pass);
        stmt=con.createStatement();
        stmt.execute("DROP TABLE IF EXISTS ACCOUNT");
        stmt.executeQuery("create table account"+"(Account int, FirstName varchar(10), LastName varchar(10),balance float");
        }catch(SQLException ex){
            System.err.println("SQLException"+ex.getMessage());
        
        }



        //this part is for console
        ArrayList<Account> accList2=new ArrayList();
        readObj read= new readObj();
        accList2=read.readAndPrintFileForConsole();
        SaveObj saveConsole=new SaveObj();
        
        saveConsole.TypeByConsole(accList2);
        
        read.readAndPrintFileForConsole();
        System.out.println("\nRead Account Object From File");
        System.out.println(read.readAndPrintFileForConsole().toString());
    
        try{
            if(stmt!=null)stmt.close();
            if(con!=null)con.close();
            System.out.println("MySQL connection finished!");
    }catch(Exception ex){
        System.err.println("SQLException in closing "+ ex.getMessage());
    }
    
    
    }
    
}

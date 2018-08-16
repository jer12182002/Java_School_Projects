/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;



/**
 *
 * @author Jason
 */
public class SaveObj{

    
   public void TypeByConsole(ArrayList<Account> accList2){
       int account= 0;
       String firstN;
       String lastN;
       double bal=0;
       String keepAdd="Y";
       while(true){
       
       System.out.println("Account:");
       Scanner scan=new Scanner(System.in);
       try{
           account=scan.nextInt();
       }catch(Exception ex){
           System.out.println("Wrong Account format!");
       }
       
       System.out.println("First Name:");
           firstN=scan.next();
       
       System.out.println("Last Name:");
           lastN=scan.next();
       System.out.println("Balance:");
        try{
           bal=scan.nextDouble();
       }catch(Exception ex){
           System.out.println("Invalid balance");
       }
        
        accList2.add(new Account(account,firstN,lastN,bal));
       try {
            ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("console.txt"));
            obj.writeObject(accList2);            
            obj.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveObj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Add One More!?? Type N/n to quit program");
        keepAdd=scan.next();
        if(keepAdd.contains("n")||keepAdd.contains("N")){
            break;
        }
       }
   }
   
    public void UserTypeAccInfo(int acc, String firstName,String lastName,double balance, ArrayList<Account> accList){

        accList.add(new Account(acc,firstName,lastName,balance));
       
         try {
            ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("test.txt"));
            obj.writeObject(accList);            
            obj.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveObj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveObj.class.getName()).log(Level.SEVERE, null, ex);
        }
         //out.println("object writted to file!!");
    }
    
    
    
    
}

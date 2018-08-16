/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class readObj {
    public ArrayList<Account> readAndPrintFile() {
        ArrayList<Account> accList=new ArrayList();
       // out.println("read file!!!!");
        try {
            ObjectInputStream oin=new ObjectInputStream(new FileInputStream("test.txt"));
            accList=(ArrayList<Account>) oin.readObject();
            oin.close();
            return accList;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(readObj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(readObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        //out.println(accList.toString().replace('[',' ').replace(']',' ').trim());
        return accList;
    }
    
    
    public ArrayList<Account> readAndPrintFileForConsole() {
        ArrayList<Account> accList=new ArrayList();
       // out.println("read file!!!!");
        try {
            ObjectInputStream oin=new ObjectInputStream(new FileInputStream("console .txt"));
            accList=(ArrayList<Account>) oin.readObject();
            oin.close();
            return accList;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(readObj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(readObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        //out.println(accList.toString().replace('[',' ').replace(']',' ').trim());
        return accList;
    }
    
    
}

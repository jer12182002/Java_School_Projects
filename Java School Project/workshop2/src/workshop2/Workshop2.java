/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

import java.util.ArrayList;
public class Workshop2 {

    
    public static void main(String[] args) {
        ArrayList<Account> accList=new ArrayList();
        accList=new readObj().readAndPrintFile();
        new frame(accList);
        
        
        //this part is for console
        ArrayList<Account> accList2=new ArrayList();
        readObj read= new readObj();
        accList2=read.readAndPrintFileForConsole();
        SaveObj saveConsole=new SaveObj();
        
        saveConsole.TypeByConsole(accList2);
        
        read.readAndPrintFileForConsole();
        System.out.println("\nRead Account Object From File");
        System.out.println(read.readAndPrintFileForConsole().toString());
    }
    
}

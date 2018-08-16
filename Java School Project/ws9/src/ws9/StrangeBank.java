/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class StrangeBank extends Thread {

    private int bal = 0, count = 1;

    @Override
    public synchronized void run() {
       
        try {
            toSh();
        } catch (InterruptedException ex) {
            Logger.getLogger(StrangeBank.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            friWithD();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(StrangeBank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        count++;
        
        
        
    }

    public synchronized void toSh() throws InterruptedException {
       Thread.yield(); 
        Thread.sleep(1000);
        System.out.println("Ready to send money to shared!!" + Thread.currentThread().getName());
        bal += count;
        System.out.println(Thread.currentThread().getName() + ": $" + bal + " sent to shared account!");
        notify();
        
    }

    public synchronized void friWithD() throws InterruptedException {
        System.out.println("Friend is ready to take out money!!");
        while (bal == 0) {
            System.out.println("No money in shared account!!");
            wait();
        }

        System.out.println("Friend takes out " + Thread.currentThread().getName() + ": $" + bal + " from shared Account");
        bal -= count;
        System.out.println("==============================\n");
   
        //notify();
        
    }
    
}

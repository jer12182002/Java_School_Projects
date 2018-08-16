/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws9;

import java.util.*;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class Ws9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        final StrangeBank sb = new StrangeBank();
        
        Thread t1 = new Thread(sb, "CND");
        Thread t2 = new Thread(sb, "POND");
        Thread t3 = new Thread(sb, "EU");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        
        
    }
}

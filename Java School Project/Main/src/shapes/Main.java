/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jason
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        String fileName = "shapes.txt";
        //ArrayList<Shape> shapes = new ArrayList<Shape>();
        Shape[] shapes = new Shape[100];
        
        int count = 0;
        double STriP = 200, LCirP = 0, ParaP = 0, Trip = 0;

       // System.out.println("------->JAC 444 Assignment 1<-------");
       // System.out.println("------->Task 1 ... <-------");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");
                if (tokens[0].matches("Circle") && tokens.length == 2) {
                    if (Double.parseDouble(tokens[1]) > 0) {
                        try {

                            //shapes.add(new Circle(Double.parseDouble(tokens[1])));
                            shapes[count] = new Circle(Double.parseDouble(tokens[1]));
                            if (shapes[count].perimeter() > LCirP) {
                                LCirP = shapes[count].perimeter();
                            }
                            count++;
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Invalid radius!");
                    }
                } else if (tokens[0].matches("Parallelogram") && tokens.length == 3) {
                    if (Double.parseDouble(tokens[1]) > 0 && Double.parseDouble(tokens[2]) > 0) {
                        try {
                            //shapes.add(new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                            shapes[count] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                            count++;

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Invalid side(s)!");
                    }

                } else if (tokens[0].matches("Rectangle") && tokens.length == 3) {
                    if (Double.parseDouble(tokens[1]) > 0 && Double.parseDouble(tokens[2]) > 0) {
                        try {
                            // shapes.add(new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                            shapes[count] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                            count++;
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Invalid side(s)!");
                    }

                } else if (tokens[0].matches("Square") && tokens.length == 2) {
                    if (Double.parseDouble(tokens[1]) > 0) {
                        try {
                            //shapes.add(new Square(Double.parseDouble(tokens[1])));
                            shapes[count] = new Square(Double.parseDouble(tokens[1]));
                            count++;
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Invalid side!");
                    }

                } else if (tokens[0].matches("Triangle") && tokens.length == 4) {
                    Double a = Double.parseDouble(tokens[1]);
                    Double b = Double.parseDouble(tokens[2]);
                    Double c = Double.parseDouble(tokens[3]);
                    if (a > 0 && b > 0 && c > 0) {
                        if (a + b > c && a + c > b && c + b > a) {
                            try {
                                shapes[count] = new Triangle(a, b, c);
                                if (shapes[count].perimeter() < STriP) {
                                    STriP = shapes[count].perimeter();
                                }
                                count++;

                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } else {
                        System.out.println("Invalid side(s)!");
                    }
                }

            }
            
            
            
            
            
            System.out.println("\"------->JAC 444 Assignment 4<-------\"");
            System.out.println("\n" + count + " shapes were created:");
            for (int i=0;i<count;i++){
                if(shapes[i] instanceof Circle){
                    
                    ((Circle) shapes[i]).areaCir.printArea();
//                    new Circle(shapes[i].perimeter()).areaCir.printArea();
                }
                  
                            
                System.out.println(shapes[i].toString());
                
                
            }
            
//
//            for (int i = 0; i < count; i++) {
//                if (shapes[i].perimeter() == LCirP && shapes[i] instanceof Circle) {
//                    for (int k = i; k < count; k++) {
//                        shapes[k] = shapes[k + 1];
//                    }
//                    count--;
//                }
//                if (shapes[i].perimeter() == STriP && shapes[i] instanceof Triangle) {
//
//                    for (int k = i; k < count; k++) {
//                        shapes[k] = shapes[k + 1];
//                    }
//                    count--;
//                }
//            }
//
//            
//          
//            System.out.println("\n\n"+"------->Task 2 ... <-------");
//            System.out.println("\n" + count + " shapes were created:");
//            
//            
//            for (int i = 0; i < count; i++) {
//                if(shapes[i] instanceof Parallelogram){
//                    if(!(shapes[i] instanceof Rectangle)){
//                        ParaP+=shapes[i].perimeter();
//                    }
//                }
//                if(shapes[i] instanceof Triangle){
//                    Trip+=shapes[i].perimeter();
//                }
//                
//                System.out.println(shapes[i].toString());
//            }
//
//            
//            System.out.println("\n\n" + "------->Task 3 ... <-------");
//            System.out.println("Total perimeter of Parallelogram is: " + ParaP);
//            System.out.println("Total perimeter of Triangle is: " + Trip);
//            
//            
            
           
                             
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}

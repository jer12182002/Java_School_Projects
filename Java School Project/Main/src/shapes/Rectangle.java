/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

public class Rectangle extends Parallelogram {
        public calculateArea areaRect=()->System.out.println("Area: "+width*height);

    
//    public double printArea(){
//            calculateArea areaRect=()->width*height;
//            return areaRect.printArea();
//        }
        public Rectangle(double w, double h) {
		super(w, h);
	}

	@Override
	public String toString() {
		return ( "Rectangle {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + perimeter() );
	}
}

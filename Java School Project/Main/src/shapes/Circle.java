/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;
import static java.lang.Math.PI;

/**this class creates a shape of type circle */
public class Circle implements Shape {
	private double radius;
    /**
     *
     */
        
          public calculateArea areaCir = () -> System.out.println("Area: "+radius*radius*PI);
//    public double printArea(){
//        calculateArea areaCir=()-> (radius*radius*PI);
//        return areaCir.printArea();
//    }
//            
        



	public Circle(double r) {
		
            radius = r;
	
        }

    /**
     *
     * @param r
     */
    public void setRadius(double r) {
            if(r>0){
            try{
                radius = r;
            }catch(Exception ex){
                System.out.println("Invalid radius!");
            }
            }
        }
        
    /**
     *
     * @return
     */
    public double getRadius() {
		return radius;
	}

	

	@Override
	public double perimeter() {
		return radius * 2 * PI;
	}

	@Override
	public String toString() {
		return ("Circle {r=" + getRadius() + "} perimeter = " + perimeter() );
	}
        
        
}

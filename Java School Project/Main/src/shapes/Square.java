/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

public class Square extends Rectangle{

  public calculateArea areaSq=()->System.out.println("Area: "+width*height);
        
//	public double printArea(){
//            calculateArea areaS=()->width*height;
//            return areaS.printArea();
//        }

	public Square(double l) {
		super(l, l);
	}

	@Override
        public void setWidth(double w){
            if(w>0){
                try{
                    super.setWidth(w);
                    super.setHeight(w);
                }catch(Exception ex){
                    System.out.println("Invalid lengh!");
                }
            }
        }
	public String toString() {
		return ("Square {s=" + getWidth()  + "} perimeter = " + perimeter());
	}

}

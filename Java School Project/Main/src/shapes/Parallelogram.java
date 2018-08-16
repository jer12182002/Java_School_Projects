/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

public class Parallelogram implements Shape {

    protected double width;
    protected double height;

    public Parallelogram(double w, double h) {
        width = w;
        height = h;
    }

    public void setWidth(double w) {
        if (w > 0) {
            try {
                width = w;
            } catch (Exception ex) {
                System.out.println("Invalid width:");
            }
        }
    }

    public void setHeight(double h) {
        if (h > 0) {
            try {
                height = h;
            } catch (Exception ex) {
                System.out.println("Invalid height!");
            }
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return ("Parallelogram {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + perimeter() + "\n");
    }

    @Override
    public double perimeter() {
        return (width * 2) + height * 2;
    }

}

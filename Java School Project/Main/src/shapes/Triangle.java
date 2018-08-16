/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

public class Triangle implements Shape {

    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle(double a, double b, double c) {

        aSide = a;
        bSide = b;
        cSide = c;

    }

    public void setASide(double a) {
        if (a > 0) {
            try {
                aSide = a;
            } catch (Exception ex) {
                System.out.println("Invalid length!");
            }
        }
    }

    public void setBSide(double b) {
        if (b > 0) {
            try {
                bSide = b;
            } catch (Exception ex) {
                System.out.println("Invalid length!");
            }

        }
    }

    public void setC(double c) {
        if (c > 0) {
            try {
                cSide = c;
            } catch (Exception ex) {
                System.out.println("Invalid length!");
            }

        }
    }

    public double getASide() {
        return aSide;
    }

    public double getBSide() {
        return bSide;
    }

    public double getCSide() {
        return cSide;
    }

    @Override
    public double perimeter() {
        return aSide + bSide + cSide;
    }

    @Override
    public String toString() {
        return ("Triangle {s1=" + getASide() + ", s2=" + getBSide() + ", s3=" + getCSide() + "} perimeter = " + perimeter() + "\n");
    }

}

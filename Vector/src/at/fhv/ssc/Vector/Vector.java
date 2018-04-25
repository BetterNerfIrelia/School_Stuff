package at.fhv.ssc.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class Vector {

    private int _x1;
    private int _y1;
    private int _x2;
    private int _y2;
    private double _angle;          // Winkel
    private double _length;         // Laenge
    private double _slopeK;		    // Steigung
    private double _interceptD;	    // Konstante

    public Vector(int x1, int y1) { //1 Punkt. Laenge wird berechnet.
        _x1 = x1;
        _y1 = y1;
        _length = sqrt((x1*x1)+(y1*y1));
    }

    public Vector(int x1, int y1, int x2, int y2) { //2 Punkte. Laenge wird berechnet.
        _x1 = x1;
        _y1 = y1;
        _x2 = x2;
        _y2 = y2;
        _length = sqrt((x1*x1)+(y1*y1));
    }

    public Vector(double angle, double length) { //Winkel und Laenge. X und Y werden berechnet.
        _angle = angle;
        _length = length;
        _x1 = (int) (length * cos(angle));
        _x2 = (int) (length * sin(angle));
    }

    public void normalVector(){ //Normalvektor: Stellen vertauschen, obere minus 1.
       int temp = getX1();
       _x1 = getY1()*(-1);
       _y1 = temp;
    }

    public void scalarMultiplication(int scalar){ // Multiplikation mit einer Zahl.
        _x1 = (getX1())*scalar;
        _y1 = (getY1())*scalar;
    }

    public void linearEquation(double slope, double intercept) { //Geradengleichung(y=kx+d), wenn k und d bekannt.
        _slopeK = slope;
        _interceptD = intercept;
    }

    public void linearEquation() {                              //Geradengleichung(y=kx+d), wenn k und d unbekannt, werden dann erst ausgerechnet.
        _slopeK = (getY1() - getY2()) / (getX1() - getX2());
        _interceptD = getY1() - (_slopeK * getX1());
    }

    public double solve(double x) {
        return _slopeK * x + _interceptD;
    }  //Lösung der Geradengleichung berechnen.

    public int getX1() {                                                 //alle getter und setter.
        return _x1;
    }

    public void setX1(int x1) {
        _x1 = x1;
    }

    public int getY1() {
        return _y1;
    }

    public void setY1(int y1) {
        _y1 = y1;
    }

    public int getX2() {
        return _x2;
    }

    public void setX2(int x2) {
        _x2 = x2;
    }

    public int getY2() {
        return _y2;
    }

    public void setY2(int y2) {
        _y2 = y2;
    }

    public double getAngle() {
        return _angle;
    }

    public void setAngle(int angle) {
        _angle = angle;
    }

    public double getLength() {
        return _length;
    }

    public void setLength(int length) {
        _length = length;
    }

    public double getSlope() {
        return _slopeK;
    }

    public double getIntercept() {
        return _interceptD;
    }

}

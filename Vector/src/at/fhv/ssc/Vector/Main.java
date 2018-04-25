package at.fhv.ssc.Vector;

public class Main {

    public static void main(String[] args) {

        Vector vectoreins = new Vector(90.0, 10.0);
        Vector vectorzwei = new Vector(3, 2, 1, 1);
        Vector vectordrei = new Vector(5,5, 1,1);

        System.out.println("X1: " + vectoreins.getX1() + " Y1: " + vectoreins.getY1() + " X2: " + vectoreins.getX2() + " Y2: " + vectoreins.getY2() + " Angle: " + vectoreins.getAngle() + " Length: " + vectoreins.getLength());
        System.out.println("X1: " + vectorzwei.getX1() + " Y1: " + vectorzwei.getY1() + " X2: " + vectorzwei.getX2() + " Y2: " + vectorzwei.getY2() + " Angle: " + vectorzwei.getAngle() + " Length: " + vectorzwei.getLength());
        System.out.println("X1: " + vectordrei.getX1() + " Y1: " + vectordrei.getY1() + " X2: " + vectordrei.getX2() + " Y2: " + vectordrei.getY2() + " Angle: " + vectordrei.getAngle() + " Length: " + vectordrei.getLength());

        vectorzwei.scalarMultiplication(2);
        System.out.println("Skalarmultiplikation X1: " + vectorzwei.getX1() + " Y1: " + vectorzwei.getY1());

        vectorzwei.normalVector();
        System.out.println("Normal X1: " + vectorzwei.getX1() + " Normal Y1: " + vectorzwei.getY1());

        vectorzwei.linearEquation(10,10);
        System.out.println("Slope: " + vectorzwei.getSlope());
        System.out.println("Intercept: " + vectorzwei.getIntercept());

        System.out.println("Solve: " + vectorzwei.solve(2.0));

        vectordrei.linearEquation();
        System.out.println("Slope: " + vectordrei.getSlope());
        System.out.println("Intercept: " + vectordrei.getIntercept());

        System.out.println("Solve: " + vectordrei.solve(2.0));
    }


}

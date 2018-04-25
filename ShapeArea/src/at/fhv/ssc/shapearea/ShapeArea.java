package at.fhv.ssc.shapearea;

/**
 * Created by sebastian on 29.04.2017.
 */
public class ShapeArea {

    public ShapeArea() {
    }

    int shapeArea(int n) {

        int shapeCounter = 1;

        for(int i = 1;i<n;i++){
            shapeCounter = shapeCounter + (4 * (n-i));
        }
        return shapeCounter;
    }


}

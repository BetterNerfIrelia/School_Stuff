package at.fhv.ssc.soccerdisplay;

import java.awt.*;

/**
 * Created by sebastian on 05.09.2017.
 */


public class BinaryPanel extends Panel{

    private BitCanvas _canvas;

public BinaryPanel() {





}

    public void setNumber (int score){
        boolean[] bits = getBitRepresentation(score);

        for (int i = bits.length-1; i >= 0; i--) {
            add(new BitCanvas(bits[i]));

                }

    }


    public boolean[] getBitRepresentation (int number){
        return new boolean[]{false, true};
    }



}


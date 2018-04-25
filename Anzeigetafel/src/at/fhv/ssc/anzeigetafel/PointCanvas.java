package at.fhv.ssc.anzeigetafel;

import java.awt.*;

/**
 * Created by sebastian on 28.06.2017.
 */
public class PointCanvas extends Canvas {


    public PointCanvas() {
        setSize(50,50);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(0,0,30,30);

    }
}

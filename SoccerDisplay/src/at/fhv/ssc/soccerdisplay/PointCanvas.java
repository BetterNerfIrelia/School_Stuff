package at.fhv.ssc.soccerdisplay;

import java.awt.*;

/**
 * Created by sebastian on 05.09.2017.
 */
public class PointCanvas extends Canvas {

    public PointCanvas() {
        setSize(10, 10);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(0, 0, 10, 10);
    }
}

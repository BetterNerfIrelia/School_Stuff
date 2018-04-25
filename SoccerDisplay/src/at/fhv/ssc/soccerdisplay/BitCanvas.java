package at.fhv.ssc.soccerdisplay;

import java.awt.*;

/**
 * Created by sebastian on 05.09.2017.
 */
public class BitCanvas extends Canvas{

    private boolean _test;

    public BitCanvas(boolean test) {
        _test = test;
        setSize(10, 10);
    }

    @Override
    public void paint(Graphics g) {

            if (_test) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 10, 10);
            } else {
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, 9, 9);
            }

    }

    public boolean isTest() {
        return _test;
    }

    public void setTest(boolean test) {
        _test = test;
    }
}
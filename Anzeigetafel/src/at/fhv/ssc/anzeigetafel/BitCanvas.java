package at.fhv.ssc.anzeigetafel;

import java.awt.*;

/**
 * Created by sebastian on 28.06.2017.
 */
public class BitCanvas extends Canvas {


    public BitCanvas() {
        setSize(50,50);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,40,40);

    }

    public void setScore(Graphics g){
        //g.setColor(Color.WHITE);
       // g.fillRect(0,0,40,40);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,40,40);

    }
}

package at.fhv.ssc.fastfood;

/**
 * Created by sebastian on 05.09.2017.
 */

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Customer orders meal out of stock > get number.
 * If meal is ready > show number + name on frame.
 * Remote (sockets).
 */
public class FastFood {

    private Label _meal;


    public FastFood() {

        Frame f = new Frame();
        f.setSize(500, 500);
        f.setLocation(500, 500);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setLayout(new BorderLayout());
        Panel center = new Panel();
        f.add(center, BorderLayout.CENTER);

        Label meal = new Label();
        center.add(meal);
        _meal = meal;

        f.pack();
        f.setVisible(true);

    }

        public void setMeal(String input){
        _meal.setText(input);
        }


}



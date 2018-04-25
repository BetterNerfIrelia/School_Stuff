package at.fhv.ssc.anzeigetafel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by sebastian on 28.06.2017.
 */
public class ScoreBoard {
    public ScoreBoard() {
        Frame f = new Frame();
        f.setSize(500,500);
        f.setTitle("Anzeigetafel");
        f.setLocation(600,200);
        f.setBackground(Color.LIGHT_GRAY);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setLayout(new BorderLayout());
        Panel oben = new Panel();
        Panel mitte = new ColonPanel();
        Panel unten = new Panel();
        f.add(oben, BorderLayout.NORTH);
        f.add(mitte, BorderLayout.CENTER);
        f.add(unten, BorderLayout.SOUTH);
        Label home = new Label("HOME:");
        Label guest = new Label("GUEST:");

        oben.add(home);
        unten.add(guest);

        ColonPanel dots = new ColonPanel();

        BitPanel homebit = new BitPanel();
        BitPanel guestbit = new BitPanel();

        oben.add(homebit);
        unten.add(guestbit);

        f.validate();
        f.pack();
        f.setVisible(true);


    }


    public void setScoreHome(Graphics g){
        //g.setColor(Color.WHITE);
        // g.fillRect(0,0,40,40);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,40,40);

    }
}

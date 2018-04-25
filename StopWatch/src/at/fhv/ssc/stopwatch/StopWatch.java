package at.fhv.ssc.stopwatch;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sebastian on 02.09.2017.
 */
public class StopWatch {

    private Timer _timer;
    private int _minute = 0;
    private int _sekunde = 0;



public StopWatch(){

    Frame f = new Frame();
    f.setSize(100,100);
    f.setLocation(500,500);

    f.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            f.dispose();
        }
    });

    f.setLayout(new BorderLayout());
    Panel north = new Panel();
    f.add(north, BorderLayout.NORTH);
    Panel center = new Panel();
    f.add(center, BorderLayout.CENTER);

    center.setLayout(new FlowLayout(FlowLayout.RIGHT));

    Label time = new Label(String.valueOf(_minute) + " : " + String.valueOf(_sekunde));
    north.add(time);

    Button start = new Button("Start");
    center.add(start);

    Button stop = new Button ("Stop");
    stop.setEnabled(false);
    center.add(stop);


    start.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            _minute = 0;
            _sekunde = 0;
            start.setEnabled(false);
            stop.setEnabled(true);


            _timer = new Timer();
            _timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if(_sekunde == 60){_minute++;
                    _sekunde = 0;
                    }
                    time.setText(_minute + " : " + _sekunde++);

                }
            },1000,1000
            );
        }
    });

    stop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            stop.setEnabled(false);
            start.setEnabled(true);

            _timer.cancel();
        }
    });

    f.pack();
    f.setVisible(true);
}

}




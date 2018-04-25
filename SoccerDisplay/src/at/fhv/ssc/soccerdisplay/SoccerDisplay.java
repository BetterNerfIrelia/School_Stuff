package at.fhv.ssc.soccerdisplay;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by sebastian on 05.09.2017.
 */
public class SoccerDisplay {

    private String _score;
    private BinaryPanel _panelvisitor;
    private BinaryPanel _panelhome;


    public SoccerDisplay(){

        Frame f = new Frame();
        f.setSize(500,500);
        f.setLocation(500,500);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();            }
        });


        f.setLayout(new BorderLayout());
        Panel north = new Panel();
        Panel center = new Panel();
        Panel south = new Panel();
        f.add(north, BorderLayout.NORTH);
        f.add(center, BorderLayout.CENTER);
        f.add(south, BorderLayout.SOUTH);

        Label home = new Label("HOME");
        north.add(home);

        Label visitor = new Label("VISITOR");
        south.add(visitor);

        PointCanvas point1 = new PointCanvas();
        PointCanvas point2 = new PointCanvas();

        center.add(point1);
        center.add(point2);

        BinaryPanel panelvisitor = new BinaryPanel();
        _panelvisitor = panelvisitor;

        BinaryPanel panelhome = new BinaryPanel();
        _panelhome = panelhome;

        north.add(panelhome);
        south.add(panelvisitor);


        f.pack();
        f.setVisible(true);





    }



    public void setScore(String score) {   // format: "00:00"
        _score = score;
        _panelvisitor.setNumber(2);
        _panelhome.setNumber(2);


    }

}

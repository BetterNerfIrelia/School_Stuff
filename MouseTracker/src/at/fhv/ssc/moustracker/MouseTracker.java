package at.fhv.ssc.moustracker;

import java.awt.*;
import java.awt.event.*;

/**
 * X-position, Y-position (0/0 is top, left) and type of mouse-movement (moved, dragged) shown in 3 textfields.
 */
public class MouseTracker {

    public MouseTracker() {

        Frame f = new Frame();
        f.setSize(500,500);
        f.setTitle("MouseTracker");
        f.setLocation(500,500);
        f.setBackground(Color.BLACK);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setLayout(new BorderLayout());


        Panel north = new Panel();
        f.add(north, BorderLayout.NORTH);

        Label xLabel = new Label("X:");
        xLabel.setForeground(Color.WHITE);
        north.add(xLabel);

        TextField xText = new TextField();
        north.add(xText);

        Label yLabel = new Label("Y:");
        yLabel.setForeground(Color.WHITE);
        north.add(yLabel);

        TextField yText = new TextField();
        north.add(yText);

        Label tLabel = new Label("Type:");
        tLabel.setForeground(Color.WHITE);
        north.add(tLabel);

        TextField tText = new TextField("      ");
        tText.setSize(50,50);

        north.add(tText);

        f.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                xText.setText(String.valueOf(e.getX()-11));
                yText.setText(String.valueOf(e.getY()-78));
                tText.setText("dragged");
                tText.setBackground(Color.GREEN);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xText.setText(String.valueOf(e.getX()-11));
                yText.setText(String.valueOf(e.getY()-78));
                tText.setText("moved");
                tText.setBackground(Color.BLUE);

            }
        });

        f.setVisible(true);





    }
}

/**
 textSouth.addKeyListener(new KeyListener() {
@Override
public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

        liste.add(textSouth.getText());
        textSouth.setText("");
        }
        }



f.addMouseWheelListener();
f.addMouseMotionListener();
*/



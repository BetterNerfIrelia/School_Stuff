
package at.fhv.ssc.graphplotter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.*;


public class Main {

    private static TextArea chatText;
    private static TextField input;
    private static Canvas canvas;

    public static void main(String[] args) {
        Frame f = new Frame(); //create new window


        f.addWindowListener(new WindowListener() { //reacts to the window (opening, closing...)

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window Openend");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing");
                e.getWindow().dispose();

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Closed");

            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Window Icon");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window Deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window Deactivated");
            }
        });


        f.setSize(200, 200);
        f.setTitle("My GraphPlotter");
        f.setLocation(600, 200); //window-location on screen
        //f.setExtendedState(Frame.MAXIMIZED_BOTH); //full-screen
        f.setBackground(Color.LIGHT_GRAY);

        f.setLayout(new BorderLayout()); //five regions: center, north, south, east, west

        //TextArea tf = new TextArea();
       // tf.setPreferredSize(new Dimension(100, 200));

        Panel center = new Panel(); //new panel center
        center.setLayout(new BorderLayout());


       // chatText = new TextArea();
       // center.add(chatText, BorderLayout.CENTER);



        Panel canvas = new Graphpannel(600,600);
        canvas.setPreferredSize(new Dimension(600,600));
        center.add(canvas, BorderLayout.CENTER);
        canvas.setBackground(Color.WHITE);
        canvas.setVisible(true);

        // center.setBackground(Color.red);

        f.add(center, BorderLayout.CENTER);

        Panel north = new Panel(); //new panel north
        TextField x2 = new TextField();
        TextField x = new TextField();
        TextField d = new TextField();
        Button enter = new Button();
        enter.setLabel("Plot");
        enter.setPreferredSize(new Dimension(100, 15));

        north.add(new Label("f(x)="));
        north.add(x2);
        north.add(new Label("* x^2 +"));
        north.add(x);
        north.add(new Label("* x +"));
        north.add(d);
        north.add(enter);

        center.add(north, BorderLayout.NORTH);

        f.pack();
        f.setVisible(true);







    }


}


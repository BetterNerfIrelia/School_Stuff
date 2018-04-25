package at.fhv.ssc.randomizer;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sebastian on 23.08.2017.
 */
public class Randomizer {

    private Timer _timer;

    public Randomizer() {

        Frame frame = new Frame();
        frame.setSize(500, 500);
        frame.setTitle("Randomizer");
        frame.setLocation(500, 500);
        frame.setBackground(Color.DARK_GRAY);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        MenuBar menu = new MenuBar();
        frame.setMenuBar(menu);
        Menu datei = new Menu("Datei");
        menu.add(datei);
        MenuItem schliessen = new MenuItem("Schliessen");
        datei.add(schliessen);
        schliessen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setLayout(new BorderLayout());

        Panel center = new Panel();
        frame.add(center, BorderLayout.CENTER);

        Panel south = new Panel();
        frame.add(south, BorderLayout.SOUTH);

        Panel east = new Panel();
        frame.add(east, BorderLayout.EAST);

        Panel north = new Panel();
        frame.add(north, BorderLayout.NORTH);

        Panel west = new Panel();
        frame.add(west, BorderLayout.WEST);

        Label slotmachine = new Label("                                                  ");
        slotmachine.setBackground(Color.WHITE);
        slotmachine.setSize(new Dimension(200, 200));
        slotmachine.validate();
        north.add(slotmachine);

        List liste = new List();
        liste.setBackground(Color.LIGHT_GRAY);

        liste.setPreferredSize(new Dimension(100, 100));
        center.add(liste);

        TextField textSouth = new TextField();
        textSouth.setBackground(Color.LIGHT_GRAY);
        textSouth.setPreferredSize(new Dimension(300, 30));
        south.add(textSouth);
        textSouth.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {

                    liste.add(textSouth.getText());
                    textSouth.setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

            Button buttonAdd = new Button();
            buttonAdd.setLabel("Add!");
            buttonAdd.setPreferredSize(new Dimension(100, 30));
            buttonAdd.setForeground(Color.WHITE);
            buttonAdd.setBackground(Color.BLACK);
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    liste.add(textSouth.getText());
                    textSouth.setText("");

                }
            });

            south.add(buttonAdd);

            Button buttonClear = new Button();
            buttonClear.setLabel("Clear!");
            buttonClear.setPreferredSize(new Dimension(100,30));
            buttonClear.setForeground(Color.WHITE);
            buttonClear.setBackground(Color.BLACK);
            buttonClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    liste.removeAll();
                }
            });

            south.add(buttonClear);

            Button buttonStart = new Button();
            buttonStart.setLabel("START");
            buttonStart.setPreferredSize(new Dimension(100,100));
            buttonClear.setForeground(Color.WHITE);
            buttonClear.setBackground(Color.BLACK);;
            buttonStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonStart.setEnabled(false);
                    _timer = new Timer();

                    _timer.scheduleAtFixedRate(new TimerTask() {
                    int i = 0;
                        @Override
                        public void run() {
                            if(i == liste.getItemCount()){
                            i = 0;}
                            slotmachine.setText(liste.getItem(i));
                            i++;


                        }
                    },0,50
                    );

                }

            });
            east.add(buttonStart);

            Button buttonStop = new Button();
            buttonStop.setLabel("STOP!");
            buttonStop.setPreferredSize(new Dimension(100, 100));
            buttonStop.setForeground(Color.WHITE);
            buttonStop.setBackground(Color.BLACK);
            buttonStop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonStart.setEnabled(true);


                    int i = (liste.getItemCount());
                    int j = (int) Math.floor(Math.random() * i);

                    Label dialogLabel = new Label(liste.getItem(j));
                    dialogLabel.setBackground(Color.BLACK);
                    dialogLabel.setForeground(Color.WHITE);
                    _timer.cancel();
                    slotmachine.setText(liste.getItem(j));


                }
            });

            east.add(buttonStop);

            frame.pack();
            frame.setVisible(true);






    }
}

package at.fhv.ssc.gameoflife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sebastian on 15.10.2017.
 */
public class Game {

    private static int _dimensionX;
    private static int _dimensionY;
    private Entity[][] _entities;
    private Rules _rules;
    private TextArea _textArea;
    private Timer _timer;

    private class Rules {

        public Rules() {

        }


        public void applyRules(int time) {


            for(int t= time; t>0; t--){

                Entity[][] newGeneration = new Entity[_dimensionY + 2][_dimensionY + 2];

                int j = 0;

                while (j < _dimensionY + 2) {

                    for (int i = 0; i < _dimensionX + 2; i++) {
                        newGeneration[i][j] = new Entity(false);
                    }
                    j++;

                }

                j = 1;

                while (j < _dimensionY + 1) {


                    for (int i = 1; i < _dimensionX + 1; i++) {
                        Entity e = _entities[i][j];

                        if (e.isAlive()) {
                            if (checkNeighbours(i, j) == 2 || checkNeighbours(i, j) == 3) {
                                newGeneration[i][j] = new Entity(true);
                            }
                            if (checkNeighbours(i, j) < 2) {
                                newGeneration[i][j] = new Entity(false);
                            }
                            if (checkNeighbours(i, j) > 3) {
                                newGeneration[i][j] = new Entity(false);
                            }


                        } else {
                            if (checkNeighbours(i, j) == 3) {
                                newGeneration[i][j] = new Entity(true);
                            } else {
                                newGeneration[i][j] = new Entity(false);
                            }
                        }
                    }

                    j++;
                }
                _entities = newGeneration;
            }


        }

        public int checkNeighbours(int x, int y) {

            // bekommt entity, checkt wieviele nachbarn leben (8-ergebnis = wieviele tot sind)


            int check = 0;

            if (_entities[x - 1][y - 1].isAlive()) {
                check++;
            }
            if (_entities[x][y - 1].isAlive()) {
                check++;
            }
            if (_entities[x + 1][y - 1].isAlive()) {
                check++;
            }
            if (_entities[x - 1][y].isAlive()) {
                check++;
            }
            if (_entities[x + 1][y].isAlive()) {
                check++;
            }
            if (_entities[x - 1][y + 1].isAlive()) {
                check++;
            }
            if (_entities[x][y + 1].isAlive()) {
                check++;
            }
            if (_entities[x + 1][y + 1].isAlive()) {
                check++;
            }


            return check;
        }


    }


    public Game(int dimensionX, int dimensionY) {
        _dimensionX = dimensionX;
        _dimensionY = dimensionY;
        _entities = new Entity[_dimensionY][_dimensionY];  //+2?
        _rules = new Rules();


        Frame f = new Frame();

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setSize(500,500);
        f.setLocation(500,500);

        f.setLayout(new BorderLayout());

        Panel center = new Panel();
        f.add(center, BorderLayout.CENTER);

        Panel south = new Panel();
        f.add(south, BorderLayout.SOUTH);

        _textArea = new TextArea();
        _textArea.setSize(200,200);
        _textArea.validate();
        center.add(_textArea);


        Button start = new Button ("Start");
        south.add(start);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                _timer = new Timer();
                _timer.scheduleAtFixedRate(new TimerTask() {
                                               @Override
                                               public void run() {
                                                   generateWorld(1);
                                                   System.out.println();
                                                   showWorld();

                                               }
                                           },1000,1000
                );
            }
        });





        f.setVisible(true);
        f.pack();


    }





    public void showWorld() {
        int j = 1;

        while (j < _dimensionY + 1) {


            for (int i = 1; i < _dimensionX + 1; i++) {

                if (_entities[i][j].isAlive()) {
                    System.out.print("X ");
                    _textArea.append("X ");
                } else {
                    System.out.print("O ");
                    _textArea.append("O ");
                }
            }
            System.out.println();
            _textArea.append("\n");
            j++;
        }
    }

    public void generateWorld(int generations) {

      _rules.applyRules(1);

    }


    public static int get_dimensionX() {
        return _dimensionX;
    }

    public static int get_dimensionY() {
        return _dimensionY;
    }

    public Entity[][] getEntities() {
        return _entities;
    }

    public static void set_dimensionX(int _dimensionX) {
        Game._dimensionX = _dimensionX;
    }

    public static void set_dimensionY(int _dimensionY) {
        Game._dimensionY = _dimensionY;
    }

    public void setEntities(Entity[][] entities) {
        _entities = entities;
    }

    public Rules getRules() {
        return _rules;
    }

    public void setRules(Rules rules) {
        _rules = rules;
    }
}

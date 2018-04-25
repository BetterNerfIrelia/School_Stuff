package at.fhv.ssc.gameoflife2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sebastian on 15.10.2017.
 */
public class Game {

    private class Rules {                                                                          //inner class for the rules.

        public Rules() {

        }


        public void applyRules(int time) {


            for (int t = time; t > 0; t--) {

                Entity[][] newGeneration = new Entity[_dimensionY + 2][_dimensionY + 2];

                int j = 0;

                if (!_torus) {                                                                        //if no torus creates death-wall.

                    while (j < _dimensionY + 2) {

                        for (int i = 0; i < _dimensionX + 2; i++) {
                            newGeneration[i][j] = new Entity(false);
                        }
                        j++;

                    }
                }

                j = 1;

                while (j < _dimensionY + _start) {


                    for (int i = _start; i < _dimensionX + _start; i++) {
                        Entity e = _entities[i][j];

                        if (e.isAlive()) {                                                          //applies rules for living entities.
                            if (checkNeighbours(i, j) == 2 || checkNeighbours(i, j) == 3) {
                                newGeneration[i][j] = new Entity(true);
                            }
                            if (checkNeighbours(i, j) < 2) {
                                newGeneration[i][j] = new Entity(false);
                            }
                            if (checkNeighbours(i, j) > 3) {
                                newGeneration[i][j] = new Entity(false);
                            }


                        } else {                                                                    //applies rules for dead entities.
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
            if (_torus) {
                return (checkNeighboursTorus(x, y));
            } else {
                return (checkNeighboursNoTorus(x, y));
            }
        }


        public int checkNeighboursNoTorus(int x, int y) {

            // gets a single entity, checks how many of its 8 neighbours are alive.


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

        public int checkNeighboursTorus(int x, int y) {

            // gets a single entity, checks how many of its 8 neighbours are alive.

            int check = 0;
            int xlen = _entities.length;
            int ylen = _entities[0].length;


            if (_entities[(x - 1 + xlen) % xlen][(y - 1 + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x + xlen) % xlen][(y - 1 + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x + 1 + xlen) % xlen][(y - 1 + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x - 1 + xlen) % xlen][(y + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x + 1 + xlen) % xlen][(y + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x - 1 + xlen) % xlen][(y + 1 + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x + xlen) % xlen][(y + 1 + ylen) % ylen].isAlive()) {
                check++;
            }
            if (_entities[(x + 1 + xlen) % xlen][(y + 1 + ylen) % ylen].isAlive()) {
                check++;
            }

            return check;
        }


    }

    private static int _dimensionX;
    private static int _dimensionY;
    private Entity[][] _entities;
    private Rules _rules;
    private Timer _timer;
    private boolean _torus;
    private int _start;

    public Game(int dimensionX, int dimensionY, boolean torus) {
        _dimensionX = dimensionX;
        _dimensionY = dimensionY;
        _torus = torus;

        if (torus) {
            _start = 0;
        } else {
            _start = 1;
        }

        _entities = new Entity[_dimensionY][_dimensionY];
        _rules = new Rules();


    }

    public static int get_dimensionX() {
        return _dimensionX;
    }

    public static void set_dimensionX(int _dimensionX) {
        Game._dimensionX = _dimensionX;
    }

    public static int get_dimensionY() {
        return _dimensionY;
    }

    public static void set_dimensionY(int _dimensionY) {
        Game._dimensionY = _dimensionY;
    }

    public void showWorld() {                           //prints out the current world(generation).
        int j = 1;

        while (j < _dimensionY + 1) {


            for (int i = 1; i < _dimensionX + 1; i++) {

                if (_entities[i][j].isAlive()) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
            j++;
        }
    }

    public void generateGenerations(int generations) {          //chances world per n generations.

        _rules.applyRules(1);

    }

    public void live() {                                         //chances and prints the world every second per 1 generation.

        _timer = new Timer();
        _timer.scheduleAtFixedRate(new TimerTask() {
                                       @Override
                                       public void run() {
                                           generateGenerations(1);
                                           System.out.println();
                                           showWorld();

                                       }
                                   }, 1000, 1000
        );
    }

    public void kataklysm() {                                      //kills 50% of all living entities.

        int j = 0;


        while (j < _dimensionY + 2) {

            for (int i = 0; i < _dimensionX + 2; i++) {

                if (_entities[i][j].isAlive()) {
                    Random r = new Random();
                    int random = 0;
                    random = r.nextInt(2);
                    if (random > 0) {
                        _entities[i][j] = new Entity(false);
                    } else {
                        _entities[i][j] = new Entity(true);
                    }
                }

            }
            j++;
        }
    }


    public Entity[][] getEntities() {
        return _entities;
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

package at.fhv.ssc.gameoflife;

import java.util.Random;

/**
 * Created by sebastian on 15.10.2017.
 */
public class Entity {

    private boolean _alive;

    public Entity(boolean alive) {
        _alive = alive;
    }


    public Entity createRandomEntity() {

        Random r = new Random();
        int random = 0;
        random = r.nextInt(2);

        boolean alive;

        if (random > 0) {
            alive = true;
        } else {
            alive = false;
        }

        return new Entity(alive);
    }

    public Entity[][] createEntityMatrix(int x, int y) {
        Entity[][] entities = new Entity[x + 2][y + 2];

        int j = 0;

        while (j < y + 2) {

            for (int i = 0; i < x + 2; i++) {
                entities[i][j] = new Entity(false);
            }
            j++;

        }

        j = 1;

        while (j < y + 1) {

            for (int i = 1; i < x + 1; i++) {
                entities[i][j] = createRandomEntity();
            }
            j++;

        }
        return entities;
    }

    public boolean isAlive() {
        return _alive;
    }
}


package at.fhv.ssc.gameoflife;

/**
 * Created by sebastian on 15.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        int x = 5;
        int y = 5;

        Game game = new Game(x, y);
        Entity test = new Entity(true);
        Entity[][] testarry = test.createEntityMatrix(x, y);
        game.setEntities(testarry);

        game.showWorld();

        game.generateWorld(1);
        System.out.println();
        game.showWorld();


    }


}



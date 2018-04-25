package at.fhv.ssc.mud;

//überflüssige getter und setter am schluss weg

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Game game = new Game();
        //game.run();

        Player player1 = new Player(1, "Hugo");

        GameMap map = new GameMap();
        map.createMap();
        //map.print();

        player1.move(DIRECTION.EAST);

      //  System.out.println("Player 1 Position: " + player1.getPosition().toString());

      //  player1.leave();
        //player1.load(player1);

        /**
         Player is safed and loaded.
         */

        player1.move(DIRECTION.EAST);
        player1.safe(player1);
        player1.leave();
        player1.load(player1);
        player1.move(DIRECTION.EAST);

        /**
         GameMap is safed and loaded.
         */

        map.safe(map);
        map.load(map);





    }

}



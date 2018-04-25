package at.fhv.ssc.gameoflife2;

public class Main {

    public static void main(String[] args) {

        int x = 5;
        int y = 5;

        //-------------------------------------------------------------//


        Game game = new Game(x, y,false);
        Entity test = new Entity();
        Entity[][] testarry = test.createEntityMatrix(x, y);
        game.setEntities(testarry);

        //-------------------------------------------------------------//

        game.showWorld();

        game.generateGenerations(1);
        System.out.println();
        game.showWorld();

        //-------------------------------------------------------------//

        game.live();



    }


}



package fhv.ssc.Game;

public class Main {

    public static void main(String[] args) {
        Game ourGame = new Game();
        ourGame.addPlayer("Oliver");
        for(int i = 10; i<10; i++){
            ourGame.addRandomBeast();

        }
        ourGame.letTheCreaturesTalk();
    }
}

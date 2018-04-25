package fhv.ssc.Game;

public class Player extends Creature {

    private String _playerName;

    public Player(String playerName) {
        _playerName = playerName;
    }

    @Override
    public void say() {
        System.out.println("Hi, Im a Player.");
    }
}

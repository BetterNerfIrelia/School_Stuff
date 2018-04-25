package fhv.ssc.Game;

import java.util.List;
import java.util.ArrayList;


public class Game {
    private List <Creature> _creatures;

    public Game(){
        _creatures = new ArrayList<>();

    }

    public void addPlayer(String playername) {
        _creatures.add(new Player(playername));
    }

    public void addRandomBeast() {
        _creatures.add(new Donkey());
    }

    public void letTheCreaturesTalk() {
        for(Creature c : _creatures){            // enhanced for-loop
            c.say();
        }
     //   _creatures.forEach(x -> x.say());       lambda-expression
    }
}

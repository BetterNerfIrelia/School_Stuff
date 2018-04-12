package at.fhv.scc.tictactoe;

import java.util.Random;

public class OpponentRandom implements Opponent {

    private Game _game;

    public OpponentRandom() {

    }

    @Override
    public void play() {

        Random ran = new Random();
        int i = ran.nextInt(3);
        int j = ran.nextInt(3);


        if (_game.getGameField().getMatrix(i, j).isSet()) {
            play();
        } else {
            _game.getGameField().setMatrix(i, j, 'O');
            _game.getGameField().printGameField();
            if (_game.isWinner('O')) {
                System.out.println("Computer won!");
                _game.printSkull();
            }else if(_game.isDraw()){
                System.out.println("Draw!");
                _game.printSkull();
            }
        }
    }

    public boolean checkFinished() {

        if (_game.getGameField().getMatrix(0, 0).getValue() == 'O' && _game.getGameField().getMatrix(0, 1).getValue() == 'O' && _game.getGameField().getMatrix(0, 2).getValue() == 'O') {
            return true;
        }
        if (_game.getGameField().getMatrix(1, 0).getValue() == 'O' && _game.getGameField().getMatrix(1, 1).getValue() == 'O' && _game.getGameField().getMatrix(1, 2).getValue() == 'O') {
            return true;
        }
        if (_game.getGameField().getMatrix(2, 0).getValue() == 'O' && _game.getGameField().getMatrix(2, 1).getValue() == 'O' && _game.getGameField().getMatrix(2, 2).getValue() == 'O') {
            return true;
        }
        if (_game.getGameField().getMatrix(0, 0).getValue() == 'O' && _game.getGameField().getMatrix(1, 0).getValue() == 'O' && _game.getGameField().getMatrix(2, 0).getValue() == 'O') {
            return true;
        }
        if (_game.getGameField().getMatrix(0, 1).getValue() == 'O' && _game.getGameField().getMatrix(1, 1).getValue() == 'O' && _game.getGameField().getMatrix(2, 1).getValue() == 'O') {
            return true;
        }
        if (_game.getGameField().getMatrix(0, 2).getValue() == 'O' && _game.getGameField().getMatrix(1, 2).getValue() == 'O' && _game.getGameField().getMatrix(2, 2).getValue() == 'O') {
            return true;
        }
        if (_game.getGameField().getMatrix(0, 0).getValue() == 'O' && _game.getGameField().getMatrix(1, 1).getValue() == 'O' && _game.getGameField().getMatrix(2, 2).getValue() == 'O') {
            return true;
            }
        if (_game.getGameField().getMatrix(0, 2).getValue()=='X' && _game.getGameField().getMatrix(1, 1).getValue()=='X' && _game.getGameField().getMatrix(2, 0).getValue()=='X') {
            return true;
        } else {
            return false;
        }
    }

    public Game getGame() {
        return _game;
    }

    public void setGame(Game game) {
        _game = game;
    }
}

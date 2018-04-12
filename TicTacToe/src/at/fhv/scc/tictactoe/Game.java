package at.fhv.scc.tictactoe;

import java.util.LinkedList;

public class Game {

    //create a new game
    private GameField _gameField;
    private Opponent _opponent;
    private OpponentRandom _oponentRandom;
    private boolean _finished;
    private boolean _playersTurn;

    public boolean checkFinished() {

        if (getGameField().getMatrix(0, 0).getValue()=='X' && getGameField().getMatrix(0, 1).getValue()=='X' && getGameField().getMatrix(0, 2).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(1, 0).getValue()=='X' && getGameField().getMatrix(1, 1).getValue()=='X' && getGameField().getMatrix(1, 2).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(2, 0).getValue()=='X' && getGameField().getMatrix(2, 1).getValue()=='X' && getGameField().getMatrix(2, 2).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(0, 0).getValue()=='X' && getGameField().getMatrix(1, 0).getValue()=='X' && getGameField().getMatrix(2, 0).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(0, 1).getValue()=='X' && getGameField().getMatrix(1, 1).getValue()=='X' && getGameField().getMatrix(2, 1).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(0, 2).getValue()=='X' && getGameField().getMatrix(1, 2).getValue()=='X' && getGameField().getMatrix(2, 2).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(0, 0).getValue()=='X' && getGameField().getMatrix(1, 1).getValue()=='X' && getGameField().getMatrix(2, 2).getValue()=='X') {
            return true;
        }
        if (getGameField().getMatrix(0, 2).getValue()=='X' && getGameField().getMatrix(1, 1).getValue()=='X' && getGameField().getMatrix(2, 0).getValue()=='X') {
                return true;
        } else {
            return false;
        }
    }


    public boolean gameOver() {

        if (isWinner('O')) {
            return true;
        }
        if (isWinner('X')) {
            return true;
        }
        if (isDraw()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isWinner(char value) {

        SingleField[][]matrix = _gameField.getMatrix();


        if (matrix[0][0].getValue() == value && matrix[0][1].getValue() == value && matrix[0][2].getValue() == value) {
            return true;
        }
        if (matrix[1][0].getValue() == value && matrix[1][1].getValue() == value && matrix[1][2].getValue() == value) {
            return true;
        }
        if (matrix[2][0].getValue() == value && matrix[2][1].getValue() == value && matrix[2][2].getValue() == value) {
            return true;
        }
        if (matrix[0][0].getValue() == value && matrix[1][0].getValue() == value && matrix[2][0].getValue() == value) {
            return true;
        }
        if (matrix[0][1].getValue() == value && matrix[1][1].getValue() == value && matrix[2][1].getValue() == value) {
            return true;
        }
        if (matrix[0][2].getValue() == value && matrix[1][2].getValue() == value && matrix[2][2].getValue() == value) {
            return true;
        }
        if (matrix[0][0].getValue() == value && matrix[1][1].getValue() == value && matrix[2][2].getValue() == value) {
            return true;
        }
        if (matrix[0][2].getValue() == value && matrix[1][1].getValue() == value && matrix[2][0].getValue() == value) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDraw() {

        SingleField[][] matrix = _gameField.getMatrix();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j].getValue() == '-') {
                    return false;
                }

            }
        }
        return true;

    }


    public Game() {
        _gameField = new GameField();
    }

    public GameField getGameField() {
        return _gameField;
    }

    public void setGameField(GameField gameField) {
        _gameField = gameField;
    }

    public Opponent getOponent() {
        return _opponent;
    }

    public void setOponent(Opponent opponent) {
        _opponent = opponent;
    }

    public boolean isFinished() {
        return _finished;
    }

    public void setFinished(boolean finished) {
        _finished = finished;
    }

    public OpponentRandom getOponentRandom() {
        return _oponentRandom;
    }

    public void setOponentRandom(OpponentRandom oponentRandom) {
        _oponentRandom = oponentRandom;
    }

    public boolean isPlayersTurn() {
        return _playersTurn;
    }

    public void setPlayersTurn(boolean playersTurn) {
        _playersTurn = playersTurn;
    }

    public void printSkull(){
        System.out.println(
                "                 uuuuuuu\n" +
                "             uu$$$$$$$$$$$uu\n" +
                "          uu$$$$$$$$$$$$$$$$$uu\n" +
                "         u$$$$$$$$$$$$$$$$$$$$$u\n" +
                "        u$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$\"   \"$$$\"   \"$$$$$$u\n" +
                "       \"$$$$\"      u$u       $$$$\"\n" +
                "        $$$u       u$u       u$$$\n" +
                "        $$$u      u$$$u      u$$$\n" +
                "         \"$$$$uu$$$   $$$uu$$$$\"\n" +
                "          \"$$$$$$$\"   \"$$$$$$$\"\n" +
                "            u$$$$$$$u$$$$$$$u\n" +
                "             u$\"$\"$\"$\"$\"$\"$u\n" +
                "  uuu        $$u$ $ $ $ $u$$       uuu\n" +
                " u$$$$        $$$$$u$u$u$$$       u$$$$\n" +
                "  $$$$$uu      \"$$$$$$$$$\"     uu$$$$$$\n" +
                "u$$$$$$$$$$$uu    \"\"\"\"\"    uuuu$$$$$$$$$$\n" +
                "$$$$\"\"\"$$$$$$$$$$uuu   uu$$$$$$$$$\"\"\"$$$\"\n" +
                " \"\"\"      \"\"$$$$$$$$$$$uu \"\"$\"\"\"\n" +
                "           uuuu \"\"$$$$$$$$$$uuu\n" +
                "  u$$$uuu$$$$$$$$$uu \"\"$$$$$$$$$$$uuu$$$\n" +
                "  $$$$$$$$$$\"\"\"\"           \"\"$$$$$$$$$$$\"\n" +
                "   \"$$$$$\"                      \"\"$$$$\"\"\n" +
                "     $$$\"                         $$$$\"\n");

    }
}


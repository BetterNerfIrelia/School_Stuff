package at.fhv.scc.tictactoe;

import java.util.LinkedList;

public class OpponentPruning implements Opponent {


    private Game _game;

    public void play() {


        int maximum = Integer.MIN_VALUE;
        SingleField[][] bestMove = null;

        LinkedList<SingleField[][]> temp = getChildren(_game.getGameField().getMatrix(), 'O');
        for (SingleField[][] child : temp) {
            int value = min(child,maximum);
            if (value > maximum) {
                bestMove = child;
                maximum = value;
            }
        }
        setBestMove(bestMove);
        _game.getGameField().printGameField();
        if (_game.isWinner('O')) {
            System.out.println("Computer won!");
            _game.printSkull();
        }else if(_game.isDraw()){
            System.out.println("Draw!");
            _game.printSkull();
        }
    }

    public void setBestMove(SingleField[][] bestMove) {

        for (int i = 0; i < bestMove.length; i++) {

            for (int j = 0; j < bestMove.length; j++) {

                if (bestMove[i][j].getValue() != _game.getGameField().getMatrix(i, j).getValue()) {
                    _game.getGameField().getMatrix(i, j).setValue('O');
                    _game.getGameField().getMatrix(i, j).setIsSet(true);
                    return;
                }

            }

        }


    }


    public int min(SingleField[][] matrix, int max) {


        int minimum = Integer.MAX_VALUE;

        if (gameOver(matrix)) {
            return utility(matrix);
        }
        LinkedList<SingleField[][]> temp = getChildren(matrix, 'X');
        for (SingleField[][] child : temp) {
            int value = max(child, minimum);
            if (value < minimum) {
                minimum = value;
            }
            if(max >= minimum){
                break;
            }
        }
        return minimum;
    }
    //best move speichern (in oberster ebene, welcher spielzug gibt das max)

    public LinkedList<SingleField[][]> getChildren(SingleField[][] matrix, char value) {

        LinkedList<SingleField[][]> liste = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {


            for (int j = 0; j < matrix.length; j++) {
                if (!matrix[i][j].isSet()) {
                    SingleField[][] copy = deepCopy(matrix);
                    copy[i][j].setValue(value);
                    copy[i][j].setIsSet(true);
                    liste.add(copy);
                }

            }

        }


        return liste;


    }

    public SingleField[][] deepCopy(SingleField[][] matrix) {
        SingleField[][] copy = new SingleField[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                copy[i][j] = new SingleField('-');
                if (matrix[i][j].isSet()) {
                    copy[i][j].setValue(matrix[i][j].getValue());
                    copy[i][j].setIsSet(true);
                }
            }

        }
        return copy;
    }


    public boolean gameOver(SingleField[][] matrix) {

        if (isWinner(matrix, 'O')) {
            return true;
        }
        if (isWinner(matrix, 'X')) {
            return true;
        }
        if (isDraw(matrix)) {
            return true;
        } else {
            return false;
        }

    }

    public int max(SingleField[][] matrix, int min) {

        int maximum = Integer.MIN_VALUE;

        if (gameOver(matrix)) {
            return utility(matrix);
        }
        LinkedList<SingleField[][]> temp = getChildren(matrix, 'O');
        for (SingleField[][] child : temp) {
            int value = min(child, maximum);
            if (value > maximum) {
                maximum = value;
            }
            if(min <= maximum){
                break;
            }
        }
        return maximum;
    }

    public boolean isWinner(SingleField[][] matrix, char value) {


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

    public boolean isDraw(SingleField[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j].getValue() == '-') {
                    return false;
                }

            }
        }
        return true;

    }


    public int utility(SingleField[][] matrix) {
        if (isWinner(matrix, 'O')) {
            return 10;
        }
        if (isWinner(matrix, 'X')) {
            return -10;
        }
        if (isDraw(matrix)) {
            return 0;
        } else {
            return 0;
        }
    }

    public Game getGame() {
        return _game;
    }

    public void setGame(Game game) {
        _game = game;
    }
}


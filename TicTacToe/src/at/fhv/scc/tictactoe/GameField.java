package at.fhv.scc.tictactoe;

public class GameField {
    //create a new 3x3 GameField

    private SingleField[][] _matrix;

    public GameField() {

        _matrix = new SingleField[3][3];

        for (int i = 0; i < _matrix.length; i++) {

            for (int j = 0; j < _matrix.length; j++) {
                _matrix[i][j] = new SingleField('-');
            }
        }
    }

    public void printGameField() {

        for (int i = 0; i < _matrix.length; i++) {
            if (i > 0) {
                System.out.println("|");
            }
            for (int j = 0; j < _matrix.length; j++) {
                System.out.print("|" + _matrix[i][j].getValue());
            }
        }

        System.out.println("|" + "\n");
    }

    public SingleField[][] getMatrix() {
        return _matrix;
    }

    public SingleField getMatrix(int i, int j) {
        return _matrix[i][j];
    }

    public void setMatrix(SingleField[][] matrix) {
        _matrix = matrix;
    }

    public void setMatrix(int i, int j, char c) {

        _matrix[i][j].setValue(c);
        _matrix[i][j].setIsSet(true);
    }
}


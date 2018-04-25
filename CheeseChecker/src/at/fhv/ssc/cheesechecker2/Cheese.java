package at.fhv.ssc.cheesechecker2;

public class Cheese {

    private Cell[][] _cellArray;
    private int _x;
    private int _y;

    /**
     * creates a cheese without holes.
     */
    public Cheese(int x, int y) {
        Cell[][] cheese = new Cell[x + 2][y + 2];

        _x = x;
        _y = y;

        int j = 0;

        while (j < _y + 2) {

            for (int i = 0; i < _x + 2; i++) {

                cheese[i][j] = new Cell("#");
            }
            j++;
        }

        j = 0;
        int i = 0;

        while (i < _x + 2) {
            cheese[i][j].setCheeseCell("-");
            i++;
        }
        j = _y + 1;
        i = 0;

        while (i < _x + 2) {
            cheese[i][j].setCheeseCell("-");
            i++;
        }

        j = 1;
        i = 0;

        while (j < _y + 1) {
            cheese[i][j].setCheeseCell("|");
            j++;
        }

        j = 1;
        i = _y + 1;

        while (j < _y + 1) {
            cheese[i][j].setCheeseCell("|");
            j++;
        }
        _cellArray = cheese;

    }

    /**
     * prints the cheese.
     */
    public void printCheese() {

        int j = 0;

        while (j < _y + 2) {

            for (int i = 0; i < _x + 2; i++) {
                System.out.print(_cellArray[i][j].getCheeseCell());
            }
            System.out.print("\n");
            j++;

        }

    }

    /**
     * creation of testcheeses.
     */
    public void createTestCheeseOne() {
        _cellArray[2][2].setCheeseCell("*");
    }

    public void createTestCheeseTwo() {
        _cellArray[2][2].setCheeseCell("*");
        _cellArray[2][3].setCheeseCell("*");
        _cellArray[3][2].setCheeseCell("*");
        _cellArray[3][3].setCheeseCell("*");
    }


    public int getX() {
        return _x;
    }

    public void setX(int x) {
        _x = x;
    }

    public int getY() {
        return _y;
    }

    public void setY(int y) {
        _y = y;
    }

    public Cell[][] getCellArray() {
        return _cellArray;
    }

    public Cell[][] getCheeseArray(int row, int col) {
        return _cellArray;
    }

    public void setCellArray(Cell[][] cellArray) {
        _cellArray = cellArray;
    }


}

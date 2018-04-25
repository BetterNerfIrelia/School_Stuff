package at.fhv.ssc.cheesechecker;

public class Cheese {

    private String[][] _cheeseArray;
    private int _x;
    private int _y;

    public Cheese(int x, int y) {
        String[][] cheese = new String[x + 2][y + 2];

        _x = x;
        _y = y;

        int j = 0;

        while (j < _y + 2) {

            for (int i = 0; i < _x + 2; i++) {

                cheese[i][j] = "#";
            }
            j++;
        }

        j = 0;
        int i = 0;

        while (i < _x + 2) {
            cheese[i][j] = "-";
            i++;
        }
        j = _y + 1;
        i = 0;

        while (i < _x + 2) {
            cheese[i][j] = "-";
            i++;
        }

        j = 1;
        i = 0;

        while (j < _y + 1) {
            cheese[i][j] = "|";
            j++;
        }

        j = 1;
        i = _y + 1;

        while (j < _y + 1) {
            cheese[i][j] = "|";
            j++;
        }
        _cheeseArray = cheese;

    }


    public void printCheese() {

        int j = 0;

        while (j < _y + 2) {

            for (int i = 0; i < _x + 2; i++) {
                System.out.print(_cheeseArray[i][j]);
            }
            System.out.print("\n");
            j++;

        }


    }

    public void createTestCheeseOne(){
        _cheeseArray[2][2] = "*";
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

    public String[][] getCheeseArray() {
        return _cheeseArray;
    }

    public void setCheeseArray(String[][] cheeseArray) {
        _cheeseArray = cheeseArray;
    }
}

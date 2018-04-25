package at.fhv.ssc.cheesechecker2;

public class CheeseChecker {

    private int _holeCount;
    private int _biggestHole;
    private Cheese _cheese;

    public CheeseChecker() {
        _holeCount = 0;
        _biggestHole = 0;
    }


    public CheeseChecker(Cheese cheese) {

        _holeCount = 0;
        _biggestHole = 0;
        _cheese = cheese;
    }

    /**
     * checks a cheese for number of holes and biggest hole.
     */
    public String checkCheese() {


        int j = 1;

        while (j < _cheese.getY() + 2) {

            for (int i = 1; i < _cheese.getX() + 1; i++) {

                int i2 = i;
                int j2 = j;


                if (_cheese.getCellArray()[i2][j2].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2].isVisited()) {
                    int temp1 = i2;
                    int temp2 = j2;
                    _holeCount++;
                    while ((

                            (_cheese.getCellArray()[i2 + 1][j2].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 + 1][j2].isVisited()) ||


                                    (_cheese.getCellArray()[i2 + 1][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 + 1][j2 + 1].isVisited()) ||


                                    (_cheese.getCellArray()[i2][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) ||

                                    (_cheese.getCellArray()[i2 - 1][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 - 1][j2 + 1].isVisited()) ||

                                    (_cheese.getCellArray()[i2 - 1][j2].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 - 1][j2].isVisited()) ||

                                    (_cheese.getCellArray()[i2 - 1][j2 - 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 - 1][j2 - 1].isVisited()) ||

                                    (_cheese.getCellArray()[i][j2 - 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i][j2 - 1].isVisited()) ||

                                    (_cheese.getCellArray()[i2 + 1][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 + 1][j2 + 1].isVisited())

                    )) {
                        if (_cheese.getCellArray()[i2 + 1][j2].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 + 1][j2].isVisited()) {
                            _cheese.getCellArray()[i2 + 1][j2].setVisited(true);
                            i2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2 + 1][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2 + 1][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2 + 1][j2 + 1].setVisited(true);
                            i2++;
                            j2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2][j2 + 1].setVisited(true);
                            j2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2 - 1][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2 - 1][j2 + 1].setVisited(true);
                            j2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2 - 1][j2].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2 - 1][j2].setVisited(true);
                            j2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2 - 1][j2 - 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2 - 1][j2 - 1].setVisited(true);
                            j2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2][j2 - 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2][j2 - 1].setVisited(true);
                            j2++;
                            _holeCount++;
                        } else if (_cheese.getCellArray()[i2 + 1][j2 + 1].getCheeseCell() == "*" && !_cheese.getCellArray()[i2][j2 + 1].isVisited()) {
                            _cheese.getCellArray()[i2 + 1][j2 + 1].setVisited(true);
                            j2++;

                        }


                    }
                    _cheese.getCellArray()[temp1][temp2].setVisited(true);
                    if (_holeCount > _biggestHole) {
                        _biggestHole = _holeCount;
                    }
                }
                _cheese.getCellArray()[i2][j2].setVisited(true);


            }


            j++;
        }


        return "hole-count: " + _holeCount + "\n" +
                "biggest hole edge: " + _biggestHole;

    }




    public Cheese getCheese() {
        return _cheese;
    }

    public void setCheese(Cheese cheese) {
        _cheese = cheese;
    }
}
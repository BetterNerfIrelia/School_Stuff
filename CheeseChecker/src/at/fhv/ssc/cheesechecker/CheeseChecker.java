package at.fhv.ssc.cheesechecker;

public class CheeseChecker {

    private int _holeCount;
    private int _biggestHole;
    private Cheese _cheese;

   public CheeseChecker(){
       _holeCount = 0;
       _biggestHole = 0;
   }


    public CheeseChecker(Cheese cheese){

        _holeCount = 0;
        _biggestHole = 0;
        _cheese = cheese;
    }




public String checkCheese(){




    int j = 1;

    while (j < _cheese.getY() + 2) {

        for (int i = 1; i < _cheese.getX() + 2; i++) {

            if(_cheese.getCheeseArray()[i][j] == "*"){
                _biggestHole = 1;

            }


        }
        j++;
    }
    _holeCount ++;



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
package at.fhv.ssc;

public class EightPuzzle {

    private PuzzlePiece[][] _matrix;
    private PuzzlePiece _X;
    private boolean _found;
    private int _counterDepth;
    private int _counterMoves;

    public EightPuzzle() {
        _matrix = new PuzzlePiece[3][3];
    }

    public void createTest() {

        //START: (7 right)
        // 1  2  3
        // 4  5  X
        // 7  8  6

        //GOAL:  (8 right)
        // 1  2  3
        // 4  5  6
        // 7  8  X

        _matrix[0][0] = new PuzzlePiece(1);
        _matrix[0][1] = new PuzzlePiece(2);
        _matrix[0][2] = new PuzzlePiece(3);
        _matrix[1][0] = new PuzzlePiece(4);
        _matrix[1][1] = new PuzzlePiece(5);
        _matrix[1][2] = new PuzzlePiece(0);
        _matrix[2][0] = new PuzzlePiece(7);
        _matrix[2][1] = new PuzzlePiece(8);
        _matrix[2][2] = new PuzzlePiece(6);


        _matrix[0][0].set_neighbourE(_matrix[0][1]);
        _matrix[0][0].set_neighbourS(_matrix[1][0]);

        _matrix[0][1].set_neighbourE(_matrix[0][2]);
        _matrix[0][1].set_neighbourS(_matrix[1][1]);
        _matrix[0][1].set_neighbourW(_matrix[0][0]);

        _matrix[0][2].set_neighbourS(_matrix[1][2]);
        _matrix[0][2].set_neighbourW(_matrix[0][1]);

        _matrix[1][0].set_neighbourN(_matrix[0][0]);
        _matrix[1][0].set_neighbourE(_matrix[1][1]);
        _matrix[1][0].set_neighbourS(_matrix[2][0]);

        _matrix[1][1].set_neighbourN(_matrix[0][1]);
        _matrix[1][1].set_neighbourE(_matrix[1][2]);
        _matrix[1][1].set_neighbourS(_matrix[2][1]);
        _matrix[1][1].set_neighbourW(_matrix[1][0]);

        _matrix[1][2].set_neighbourN(_matrix[0][2]);
        _matrix[1][2].set_neighbourS(_matrix[2][2]);
        _matrix[1][2].set_neighbourW(_matrix[1][1]);

        _matrix[2][0].set_neighbourN(_matrix[1][0]);
        _matrix[2][0].set_neighbourE(_matrix[2][1]);

        _matrix[1][0].set_neighbourN(_matrix[1][1]);
        _matrix[1][0].set_neighbourE(_matrix[2][2]);
        _matrix[1][0].set_neighbourW(_matrix[2][0]);

        _matrix[2][2].set_neighbourN(_matrix[1][2]);
        _matrix[2][2].set_neighbourW(_matrix[2][1]);


        _X = _matrix[1][2];

    }

    public void printMatrix() {
        for (int i = 0; i < _matrix.length; i++) {
            for (int j = 0; j < _matrix.length; j++) {
                System.out.print(_matrix[i][j].get_value() + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Correct Pieces: " + countCorrect());
        System.out.println("Depth: " + get_counterDepth());
        System.out.println("Moves: " + get_counterMoves());
        System.out.println("Branching-Factor: " + calculateBranchingFactor()+ "\n");
    }

    public void swap(Enum direction){

        if(direction == Direction.NORTH){

        }

        if(direction == Direction.EAST){

        }

        if(direction == Direction.SOUTH){

        }

        if(direction == Direction.WEST){

        }


    }




    public boolean easySolver(int limit) {

        if (countCorrect() == 8) {                                                            //check ob gelöst
            return true;
        }

        if (limit > 0) {

            if (_X.get_neighbourN() != null) {

                int temp = _X.get_value();                                                          //swap
                _X.set_value(_X.get_neighbourN().get_value());
                _X.get_neighbourN().set_value(temp);
                _X = _X.get_neighbourN();
                _counterMoves ++;

                boolean found = easySolver(limit - 1);
                if (found) {
                    return true;
                }
                else{
                    int tempus = _X.get_value();                                                          //swap back
                    _X.set_value(_X.get_neighbourS().get_value());
                    _X.get_neighbourS().set_value(tempus);
                    _X = _X.get_neighbourS();

                }
            }

            if (_X.get_neighbourE() != null) {

                int temp = _X.get_value();                                                          //swap
                _X.set_value(_X.get_neighbourE().get_value());
                _X.get_neighbourE().set_value(temp);
                _X = _X.get_neighbourE();
                _counterMoves ++;

                boolean found = easySolver(limit - 1);
                if (found) {
                    return true;
                }else{int tempus = _X.get_value();                                                          //swap back
                    _X.set_value(_X.get_neighbourW().get_value());
                    _X.get_neighbourW().set_value(tempus);
                    _X = _X.get_neighbourW();}
            }

            if (_X.get_neighbourS() != null) {

                int temp = _X.get_value();                                                          //swap
                _X.set_value(_X.get_neighbourS().get_value());
                _X.get_neighbourS().set_value(temp);
                _X = _X.get_neighbourS();
                _counterMoves ++;

                boolean found = easySolver(limit - 1);
                if (found) {
                    return true;
                }else{
                    int tempus = _X.get_value();                                                          //swap back
                    _X.set_value(_X.get_neighbourN().get_value());
                    _X.get_neighbourN().set_value(tempus);
                    _X = _X.get_neighbourN();
                }
            }

            if (_X.get_neighbourW() != null) {

                int temp = _X.get_value();                                                          //swap
                _X.set_value(_X.get_neighbourW().get_value());
                _X.get_neighbourW().set_value(temp);
                _X = _X.get_neighbourW();
                _counterMoves ++;

                boolean found = easySolver(limit - 1);
                if (found) {
                    return true;
                }else{
                    int tempus = _X.get_value();                                                          //swap back
                    _X.set_value(_X.get_neighbourE().get_value());
                    _X.get_neighbourE().set_value(tempus);
                    _X = _X.get_neighbourE();

                }
            }
        }
        return false;
    }

    public void ids() {

        _counterMoves = 0;
        _counterDepth = 1;
        while (_counterDepth <= 65) {
            _counterDepth++;
            if (easySolver(_counterDepth)) {
                return;
            }
        }
    }

    public int countCorrect() {

        int count = 0; // 8 = all correct

        if (_matrix[0][0].get_value() == 1) {
            count++;
        }
        if (_matrix[0][1].get_value() == 2) {
            count++;
        }
        if (_matrix[0][2].get_value() == 3) {
            count++;
        }
        if (_matrix[1][0].get_value() == 4) {
            count++;
        }
        if (_matrix[1][1].get_value() == 5) {
            count++;
        }
        if (_matrix[1][2].get_value() == 6) {
            count++;
        }
        if (_matrix[2][0].get_value() == 7) {
            count++;
        }
        if (_matrix[2][1].get_value() == 8) {
            count++;
        }
        return count;
    }

    public double calculateBranchingFactor(){
        double epsilon = 0.0001;
        double b = 1.000;
        double result;
        do{
            b += epsilon;
            result = 1 - _counterMoves + b * _counterMoves - Math.pow(b, _counterDepth +1);
        }while (result > epsilon);
        return b;
    }


    public PuzzlePiece[][] get_matrix() {
        return _matrix;
    }

    public void set_matrix(PuzzlePiece[][] matrix) {
        _matrix = matrix;
    }

    public PuzzlePiece get_X() {
        return _X;
    }

    public void set_X(PuzzlePiece _X) {
        this._X = _X;
    }

    public boolean is_found() {
        return _found;
    }

    public void set_found(boolean _found) {
        this._found = _found;
    }

    public int get_counterDepth() {
        return _counterDepth;
    }

    public void set_counterDepth(int _counterDepth) {
        this._counterDepth = _counterDepth;
    }

    public int get_counterMoves() {
        return _counterMoves;
    }

    public void set_counterMoves(int _counterMoves) {
        this._counterMoves = _counterMoves;
    }
}




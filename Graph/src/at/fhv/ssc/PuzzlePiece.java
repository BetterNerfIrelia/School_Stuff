package at.fhv.ssc;

public class PuzzlePiece {

    private int _value;
    private PuzzlePiece _neighbourN;
    private PuzzlePiece _neighbourE;
    private PuzzlePiece _neighbourS;
    private PuzzlePiece _neighbourW;

    public PuzzlePiece(int value) {
        _value = value;
    }


    public int get_value() {
        return _value;
    }

    public void set_value(int value) {
        _value = value;
    }

    public PuzzlePiece get_neighbourN() {
        return _neighbourN;
    }

    public void set_neighbourN(PuzzlePiece neighbourN) {
        _neighbourN = neighbourN;
    }

    public PuzzlePiece get_neighbourE() {
        return _neighbourE;
    }

    public void set_neighbourE(PuzzlePiece neighbourE) {
        _neighbourE = neighbourE;
    }

    public PuzzlePiece get_neighbourS() {
        return _neighbourS;
    }

    public void set_neighbourS(PuzzlePiece neighbourS) {
        _neighbourS = neighbourS;
    }

    public PuzzlePiece get_neighbourW() {
        return _neighbourW;
    }

    public void set_neighbourW(PuzzlePiece neighbourW) {
        _neighbourW = neighbourW;
    }
}

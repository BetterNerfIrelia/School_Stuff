package at.fhv.scc.tictactoe;

public class SingleField {
    //single field in the matrix

    private char _value;
    private boolean _isSet;

    public SingleField(char c){
        _value = c;
    }

    public char getValue() {
        return _value;
    }

    public void setValue(char value) {
        _value = value;
        if (value == 'O' || value == 'X') {
            _isSet = true;
        }
    }

    public boolean isSet() {
        return _isSet;
    }

    public void setIsSet(boolean isSet) {
        _isSet = isSet;
    }
}

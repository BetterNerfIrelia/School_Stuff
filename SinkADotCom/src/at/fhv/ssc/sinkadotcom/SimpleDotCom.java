package at.fhv.ssc.sinkadotcom;

public class SimpleDotCom {

    private int[] _locationCells;
    private int _numberofHits = 0;

    public void setLocationCells(int[] locs){
        _locationCells = locs;
    }

    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for(int cell : _locationCells){
            if(guess == cell){
                result = "hit";
                _numberofHits++;
                break;
            }
        }

        if(_numberofHits == _locationCells.length){
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}

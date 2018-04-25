package at.fhv.ssc.datenmanagement_projekt;

public class Kunde {

    private String _fuehrerschein_nummer; //primary
    private String _kunde_name;
    private String _anschrift;

    public String toString(){
        return _fuehrerschein_nummer + " " + _kunde_name + " " + _anschrift;
    }



}

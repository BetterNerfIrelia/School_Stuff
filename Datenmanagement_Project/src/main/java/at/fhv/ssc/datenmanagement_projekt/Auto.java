package at.fhv.ssc.datenmanagement_projekt;

public class Auto {

    private String _kennzeichen; //primary
    private double _km_stand;
    private String _farbe;
    private Vermietstation _vermietstation;
    private String _typ_bezeichnung;

    public String toString(){
        return "Kennzeichen: " + _kennzeichen;
    }



}


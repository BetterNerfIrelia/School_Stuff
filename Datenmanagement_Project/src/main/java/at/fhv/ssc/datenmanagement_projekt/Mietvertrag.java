package at.fhv.ssc.datenmanagement_projekt;

public class Mietvertrag{

    private Reservierung _reservierung;
    private double km_stand_uebergabe;
    private double km_stand_rueckgabe;
    private String _kennzeichen;

    public String toString(){
        return _kennzeichen + " " +  _reservierung;
    }

}




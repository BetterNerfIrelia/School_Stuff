package at.fhv.ssc.datenmanagement_projekt;

import java.time.LocalDate;

public class Reservierung {
    private Vermietstation _vermietstation;
    private String _reservierungs_nr; //primary
    private LocalDate _anfangsdatum;
    private LocalDate _enddatum;
    private int _fuehrerschein_nummer;
    private String _kategorie_bezeichnung;

    public String toString(){
        return _reservierungs_nr + " " + _vermietstation;
    }

}


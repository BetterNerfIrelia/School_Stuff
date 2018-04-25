package at.fhv.ssc.datenmanagement_projekt;

public class Verfuegt_ueber {

    private String _typ_bezeichnung; //primary/foreign
    private String _extras_bezeichnung; //primary/foreign
    private Auto _auto;

    public String toString(){
        return _typ_bezeichnung + " " + _extras_bezeichnung + " " + _auto;
    }


}

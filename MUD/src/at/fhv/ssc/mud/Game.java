package at.fhv.ssc.mud;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.LinkedList;

public class Game {

    public enum Direction {

        NORTH,
        EAST,
        SOUTH,
        WEST,
    }

    private LinkedList <FieldRole> _liste;

    public Game() {
        _liste = new LinkedList<FieldRole>();
           }

    public LinkedList<FieldRole> getListe() {
        return _liste;
    }

    public void setListe(LinkedList<FieldRole> liste) {
        _liste = liste;
    }



    }



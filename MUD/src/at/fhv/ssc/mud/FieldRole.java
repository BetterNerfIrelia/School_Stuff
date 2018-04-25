package at.fhv.ssc.mud;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FieldRole implements Serializable{

    private int _id;
    private int _neighbourNorth;
    private int _neighbourEast;
    private int _neighbourSouth;
    private int _neighbourWest;
    /* _neighbours holds references to the neighbouring fields */
    private Map<DIRECTION, FieldRole> _neighbours = new HashMap<>();
    private String _shortDescription;
    private String _longDescription;
    private String _item;

    public FieldRole(){

    }

    public FieldRole(int id) {
        _id = id;

    }

    public FieldRole(int id, String shortDescription, String longDescription) {
        _id = id;
        _shortDescription = shortDescription;
        _longDescription = longDescription;
    }

    public FieldRole(int id, String shortDescription, String longDescription, HashMap<DIRECTION, FieldRole> neighbours) {
        _id = id;
        _shortDescription = shortDescription;
        _longDescription = longDescription;
       _neighbours =  neighbours;


    }

    public FieldRole getNeighbours(DIRECTION d) {
        return _neighbours.get(d);
    }

    public void setNeighbours(DIRECTION d, FieldRole fr) {
        _neighbours.put(d, fr);
//            if (d == Direction.EAST) {
//                setNeighbours(Direction.EAST, fr);
//            }
//            if (d == Direction.WEST) {
//                setNeighbours(Direction.WEST, fr);
//            }
//            if (d == Direction.NORTH) {
//                setNeighbours(Direction.NORTH, fr);
//            }
//            if (d == Direction.SOUTH) {
//                setNeighbours(Direction.SOUTH, fr);
//            }
//

    }




    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getNeighbourNorth() {
        return _neighbourNorth;
    }

    public void setNeighbourNorth(int neighbourNorth) {
        _neighbourNorth = neighbourNorth;
    }

    public int getNeighbourEast() {
        return _neighbourEast;
    }

    public void setNeighbourEast(int neighbourEast) {
        _neighbourEast = neighbourEast;
    }

    public int getNeighbourSouth() {
        return _neighbourSouth;
    }

    public void setNeighbourSouth(int neighbourSouth) {
        _neighbourSouth = neighbourSouth;
    }

    public int getNeighbourWest() {
        return _neighbourWest;
    }

    public void setNeighbourWest(int neighbourWest) {
        _neighbourWest = neighbourWest;
    }

    public String getShortDescription() {
        return _shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        _shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return _longDescription;
    }

    public void setLongDescription(String longDescription) {
        _longDescription = longDescription;
    }

    public String getItem() {
        return _item;
    }

    public void setItem(String item) {
        _item = item;
    }

    @Override
    public String toString() {
        return "FieldRole{" +
                "_id=" + _id +
                "\nNorth=" + _neighbourNorth +
                "\n, _neighbourEast=" + _neighbourEast +
                ", _neighbourSouth=" + _neighbourSouth +
                ", _neighbourWest=" + _neighbourWest +
                ", _neighbours=" + _neighbours +
                ", _shortDescription='" + _shortDescription + '\'' +
                ", _longDescription='" + _longDescription + '\'' +
                ", _item='" + _item + '\'' +
                '}';
    }
}



//extends Field, Wall, Door
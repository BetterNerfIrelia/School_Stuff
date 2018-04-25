package at.fhv.ssc.mud;

import javax.swing.text.Position;
import java.io.*;
import java.util.LinkedList;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

public class Player implements Serializable{

    private int _id;
    private String _name;
    private FieldRole _position;
    private LinkedList<Item> _inventory;

    public Player(int id, String name) {
        _id = id;
        _name = name;
        _position = new FieldRole(1);
        _inventory = new LinkedList<Item>();
    }

    public Player(){

    }

    public void leave(){
        this.setPosition(new FieldRole(1));
    }

    /**
     * Move the Player to the Field in the given direction
     */

    public void move(DIRECTION dir) {

        FieldRole nextField = this.getPosition().getNeighbours(dir);

        //if player is on map he has a position
        if(this.getPosition() != null) {
            // if there is a neighbour in this direction, we can (maybe) move there
            if (nextField != null) {
                //if this is a wall, we cant move through it
                if(nextField instanceof Wall) {
                } else if( nextField instanceof Door) {
                    // do i have a key for this door?
                } else if( nextField instanceof  Field){  // no wall, free to move!
                    this.setPosition(nextField);
                }
            }
        }

    }

    /**
    Safes a Player as XML, via XMLEnocder into BufferOutputStream inti Fileoutpoutstream.
     */

    public void safe(Player player) throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("C:\\test\\Player01.xml")));
        e.writeObject(player);
        e.close();

    }

    /**
     Loads a Player from XML, via XMLEnocder into BufferOutputStream inti Fileoutpoutstream.
     */

    public void load(Player player) throws FileNotFoundException{
        XMLDecoder d = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream("C:\\test\\Player01.xml")));
        Object result = d.readObject();
        d.close();

    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public FieldRole getPosition() {
        return _position;
    }

    public void setPosition(FieldRole position) {
        _position = position;
    }

    public LinkedList<Item> getInventory() {
        return _inventory;
    }

    public void setInventory(LinkedList<Item> inventory) {
        _inventory = inventory;
    }
}

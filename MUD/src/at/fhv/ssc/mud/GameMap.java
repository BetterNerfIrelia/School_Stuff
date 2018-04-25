package at.fhv.ssc.mud;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.beans.XMLEncoder;

/**
 * Created by sebastian on 26.04.2017.
 */
public class GameMap implements Serializable{


    public static FieldRole[] fields = new FieldRole[100];

    /**
     * empty Constructor defining fields
     */
    public GameMap() {

    }

    public FieldRole getField(int id) {
        return fields[id];
    }

    public void createMap() {

        Field field1 = new Field(1, "Dark Dungeon", "You are at the beginning of a dark dungeon.");
        Field field2 = new Field(2, "Small Room", "You are in a small wooden room, it smells a bit.");
        Wall wall1 = new Wall(3, "Dungeon Wall", "A cold stonewall.");
        Wall wall2 = new Wall(4, "Dungeon Wall", "Another cold stonewall.");
        Wall wall3 = new Wall(5, "Dungeon Wall", "A stonewall that is cold.");
        Door door1 = new Door(6, "Wooden Door", "An old wooden door.");
        field1.setNeighbourNorth(3);
        field1.setNeighbourEast(6);
        field2.setNeighbourNorth(5);
        field2.setNeighbourWest(6);
        wall1.setNeighbourEast(4);
        wall1.setNeighbourSouth(1);
        wall2.setNeighbourWest(3);
        wall2.setNeighbourEast(5);
        wall2.setNeighbourSouth(6);
        wall3.setNeighbourWest(4);
        wall3.setNeighbourSouth(2);
        door1.setNeighbourNorth(4);
        door1.setNeighbourEast(2);
        door1.setNeighbourWest(1);



        Item healpot1 = new Item(1, "Small healpot");
        Item manapot1 = new Item(2, "Small manapot");
        Item sword1 = new Item(3, "A small wooden sword");
        Item shield1 = new Item(4, "A Small wooden shield");

        field1.setItem(healpot1.getName());
        field2.setItem(manapot1.getName());

        field1.setNeighbours(DIRECTION.NORTH, wall1);
        field1.setNeighbours(DIRECTION.EAST, door1);
        field1.setNeighbours(DIRECTION.SOUTH, null);
        field1.setNeighbours(DIRECTION.WEST, null);

        fields[0]=field1;
        fields[1]=field2;
        fields[2]=wall1;
        fields[3]=wall2;
        fields[4]=wall3;
        fields[5]=door1;

    }



    /**
     * prints the map
     */
    public void print() {
        try {
            for (int i = 0; i < 6; i++) { //Prints out all Fields.

                fields[i].toString();

                System.out.println("--------------------------------------------------------------------");
                System.out.println("Field: " + fields[i].getId() + ", " + fields[i].getShortDescription());
                System.out.println("Description: " + fields[i].getLongDescription());
                System.out.println("North: \t" + fields[i].getNeighbours(DIRECTION.NORTH).getId());
                System.out.println("North: \t" + fields[i].getNeighbours(DIRECTION.NORTH).getId());
                System.out.println("East: \t" + fields[i].getNeighbourEast());
                System.out.println("South: \t" + fields[i].getNeighbourSouth());
                System.out.println("West: \t" + fields[i].getNeighbourWest());
                System.out.println("Item: \t" + fields[i].getItem());
            }
            System.out.println("--------------------------------------------------------------------");


        } catch (NullPointerException e) {
            // e.printStackTrace(); //most likely because some neighbour was null
        }
    }

    /**
     Safes a GameMap as XML via XMLEnocder into BufferOutputStream inti Fileoutpoutstream.
     */

    public void safe(GameMap gamemap) throws FileNotFoundException {
        XMLEncoder en = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("C:\\test\\GameMap01.xml")));
        en.writeObject(gamemap);
        en.close();

    }

    /**
     Loads a GameMap from XML via XMLEnocder into BufferOutputStream inti Fileoutpoutstream.
     */

    public void load(GameMap gamemap) throws FileNotFoundException{
        XMLDecoder de = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream("C:\\test\\Gamemap01.xml")));
        Object result = de.readObject();
        de.close();

    }





}



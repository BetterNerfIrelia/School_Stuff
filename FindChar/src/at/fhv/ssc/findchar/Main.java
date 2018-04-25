package at.fhv.ssc.findchar;

public class Main {

    public static void main(String [] args ){

      FindChar charfinder = new FindChar();

     System.out.println("findCharLeft: " + charfinder.findCharLeft("ABBCD", 'B'));
     System.out.println("findCharRight: " + charfinder.findCharRight("ABBCD", 'B'));
     System.out.println("findCharRandom: " + charfinder.findCharRandom("ABBCD", 'B'));
    }
}

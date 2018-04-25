package at.fhv.ssc.Logistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastian on 26.03.2017.
 * Es werden ein Feld, 2 Produkte "Banane" mit unterschiedlichen IDs und ein Trolley erzeugt.
 * Danach werden die beiden Produkte in den Trolley geladen.
 * Dann werden Infos zu Field/Home und zum Trolley abgerufen.
 * Der Trolley wird dann um 2 Felder bewegt und leert dort seine Ladung und gibt diese aus.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("###### START ######");
        Field Feldnew = new Field(2,4);
        Product productnew = new Product("Banane", 0001, 1);
        Product productnew2 = new Product("Banane", 0002, 1);
        Trolley trolleynew = new Trolley(10, Feldnew.getHomeX(), Feldnew.getHomeY(), "Trolley McTrollFace", 10);
        trolleynew.loadProduct(productnew);
        trolleynew.loadProduct(productnew2);

        System.out.println("###### Field/HomeInfo: ######");
        System.out.println("Width Field: " + Feldnew.getWidth());
        System.out.println("Height Field: " + Feldnew.getHeight());
        System.out.println("X-Coordinate Home: " + Feldnew.getHomeX());
        System.out.println("Y-Coordinate Home: " + Feldnew.getHomeY());

        System.out.println("###### TrolleyInfos: ######");
        System.out.println("Trolley-Capa: " + trolleynew.getCapa());
        System.out.println("X-Coordinate Trolley: " + trolleynew.getPosX());
        System.out.println("Y-Coordinate Trolley: " + trolleynew.getPosY());
        System.out.println("Product: " + productnew.getId() + productnew.getName() + productnew.getCubicCentimeter());

        System.out.println("###### MoveTrolley: ######");
        trolleynew.MoveTrolley(Trolley.Direction.NORTH);
        System.out.println("New X-Coordinate Trolley: " + trolleynew.getPosX());
        System.out.println("New Y-Coordinate Trolley: " + trolleynew.getPosY());
        trolleynew.MoveTrolley(Trolley.Direction.WEST);
        System.out.println("New X-Coordinate Trolley: " + trolleynew.getPosX());
        System.out.println("New Y-Coordinate Trolley: " + trolleynew.getPosY());

        System.out.println("###### OutputTrolleyInhalt ######");
        System.out.println(trolleynew.toString());
        trolleynew.unloadProduct();

        System.out.println("###### END ######");


    }
}




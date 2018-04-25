package at.fhv.ssc.arraylistserialisationionetworkingstuff;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //TODO: Klasse File übergeben, Buffer einbauen.

        ArrayList listeAll = new ArrayList();                       //Object-ArrayList
        ArrayList<Test> listeTest = new ArrayList<Test>();           //Test-ArrayList

        Test test = new Test("Anton");

        listeAll.add(test);
        listeTest.add(test);

        System.out.print(((Test) listeAll.get(0)).getName() + " ");     //cast
        System.out.print((listeTest.get(0)).getName() + " ");
        System.out.print(((Test) listeAll.get(0)).getName() + " ");     //cast
        System.out.println((listeTest.get(0)).getName());

        System.out.print(listeTest.size() + " ");
        System.out.print(listeTest.contains(test) + " ");
        System.out.print(listeTest.isEmpty() + " ");
        System.out.println(listeTest.indexOf(test));

        try {   //Write Objects (Serialize)
            FileOutputStream filo = new FileOutputStream("C:\\Users\\sebastian\\Desktop\\Übungen\\ArraylistSerialisationIONetworkingStuff\\test1.txt");
            BufferedOutputStream bufi = new BufferedOutputStream(filo);
            ObjectOutputStream objo = new ObjectOutputStream(bufi);
            objo.writeObject(test);
            objo.close();
            System.out.println(test.getName() + " !Object serialized!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {   //Read Objects (Deserialize)
            InputStream fili = new FileInputStream("C:\\Users\\sebastian\\Desktop\\Übungen\\ArraylistSerialisationIONetworkingStuff\\test1.txt");
            BufferedInputStream bufi = new BufferedInputStream(fili);
            ObjectInput obji = new ObjectInputStream(bufi);
            Object one = obji.readObject();
            test = (Test) one;
            obji.close();
            System.out.println(test.getName() + " !Object deserialized!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {   //Write Strings (Textfiles)
            FileWriter fili = new FileWriter("C:\\Users\\sebastian\\Desktop\\Übungen\\ArraylistSerialisationIONetworkingStuff\\test2.txt");
            BufferedWriter bufi = new BufferedWriter(fili);
            String str = ("Hi there!");
            bufi.write(str);
            bufi.close();
            System.out.println(str + " !File written!");
        } catch (Exception e){
            e.printStackTrace();
        }

        try{    //Read String (Textfiles)
            FileReader filo = new FileReader("C:\\Users\\sebastian\\Desktop\\Übungen\\ArraylistSerialisationIONetworkingStuff\\test2.txt");
            BufferedReader bufi = new BufferedReader(filo);
            String line = null;
            while((line = bufi.readLine()) != null){
                System.out.print(line);
            }
            bufi.close();
            System.out.println(" !File read!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}



package at.fhv.ssv.caesardecorator;
import java.io.*;
import java.io.FileWriter;

public class Main {

    public static void main (String[] args) throws IOException {

        /******* WRITER-Test *******/
        FileWriter writer = new FileWriter("C:/test/writer.txt");
        CaesarWriter caesar = new CaesarWriter(4, writer);
        String st = "Et tu, Brute?";
        char[] cha = st.toCharArray();

        caesar.write(cha);
        writer.close();
        caesar.close();

        /******* READER-Test *******/
        FileReader reader = new FileReader("C:/test/writer.txt");
        CaesarReader brutus = new CaesarReader(4, reader);
        char[] buffer = new char[1024];

        brutus.read(buffer);
        System.out.println(buffer);
        reader.close();
        brutus.close();
    }
    }

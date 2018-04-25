package at.fhv.ssc.mud;

import java.beans.XMLEncoder;
        import java.beans.XMLDecoder;
        import java.io.*;

public class XmlGenerator {
    public static void write(Player f, String filename) throws Exception{
        XMLEncoder encoder =
                new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)));
        encoder.writeObject(f);
        encoder.close();
    }

    public static Player read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(new BufferedInputStream(
                        new FileInputStream(filename)));
        Player o = (Player)decoder.readObject();
        decoder.close();
        return o;
    }
}
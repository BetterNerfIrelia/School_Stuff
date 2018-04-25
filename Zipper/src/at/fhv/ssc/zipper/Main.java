package at.fhv.ssc.zipper;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

        /**
         Neuer Zipper wird erstellt und verpackt ein txt-File in ein zip-File.
         */

        Zipper zipper = new Zipper();
        zipper.zipper(new File("C:/test/output.txt"), "C:/test/output.zip");

    }
}

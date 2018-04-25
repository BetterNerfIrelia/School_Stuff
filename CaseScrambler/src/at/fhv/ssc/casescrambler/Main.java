package at.fhv.ssc.casescrambler;

import java.io.*;

/**
 * Created by sebastian on 03.09.2017.
 */
public class Main {

    public static void main(String [] args) throws IOException {

        String str = "Das ist ein Test";
        CaseScrambler scrambler = new CaseScrambler(new StringReader(str));
        char[] buffer = new char[1024];
        scrambler.read(buffer, 0, buffer.length);
        System.out.println(buffer);



    }

}



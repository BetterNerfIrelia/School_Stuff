package at.fhv.ssc.compromiser;

import static org.junit.Assert.*;

public class Test {

    String plain;
    String cipher;
    String output;
    Compromiser compromiser = new Compromiser();


    @org.junit.Test
    public void compromiseTest() {

        plain = "AABBBCC";
        cipher = "AA§3§BCC";
        output = compromiser.compromise(plain);
        assertEquals(output, cipher);

        plain = "AAAAAAAAAA";
        cipher = "§10§A";
        output = compromiser.compromise(plain);
        assertEquals(output, cipher);

        plain = "AAAA3B33";
        cipher = "§4§A3B33";
        output = compromiser.compromise(plain);
        assertEquals(output, cipher);

        plain = "12124124";
        cipher = "12124124";
        output = compromiser.compromise(plain);
        assertEquals(output, cipher);
    }

    @org.junit.Test
    public void decompromiseTest() {

        cipher = "AA§3§BCC";
        plain = "AABBBCC";
        output = compromiser.decompromise(cipher);
        assertEquals(output, plain);

        cipher = "§10§A";
        plain = "AAAAAAAAAA";
        output = compromiser.decompromise(cipher);
        assertEquals(output, plain);

        cipher = "§4§A3B33";
        plain = "AAAA3B33";
        output = compromiser.decompromise(cipher);
        assertEquals(output, plain);

        cipher = "12124124";
        plain = "12124124";
        output = compromiser.decompromise(cipher);
        assertEquals(output, plain);
    }
}

package at.fhv.ssc.findchar;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sebastian on 11.10.2017.
 */
class FindCharTest extends FindChar {

    FindChar charfinder = new FindChar();
    String string;
    char ch;
    int output;

    @Test
    void findCharLeft() {

        string = "ABBCD";
        ch = 'B';
        output = charfinder.findCharLeft(string, ch);
        assertEquals(output, 1);

        string = "AABAA";
        ch = 'B';
        output = charfinder.findCharLeft(string, ch);
        assertEquals(output, 2);
    }

    @Test
    void findCharRight() {

        string = "ABBCD";
        ch = 'B';
        output = charfinder.findCharRight(string, ch);
        assertEquals(output, 2);

        string = "AABAA";
        ch = 'B';
        output = charfinder.findCharRight(string, ch);
        assertEquals(output, 2);
    }

    @Test
    void findCharRandom() {

        string = "ABBCD";
        ch = 'B';
        output = charfinder.findCharRandom(string, ch);
        assertTrue(output == 1 || output == 2);

        string = "AABAA";
        ch = 'B';
        output = charfinder.findCharRandom(string, ch);
        assertEquals(output, 2);
    }

}
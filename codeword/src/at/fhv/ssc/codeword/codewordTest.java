package at.fhv.ssc.codeword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sebastian on 22.03.2017.
 */
class codewordTest {
    @Test
    void addNewStudent() {
        codeword codeword = new codeword(2);
        codeword.addNewStudent("Herwig");
        codeword.addNewStudent("Doerte");
        codeword.addNewStudent("Sebsl");
        codeword.addNewStudent("Blub");
        fail("Not yet implemented");

    }

    @Test
    void getPasswordOfStudent() {

    }

}
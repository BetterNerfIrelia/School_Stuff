package at.fhv.ssc.caesar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCodeTest {
    @Test
    void encode() {
        String input1 = "ABC";
        String output1 = "FGH";
        input1 = CaesarCode.encode(input1, 5);
        assertEquals(output1,input1);

        String input2 = "xyz";
        String output2 = "yza";
        input2 = CaesarCode.encode(input2, 1);
        assertEquals( output2, input2);

        String input3 = "xyz";
        String output3 = "offset > 26";
        input3 = CaesarCode.encode(input3, 30);
        assertEquals( output3, input3);

        String input4 = "Et tu Brute";
        String output4 = "Hw wx Euxwh";
        input4 = CaesarCode.encode(input4, 3);
        assertEquals( output4, input4);

    }

    @Test
    void decode() {
        String input1 = "FGH";
        String output1 = "ABC";
        input1 = CaesarCode.decode(input1, 5);
        assertEquals( output1,input1);

        String input2 = "yza";
        String output2 = "xyz";
        input2 = CaesarCode.decode(input2, 1);
        assertEquals( output2, input2);

        String input3 = "xyz";
        String output3 = "offset > 26";
        input3 = CaesarCode.decode(input3, 30);
        assertEquals( output3, input3);

        String input4 = "Hw wx Euxwh";
        String output4 = "Et tu Brute";
        input4 = CaesarCode.decode(input4, 3);
        assertEquals( output4, input4);
    }

}

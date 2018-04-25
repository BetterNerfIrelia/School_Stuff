package at.fhv.ssc.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testCalculate() {
        assertEquals(2, Stack.calculate("3 3 + 2 - 5 * 10 / ;") );
        assertEquals(4, Stack.calculate("3 3 + 2 - 5 * 10 / 2 * ;") );
        assertEquals(11, Stack.calculate("3 2 - 10 + ;") );
        assertEquals(10, Stack.calculate("100 100 + 20 / ;") );
    }
}


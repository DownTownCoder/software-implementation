package com.downtowncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class MathNegateExactUnitTest {
    /**
     * Show that a negation of a negation works.
     * Shows that in integer can be made to alternation between positive and negative with the same assignment. This is useful when working within loops.
     */
    @Test
    void whenMathNegateExactUsed_thenChangeSign() {
        int x = 10;

        x = Math.negateExact(x);
        assertEquals(x, -10);

        x = Math.negateExact(x);
        assertEquals(x, 10);

        x = Math.negateExact(x);
        assertEquals(x, -10);
    }

    /**
     * A predefined empty exception string is assigned the ArithmeticException message.
     * Math.negateExact() throws an ArithmeticException when it is given a value equal to the minimum Integer boundary value. Attempt to return a value above Integer.MAX_VALUE.
     * All we need to do is provide the try-catch statement.
     */
    @Test
    void whenArithmeticExceptionThrown_thenSetExceptionStringToNotEmpty() {
        String exception = "";

        try {
            int x = Integer.MIN_VALUE;
            x = Math.negateExact(x);
        } catch (ArithmeticException e) {
            exception = e.getMessage();
            //System.out.println( e.getMessage() );
        }

        assertFalse(exception.isEmpty());
    }
}

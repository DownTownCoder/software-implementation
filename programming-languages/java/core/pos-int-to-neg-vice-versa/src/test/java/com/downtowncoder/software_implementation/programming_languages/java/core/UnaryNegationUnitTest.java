package com.downtowncoder.software_implementation.programming_languages.java.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UnaryNegationUnitTest {
    /**
     * Show that a negation of a negation works.
     * Shows that in integer can be made to alternate between positive and negative with the same assignment. This is useful when working within loops.
     */
    @Test
    void whenUnaryOperatorUsed_thenChangeSign() {
        int x = 10;

        x = -x;
        assertEquals(x, -10);

        x = -x;
        assertEquals(x, 10);

        x = -x;
        assertEquals(x, -10);
    }

    /**
     * A predefined empty exception string remains empty.
     * Shows that unary operator does not throw ArithmeticException when attempting to negate Integer.MIN_VALUE.
     * We would need to define if-statement and throw the exception ourselves.
     */
    @Test
    void whenTryCatchUsed_thenExceptionStringRemainsEmpty() {
        String exception = "";

        try {
            int x = Integer.MIN_VALUE;
            x = -x;                         // Attempt to return a value above Integer.MAX_VALUE
        } catch (ArithmeticException e) {
            exception = e.getMessage();
            //System.out.println( e.getMessage() );
        }

        assertTrue(exception.isEmpty());
    }

    /**
     * Unary negation does not throw an exception when it is given a value equal to the minimum Integer boundary value.
     *
     * The Integer.MIN_VALUE (-2147483648) negates to 2147483648. This is one more than Integer.MAX_VALUE, which constitutes an Integer overflow. An attempt to assign a value above the Integer.MAX_VALUE of 2147483647 fails without throwing an exception.
     *
     * [1] When trying x = -x, the negation fails because no room for 2147483648, so value of x remains at -2147483648, x remains on -2147483647. When we try to negate x in the tests with -x, again the negation fails and the value of x is returned.
     */
    @Test
    void whenIntegerOverflow_thenNoExceptionThrown() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println();

        int x = Integer.MIN_VALUE;
        x = -x;                                                 // [1]

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(-x));

        System.out.println(x);
        System.out.println(-x);

        assertEquals(x, Integer.MIN_VALUE);
        assertEquals(-x, Integer.MIN_VALUE);
        assertEquals(x, -x);
    }

    /**
     * Here's another test involving a temporary variable.
     */
    @Test
    void whenThereIsATemporaryVariable_thenChangeSign() {
        int x = 10;
        int y = -x;                 // y == -10
        assertEquals(-y, x);      // -y == --10 == 10 == x
    }

}

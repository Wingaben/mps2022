package org.wingaben.fibonacci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wingaben.factorial.Factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test cases:
 * fibonacci 0 --> 0 *
 * fibonacci 1 --> 1 *
 * fibonacci 2 --> 1 *
 * fibonacci 3 --> 2 *
 * fibonacci 4 --> 3 *
 * fibonacci 5 --> 5 *
 * fibonacci negative number --> raises an exception *
 */

public class FibonacciTest {
    private Fibonacci fibonacci ;

    @BeforeEach
    public void setup(){
        fibonacci = new Fibonacci() ;
    }

    @AfterEach
    public void finish(){
        fibonacci = null ;
    }

    @Test
    public void testComputeReturnZeroIfTheNumberIsZero(){
        int expectedValue=0;
        int obtainedValue = fibonacci.compute(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnOneIfTheNumberIsOne(){
        int expectedValue=1;
        int obtainedValue = fibonacci.compute(1);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnOneIfTheNumberIsTwo(){
        int expectedValue=1;
        int obtainedValue = fibonacci.compute(2);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnTwoIfTheNumberIsThree(){
        int expectedValue=2;
        int obtainedValue = fibonacci.compute(3);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnThreeIfTheNumberIsFour(){
        int expectedValue=3;
        int obtainedValue = fibonacci.compute(4);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnFiveIfTheNumberIsFive(){
        int expectedValue=5;
        int obtainedValue = fibonacci.compute(5);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeOfANegativeNumberRaisesAnException(){
        assertThrows(RuntimeException.class, ()->fibonacci.compute(-1)) ;
    }
}

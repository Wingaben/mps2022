package org.wingaben.factorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases:
 * factorial 0 --> 1 *
 * factorial 1 --> 1 *
 * factorial 2 --> 2 *
 * factorial 3 --> 6 *
 * factorial 6 --> 720 *
 * factorial negative number --> raises an exception *
 */

class FactorialTest {
    private Factorial factorial ;

    @BeforeEach
    public void setup(){
        factorial = new Factorial() ;
    }

    @AfterEach
    public void finish(){
        factorial = null ;
    }

    @Test
    public void testComputeReturnOneIfTheNumberIsZero(){
        int expectedValue=1;
        int obtainedValue = factorial.compute(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnOneIfTheNumberIsOne(){
        int expectedValue=1;
        int obtainedValue = factorial.compute(1);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testComputeReturnSixIfTheNumberIsThree(){
        int expectedValue = 6 ;
        int obtainedValue = factorial.compute(3) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void testComputeReturn720IfTheNumberIsSix(){
        int expectedValue = 720 ;
        int obtainedValue = factorial.compute(6) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void testComputeOfANegativeNumerRaisesAnException(){
        assertThrows(RuntimeException.class, ()->factorial.compute(-1)) ;
    }
}
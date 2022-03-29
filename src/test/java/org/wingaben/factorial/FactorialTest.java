package org.wingaben.factorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
@DisplayName("Factorial")
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

    @DisplayName("returns one if number is zero")
    @Test
    public void testComputeReturnOneIfTheNumberIsZero(){
        int expectedValue=1;
        int obtainedValue = factorial.compute(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @DisplayName("returns one if number is one")
    @Test
    public void testComputeReturnOneIfTheNumberIsOne(){
        int expectedValue=1;
        int obtainedValue = factorial.compute(1);

        assertEquals(expectedValue, obtainedValue);
    }

    @DisplayName("returns two if number is two")
    @Test
    public void testComputeReturnTwoIfTheNumberIsTwo(){
        int expectedValue = 2;
        int obtainedValue = factorial.compute(2);

        assertEquals(expectedValue, obtainedValue);
    }

    @DisplayName("returns six if number is three")
    @Test
    public void testComputeReturnSixIfTheNumberIsThree(){
        int expectedValue = 6 ;
        int obtainedValue = factorial.compute(3) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @DisplayName("returns 720 if number is six")
    @Test
    public void testComputeReturn720IfTheNumberIsSix(){
        int expectedValue = 720 ;
        int obtainedValue = factorial.compute(6) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @DisplayName("returns RuntimeException if negative number")
    @Test
    public void testComputeOfANegativeNumberRaisesAnException(){
        assertThrows(RuntimeException.class, ()->factorial.compute(-1)) ;
    }

    @DisplayName("has an instance")
    @Test
    public void testFactorialClass(){
        assertNotNull(factorial.getClass());
    }
}
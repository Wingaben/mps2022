package org.wingaben.examples;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.wingaben.factorial.Factorial;

class ExamplesOfAssertionsTest {
    private double EPSILON = 0.0000001 ;

    @Test
    public void simpleAssertionExamples() {
        assertEquals(4, 3 + 1);
        assertEquals(4.0, 3.0 + 1.0, EPSILON);
        assertNotEquals(4, 5 + 2);

        assertTrue(6 > 5);
        assertTrue("hello".startsWith("h")) ;
        assertTrue("hello".contains("e")) ;
        assertFalse("hello".contains("v"));

        assertThrows(RuntimeException.class, () -> new Factorial().compute(-1)) ;

        assertTimeout(Duration.ofMillis(1), () -> new Factorial().compute(50));

        double[] expectedArray = new double[]{1.0, 5.0, 5.2} ;
        assertArrayEquals(expectedArray, new double[]{1.0, 5.0, 5.2});

        double[] anotherArray = expectedArray ;
        assertSame(expectedArray, anotherArray);

        Object nullObject = null ;
        assertNull(nullObject) ;
    }

    @Test
    public void simpleAssertionExamplesWithAssertTrue() {
        assertTrue(4 == 3 + 1);
        assertTrue(4.0 == 3.0 + 1.0);
        assertTrue(4 != 5 + 2);

        assertTrue(6 > 5);
        assertTrue("hello".startsWith("h")) ;
        assertTrue("hello".contains("e")) ;
        assertTrue(!"hello".contains("v"));

        double[] expectedArray = new double[]{1.0, 5.0, 5.2} ;
        assertTrue(Arrays.equals(expectedArray, new double[]{1.0, 5.0, 5.2})) ;

        double[] anotherArray = expectedArray ;
        assertTrue(expectedArray == anotherArray);
        assertTrue(expectedArray.equals(anotherArray));

        Object nullObject = null ;
        assertTrue(null == nullObject) ;
    }
}
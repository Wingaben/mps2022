package org.wingaben.examples;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.wingaben.factorial.Factorial;

class AssertJExamplesTest {

    private double EPSILON = 0.0000001;

    @Test
    public void simpleAssertionExamples() {
        assertThat(4).isEqualTo(3 + 1);
        assertThat(4.0).isEqualTo(3.0 + 1.0);
        assertThat(4).isNotEqualTo(5 + 2);

        assertThat(6).isGreaterThan(5);

        assertThat("hello")
                .startsWith("h")
                .endsWith("o")
                .contains("e")
                .doesNotContain("v")
                .hasSize(5);

        double[] expectedArray = new double[]{1.0, 5.0, 5.2};
        assertThat(expectedArray).isEqualTo(new double[]{1.0, 5.0, 5.2}) ;
        assertThat(expectedArray)
                .contains(5.0)
                .containsAnyOf(1.0, 2.0) ;

        double[] anotherArray = expectedArray;
        assertThat(expectedArray).isSameAs(anotherArray);

        Object nullObject = null;
        assertThat(nullObject).isNull();
    }
}
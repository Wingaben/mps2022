package org.wingaben.mock.exercises;

/*
  Example Dummy
  Example Fake
  Example Stub
  Example Spy
  Example Mock
 */

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockingExampleTest {

    private static class ExampleClass1 {
    }

    @Test
    public void test() {
        ExampleClass1 example = Mockito.mock(ExampleClass1.class) ;

        assertNotNull(example) ;
    }
}

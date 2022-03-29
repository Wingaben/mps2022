package org.wingaben.mock.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockedListTest {

    @Test
    public void simpleMockingExamples() {
        // STEP 1: create mock object
        List<String> mockedList = mock(List.class);

        // STEP 2: using the mock object
        mockedList.add("green");
        mockedList.add("blue");
        mockedList.add("green");
        mockedList.clear();

        // STEP 3: verify the calls to the mocked object
        verify(mockedList).add("blue");
        verify(mockedList, times(2)).add("green");
        verify(mockedList).clear();

        verify(mockedList, times(3)).add(anyString());
        verify(mockedList, never()).add("red");
        verify(mockedList, never()).size();
        verify(mockedList, atLeastOnce()).add("green");
        verify(mockedList, atLeast(1)).add(anyString());
    }

    @Test
    public void simpleStubbingExamples() {
        // STEP 1: create mock object
        List<String> mockedList = mock(List.class);

        // STEP 2: stubbing
        mockedList.add("green");
        mockedList.add("blue");
        when(mockedList.size()).thenReturn(2);

        // STEP 3: verify the calls to the mocked object
        verify(mockedList, times(2)).add(anyString());

        assertEquals(2, mockedList.size());
    }

    @Test
    public void examplesOfSpying() {
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("green");
        spyList.add("red");

        verify(spyList).add("green");
        verify(spyList).add("red");
        verify(spyList, times(2)).add(anyString());

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }
}

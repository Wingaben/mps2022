package org.wingaben.doubleendedqueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    @Test
    public void shouldConstructorAssignedTheCorrectValue() {
        var node = new DequeNode<>(1, null, null);
        int expectedValue = 1;
        int obtainedValue = node.getItem();

        assertEquals(expectedValue, obtainedValue);
        assertNull(node.getPrevious());
        assertNull(node.getNext());
    }

    @Test
    public void shouldConstructorInitializeNodeWithPreviousAndNext() {
        var previousNode = new DequeNode<>(1, null, null);
        var nextNode = new DequeNode<>(3, null, null);
        var currentNode = new DequeNode<>(2, nextNode, previousNode);

        // we use assertSame because assertEquals returns correct test
        // with different nodes and same values
        assertSame(previousNode, currentNode.getPrevious());
        assertSame(nextNode, currentNode.getNext());
    }

    @Test
    public void shouldReturnIsFirstNode(){
        var firstNode = new DequeNode<>(1, null, null) ;
        var thirdNode = new DequeNode<>(3, null, null) ;
        var secondNode = new DequeNode<>(2, thirdNode, firstNode) ;
        firstNode.setNext(secondNode);
        thirdNode.setPrevious(secondNode);

        assertTrue(firstNode.isFirstNode());
    }

    @Test
    public void shouldReturnIsLastNode(){
        var firstNode = new DequeNode<>(1, null, null) ;
        var thirdNode = new DequeNode<>(3, null, null) ;
        var secondNode = new DequeNode<>(2, thirdNode, firstNode) ;
        firstNode.setNext(secondNode);
        thirdNode.setPrevious(secondNode);

        assertTrue(thirdNode.isLastNode());
    }

    @Test
    public void shouldReturnIsNotTerminalNode(){
        var firstNode = new DequeNode<>(1, null, null) ;
        var thirdNode = new DequeNode<>(3, null, null) ;
        var secondNode = new DequeNode<>(2, thirdNode, firstNode) ;
        firstNode.setNext(secondNode);
        thirdNode.setPrevious(secondNode);

        assertTrue(secondNode.isNotATerminalNode());
    }

    @Test
    public void shouldReturnItem(){
        var firstNode = new DequeNode<>(null, null,null);
        firstNode.setItem(1);
        int expectedValue = 1;
        int obtainedValue = (int) firstNode.getItem();

        assertEquals(expectedValue, obtainedValue);
    }
}

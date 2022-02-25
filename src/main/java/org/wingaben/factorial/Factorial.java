package org.wingaben.factorial;

/**
 * Class providing a method that computes the factorial of an integer number
 *
 * @author José Luis Quiñones N.
 */

public class Factorial {

    public int compute(int value) {
        if(value < 0)
            throw new RuntimeException("Negative value: " + value);
        int factorial = 1;
        while ( value!=0) {
            factorial=factorial*value; value--;
        }
        return factorial ;
    }
}

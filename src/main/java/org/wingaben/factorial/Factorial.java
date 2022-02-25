package org.wingaben.factorial;

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

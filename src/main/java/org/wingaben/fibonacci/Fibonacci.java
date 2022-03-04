package org.wingaben.fibonacci;

/**
 * Class providing a method that computes the fibonnaci sucesion of a number
 *
 * @author José Luis Quiñones N.
 */

public class Fibonacci {

    public int compute(int value) {
        if(value < 0) {
            throw new RuntimeException("Negative value: " + value);
        }else if(value==0){
            return 0;
        }else if(value==1){
            return 1;
        }else{
            return compute(value-1)+compute(value-2);
        }
    }
}
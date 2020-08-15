package com.arpan.operators;

import java.util.List;

public class DefaultMultiplier implements Multiplier {
    
    @Override
    public Integer multiply(List<Integer> numList) {
        
        if (!numList.isEmpty()) {
            Integer product=1;
            for (Integer num: numList) {
                product = Math.multiplyExact(product, num); // To check integer overflow, returns ArithmeticException by default.
            }
            return product;
        }
        throw new IllegalStateException("List is Empty, can't perform the operation!");        
    }
}
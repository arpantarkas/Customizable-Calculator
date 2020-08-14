package com.arpan.operators;

import java.util.List;

public class DefaultMultiplier implements Multiplier {
    
    @Override
    public Integer multiply(List<Integer> numList) throws Exception {
        
        if (numList.isEmpty() == false) {
            Integer product=1;
            for (Integer num: numList) {
                product *= num;
            }
            return product;
        }
        throw new Exception("ss");        
    }
}
package com.arpan.operators;

import java.util.ArrayList;
import java.util.List;

import com.arpan.Operation;

public class DefaultAdder implements Adder {

    @Override
    public Integer add(List<Integer> numList) {
        if (!numList.isEmpty()) {
            Integer sum=numList.get(0);
            for (int num=1; num<numList.size(); num++) {
                sum = Math.addExact(sum, numList.get(num));
                
            }
            return sum;
        }
        throw new IllegalStateException("List is Empty, can't perform the operation!");
    }
    
}
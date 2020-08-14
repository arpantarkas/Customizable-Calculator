package com.arpan.operators;

import java.util.List;

public class DefaultAdder implements Adder {

    @Override
    public Integer add (List<Integer> numList) throws Exception {

        if (numList.isEmpty() == false) {
            Integer sum=0;
            for (Integer num: numList) {
                sum += num;
            }
            return sum;
        }
        throw new Exception("ss");
    }
    
}
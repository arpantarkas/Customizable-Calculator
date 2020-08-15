package com.arpan.operators;

public class DefaultDivider implements Divider {
    @Override
    public Integer divide(Integer a, Integer b) {
        return Math.floorDiv(a, b);
    }
}
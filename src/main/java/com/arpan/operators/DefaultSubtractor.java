package com.arpan.operators;

public class DefaultSubtractor implements Subtractor{
    @Override
    public Integer subtract(Integer a, Integer b) {
        return Math.subtractExact(a, b);
    }
}
package com.arpan;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.arpan.operators.Adder;
import com.arpan.operators.DefaultAdder;

import org.junit.Test;
import org.mockito.InjectMocks;

public class CalculatorTest {
    @InjectMocks
    Calculator calculator;

    @Test
    public void basicTestInDefaultMode () {
        Calculator calculator = new Calculator.Builder().build();
        List<Integer> numList = Arrays.asList(1, 2, -1, 4);

        Integer sum = calculator.multiply(numList);
        
        assertEquals("Sum should be", -8, (int)sum);
    }

    @Test
    public void customizedModeTest () {
        Adder myAdder = numList -> numList.size();
        List<Integer> numList = Arrays.asList(1, 2, -1, 4);

        Calculator calculator = new Calculator.Builder()
                .addAdder(myAdder)
                .build();
        Integer sum=null, product=null;
        try {
            sum = calculator.add(numList);
            product = calculator.multiply(numList);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        assertEquals("The calculator should return size of numbers passed as specified by myAdder", 4, (int)sum);
        assertEquals("The multiplication behavior should remain same", -8, (int)product);
        
    }

}
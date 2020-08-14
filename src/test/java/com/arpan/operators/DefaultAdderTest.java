package com.arpan.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DefaultAdderTest {
    
    DefaultAdder defaultAdder;
    
    @Before
    public void init() {
        defaultAdder = new DefaultAdder();
    }

    @Test
    public void basicTest() {
        List<Integer> numList = Arrays.asList(1, 2, -1);
        
        try {
            Integer sum=0;
            sum = defaultAdder.add(numList);
            assertEquals("Sum should be 1", 2, (int)sum);

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        
    }

    @Test
    public void checkEmptyListTest() {
        List<Integer> numList = Arrays.asList();
        try {
            defaultAdder.add(numList);
            fail("Adding an empty list should throw exception");
        } catch (Exception e) {
            //TODO: handle exception
            
            assertTrue("Exception detected", true);
        }
    }
}
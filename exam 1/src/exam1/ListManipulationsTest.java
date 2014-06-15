package exam1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListManipulationsTest {
    
  
    private List<Integer> input;
    private List<Integer> output;
    
    @Before
    public void setUp() throws Exception {
        input = new ArrayList<Integer>(Arrays.asList(8,3,4,2,6));
    }

    @After
    public void tearDown() throws Exception {
    }
    
    // reverse() Tests
    @Test
    public void testReverse() {
        output = new ArrayList<Integer>(Arrays.asList(6,2,4,3,8));
        assertEquals(output, ListManipulations.reverse(input));
    }
    
    @Test
    public void testReverseFewerElementsOfOutputList() {
        output = new ArrayList<Integer>(Arrays.asList(6,2,4,3));
        assertNotEquals(output, ListManipulations.reverse(input));
    }
    
    // sort() Tests
    @Test
    public void testSort() {
        output = new ArrayList<Integer>(Arrays.asList(2,3,4,6,8));
        assertEquals(output, ListManipulations.sort(input));
    }
    
    
    // isMonotonous() Tests
    @Test
    public void testIsMonotonousAscendingOrder() {
        output = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        assertTrue(ListManipulations.isMonotonous(output));
    }
    
    @Test
    public void testIsMonotonousDescendingOrder() {
        output = new ArrayList<Integer>(Arrays.asList(6,5,4,3,2,1,1,1));
        assertTrue(ListManipulations.isMonotonous(output));
    }
    
    public void testIsNotMonotonous() {
        output = new ArrayList<Integer>(Arrays.asList(1,2,1,4,5,4));
        assertFalse(ListManipulations.isMonotonous(output));
    }
}

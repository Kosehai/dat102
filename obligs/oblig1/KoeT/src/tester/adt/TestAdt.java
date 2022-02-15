package tester.adt;

import no.hvl.dat102.adt.KoeADT;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class TestAdt {
    
    public KoeADT<Integer> stack;
    
    public Integer testint0 = 0;
    public Integer testint1 = 1;
    public Integer testint2 = 2;
    public Integer testint3 = 3;
    public Integer testint4 = 4;

    protected abstract KoeADT<Integer> reset();

    @BeforeEach
    public void setup(){
        stack = reset();
    }

    @Test
    public void testInnKoe(){
        stack.innKoe(testint0);
        assertEquals(0, stack.foerste());
    }

    @Test
    public void testUtKoe(){
        stack.innKoe(testint0);
        stack.innKoe(testint1);
        stack.innKoe(testint3);
        Integer uttest = stack.utKoe();
        assertEquals(uttest, testint0);
    }

    @Test
    public void testerTom(){
        stack.innKoe(testint0);
        assertFalse(stack.erTom());
        stack.utKoe();
        assertTrue(stack.erTom());
    }

    @Test
    public void testFoerste(){
        stack.innKoe(testint0);
        assertEquals(testint0, stack.foerste());
    }
}

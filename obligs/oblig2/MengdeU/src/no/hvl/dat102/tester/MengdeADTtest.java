package no.hvl.dat102.tester;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;

public abstract class MengdeADTtest {
    private MengdeADT<Integer> m1;
    private MengdeADT<Integer> m2;
    private MengdeADT<Integer> m3; //For sjekker

    private Integer i0 = 0;
    private Integer i1 = 1;
    private Integer i2 = 2;
    private Integer i3 = 3;

    protected abstract MengdeADT<Integer> reset();
        
    @BeforeEach
    public void setup(){
        m1 = reset();
        m2 = reset();
        m3 = reset();
    }

    @Test
    public void testUnion(){
        m1.leggTil(i0);
        m1.leggTil(i1);
        m2.leggTil(i2);
        m2.leggTil(i3);
        m3 = m1.union(m2);
        boolean sjekk = m3.inneholder(i0) && m3.inneholder(i1) && m3.inneholder(i2) && m3.inneholder(i3);
        assertEquals(true, sjekk);
    }

    @Test
    public void testSnitt(){
        System.out.println(m1);
        m1.leggTil(i0);
        m1.leggTil(i1);
        m2.leggTil(i0);
        m2.leggTil(i3);
        var m3 = m1.snitt(m2);
        assertEquals(true, m3.inneholder(i0));
    }

    @Test
    public void testDiff(){
        m1.leggTil(i0);
        m1.leggTil(i1);
        m2.leggTil(i0);
        m2.leggTil(i3);
        var m3 = m1.differens(m2);
        assertEquals(true, 
            m3.inneholder(i1) && 
            m3.inneholder(i3));
    }
}

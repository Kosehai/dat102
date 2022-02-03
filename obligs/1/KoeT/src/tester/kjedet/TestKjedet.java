package tester.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;
import tester.adt.TestAdt;

public class TestKjedet extends TestAdt {
    @Override
    protected KoeADT<Integer> reset() {
        return new KjedetKoe<Integer>();
    }
}

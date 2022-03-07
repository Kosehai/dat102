package no.hvl.dat102.tester;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class MengdeTabelltest extends MengdeADTtest {
    @Override
    protected MengdeADT<Integer> reset() {
        return new TabellMengde<Integer>();
    }
}

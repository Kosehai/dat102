package no.hvl.dat102.tester;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class MengdeKjedettest extends MengdeADTtest{
@Override
    protected MengdeADT<Integer> reset() {
        return new KjedetMengde<Integer>();
    }
}

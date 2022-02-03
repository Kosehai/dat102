package tester.tabell;

import no.hvl.dat102.adt.StabelADT;
import tester.adt.StabelADTTest;
import no.hvl.dat102.tabell.TabellStabel;

public class TabellStabelTest extends StabelADTTest {

	@Override
	protected StabelADT<Integer> reset() {
		return new TabellStabel<Integer>();
	}

}

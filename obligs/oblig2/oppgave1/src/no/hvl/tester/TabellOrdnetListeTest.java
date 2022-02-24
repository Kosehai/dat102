package no.hvl.tester;

import no.hvl.oppgave1.OrdnetListeADT;
import no.hvl.tester.OrdnetListeADTTest;
import no.hvl.oppgave1.KjedetOrdnetListe;
import no.hvl.oppgave1.TabellOrdnetListe;

public class TabellOrdnetListeTest extends OrdnetListeADTTest {
	@Override
	protected OrdnetListeADT<Integer> reset() {
		return new TabellOrdnetListe<Integer>();
	}
}


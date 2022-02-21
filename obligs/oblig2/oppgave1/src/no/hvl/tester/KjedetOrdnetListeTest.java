package no.hvl.tester;

import no.hvl.oppgave1.*;


public class KjedetOrdnetListeTest extends  OrdnetListeADTTest{
	   @Override
		protected OrdnetListeADT<Integer> reset() {
			return new KjedetOrdnetListe<Integer>();
		}		
}


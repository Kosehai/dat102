package tester.tabell;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.tabell.TabellSirkulaerKoe;
import tester.adt.TestAdt;
import org.junit.jupiter.api.Test;

public class TestTabell extends TestAdt{
    @Override
    protected KoeADT<Integer> reset() {
        return new TabellSirkulaerKoe<Integer>();
    }

    //Frivillig
    @Test
    public void testUtvid(){
        for(int i = 0; i<120; i++){
            assertDoesNotThrow(() -> super.stack.innKoe(testint0));
        }
    }
}

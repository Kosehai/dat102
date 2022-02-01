package tester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.oblig1.Film;
import no.hvl.oblig1.Filmarkiv;
import no.hvl.oblig1.Sjanger;

public class TestFilmarkiv {
    Film testfilm = new Film(10, "Test Prod", "Test Tittel", 1990, Sjanger.ACTION, "Test Selskap");
    
    @Test
    public void testStandardConstructor() {
        Filmarkiv arkiv = new Filmarkiv();
        assertEquals(arkiv.antall(), 0);
    }

    @Test
    public void testleggTil(){
        Filmarkiv arkiv = new Filmarkiv();
        arkiv.leggTilFilm(testfilm);
        assertEquals(arkiv.finnFilm(testfilm.getFilmnr()), true);
    }

    @Test
    public void testantall(){
        Filmarkiv arkiv = new Filmarkiv();
        arkiv.leggTilFilm(testfilm);
        assertEquals(1, arkiv.antall());
    }

    @Test
    public void testantallSjanger(){
        Filmarkiv arkiv = new Filmarkiv();
        arkiv.leggTilFilm(testfilm);
        assertEquals(1, arkiv.antall(Sjanger.ACTION));
    }

    @Test
    public void testslettFilm(){
        Filmarkiv arkiv = new Filmarkiv();
        arkiv.leggTilFilm(testfilm);
        arkiv.slettFilm(testfilm.getFilmnr());
        assertEquals(0, arkiv.antall());
    }

    @Test
    public void testsoekTittel(){
        Filmarkiv arkiv = new Filmarkiv();
        Film testfilm2 = new Film(10, "Test Prod2", "Dette er tittel 2", 1992, Sjanger.DRAMA, "Test Selskap2");
        Film testfilm3 = new Film(10, "Test Prod3", "Her er en til", 1993, Sjanger.HISTORY, "Test Selskap3");
    
        arkiv.leggTilFilm(testfilm);
        arkiv.leggTilFilm(testfilm2);
        arkiv.leggTilFilm(testfilm3);

        Film[] sok1 = arkiv.soekTittel("Test Tittel");
        Film[] sok2 = arkiv.soekTittel("Dette er");
        Film[] sok3 = arkiv.soekTittel("er en til");
        for(Film f : sok1){
            assertEquals(testfilm, f);
        }
        for(Film f : sok2){
            assertEquals(testfilm2, f);
        }
        for(Film f : sok3){
            assertEquals(testfilm3, f);
        }

    }

}

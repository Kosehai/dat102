package tester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.oblig1.Film;
import no.hvl.oblig1.Filmarkiv2;
import no.hvl.oblig1.Sjanger;

public class TestFilmarkiv2 {
    Film testfilm = new Film(10, "Test Prod", "Test Tittel", 1990, Sjanger.ACTION, "Test Selskap");
    
    @Test
    public void testStandardConstructor() {
        Filmarkiv2 arkiv = new Filmarkiv2();
        assertEquals(arkiv.antall(), 0);
    }

    @Test
    public void testleggTil(){
        Filmarkiv2 arkiv = new Filmarkiv2();
        arkiv.leggTilFilm(testfilm);
        assertEquals(arkiv.finnFilm(testfilm.getFilmnr()), true);
    }

    @Test
    public void testantall(){
        Filmarkiv2 arkiv = new Filmarkiv2();
        arkiv.leggTilFilm(testfilm);
        assertEquals(1, arkiv.antall());
    }

    @Test
    public void testantallSjanger(){
        Filmarkiv2 arkiv = new Filmarkiv2();
        Film testfilm2 = new Film(15, "Test Prod2", "Dette er tittel 2", 1992, Sjanger.ACTION, "Test Selskap2");
        arkiv.leggTilFilm(testfilm);
        arkiv.leggTilFilm(testfilm2);
        assertEquals(2, arkiv.antall(Sjanger.ACTION));
    }

    @Test
    public void testslettFilm(){
        Filmarkiv2 arkiv = new Filmarkiv2();
        Film testfilm2 = new Film(13, "Test Prod2", "Dette er tittel 2", 1992, Sjanger.DRAMA, "Test Selskap2");
        Film testfilm3 = new Film(14, "Test Prod3", "Her er en til", 1993, Sjanger.HISTORY, "Test Selskap3");
    
        arkiv.leggTilFilm(testfilm);
        arkiv.leggTilFilm(testfilm2);
        arkiv.leggTilFilm(testfilm3);
        int antall = arkiv.antall() - 1;
        arkiv.slettFilm(testfilm3.getFilmnr());
        assertEquals(antall, arkiv.antall());
    }

    @Test
    public void testsoekTittel(){
        Filmarkiv2 arkiv = new Filmarkiv2();
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

package tester;

import org.junit.Test;
import static org.junit.Assert.*;
import no.hvl.oblig1.*;

public class TestFilm {
    @Test
    public void testStandardConstructor() {
        Film film = new Film();
        assertEquals(film.getFilmnr(), 0);
        assertEquals(film.getProdusent(), "");
        assertEquals(film.getTittel(), "");
        assertEquals(film.getYear(), 0);
        assertEquals(film.getFilmselskap(), "");
    }

    @Test
    public void testConstructor() {
        Film film = new Film(10, "test", "testtittel", 1990, Sjanger.ACTION, "testselskap");
        assertEquals(film.getFilmnr(), 10);
        assertEquals(film.getProdusent(), "test");
        assertEquals(film.getTittel(), "testtittel");
        assertEquals(film.getYear(), 1990);
        assertEquals(film.getFilmselskap(), "testselskap");
        assertEquals(film.getSjanger(), Sjanger.ACTION);
    }

    @Test
    public void testleggTil() {
    }
}
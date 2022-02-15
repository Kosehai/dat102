package no.hvl.oblig1;

import java.io.Console;

public class Tekstgrensesnitt {

    Console console;

    public Tekstgrensesnitt(){
        console = System.console();
    }

    // lese opplysningene om en FILM fra tastatur
    public Film lesFilm(){
        System.out.println("Ny film:");
        Film nyfilm = new Film();
        nyfilm.setFilmnr(Integer.parseInt(console.readLine("Skriv in film.nr: ")));
        nyfilm.setTittel(console.readLine("Skriv inn tittel: "));
        nyfilm.setProdusent(console.readLine("Skriv inn produsent: "));
        nyfilm.setFilmselskap(console.readLine("Skriv inn filmselskap: "));
        nyfilm.setSjanger(Sjanger.finnSjanger(console.readLine("Skriv inn sjanger: ")));
        nyfilm.setYear(Integer.parseInt(console.readLine("Skriv in årstall: ")));
        return nyfilm;
    }
    // vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void visFilm(Film film) {
        System.out.println(film.toString());
    }
    // Skrive ut alle Filmer med en smkdipesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT filma,
     String delstreng) {
        for(Film f : filma.soekTittel(delstreng)){
            System.out.println(f.toString());
        }
    }
    // Skriver ut alle Filmer av en produsent / en gruppe
    public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
        //hack for å hente ut hele listen
        for(Film f : filma.soekTittel("")){
            if(f.getProdusent().contains(delstreng)) System.out.println(f.toString());
        }
    }
    // Skrive ut en enkel statistikk som inneholder antall Filmer totalt
    // og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT filma) {
        System.out.println("Totalt antall filmer: " + filma.antall());
        System.out.println(filma.toString() + "\n");
    }

    public int lesInput(){
        int valg = 0;
        try {
            valg = Integer.parseInt(console.readLine("\nSkriv inn int: "));
        } catch (Exception e){
            valg = 0;
        }
        return valg;
    }

    public int lesInput(String msg){
        int valg = 0;
        try {
            valg = Integer.parseInt(console.readLine("\n" + msg));
        } catch (Exception e){
            valg = 0;
        }
        return valg;
    }

    public String lesInputString(){
        return console.readLine("Skriv inn streng: ");
    }
}
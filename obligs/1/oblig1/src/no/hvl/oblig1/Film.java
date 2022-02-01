package no.hvl.oblig1;

import java.util.Set;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int year;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {
        filmnr = 0;
        produsent = "";
        tittel = "";
        year = 0;
        filmselskap = "";
    }

    public Film(int nr, String produsent, String tittel, int year, Sjanger sjanger, String filmselskap) {
        filmnr = nr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
        this.year = year;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public String getProdusent() {
        return produsent;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getTittel() {
        return tittel;
    }

    public int getYear() {
        return year;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Film == false)
            return false;
        Film filmobj = (Film) obj;
        return filmobj.filmnr == getFilmnr();
    }

    @Override
    public int hashCode() {
        Integer temp = filmnr;
        return temp.hashCode();
    }

    @Override
    public String toString() {
        return String.format("[nr: %d, {tittel: %s, filmselskap: %s, år: %s, sjanger: %s}]", getFilmnr(), getTittel(),
                getFilmselskap(), getYear(), getSjanger().toString());
    }
}
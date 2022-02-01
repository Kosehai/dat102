package no.hvl.oblig1;

import java.util.List;
import java.util.ArrayList;

public class Filmarkiv2 implements FilmarkivADT {

    LinearNode<Film> forstenode;
    LinearNode<Film> sistenode;
    int antall;

    public Filmarkiv2(){
        forstenode = new LinearNode<Film>();
        sistenode = forstenode;
        antall = 0;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> film = forstenode;
        boolean sistenode = false;
        while(sistenode == false){
            if(film.getElement().getSjanger() == sjanger) count++;
            film = film.getNeste();
            if(film == null) sistenode = true;
        }
        return count;
    }

    @Override
    public void visFilm(int nr) {
        LinearNode<Film> film = forstenode;
        while(film.getNeste() != null){
            if(film.getElement().getFilmnr() == nr) film.getElement().toString();
            film = film.getNeste();
        }
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        List<Film> filmlist = new ArrayList<Film>();
        
        LinearNode<Film> film = forstenode;
        boolean sistenode = false;
        while(sistenode == false){
            String tittel = film.getElement().getTittel();
            if(tittel.contains(delstreng)) filmlist.add(film.getElement());
            film = film.getNeste();
            if(film == null) sistenode = true;
        }
        
        Film[] returliste = new Film[filmlist.size()];
        for(int i=0;i<filmlist.size();i++){
            returliste[i] = filmlist.get(i);
        }

        return returliste;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(antall == 0){
            forstenode.setElement(nyFilm);
            antall++;
            return;
        }
        LinearNode<Film> nynode = new LinearNode<Film>(nyFilm);
        
        sistenode.setNeste(nynode);
        sistenode = nynode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        boolean slettet = false;
        if(forstenode.getElement() == null) return false;
        if(forstenode.getElement().getFilmnr() == filmnr){
            if(forstenode.getNeste() == null) {
                forstenode = new LinearNode<Film>();
                slettet = true;
            }
            forstenode = forstenode.getNeste();
            slettet = true;
        } else {
            boolean sistenode = false;
            LinearNode<Film> film = forstenode;
            while(sistenode == false){
                if(film.getNeste() == null) {
                    slettet = false;
                } else if(film.getNeste().getElement().getFilmnr() == filmnr){
                    film.setNeste(film.getNeste().getNeste());
                    slettet = true;
                }
                film = film.getNeste();
                if(film == null || slettet) sistenode = true;
            }
        }
        if(slettet) antall--;
        return slettet;
    }

    @Override
    public boolean finnFilm(int filmnr) {
        LinearNode<Film> film = forstenode;
        boolean sistenode = false;
        while(sistenode == false){
            if(film.getElement().getFilmnr() == filmnr) return true;
            film = film.getNeste();
            if(film == null) sistenode = true;
        }
        return false;
    }
    
}

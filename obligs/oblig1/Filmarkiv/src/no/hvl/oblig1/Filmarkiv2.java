package no.hvl.oblig1;

public class Filmarkiv2 implements FilmarkivADT {

    LinearNode<Film> forstenode;
    int antall;

    public Filmarkiv2(){
        forstenode = new LinearNode<Film>();
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
        while(film != null){
            if(film.getElement().getSjanger() == sjanger) count++;
            film = film.getNeste();
        }
        return count;
    }

    @Override
    public void visFilm(int nr) {
        LinearNode<Film> film = forstenode;
        while(film != null){
            if(film.getElement().getFilmnr() == nr) film.getElement().toString();
            film = film.getNeste();
        }
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] filmliste = new Film[antall];
        int c = 0;

        LinearNode<Film> film = forstenode;
        while(film != null){
            String tittel = film.getElement().getTittel();
            if(tittel.contains(delstreng)){
                filmliste[c++] = film.getElement();
            } 
            film = film.getNeste();
        }

        Film[] returliste = new Film[c];
        //trim array
        for(int i=0;i<c;i++){
            returliste[i] = filmliste[i];
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
        LinearNode<Film> neste = forstenode;
        while(neste.getNeste() != null){
            neste = neste.getNeste();
        }
        neste.setNeste(nynode);
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> neste, forrige = null;
        neste = forstenode;
        //Vist første node er den som skal slettest
        if(neste != null && neste.getElement().getFilmnr() == filmnr){
            forstenode = neste.getNeste();
        }

        while(neste != null && neste.getElement().getFilmnr() != filmnr){
            forrige = neste;
            neste = neste.getNeste();
        }
        //returnerer false om vi ikkje finner noen node med filmnr
        if(neste == null)
            return false;

        forrige.setNeste(neste.getNeste());
        antall--;
        return true;
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

    @Override
    public String toString() {
        String outstring = "";
        LinearNode<Film> neste = forstenode;
        while(neste != null){
            outstring += neste.getElement().toString();
            neste = neste.getNeste();
        }
        return outstring;
    }
    
}

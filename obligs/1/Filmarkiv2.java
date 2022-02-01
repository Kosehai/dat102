import java.util.List;
import java.util.ArrayList;

public class Filmarkiv2 implements FilmarkivADT {

    LinearNode<Film> forstenode;

    public Filmarkiv2(){
        forstenode = new LinearNode<Film>();
    }

    @Override
    public int antall() {
        int count = 0;
        LinearNode<Film> film = forstenode;
        while(film.getNeste() != null){
            film = film.getNeste();
            count++;
        }
        return count;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> film = forstenode;
        while(film.getNeste() != null){
            film = film.getNeste();
            if(film.getElement().getSjanger() == sjanger) count++;
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
        while(film.getNeste() != null){
            String tittel = film.getElement().getTittel();
            if(tittel.contains(delstreng)) filmlist.add(film.getElement());
            film = film.getNeste();
        }
        Film[] returliste = new Film[filmlist.size()];
        for(int i=0;i<filmlist.size();i++){
            returliste[i] = filmlist.get(i);
        }
        return returliste;
    }
    
}

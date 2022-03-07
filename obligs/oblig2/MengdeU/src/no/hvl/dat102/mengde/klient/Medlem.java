package no.hvl.dat102.mengde.klient;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
    private String navn; 
    private MengdeADT<Hobby> hobbyer;  
    private int statusIndeks; 
//... Konstruktør 
    public Medlem(String navn, String hobbyer, int statusIndeks){
        this.navn = navn;
        this.hobbyer = new TabellMengde<Hobby>();
        this.statusIndeks = statusIndeks;
    }
//... Andre metoder 
    public String getNavn() {
        return navn;
    }

    public MengdeADT<Hobby> getHobbyer() {
        return hobbyer;
    }

    public int getStatusIndeks() {
        return statusIndeks;
    }

    public boolean passerTill(Medlem m2){
        return this.hobbyer.equals(m2.getHobbyer());
    }

}

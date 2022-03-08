package no.hvl.dat102.mengde.klient;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
    private String navn; 
    private MengdeADT<Hobby> hobbyer;  
    private int statusIndeks; 
//... Konstruktør 
    public Medlem(String navn,  MengdeADT<Hobby> hobbyer, int statusIndeks){
        this.navn = navn;
        this.hobbyer = hobbyer;
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

    public void setStatusIndeks(int statusIndeks) {
        this.statusIndeks = statusIndeks;
    }

    public boolean passerTill(Medlem m2){
        return this.hobbyer.equals(m2.getHobbyer());
    }

}

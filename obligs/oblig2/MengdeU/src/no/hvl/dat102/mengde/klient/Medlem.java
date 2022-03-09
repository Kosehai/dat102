package no.hvl.dat102.mengde.klient;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
    private String navn; 
    private MengdeADT<Hobby> hobbyer;  
    private int statusIndeks; 
//... Konstruktør 
    public Medlem(String navn,  MengdeADT<Hobby> hobbyer){
        this.navn = navn;
        this.hobbyer = hobbyer;
        statusIndeks = -1;
    }
//... Andre metoder 
    public String getNavn() {
        return navn;
    }

    public MengdeADT<Hobby> getHobbyer() {
        return hobbyer;
    }

    public void leggTilHobby(Hobby h){
        hobbyer.leggTil(h);
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

    public void setHobbyer(MengdeADT<Hobby> hobbyer) {
        this.hobbyer = hobbyer;
    }

    @Override
    public String toString() {
        return String.format("\t{\"navn\": \"%s\", \"hobbier\": %s, \"index\": %d}", navn, hobbyer.toString(), statusIndeks);
    }

}

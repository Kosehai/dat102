package no.hvl.oblig1;

public class KlientFilmarkiv {
    public static void main(String[] args) {
        FilmarkivADT filma = new Filmarkiv2();
        Meny meny = new Meny(filma);
        meny.start();
    }
}
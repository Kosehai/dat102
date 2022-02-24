package no.hvl.dat102.klient;
import java.io.Console;
import java.util.Random;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;

public class KlientDobbelKjedetListe {
    public static void main(String[] args) throws Exception {
        Klient klient = new Klient();
        klient.mainloop(); 
    }
}

class Klient {
    Console console;
    DobbelKjedetOrdnetListe<Integer> dk;
    public Klient(){
        console = System.console();
        dk = new DobbelKjedetOrdnetListe<Integer>(0, 100000);
    }

    public void mainloop(){
        helpText();
        while(true){
            String input = console.readLine(": ");
            switch(input){
                case("1"):
                    leggtil();
                    break;
                case("2"):
                    finnes();
                    break;
                case("3"):
                    printall();
                    break;
                case("4"):
                    gen();
                    break;
                default:
                    helpText();
                    break;
            }
        }
    }

    void leggtil(){
        String input = console.readLine("Skriv in streng: ");
        try {
            dk.leggTil(Integer.parseInt(input));
        } catch (Exception e){
            System.out.println("Ikkje et tall");
        }
    }

    void finnes(){
        String input = console.readLine("Skriv in streng: ");
        int n = 1;
        try {
            n = Integer.parseInt(input);
        } catch(Exception e){
            System.out.println("Ugyldig tall");
        }
        Integer d = dk.fjern(n);
        if(d != null)
            System.out.println("Fjernet node");
        else
            System.out.println("Fant ikkje node");
    }

    void printall(){
        dk.visListe();
    }

    void helpText(){
        System.out.print("DobbelKjedet CLI\n==============\n1. Legg til int\n2. fjern node\n3. Print liste\n4. Generer tilfeldige tall\nctrl+c for å avslutte\n");
    }

    void gen(){
        Random rng = new Random();
        String input = console.readLine("Hvor mange tall?: ");
        int n = 0;
        try {
            n = Integer.parseInt(input);
        } catch(Exception e){
            System.out.println("Ugyldig tall");
        }
        for(int i=0;i<n;i++){
            dk.leggTil(rng.nextInt(1000));
        }
    }
}

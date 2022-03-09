package no.hvl.dat102.mengde.klient;

import java.util.Random;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Main {
    public static void main(String[] args) {
        Datakontakt tab = new Datakontakt();

        String[] hobbier = {
            "Ski",
            "Hockey",
            "Fotball",
            "Dungeons and dragons",
            "Databaser",
            "html programmering"
        };

        TabellMengde<Hobby> hobbier1 = new TabellMengde<>();
        TabellMengde<Hobby> hobbier2 = new TabellMengde<>();
        KjedetMengde<Hobby> hobbier3 = new KjedetMengde<>();


        Random rng = new Random();
        for(int i = 0; i<rng.nextInt(4)+1; i++){
            hobbier1.leggTil(new Hobby(hobbier[rng.nextInt(hobbier.length)]));
        }
        for(int i = 0; i<rng.nextInt(4)+1; i++){
            hobbier2.leggTil(new Hobby(hobbier[rng.nextInt(hobbier.length)]));
        }
        for(int i = 0; i<rng.nextInt(4)+1; i++){
            hobbier3.leggTil(new Hobby(hobbier[rng.nextInt(hobbier.length)]));
        }

 
        tab.leggTillMedlem(new Medlem("Arne", hobbier1));
        tab.leggTillMedlem(new Medlem("Kristine", hobbier2));
        tab.leggTillMedlem(new Medlem("Beate", hobbier3));
        tab.leggTillMedlem(new Medlem("bjarne", hobbier1));
        tab.leggTillMedlem(new Medlem("alexander", hobbier2));
        System.out.println(tab.toString());
    }
}

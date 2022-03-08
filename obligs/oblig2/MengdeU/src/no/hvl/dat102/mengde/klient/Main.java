package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Main {
    public static void main(String[] args) {
        Datakontakt tab = new Datakontakt();

        Hobby hob = new Hobby("hocky");
        KjedetMengde<Hobby> test = new KjedetMengde<Hobby>();
        test.leggTil(hob); 
      

 
        tab.leggTillMedlem(new Medlem("Arne", test , 9));
        tab.leggTillMedlem(new Medlem("Kristine", test, 4));
        tab.leggTillMedlem(new Medlem("Beate", test , 2));
        tab.leggTillMedlem(new Medlem("bjarne", test, 3));
        tab.leggTillMedlem(new Medlem("alexander", test, 7));



        System.out.println(tab.partner("Arne").getNavn());
        





    }
}

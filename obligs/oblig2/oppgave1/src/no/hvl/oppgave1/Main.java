package no.hvl.oppgave1;

/*
 Lag et enkelt main()-program der du oppretter en ordnet liste av Person-objekt, leser inn
4-6 objekter fra tastaturet og legger hvert objekt etter tur inn i listen. Til slutt tar du ut ett og
ett objekt fra listen og skriver det ut på skjermen i stigende alder inntil listen er tom. Pass på at
du har flere personer med samme fødselsår. Bruk både TabellOrdnetListe-klassen og
KjedetOrdnetListe-klassen.
*/
class Main {
  
  
  public static void main(String[] args) {
    TabellOrdnetListe<Person> liste = new TabellOrdnetListe<Person>(5);
   liste.leggTil(new Person("Zak", "Amil", 2000));
   liste.leggTil(new Person("Zak", "Bmil", 2000));
   liste.leggTil(new Person("Zak", "Bmil", 2001));
   liste.leggTil(new Person("Zak", "Bmil", 1999));
   liste.leggTil(new Person("Zak", "Bmil", 2005));
    
    liste.sorter();

    System.out.println(liste.toString());
    
    }
}


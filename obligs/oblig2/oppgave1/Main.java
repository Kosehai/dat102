/*
 Lag et enkelt main()-program der du oppretter en ordnet liste av Person-objekt, leser inn
4-6 objekter fra tastaturet og legger hvert objekt etter tur inn i listen. Til slutt tar du ut ett og
ett objekt fra listen og skriver det ut på skjermen i stigende alder inntil listen er tom. Pass på at
du har flere personer med samme fødselsår. Bruk både TabellOrdnetListe-klassen og
KjedetOrdnetListe-klassen.
*/
class Main {

  public static void main(String[] args) {
    Person Person1 = new Person("Zak", "Amil", 2000);
    Person Person2 = new Person("Zak", "Bmil", 2000);

    Person Person3 = new Person("Zak", "Bmil", 2001);
    Person Person4 = new Person("Zak", "Bmil", 1999);

    Person Person5 = new Person("Zak", "Bmil", 2005);

    System.out.println("Objekter er like: " + Person4.compareTo(Person5));
    System.out.println("Objekter er like: " + Person5.compareTo(Person4));
    System.out.println("Objekter er like: " + Person1.compareTo(Person2));
    System.out.println("Objekter er like: " + Person2.compareTo(Person1));
  }
}

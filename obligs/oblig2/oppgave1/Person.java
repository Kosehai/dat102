/*
Se Klassen Person i prosjektet ListeOrdnetU. Ferdigstill metoden compareTo. Metoden
skal sammenligne to Person-objekter med hensyn på fødselsår. Vi ønsker at den eldste
kommer først (compareTo returnerer et tall < 0). Ved sammenligning av like fødselsår skal
du sammenligne etternavn og deretter eventuelt fornavn (ønsker ordnet i alfabetisk
rekkefølge). Tips: Se gjerne compareTo i klassen Lag, i prosjektet ListeOrdnetU.
*/
public class Person implements Comparable<Person> {

  private String fornavn;
  private String etternavn;
  private int foedselsaar;

  // Konstruktører

  public Person() {
    this("", "", 0);
  }

  public Person(String fornavn, String etternavn, int foedselsaar) {
    this.fornavn = fornavn;
    this.etternavn = etternavn;
    this.foedselsaar = foedselsaar;
  }

  public void setFoedselsaar(int foedselsaar) {
    this.foedselsaar = foedselsaar;
  }

  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }

  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }

  int getFoedselsaar() {
    return foedselsaar;
  }

  public String getEtternavn() {
    return etternavn;
  }

  public String getFornavn() {
    return fornavn;
  }

  @Override
  public String toString() {
    return (foedselsaar + "\t" + etternavn + ", " + fornavn);
  }

  @Override
  public int compareTo(Person denAndrePersonen) {
    int diff = denAndrePersonen.getFoedselsaar() - this.getFoedselsaar();
    if (diff == 0) {
      int diff2 =
        this.getEtternavn().compareTo(denAndrePersonen.getEtternavn());
      if (diff2 == 0) {
        return this.getFornavn().compareTo(denAndrePersonen.getFornavn());
      }
      return diff2;
    }
    return diff;
  }
}

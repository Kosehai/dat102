class Heltall {
  private int tall;

  public Heltall(int n) {
    tall = n;
  }

  public void inkrementer() {
    tall++;
  }

  @Override
  public String toString() {
    return "" + tall;
  }
}

class Main {

  static void skrivTab(int[] tab) {

    for (int i = 0; i < tab.length; i++) {
      System.out.print(tab[i] + " ");
    }

    System.out.println();
  }

  public static void main(String[] args) {

    int[] hTab = { 1, 2, 3, 4 };
    skrivTab(hTab);

    // a) Hva blir skrevet ut?
    for (int i = 0; i < hTab.length; i++) {
      hTab[i]++;
    }
    skrivTab(hTab);
    //[2,3,4,5]

    // b) Hva blir skrevet ut?
    for (int t : hTab) {
      t++;
    }
    skrivTab(hTab);
    //[3,4,5,6]

    Heltall[] rTab = new Heltall[4];
    rTab[0] = new Heltall(1);
    rTab[1] = new Heltall(2);
    rTab[2] = new Heltall(3);
    rTab[3] = new Heltall(4);

    // c) Hvorfor fungerer ikke denne?
    // skrivTab(rTab);
    //Fordi rTab er en tabell av en klasse og ikke en int
    //Denne kunne fungert vist classen hadde en måte å returnere verdien sin på
    // d) Hva blir skrevet ut?
    for (Heltall t : rTab) {
      System.out.print(t + " ");
    }
    System.out.println();
    //1 2 3 4\n

    // e) Hva blir skrevet ut?
    for (Heltall t : rTab) {
      t.inkrementer();
    }

    for (Heltall t : rTab) {
      System.out.print(t + " ");
    }
    System.out.println();
    //2 3 4 5\n
  }
}
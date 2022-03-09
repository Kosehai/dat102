package no.hvl.dat102.mengde.klient;

public class Datakontakt {
    private int antallMedlemer;
    private Medlem[] medlemsTabell;

    public Datakontakt() {
        antallMedlemer = 0;
        medlemsTabell = new Medlem[100];
    }

    public Datakontakt(int antallMedlemer) {
        this.antallMedlemer = 0;
        medlemsTabell = new Medlem[antallMedlemer];
    }

    public void leggTillMedlem(Medlem m) {
        if (finnes(m) == true)
            return;
        if (antallMedlemer >= medlemsTabell.length)
            utvidKapasitet();
        m.setStatusIndeks(antallMedlemer);
        medlemsTabell[antallMedlemer++] = m;

    }

    public boolean finnes(Medlem m) {
        for (int i = 0; i < antallMedlemer; i++) {
            if (medlemsTabell[i].equals(m) == true)
                return true;
        }
        return false;
    }

    private void utvidKapasitet() {
        Medlem[] hjelpetabell = new Medlem[medlemsTabell.length * 2];
        for (int i = 0; i < medlemsTabell.length; i++) {
            hjelpetabell[i] = medlemsTabell[i];
        }
        medlemsTabell = hjelpetabell;
    }

    public int finnMedlemIndex(String s) {
        for (int i = 0; i < antallMedlemer; i++) {
            if (medlemsTabell[i].getNavn() == s)
                return medlemsTabell[i].getStatusIndeks();
        }
        return -1;
    }

    public int finnPartnerFor(String medlemsnavn) {
        if (finnMedlemIndex(medlemsnavn) == -1)
            return -1;
        Medlem m1 = medlemsTabell[finnMedlemIndex(medlemsnavn)];
        for (int i = 0; i < antallMedlemer; i++) {
            if (m1.equals(medlemsTabell[i]) == false &&
                    m1.getHobbyer().equals(medlemsTabell[i].getHobbyer()))
                return i;
        }
        return -1;
    }

    public void tilbakestillStatusIndex(String medlemsnavn) {
        if (finnMedlemIndex(medlemsnavn) == -1 || finnPartnerFor(medlemsnavn) == -1)
            return;
        Medlem m1 = medlemsTabell[finnMedlemIndex(medlemsnavn)];
        Medlem m2 = medlemsTabell[finnPartnerFor(medlemsnavn)];
        if (m1 != medlemsTabell[finnPartnerFor(medlemsnavn)]) {
            m1.setStatusIndeks(-1);
            m2.setStatusIndeks(-1);
        }
    }

    @Override
    public String toString() {
        String outstring = "[\n";
        for(int i=0;i<antallMedlemer;i++){
            outstring += medlemsTabell[i].toString();
            if(i < antallMedlemer-1)
                outstring += ", \n";
        }
        outstring += "\n]";
        return outstring;
    }
}

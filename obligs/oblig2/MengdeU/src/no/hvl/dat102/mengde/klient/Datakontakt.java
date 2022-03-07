package no.hvl.dat102.mengde.klient;


public class Datakontakt {
  private int antallMedlemer;
  private Medlem[] medlemsTabell;

    public Datakontakt(){
       antallMedlemer = 0; 
       medlemsTabell = new Medlem[100];

    }

    public Datakontakt(int antallMedlemer){
     this.antallMedlemer = 0;
     medlemsTabell = new Medlem[antallMedlemer]; 
    }

    public void leggTillMedlem(Medlem m){
        if(finnes(m) == true) return;
        if(antallMedlemer >= medlemsTabell.length) utvidKapasitet();
        medlemsTabell[antallMedlemer++] = m;

        
    }

    public boolean finnes(Medlem m){
        boolean finnes = false;
        for(int i = 0;i<antallMedlemer; i++ ){
            if(medlemsTabell[i].equals(m) == true){
                finnes = true;
            }
        }
        return finnes;
    }

    private void utvidKapasitet() {
		Medlem[] hjelpetabell = new Medlem[medlemsTabell.length*2];
		for (int i = 0; i < medlemsTabell.length; i++) {
			hjelpetabell[i] = medlemsTabell[i];
		}
		medlemsTabell = hjelpetabell;
	}

    private int finnIndex(String s){
        for(int i = 0; i<antallMedlemer; i++){
            if(medlemsTabell[i].getNavn() == s ) return medlemsTabell[i].getStatusIndeks();
        }
        return -1;
    }

    private Medlem finnPartnerFor(String medlemsnavn){
    
    }

    




}



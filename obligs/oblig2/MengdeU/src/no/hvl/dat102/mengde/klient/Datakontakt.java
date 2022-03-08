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

    public int finnMedlemIndex(String s){
        for(int i = 0; i<antallMedlemer; i++){
            if(medlemsTabell[i].getNavn() == s ) return medlemsTabell[i].getStatusIndeks();
        }
        return -1;
    }

    public int finnPartnerFor(String medlemsnavn){
        for(int i = 0; i< antallMedlemer; i++ ){
           
           if(navnTilMedlem(medlemsnavn).getHobbyer() == medlemsTabell[i].getHobbyer()) return medlemsTabell[i].getStatusIndeks();
        }
        return -1;
    }
    public Medlem partner(String medlemsnavn){
        for(int i = 0; i< antallMedlemer; i++ ){
            if (navnTilMedlem(medlemsnavn).getHobbyer().equals(medlemsTabell[i].getHobbyer()) == true ) return medlemsTabell[i];
         }
             return null;
        
    }

    public Medlem navnTilMedlem(String medlemsnavn){
        for (int i =0; i< antallMedlemer;i++){
            if (medlemsnavn == medlemsTabell[i].getNavn())return medlemsTabell[i];
        }
        return null;
    }
    
    public void tilbakestillStatusIndex (String medlemsnavn){
        if (finnes(navnTilMedlem(medlemsnavn))!= false){
        if(navnTilMedlem(medlemsnavn) != partner(medlemsnavn)){
            navnTilMedlem(medlemsnavn).setStatusIndeks(-1);
            partner(medlemsnavn).setStatusIndeks(-1);
        }}
    }


}



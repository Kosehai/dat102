package no.hvl.dat100;

import java.util.Random;
public class App {
    static final int MAX_RNG = 20000;
    static final int NODER = 1023;
    static final int NODER_TEST = 8191;
    static final int BS_MENGDE = 100;
    static Random rng = new Random();
    public static void main(String[] args) throws Exception {
        //Generer 100 søke BS_tre

        int max_hoyde = Integer.MIN_VALUE;
        int min_hoyde = Integer.MAX_VALUE;
        double avg_hoyde = 0;
        for(int i = 0; i<BS_MENGDE; i++){
            BS_Tre<Integer> tre = new BS_Tre<>(0);
            rngTre(NODER, tre);
            Integer hoyde = tre.hoyde();
            if(hoyde < min_hoyde) min_hoyde = hoyde;
            if(hoyde > max_hoyde) max_hoyde = hoyde;
            avg_hoyde += hoyde;
        }

        avg_hoyde = avg_hoyde / BS_MENGDE;

        System.out.println("i) Antall noder: " + NODER);
        System.out.println("ii) Teoretisk min: " + min_noder(NODER));
        System.out.println("iii) Teoretisk max: " + max_noder(NODER));
        System.out.println(String.format("iv) Minste høyden av %d iterasjoner: %d", 
            BS_MENGDE, min_hoyde));
        System.out.println(String.format("v) Største hoyden av %d iterasjoner: %d", 
            BS_MENGDE, max_hoyde));
        System.out.println(String.format("vi) Gjennomsnittelig høyde av %d iterasjoner: %.3f", 
            BS_MENGDE, avg_hoyde));
        System.out.println(String.format("\n\nc) Vi bruker gjennomsnittelige verdien for %d til å estimere gjennomsnittet til %d",
            NODER, NODER_TEST));
        System.out.println(String.format("Formel: %f = c*log2(%d)", avg_hoyde, NODER));
        System.out.println(String.format("Vi snur på formelen: c = %f / log2(%d)", avg_hoyde, NODER));
        double c = avg_hoyde / min_noder(NODER);
        System.out.println(String.format("c = %f", c));
        System.out.println(String.format("%f*log2(%d) = %f", c, NODER_TEST, c*(Math.log(NODER_TEST)/Math.log(2))));
        System.out.println(String.format("Kjører test på %d iterasjoner", BS_MENGDE));
        double avg_test = 0;
        for(int i = 0; i < BS_MENGDE; i++){
            BS_Tre<Integer> tre = new BS_Tre<>(0);
            rngTre(NODER_TEST, tre);
            Integer hoyde = tre.hoyde();
            avg_test += hoyde;
        }
        avg_test = avg_test/BS_MENGDE;
        System.out.println(String.format("Gjennomsnitts verdi for %d er %f", NODER_TEST, avg_test));
    }

    static void rngTre(int n, BS_Tre<Integer> tre){
        for(int i=0; i<n; i++){
            //Prøve å legge til en ny verdi
            Integer verdi = null;
            do {
                verdi = tre.leggTil(rng.nextInt(MAX_RNG));
            } while(verdi != null);
        }
    }
    //Formel: min = ceil(log2(n))
    //Java.math har ikkje log2 så vi bruker log(n)/log(2) 
    //for å oppnå det samme
    static int min_noder(int n){
        double h = Math.log(n)/Math.log(2);
        return (int)Math.ceil(h);
    }

    static int max_noder(int n){
        return n-1;
    }
}

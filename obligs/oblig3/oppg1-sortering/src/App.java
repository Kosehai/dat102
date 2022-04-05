import java.util.Random;

public class App {
    
    private static final int LISTESIZE = 10;

    public static void main(String[] args){

        int[] tab1 = nyTabell();
        int[] tab2 = nyTabell();
        sorter.forArbeid(tab1);
        long startTime = System.currentTimeMillis();
        sorter.sorteringVedInssettingTriks(tab1);
        long endTime = System.currentTimeMillis();
        System.out.println("tab1 sortert med triks etter: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        sorter.sorteringVedInssetting(tab2);
        endTime = System.currentTimeMillis();
        System.out.println("tab2 sortert uten triks etter: " + (endTime - startTime) + "ms");
        //Oppserverer at sorteringen tar forsatt ca like mye tid..

        int[] tab3 = nyTabell();
        printArray("Før: ", tab3);
        sorter.sorteringVedInssettingDobbel(tab3);
        printArray("Etter: ", tab3);

    }

    public static int[] nyTabell(){
        int[] mengde = new int[LISTESIZE];
        Random rng = new Random();
        for(int i=0;i<mengde.length;i++){
            mengde[i] = rng.nextInt(1000);
        }
        return mengde;
    }

    public static void printArray(String s, int[] a){
        String outstring = "";
        for(int i : a){
            outstring += i + ", ";
        }
        System.out.println(s + outstring.substring(0, outstring.length()-2));
    }
}

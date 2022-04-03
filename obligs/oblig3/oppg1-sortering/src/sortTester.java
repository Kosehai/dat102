import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class sortTester {

    private int[] mengde;
    private final int LISTESIZE = 10;

    @BeforeEach
    public void init(){
        mengde = new int[]{2,5,1,3,6,9,8,7,4};
        /*
        Random rng = new Random();
        for(int i=0;i<mengde.length;i++){
            mengde[i] = rng.nextInt(1000);
        }
        */
    }

    @Test
    public void insertionSort(){
        printArray("1: ", mengde);
        sorter.sorteringVedInssetting(mengde);
        printArray("2: ", mengde);
    }

    public void printArray(String s, int[] a){
        String outstring = "";
        for(int i : a){
            outstring += i + ", ";
        }
        System.out.println(s + outstring);
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testopg4 {

    // tester funksjonen i oppgave 4.a
    @Test
    @DisplayName("Teller til 100")
    public final void testA(){
        assertEquals(100, a.add100(0));
    }

    // tester funksjonen i oppgave 4.b
    @Test 
    @DisplayName("Teller de 10 første tallene")
    public final void testB(){
        assertEquals(117075, b.a(10));
    }

    int[] fibonachi = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584 ,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986};

    // tester funksjonen i oppgave 4.c
    @Test
    @DisplayName("rekursiv fibonacci")
    public final void testC(){
        int j = 0;
        for(int i: fibonachi){
        assertEquals(i, c.f(j++));
        }
    }


    // tester funksjonen i oppgave 4.d
    @Test
    @DisplayName("itererende fibonacci")
    public final void testD(){
        int j = 0;
        for(int i: fibonachi){
        assertEquals(i, d.fibonachi(j++));
        }  
    }


}

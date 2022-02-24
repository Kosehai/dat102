import java.io.Console;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Klient klient = new Klient();
        klient.mainloop(); 
    }
}

class Klient {
    Console console;
    DobbelKjedet dk;
    public Klient(){
        console = System.console();
        dk = new DobbelKjedet();
    }

    public void mainloop(){
        helpText();
        while(true){
            String input = console.readLine(": ");
            switch(input){
                case("1"):
                    leggtil();
                    break;
                case("2"):
                    finnes();
                    break;
                case("3"):
                    printall();
                    break;
                case("4"):
                    gen();
                    break;
                default:
                    helpText();
                    break;
            }
        }
    }

    void leggtil(){
        String input = console.readLine("Skriv in tall: ");
        int n = -1;
        try {
            n = Integer.parseInt(input);
        } catch(Exception e){
            System.out.println("Ugyldig tall");
        }
        dk.leggtil(n);
    }

    void finnes(){
        String input = console.readLine("Skriv in tall: ");
        int n = -1;
        try {
            n = Integer.parseInt(input);
        } catch(Exception e){
            System.out.println("Ugyldig tall");
        }
        boolean finnes = dk.fins(n);
        System.out.println(input + " finnes: " + finnes);
    }

    void printall(){
        dk.visListe();
    }

    void helpText(){
        System.out.print("DobbelKjedet CLI\n==============\n1. Legg til int\n2. Finnes int\n3. Print liste\n4. Generer tilfeldige tall\nctrl+c for å avslutte\n");
    }

    void gen(){
        Random rng = new Random();
        String input = console.readLine("Hvor mange tall?: ");
        int n = 0;
        try {
            n = Integer.parseInt(input);
        } catch(Exception e){
            System.out.println("Ugyldig tall");
        }
        for(int i=0;i<n;i++){
            dk.leggtil(rng.nextInt(1000));
        }
    }
}

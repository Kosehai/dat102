import java.io.Console;

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
        while(true){
            helpText();
            String input = console.readLine(": ");
            switch(input){
                case("1"):
                    leggtil();
                    break;
                case("2"):
                    break;
                case("3"):
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

    void helpText(){
        System.out.print("DobbelKjedet CLI\n==============\n1. Legg til int\n2. Finnes int\n3. Print liste");
    }
}

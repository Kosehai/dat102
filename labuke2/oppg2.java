import java.util.ArrayList;
import java.util.List;

public class oppg2 {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();

        liste.add(4);
        liste.add(4);
        liste.add(7);
        liste.add(8);
        liste.add(2);

        System.out.println(liste.get(4));
        //System.out.println(liste.get(5)); Får feil her fordi index 5 er out of rangen listen begynner på 0, sp går fra 0-4
        System.out.println(String.format("Liste size: %d", liste.size()));
        liste.set(2, 70);

        System.out.println(String.format("Finnest 8: %b\nFinnest 7: %b", liste.contains(8), liste.contains(7)));
        
        int firsti = liste.indexOf(4);
        int lasti = liste.lastIndexOf(4);
        System.out.println(String.format("Første index: %d\nSiste index: %d", firsti, lasti));

        liste.clear();
        System.out.println(String.format("Liste size: %d", liste.size()));
    }
}

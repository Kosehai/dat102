public class sorter {
    // Vi tar utgangspunkt i att
    public static void sorteringVedBubble(int[] a) {
        for (int i = a.length - 1; i >= 1; i--) {
            int h = i; // Starter på siste nøkkel
            int v = i - 1;
            // Bytter om vist nabo er mindere
            if (a[v] > a[h]) {
                int aa = a[v];
                // Inkrementerer venstre og høgere etter byttet
                // for å sjekke om forrige elemente er riktig plasert basert på nye
                a[v++] = a[h];
                a[h++] = aa;
            }
        }
    }

    public static void forArbeid(int[] a){
        //Setter minste element først
        int minste = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] < a[minste])
                minste = i;
        }
        int temp = a[minste];
        a[minste] = a[0];
        a[0] = temp;
    }

    public static void sorteringVedInssettingTriks(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            boolean ferdig = false;
            while (!ferdig && j >= 1) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    ferdig = true;
                }
            }
            a[j + 1] = temp;
        }
    }

    public static void sorteringVedInssetting(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            boolean ferdig = false;
            while (!ferdig && j >= 0) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    ferdig = true;
                }
            }
            a[j + 1] = temp;
        }
    }

    /*
    Så lenge
    det største elementet er mindre enn elementet vi sammenligner med i sortert del, så kan vi
    flytte elementet to plasser til høyre. Når vi finner rett plass for det største, forsetter vi som
    vanlig med å sette inn det minste
*/

    public static void sorteringVedInssettingDobbel(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            int temp = a[i];
            int temp2 = a[i+1];

            int j = i - 1;
            boolean ferdig = false;
            while (!ferdig && j >= 1) {
                if (temp < a[j]) {
                    a[j + 2] = a[j];
                    j--;
                } else {
                    ferdig = true;
                }
            }
            if(temp > temp2){
                temp = a[i+1];
                temp2 = a[i];
            }
            a[j + 1] = temp;
            a[j + 2] = temp2;
        }
    }

}

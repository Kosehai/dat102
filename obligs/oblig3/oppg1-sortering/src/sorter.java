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

    public static void sorteringVedInssettingDobbel(int[] a){
        for (int i=0; i<a.length; i += 2){
            int[] b = new int[2];
            //"Sortered sub array så minste element alltid først"
            if(a[i] < a[i+1]){
                b[0] = a[i];
                b[1] = a[i+1];
            } else {
                b[1] = a[i];
                b[0] = a[i+1];
            }
            
            int j = i - 2;
            boolean ferdig = false;
            while(!ferdig && j >= 0 ){
                if(b[0] < a[j]){
                    a[j + 1] = a[j];
                    a[j + 2] = a[j+1];
                    j--;
                } else {
                    ferdig = true;
                }
            }
            a[j + 2] = b[0];
            a[j + 3] = b[1];
        }
    }

}

public class sorter {
    public static void sorteringVedInssettingRev(int[] a) {
		for (int i = 0; i < a.length; i++){
            
        }
	}
    
    public static void sorteringVedInssetting(int[] a) {
		for (int i = 0 + 1; i <= a.length; i++) {
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
			a[j+1] = temp;
		}
		
	} 
}

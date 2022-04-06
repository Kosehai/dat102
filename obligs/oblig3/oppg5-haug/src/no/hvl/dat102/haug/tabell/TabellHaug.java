package no.hvl.dat102.haug.tabell;

public class TabellHaug<T extends Comparable<T>> {
	// Lager en minimumshaug

	private T[] data;
	private int antall;

	private static final int STDK = 100;

	public TabellHaug() {
		data = (T[]) new Comparable[STDK];
		antall = 0;
	}

	public void leggTilElement(T el) {
		if (antall == data.length)
			utvidTabell();
		data[antall] = el; // Plasser den nye helt sist
		antall++;
		if (antall > 1)
			heapmax(); // Bytt om oppover hvis n�dvendig
	}

	private void utvidTabell() {
		// Dobler tabellen ved behov for utviding
		int lengde = data.length;
		T[] ny = (T[]) new Comparable[2 * lengde];
		for (int i = 0; i < antall; i++)
			ny[i] = data[i];
		data = ny;
	}

	public void heapmax(){
		int n = antall;
        for (int i = n / 2 - 1; i >= 0; i--)
            reparerOpp(data, n, i);
        for (int i = n - 1; i > 0; i--) {

            var temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            reparerOpp(data, i, 0);
		}

    }
		private void reparerOpp(T data[], int n, int i)
		{
			int largest = i; 
			int l = 2 * i + 1; 
			int r = 2 * i + 2; 
			if (l < n && data[l].compareTo(data[largest]) < 0)
				largest = l;
	 
			if (r < n && data[r].compareTo(data[largest]) < 0)
				largest = r;
	 
			if (largest != i) {
				T swap = data[i];
				data[i] = data[largest];
				data[largest] = swap;
				reparerOpp(data, n, i);
			}
		}


	public T fjernMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
			data[0] = data[antall - 1];
			reparerNed(); // Bytter om nedover hvis n�dvendig
			antall--;
		}
		return svar;
	}

	public T finnMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
		}
		return svar;
	}

	private void reparerNed() {
		T hjelp;
		
		boolean ferdig = false;
		int forelder = 0; // Start i roten og sml med neste niv�
		int minbarn;
		int vbarn = forelder * 2 + 1;
		int hbarn = vbarn + 1;
		while ((vbarn < antall) && !ferdig) { // Har flere noder lenger nede
			minbarn = vbarn;

			if ((hbarn < antall) && ((data[hbarn]).compareTo(data[vbarn]) < 0))
				minbarn = hbarn;
			// Har funnet det "minste" av barna. Sml med forelder

			
			if ((data[forelder]).compareTo(data[minbarn]) <= 0)
				ferdig = true;
			else { // Bytt om og g� videre nedover hvis forelder er for stor
				hjelp = data[minbarn];
				data[minbarn] = data[forelder];
				data[forelder] = hjelp;
				forelder = minbarn;
				vbarn = forelder * 2 + 1;
				hbarn = vbarn + 1;
			}
		}
	}

	public boolean erTom() {
		return antall == 0;
	}

	public void skrivTab() {
		// Hjelpemetode til test
		for (int i = 0; i < antall; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}
}
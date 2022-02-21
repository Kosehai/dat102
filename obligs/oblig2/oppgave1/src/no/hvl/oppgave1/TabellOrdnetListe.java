package no.hvl.oppgave1;
import java.util.Arrays;

import no.hvl.oppgave1.*;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

        private final static int STDK = 100;
        private final static int IKKE_FUNNET = -1;
        private int bak;
        private T[] liste;

        public TabellOrdnetListe() {
                this(STDK);
        }

        public TabellOrdnetListe(int startKapasitet) {
                bak = 0;
                liste = (T[]) (new Comparable[startKapasitet]);
        }

        @Override
        public T fjernSiste() {
                if (erTom())
                        throw new EmptyCollectionException("ordnet liste");

                T resultat = liste[liste.length];
                liste[liste.length] = null;
                return resultat;
        }

        @Override
        public T fjernFoerste() {
                if (erTom())
                        throw new EmptyCollectionException("ordnet liste");

                T resultat = liste[0];
                T[] nyliste = (T[]) (new Comparable[bak-1]);
                for(int i = 1; i<bak; i++){
                    nyliste[i - 1] = liste[i]; 
                }
                bak--;
                liste = nyliste;
                return resultat;
        }

        @Override
        public T foerste() {
                if (erTom())
                        throw new EmptyCollectionException("ordnet liste");

                T resultat = liste[0];
                return resultat;
        }

        @Override
        public T siste() {
                if (erTom())
                        throw new EmptyCollectionException("ordnet liste");

                T resultat = liste[bak];

                return resultat;
        }

        @Override
        public boolean erTom() {
            return (bak == 0);
        }

        @Override
        public int antall() {
                return bak;
        }

        @Override
        public void leggTil(T element) {
            liste[bak] = element;
            bak = bak + 1;
            //Insertion sort
            Arrays.sort(liste);
        }

        @Override
        public boolean inneholder(T element) {
                return (finn(element) != IKKE_FUNNET);
        }

        @Override
        public T fjern(T element) {
            T[] nyliste = (T[]) (new Comparable[bak-1]);
            for(int i = 0, j = 0; i<bak; i++){
                if(liste[i] != element) 
                {
                    nyliste[j++] = liste[i];
                }
            }
            liste = nyliste;
            return element;
        }
        //Itterasjons basert biner søk O = log n
        private int finn(T el) {
            int resultat = IKKE_FUNNET;
            int l = 0;
            int r = bak;
            while(l != r){
                int mid = (l + r)/2;
                if(liste[mid] == el){
                    return mid;
                }
                if(el.compareTo(liste[mid]) > 0){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }   
            return resultat;
        }

        public String toString() {
                String resultat = "";

                for (int i = 0; i < bak; i++) {
                        resultat = resultat + liste[i].toString() + "\n";
                }
                return resultat;
        }

        private void utvid() {
                T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

                for (int i = 0; i < liste.length; i++) {
                        hjelpeTabell[i] = liste[i];
                }

                liste = hjelpeTabell;
        }

}// class
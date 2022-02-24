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

                T resultat = liste[bak-1];
                liste[bak-1] = null;
                bak--;
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
            liste[bak++] = element;
            sorter();
        }

        void sorter(){
            for(int i=1; i<bak; ++i){
                T key = liste[i];
                int j = i - 1;

                while(j >= 0 && key.compareTo(liste[j]) <= 0){
                    liste[j + 1] = liste[j];
                    j = j - 1;
                }
                liste[j + 1] = key;
            }
        }

        @Override
        public boolean inneholder(T element) {
                return (finn(element) != IKKE_FUNNET);
        }

        @Override
        public T fjern(T element) {
            T returnElm = null;
            for(int i = 0; i < bak; i++){
                if(liste[i] != null && liste[i].equals(element)){
                    liste[i] = null;
                    liste[i] = liste[--bak];
                    returnElm = element;
                    break;
                }
            }
            sorter();
            return returnElm;
        }
        //Itterasjons basert biner søk O = log n
        private int finn(T el) {
            int resultat = IKKE_FUNNET;
            int l = 0;
            int r = bak;
            while(l != r){
                int mid = (l + r)/2;
                if(liste[mid].equals(el)){
                    return mid;
                }
                if(liste[mid+1] != null && liste[mid+1].equals(el)){
                    return mid+1;
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
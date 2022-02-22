public class DobbelKjedet {
    private Node first;
    private Node last;


    public DobbelKjedet() {
        first = new Node();
        first.setAntall(0);
        last = new Node();
        last.setAntall(Integer.MAX_VALUE);

        first.setNext(last);
        first.setPrev(last);

        last.setNext(null);
        last.setPrev(first);
    }

    public void leggtil(int n){
        if(n < first.getAntall() || n > last.getAntall()) return;
        Node nynode = new Node();
        nynode.setAntall(n);
        Node neste = last;
        while(neste != null){
            if(n > neste.getAntall()){
                Node temp = neste.getNext();
                neste.setNext(nynode);
                nynode.setPrev(neste);
                nynode.setNext(temp);
                temp.setPrev(nynode);
                break;
            }
            neste = neste.getPrev();
        }
    }

    public boolean fins(int n){
        boolean finnes = false;
        Node neste = first;
        while(neste.getNext() != null){
            neste = neste.getNext();
            if(neste.getAntall() == n){
                finnes = true;
                break;
            }
        }
        return finnes;
    }

    public void visListe(){
        String outstring = "";
        Node neste = first;
        while(neste.getNext() != null){
            neste = neste.getNext();
            if(neste.getAntall() != last.getAntall()){
                outstring += neste.getAntall() + " -> ";
            }
        }
        outstring = outstring.substring(0, outstring.length() - 4);
        System.out.println(outstring);
    }

}

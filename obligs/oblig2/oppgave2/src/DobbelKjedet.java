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
        Node nynode = new Node();
        nynode.setAntall(n);
        Node neste = first;
        while(neste != null){
            if(neste.getAntall() < n){
                Node temp = neste.getNext();
                neste.setNext(nynode);
                nynode.setPrev(neste);
                nynode.setNext(temp);
                temp.setPrev(nynode);
                break;
            }
            neste = neste.getNext();
        }
    }

    public boolean fins(Node n){
        boolean finnes = false;
        Node neste = first;
        while(neste.getNext() != null){
            neste = neste.getNext();
            if(neste == n){
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
            outstring += neste.getAntall() + " -> ";
        }
        System.out.println(outstring);
    }

}

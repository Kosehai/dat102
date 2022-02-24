public class Node {
    private Node prev;
    private Node next;
    private int antall;
    
    public Node(){
        prev = null;
        next = null;
        antall = 0;
    }

    public Node getPrev() {
        return prev;
    }
    
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public int getAntall() {
        return antall;
    }
    
    public void setAntall(int antall) {
        this.antall = antall;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Node)) return false;
        Node nodeobj = (Node) obj;
        return nodeobj.getAntall() == getAntall();
    }
}

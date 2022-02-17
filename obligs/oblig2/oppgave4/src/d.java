public class d {
    public static void main(String[] args) {
        int N = 100;
        int last = 1;
        int next = 0;
        int out = 0;
        for(int  i = 0; i < N ; i++ ){
            
            next = last + next;
            last = next - last;
            
            out = last + next;
            
            System.out.println(out);

        } 

    }
}

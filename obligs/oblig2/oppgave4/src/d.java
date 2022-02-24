public class d {
    public static void main(String[] args) {
  for(int i = 0 ;i < 40; i++ ){
      System.out.println(fibonachi(i));
  }
    }

    public static int fibonachi(int N){
        int last = 1;
        int next = 0;
        int out = 0;
        for(int  i = 0; i < N ; i++ ){

            out = last + next; 
            
            next = last + next;
            last = next - last;
            
                    

        } 
        return out;
    }
}

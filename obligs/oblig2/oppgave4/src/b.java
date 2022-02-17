public class b {    
    public static void main(String[] args) {
        int p = 10;
        for (int i = 0; i < p; i++){
        System.out.println("a("+(i+1)+")= " +a(i+1));
        }
    }
    
    static int a(int n){ 
        if(n == 0){
            return 2;
        }else if (n == 1){
            return 5;
        }
        return (5*a(n-1)) - (6*a(n-2)) + 2;

    }
    
}

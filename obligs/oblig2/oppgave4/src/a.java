class a{
    public static void main(String[] args) {
    System.out.println(add100(0));
        
    }
    
    static int add100(int n){
        if(n == 100){
            return n;
        }
        return add100(n+1);
    }


}


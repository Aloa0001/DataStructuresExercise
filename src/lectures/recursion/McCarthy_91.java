package lectures.recursion;

public class McCarthy_91 {
    public static void main(String[] args) {
        System.out.println(mcCarthy_91(103));
        System.out.println(iterativeF(103));
    }

    private static int mcCarthy_91(int n) {
        if (n > 100) {
            return n - 10;
        } else {
            return mcCarthy_91(mcCarthy_91(n + 11));
        }
    }

    private static int iterativeF(int n) {
       if (n > 100){
           return n-10;
       }else{
           while( n != 91){
               if (n < 100){
                   n += 11;
               }
               n -= 10;
           }
           return n;
       }
    }
}

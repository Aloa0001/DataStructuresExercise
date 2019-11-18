package lectures.recursion;

public class SumOfInt {
    public static void main(String[] args) {
        System.out.println(sumOfInt(3));
    }
    private static long sumOfInt(int n){
        if (n == 1){
            return 1;
        }else{
            return sumOfInt(n-1) + n;
        }
    }
}

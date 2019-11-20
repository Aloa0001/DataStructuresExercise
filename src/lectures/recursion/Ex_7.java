package lectures.recursion;

public class Ex_7 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial_(5));
    }

    private static long factorial(long n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static long factorial_(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial_(n - 1);
    }
}

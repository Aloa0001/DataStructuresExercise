package lectures.recursion;

public class Fibonacci_2 {
    public static void main(String[] args) {
        System.out.println(fibonacci(20));
        System.out.println(fibon_acci(20));
    }
    private static int fibon_acci(int n){
        if (n<3){
            return 1;
        }
        if(n % 2 == 1){
            int a = (n+1)/2;
            int b = (n-1)/2;
            return (fibon_acci(a)*fibon_acci(a) + fibon_acci(b)*fibon_acci(b));
        }else{
            int a = (n/2)+1;
            int b = (n/2)-1;
            return (fibon_acci(a)*fibon_acci(a) - fibon_acci(b)*fibon_acci(b));
        }
    }
    private static long fibonacci(int n){
        if (n <= 1){
            return n;
        }else{
            return fibon_acci(n-1) + fibonacci(n-2);
        }
    }
}

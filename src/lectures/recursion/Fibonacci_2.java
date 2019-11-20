package lectures.recursion;

public class Fibonacci_2 {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
    private static int fibonacci(int n){
        if (n<3){
            return 1;
        }
        if(n % 2 == 1){
            int a = (n+1)/2;
            int b = (n-1)/2;
            return (fibonacci(a)*fibonacci(a) + fibonacci(b)*fibonacci(b));
        }else{
            int a = (n/2)+1;
            int b = (n/2)-1;
            return (fibonacci(a)*fibonacci(a) - fibonacci(b)*fibonacci(b));
        }
    }
}

package chapter2;

/**
 * Calculate Sigma(Sum) of  n elements starting with i = 1 , where i * i * i
 */
public class Example2_4_1 {
    public static void main(String[] args) {
        System.out.println("The sum of the cubic values up to 10 is "+sumOfCubicN(10));
    }
    private static int sumOfCubicN (int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += i * i * i;
        }
        return sum;
    }
}

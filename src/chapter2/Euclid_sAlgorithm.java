package chapter2;

public class Euclid_sAlgorithm {
    public static void main(String[] args) {

        System.out.println(gcd(123456,420));

    }

    private static long gcd(long m, long n){
        while (n!=0){

            long rem = m%n;
            m = n;
            n = rem;
        }

        return m;
    }
}

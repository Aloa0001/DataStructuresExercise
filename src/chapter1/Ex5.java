package chapter1;

public class Ex5 {

    public static void main(String[] args) {
        System.out.println(exponentialPower(5,3));
    }

    /**
     * recursive method to find exponential power of a number
     * @param a the base
     * @param b the exponent
     * @return a powered to b
     */
    private static int exponentialPower(int a, int b){
        if( b < 1){
            return 1;
        }else{
            return a * exponentialPower(a, b-1);
        }
    }
}

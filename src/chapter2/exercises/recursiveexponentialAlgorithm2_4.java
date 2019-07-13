package chapter2.exercises;

public class recursiveexponentialAlgorithm2_4 {
    public static void main(String[] args) {
        System.out.println(exp(2,3));
    }

    private static long exp(long x, int y){
        if(y==0){
            return 1;
        }
        if( y == 1){
            return x;
        }
        if (y%2 == 0){
            return exp(x*x, y/2);
        }else{
            return exp(x*x, y/2)*x;
        }
    }

}

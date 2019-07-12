package chapter2;

public class Exponential {
    public static void main(String[] args) {
        System.out.println(pow(12, 2));
    }
    private static long pow(long x, int y){
        if(y==0){
        return 1;
        }
        if( y == 1){
            return x;
        }
        if (y%2 == 0){
            return pow(x*x, y/2);
        }else{
            return pow(x*x, y/2)*x;
        }
    }

}
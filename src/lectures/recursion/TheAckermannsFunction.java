package lectures.recursion;

public class TheAckermannsFunction {
    public static void main(String[] args) {
        System.out.println(ackermannsFunction(2,2));
    }
    private static int ackermannsFunction(int x, int y){
        if ( x  == 1 && y >= 1){
            return (int) Math.pow(2,y);
        }
        if (x > 1 && y == 1){
            return ackermannsFunction(x-1, 2);
        }else{
            return ackermannsFunction(x-1, ackermannsFunction(x, y-1));
        }
    }
}

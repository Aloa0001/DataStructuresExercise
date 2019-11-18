package lectures.recursion;

public class Tak {
    public static void main(String[] args) {
        System.out.println(takFunction(1 ,1,9));
    }
    private static int takFunction(int x, int y, int z){
        if (x<=y){
            return y;
        }else{
            return takFunction(takFunction(x-1,y,z),takFunction(y-1,z,x),takFunction(z-1,x,y));
        }
    }
}

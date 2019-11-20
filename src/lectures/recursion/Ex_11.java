package lectures.recursion;

public class Ex_11 {

    public static void main(String[] args) {
        System.out.println(f(5,8));
        System.out.println(iterativeF(5,8));
    }
    private static int f(int x, int y) {
        if (y == 0) {
            return x;
        }
        return f(x * y, y - 1);
    }
    private static int iterativeF(int x, int y){
        if(y == 0){
            return x;
        }else{
            int temp = x;
            for (int i = y; i > 0; i--){
                temp = temp * i;
            }
            return temp;
        }
    }
}

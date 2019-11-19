package lectures.recursion;

public class Tak {
    public static void main(String[] args) {
        System.out.println(takFunction(5,4,2));
        System.out.println(iterativeTak(5,4,2));
    }
    private static int takFunction(int x, int y, int z){
        if (x<=y){
            return y;
        }else{
            return takFunction(takFunction(x-1,y,z),takFunction(y-1,z,x),takFunction(z-1,x,y));
        }
    }
    private static int iterativeTak(int x, int y, int z){
        if (x<=y){
            return y;
        }else{
            int[] input = {x, y, z};
            while(input[0] > input[1]){
                for (int k = 0; k < 3; k++){
                    int temp = input[k];
                    while(input[k]  > input[(k+1)%3]){
                        input[k] = input[(k+1)%3]-1;
                        input[(k+1)%3] = input[(k+2)%3];
                        input[(k+2)%3] = temp;
                    }
                }
            }
            return input[1];
        }
    }
}

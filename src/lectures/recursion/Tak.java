package lectures.recursion;

import java.sql.Time;

public class Tak {
    public static void main(String[] args) {
       long start = System.currentTimeMillis();
        System.out.println(takFunction(100,1,15));
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000+" seconds");
        System.out.println(iterativeTak(5,3,4));
    }
    private static int takFunction(int x, int y, int z){
        if (x<=y){
            return y;
        }else{
            return takFunction(takFunction(x-1,y,z),takFunction(y-1,z,x),takFunction(z-1,x,y));
        }
    }
    private static int iterativeTak(int x, int y, int z){
        if (x <= y){
            return y;
        }else{
            int[] input = {x, y, z};

            while(input[0] > input[1]){//as long x > y

                for (int k = 0; k < 3; k++){ // for each x,y,z
                    int temp = input[k]; // temp = x
                   // if(input[])
                    while(input[k]  > input[(k+1)%3]){  // if x > y

                            input[k%3] = input[k%3]-1;//input[(k+1)%3]-1; //
                            input[(k+1)%3] = input[(k+2)%3];
                            input[(k+2)%3] = temp;
                    }
                    input[1] = temp;
                }
            }
            return input[1];
        }
    }
}

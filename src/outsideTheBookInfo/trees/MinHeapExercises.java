package outsideTheBookInfo.trees;

import java.security.SecureRandom;
import java.util.Arrays;

public class MinHeapExercises {
    static int[] array = new int[100];
    static int currentSize = 0;
    static SecureRandom rand = new SecureRandom();

    public static void main(String[] args) {
        insert(27);
        insert(17);
        insert(7);
        insert(14);
        insert(37);
        insert(11);
        insert(6);
        insert(9);
        insert(2);
        insert(3);
        System.out.println(Arrays.toString(array));
        insert(1);
        System.out.println(Arrays.toString(array));

    }
    //percolate-up
    private static void insert(int x){
        //check load factor
        //if full, double size of the array
        int temp = currentSize+1 ;
        array[temp] = x;
        while (x < array[temp / 2]){
            array[temp] = array[temp / 2];
            array[temp / 2] = x;
            temp = temp / 2;
        }
        currentSize++;
    }
}

package chapter3;

import java.util.Arrays;

public class DoubleTheArraySize {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
////        System.out.println(Arrays.toString(doubleTheSizeOfAnArray(arr)));
////        System.out.println("the size of arr is " + doubleTheSizeOfAnArray(arr).length);
////        System.out.println(arr.hashCode());
        increaseArrayListSize();
        System.out.println("\n"+Arrays.toString(arr));
        System.out.println(Arrays.toString(doubleTheSizeOfAnArray(arr)));

    }

    private static int[] doubleTheSizeOfAnArray(int[] arr) {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        return arr;
    }
    private static void increaseArrayListSize(){
        int[] arr = {3,4,5,6,7,8,9,0,2,1};
        int[] ar = Arrays.copyOfRange(arr, 0,20);
        int[] arrr = Arrays.copyOf(arr,22);
        System.out.println(arrr.length);
        System.out.println(ar.length);

        for (int x : ar){
            System.out.print(x+ " ");
        }
    }

}

package chapter3;

import java.util.Arrays;

public class DoubleTheArraySize {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(doubleTheSizeOfAnArray(arr)));
        System.out.println("the size of arr is " + doubleTheSizeOfAnArray(arr).length);
        System.out.println(arr.hashCode());
    }

    private static int[] doubleTheSizeOfAnArray(int[] arr) {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        return arr;
    }

}

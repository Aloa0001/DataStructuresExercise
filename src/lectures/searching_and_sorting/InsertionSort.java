package lectures.searching_and_sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] in = {11, 10, 12, 13, 14, 15, 1, 7, 3, 1, 9, 4, 5, 6, 2, 8, 7};
        insertionSort(in);
        System.out.println(Arrays.toString(in));
    }

    private static void insertionSort(int[] input) {
        int j;
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            for (j = i; j > 0 && temp < input[j - 1]; j--) {
                input[j] = input[j - 1];
            }
            input[j] = temp;
        }
    }
}

package lectures.searching_and_sorting;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] in = {11, 10, 12, 13, 14, 15, 1, 7, 3, 1, 9, 4, 5, 6, 2, 8, 7};
        shellSort(in);
        System.out.println(Arrays.toString(in));
    }

    private static void shellSort(int[] input) {
        int k;
        for (int gap = input.length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < input.length; j++) {
                int temp = input[j];
                for (k = j; k >= gap && temp < input[k - gap]; k -= gap){
                    input[k] = input[k - gap];
                }
                input[k] = temp;
            }
        }
    }
}

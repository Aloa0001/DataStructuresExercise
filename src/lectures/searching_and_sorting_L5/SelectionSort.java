package lectures.searching_and_sorting_L5;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] in = {11,10,12,13,14,15,1,7,3,1,9,4,5,6,2,8,7};
        selectionSort(in);
        System.out.println(Arrays.toString(in));

    }
    private static void selectionSort(int[] in){
        for (int i = 0; i< in.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < in.length; j++){
                if (in[j] < in[min]){
                    min = j;
                }
            }
            int temp = in[i];
            in[i] = in[min];
            in[min] = temp;
        }
    }
}

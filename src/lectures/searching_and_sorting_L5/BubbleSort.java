package lectures.searching_and_sorting_L5;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] in = {11,10,12,13,14,15,1,7,3,1,9,4,5,6,2,8,7};
        bubbleSort(in);
        System.out.println(Arrays.toString(in));
    }
    private static void bubbleSort(int[] input){
        boolean swapped;
        do{
            swapped = false;
            for (int i = 1; i < input.length; i++){
                if (input[i - 1] > input[i]){
                    int temp = input[i - 1];
                    input[i - 1] = input[i];
                    input[i] = temp;
                    swapped = true;
                }
            }
        }while(swapped);
    }
}

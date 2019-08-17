package fundationsOfCSDataStructures;

import java.util.ArrayList;

public class ArraysExercises {
    public static void main(String[] args) {
        String[] arr = {"one", "two","three"};
        insertElementInArray(arr,"four",1);
    }

    private static <T> ArrayList<T> insertElementInArray(T[] arr, T element, int indexToInsert){
        ArrayList<T> newArr = new ArrayList<>();
        for(int i = 0; i <= arr.length; i ++){
            if(i > indexToInsert){
                newArr.set(i+1,arr[i]);
            }else if(i == indexToInsert){
                newArr.set(i, element);
            }else {
                newArr.set(i , arr[i]);
            }
        }
        return newArr;
    }
}

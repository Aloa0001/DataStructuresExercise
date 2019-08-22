package outsideTheBookInfo.fundationsOfCSDataStructures;

import java.util.*;

public class ArraysExercises {
    public static void main(String[] args) {
        /**insert element in an array*/
        String[] arr = {"one", "two","three"};
        System.out.println(insertElementInArray(arr,"four",3));
        String text = "my name is Alexander";
        System.out.println(text.charAt(14));
        int i = text.charAt(0);// the integer will be the unicode value: 'm' is 109 in unicode
        System.out.println(i);

        /**arrays*/
        String name = "Alexander";
        System.out.println(name.toCharArray()[3]);

        Stack<Character> surname = new Stack<>();
        for(char x: name.toCharArray()){
            surname.push(x); }
        System.out.println(surname);

        /**queue*/
        Queue<Character> queue = new LinkedList<>();
        queue.addAll(surname);
        System.out.println(queue.peek());
        queue.offer('Q');
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.hashCode());
    }

    private static <T> ArrayList<T> insertElementInArray(T[] arr, T element, int indexToInsert){

        ArrayList<T> newArr = new ArrayList<>();

        try {

            for(int i = 0 ; i < arr.length + 1 ; i++){
                if(i<indexToInsert){
                    newArr.add(arr[i]);
                }else if( i == indexToInsert){
                    newArr.add(element);
                }else{
                    newArr.add(arr[i-1]);
                }
            }

        }catch (IndexOutOfBoundsException err){
            System.err.println(err.fillInStackTrace());
        }
        return newArr;
    }

    private static <T> T[] insertElInArr(T[] arr, T element, int index){

        T[] array = (T[]) new Object[arr.length+1];
        for (int i = arr.length; i <=0 ; i--){
            if(i>=index){
                array[i]=arr[i-1];
            }else if(  i == index-1){
                array[i] = element;
            }else{
                array[i] = arr [i];
            }

            }

        return array;

    }
}

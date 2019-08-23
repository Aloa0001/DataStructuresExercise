package outsideTheBookInfo.sorts;

public class Sorts <T>{


    public void insertionSort(T[] array){

        for (int i = 1 ; i < array.length; i ++){// starting  with index 1, all values are iterated

            int j ;//the index of the previous value in the array, to the one to be compared
            T v = array[i] ;// the value of the value<T> in the array that is compared to the previous

            for(j = i-1 ;  //   the index of the value that will be compared to
                j >= 0 ;   //   the iteration will stop when  the first element will be reached
                j--  ){   //   the index of the next compared element will decrease by one*/

                if(((Comparable<T>)array[j]).compareTo(v) <= 1){

                    break ;
                }else{
                    array[j+1] = array[j] ;
                }
            }
            array[j+1] = v ;
        }
    }



}
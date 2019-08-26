package outsideTheBookInfo.sorts;

public class QuickSort <E>{

    E[] array;

    public E[] sort(E[] array){
        this.array= array;
        quickSort(0, array.length-1);// sort the whole array
        return array;// return the globally scoped array
    }

    private void swop(int from, int to){//from, to = array indexes, to = pivot = last element in the list
        E temporary = array[from];// temporary variable to store the value at array[from],
                                  // so the value is not lost in the next step
        array[from] = array[to];  // the value at array[from] is replaced with the other value to be swapped(pivot)
        array[to] = temporary;    // the stored value is injected in the array[to]
    }

    private void quickSort(int from, int to){

        if(from >= to) return;// if is only one element to be sorted, return

        E value = array[to];  // the value of the pivot is stored

        int counter = from;   // the counter will keep track of the first bigger value than the pivot in the list

        for (int i = from; //starting with the first element to be sorted
             i<= to;       //until reaches the pivot
             i++){         // move to the next element to the right
            if(((Comparable<E>)array[i]).compareTo(value) <= 0){    // if the value is smaller than the pivot value
                swop(i, counter); // swap values between array[i] and array[counter](the first bigger value than pivot)
                counter ++;       // move the counter to the next 'bigger than pivot' value in the list
            }
        }
        swop(counter,to);     // when all elements are iterated, the pivot value will be swapped with the counter value
        quickSort(from, counter-1); // sort recursively the first part of the list, until the pivot,
                                    // that contains elements smaller than the pivot value
        quickSort(counter+1, to);   // sort recursively the second half of the list, from the first element after the pivot
                                    // until the last in the list
    }



}

package outsideTheBookInfo.sorts;

public class MergeSort <T>{


    private  T[] array, temp ;

    public MergeSort(T[] array){
        this.array = array ;
        temp =(T[])new Object[array.length];
        split(0,array.length-1);
    }

    private void split(int low, int high){
        if(low == high){
            return;
        }
        int mid = (low+high)/2;
        split(low,mid);
        split((mid+1),high);
    }

    private void merge(int low, int mid, int high){

        int i = low, j = mid+1, temporaryPossition = low;

        while( i <= mid && j <= high){
            if(((Comparable<T>)array[i]).compareTo(array[j]) < 1){
                temp[temporaryPossition++] = array[i++];
            }else{
                temp[temporaryPossition++] = array[j++];
            }
        }
        while( i <= mid ){
            temp[temporaryPossition++] = array[i++];
        }
        while( j <= high ){
            temp[temporaryPossition++] = array[j++];
        }
        for(temporaryPossition = low ; temporaryPossition <= high ; temporaryPossition++){
            array[temporaryPossition] = temp[temporaryPossition];
        }
    }

}

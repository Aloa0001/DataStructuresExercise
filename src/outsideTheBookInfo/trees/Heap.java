package outsideTheBookInfo.trees;

public class Heap <E> {

    int lastPosition;//the number of elements im the array
    private int size;
    E[] array = (E[]) new Object[size];

    public E remove(){
        E tmp = array[0];
        swop(0,lastPosition--);
        trickleDown(0);
        return tmp;
    }
    public void add(E obj){//a recursive trickle up needed
        array[++lastPosition] = obj;
        trickleUp(lastPosition);
    }
    public void swop(int from, int to){
        E tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
    public void trickleUp(int position){
        if(position == 0){
            return;
        }
        int parent = (int) Math.floor((position-1)/2);
        if(((Comparable<E>)array[position]).compareTo(array[parent]) > 0){
            swop(position,parent);
            trickleUp(parent);
        }
    }
    public void trickleDown(int parent){
        int leftChild = 2*parent+1;
        int rightChild = 2*parent +2;

        if(leftChild == lastPosition && (((Comparable<E>)array[parent]).compareTo(array[leftChild])< 0)){
            swop(parent, leftChild);
            return;
        }
        if(rightChild == lastPosition && (((Comparable<E>)array[parent]).compareTo(array[rightChild])< 0)){
            swop(parent, rightChild);
            return;
        }
        if(leftChild>= lastPosition || rightChild >= lastPosition){
            return;
        }
        if((((Comparable<E>)array[parent]).compareTo(array[leftChild]) < 0)
                && (((Comparable<E>)array[leftChild]).compareTo(array[rightChild]) > 0)){

            swop(parent,leftChild);
            trickleDown(leftChild);
        }
        if((((Comparable<E>)array[parent]).compareTo(array[rightChild]) < 0)){

            swop(parent,rightChild);
            trickleDown(rightChild);
        }

    }
}

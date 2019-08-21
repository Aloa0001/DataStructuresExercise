package linkedList;

public class Hash <K,V> implements HashI<K,V>{

    /**
     * inner class HashElement
     * @param <K>
     * @param <V>
     */
    class HashElement<K,V> implements Comparable<HashElement<K,V>>{

         K key;
         V value;



         public HashElement(K key,V value){
             this.key = key;
             this.value = value;
         }

         public int compareTo(HashElement<K,V> o){
             return ((Comparable<K>)o.key).compareTo(this.key);
         }

    }
    /**global variables*/
    LinkedList<HashElement<K,V>> [] hash_array;

    int numElement, tableSize;
    double maxLoadFactor;

    /**
     * Hash constructor
     * @param tableSize
     */
    public Hash(int tableSize){
        this.tableSize = tableSize;

        maxLoadFactor = 0.75;
        numElement = 0;

        hash_array = (LinkedList<HashElement<K,V>> []) new LinkedList[tableSize];

        for(int i = 0 ; i < tableSize; i++){
            hash_array[i] = new LinkedList<HashElement<K,V>>();
        }

    }
    public boolean add(K key, V value){
        if (loadFactor() > maxLoadFactor) {
            resize(tableSize*2);
        }
        HashElement<K,V> he = new HashElement(key,value);
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF % tableSize;
        hash_array[hashVal].addFirst(he);
        numElement++;
        return true;
    }

    public boolean remove(K key, V value){

        HashElement<K,V> he = new HashElement(key,value);

        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF % tableSize;
        hash_array[hashVal].remove(he);
        numElement--;
        return true;
    }

    public V getValue(K key){
        int hashVal = key.hashCode() & 0x7FFFFFFF % tableSize;
        for(HashElement<K,V> he : hash_array[hashVal]){// how to replace it with a regular for or while?
            if (((Comparable<K>)key).compareTo(he.key) == 0){
                return he.value;
            }
        }
        return null;
    }

    public void resize(int newSize){
        LinkedList<HashElement<K,V>> [] newArray = (LinkedList<HashElement<K,V>> [])new LinkedList[newSize];

        for(int i = 0 ; i < newSize ; i ++){
            newArray[i] = new LinkedList<HashElement<K,V>>();
        }
        for(K key : this){
            V value = getValue(key);
            HashElement<K,V> he = new HashElement<K,V>(key, value);
            int hashVal = (key.hashCode() & 0x7FFFFFFF)% newSize;
            newArray[hashVal].addFirst(he);
        }
        hash_array = newArray;
        tableSize = newSize;
    }

    public double loadFactor(){
         return numElement/tableSize;
    }


}

package trees;

public class RedBlackTree <K,V> implements RedBlackI<K,V>{

    Node<K,V> node;
    int size;

    class Node<K,V> {

        K key;
        V value;
        Node<K,V> leftChild, rightChild, parent;
        boolean isLeftChild, isBlack;

        /**
         * NODE constructor
         * @param key
         * @param value
         */
        public Node (K key, V value){
            this.key = key;
            this.value = value;
            leftChild = rightChild = parent = null;
            isLeftChild = false;//it is not known at this time
            isBlack = false; // ALL NEW NODES ARE RED
        }
    }

}

package outsideTheBookInfo.linkedList;

/**
 * Generic linked list
 *
 * @param <E>
 */
public class LinkedList<E> {

    class Node<E> {

        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    /**
     * Constructor
     */
    public LinkedList() {
        head = null;
        currentSize = 0;
    }

    /**
     * Adding a new node to a linked list
     *Complexity O(1)
     * @param obj is the data stored in the node
     */
    public void addFirst(E obj) {
        Node<E> node = new Node(obj);
        if(head == null){
            head = node;
            tail = node;
            currentSize++;
            return;
        }
        node.next = head;
        head = node;
        currentSize++;
    }

    /**
     * AddingFirst to a linked list
     * complexity O(1)
     */
    public void addLast(E obj) {
        Node<E> node = new Node<>(obj);
        if (head == null) {
            head = node;
            tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
        return;
    }

    /**
     * remove first from a linked list
     * @return removed element or null if the linked list is empty
     */
    public E removeFirst(){
        if(head == null){
            return null;
        }
        E temp = head.data;
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
        currentSize--;
        return temp;
    }

    /**
     * remove lasty from a linked list
     * @return removed element or null if the linked list is empty
     */
    public E removeLast(){
        if(head == null){
            return null;
        }
        if(head == tail){
           return removeFirst();
        }
        Node<E> current = head, previous = null;
        while(current!=tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    /**
     * remove an object from a linked list
     * @param obj to be removed
     * @return
     */
    public E remove(E obj){
        Node<E> current = head, previous = null;
        while(current!=null){
            if (((Comparable<E>)obj).compareTo(current.data)==0){
                if(current == head){
                    return removeFirst();
                }
                if(current == tail){
                    return removeLast();
                }
                currentSize -- ;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    /**
     * contains an  object into a linked list
     * @param obj to be compared
     * @return true if the obj belongs to the the linked list, false if not
     */
    public boolean contains(E obj){
        Node<E> current = head;
        while (current!= null){
            if(((Comparable<E>)obj).compareTo(current.data)==0){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

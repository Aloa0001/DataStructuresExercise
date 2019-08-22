package trees;

public class Tree<E> {

    class Node <E> {
        E data;
        Node<E> left, right, parent;

        public Node(E obj){

            this.data = obj; // add object value as data
            left = right = parent = null;// initiate the three nodes as null
        }
    }

    Node<E> root;
    int currentSize;

    public Tree(){
        root = null;
        currentSize = 0;
    }

    private void add(E obj, Node<E> node){

        if(((Comparable<E>)obj).compareTo(node.data)>0){// go to the right on the three structure.
                                                        // starting with the root
            if(node.right == null){
                node.right = new Node<E>(obj);
                return;
            }
            add(obj, node.right);
            if (node.left == null){
                node.left = new Node<E>(obj);
                return;
            }
            add(obj, node.left);
        }
    }

    public void add(E obj){
        if(root == null){
            root = new Node<E>(obj);
        }else{
            add(obj,root);
        }
        currentSize++;
    }

    public boolean contains(E obj){
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node){

        if(node == null){
            return false;
        }
        if(((Comparable<E>)obj).compareTo(node.data)== 0){
            return true;
        }
        if(((Comparable<E>)obj).compareTo(node.data)>0){
            return contains(obj, node.right);
        }
        return contains(obj, node.left);
    }

    public void remove(E obj, Node<E> node){

    }

    public Node<E> leftRotate(Node <E> node){ // for imbalances to the right child, right subtree

        Node<E> temp = node.right;//a temporary pointer set to the node's right child
        node.right = temp.left;// the node right child set to the left child
        temp.left = node;//temporary pointer left child set to the node who is rotating
        return temp;
    }

    public Node<E> rightRotate(Node <E> node){//for imbalances to the left child, left subtree

        Node<E> temp = node.left;//pointer set to the nodes left child
        node.left = temp.right;//node.left set to the right child
        temp.right = node;//temp.right equal to the node that is rotating
        return temp;
    }

    public Node<E> leftRightRotate(Node<E> node){//left child, right subtree imbalance

        node.left = leftRotate(node.left);//rotate the parent to the left
        return leftRotate(node);// rotate the grandparent to the right
    }

    public Node<E> rightLeftRotate(Node<E> node){//right child, left subtree imbalance

        node.right = rightRotate(node.right);//rotate the parent to the right
        return leftRotate(node);// rotate the grandparent to the left
    }


}

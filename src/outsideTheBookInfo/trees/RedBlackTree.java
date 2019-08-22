package outsideTheBookInfo.trees;

public class RedBlackTree <K,V> implements RedBlackI<K,V>{

    Node<K,V> node, root;
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

    public void add(K key, V value){

        Node<K,V> node = new Node<>(key, value);
        if(root == null){
            root = node;
            root.isBlack = true;
            size++;
            return;
        }
        add(root, node);
        size++;
    }

    private void add(Node<K,V> parent, Node<K,V> newNode){
        if(((Comparable<K>)newNode.key).compareTo(parent.key) > 0 ){
            if(parent.rightChild == null){
                parent.rightChild = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
                return;
            }
            add(parent.rightChild, newNode);
            return;
        }
        if(parent.leftChild == null){
            parent.leftChild = newNode;
            newNode.parent = parent;
            newNode.isLeftChild = true;
            return;
        }
        add(parent.leftChild, newNode);
        checkColor(newNode);// resposible to check the red black tree rules and establish the balance
    }

    public int blackNodes(Node<K,V> node){

        if (node == null){
            return 1;
        }
        int rightBlackNodes = blackNodes(node.rightChild);
        int leftBlackNodes = blackNodes(node.leftChild);
         if(rightBlackNodes != leftBlackNodes){
             //fix the tree
         }
         if(node.isBlack){
             leftBlackNodes++;
         }
         return leftBlackNodes;
    }

    private void checkColor(Node<K,V> node){

        if(node == root){
            return;
        }
        if(!node.isBlack && !node.parent.isBlack){
            correctTree(node);
        }
        checkColor(node.parent);
    }

    public void correctTree(Node<K,V> node){

        if(node.parent.isLeftChild){//the aunt is node.parent.parent.rightChild
            if(node.parent.parent.rightChild == null || node.parent.parent.isBlack){
                rotate(node);
                return;
            }
            if (node.parent.parent.rightChild != null){
                node.parent.parent.isBlack = true;
            }
            node.parent.isBlack = true;
        }else{                     //the aunt is node.parent.parent.leftChild
            if(node.parent.parent.leftChild == null || node.parent.parent.isBlack){
                rotate(node);
                return;
            }
            if (node.parent.parent.leftChild != null){
                node.parent.parent.isBlack = true;
            }
            node.parent.isBlack = true;
        }
    }

    public void rotate(Node<K,V> node){
        if(node.isLeftChild){
            if(node.parent.isLeftChild){
                rightRotate(node.parent.parent);
                node.isBlack = false;
                node.parent.isBlack = true;
                if(node.parent.rightChild != null){
                    node.parent.rightChild.isBlack = false;
                }
            }
        }else{
            rightLeftRotate(node.parent.parent);
            node.isBlack = true;
            node.rightChild.isBlack = false;
            node.leftChild.isBlack = false;
        }
        if(!node.isLeftChild){
            if(!node.parent.isLeftChild){
                leftRotate(node.parent.parent);
                node.isBlack = false;
                node.parent.isBlack = true;
                if(node.parent.leftChild != null){
                    node.parent.leftChild.isBlack = false;
                }
            }
        }else{
            leftRightRotate(node.parent.parent);
            node.isBlack = true;
            node.rightChild.isBlack = false;
            node.leftChild.isBlack = false;
        }
    }

    /**
     * is taking the grandparent of the child whom created the conflict(the violation)
     * and rotate it to the left, so the parent takes the grandparent place,
     * and the grandparent becomes the left child, leaving the right child in the same place
     * @param grandparent
     */
    public void leftRotate(Node<K,V> grandparent){// the node to be rotate to left is the grandparent
        Node<K,V> temp = grandparent.rightChild;
        grandparent.rightChild = temp.leftChild;
        if(grandparent.rightChild != null){
            grandparent.rightChild.parent = grandparent;
            grandparent.rightChild.isLeftChild = false;
        }
        if(grandparent.parent == null){// means that the grandparent is the root of the tree

            root = temp;
            temp.parent = null;
        }else{

            temp.parent = grandparent.parent;
            if(grandparent.isLeftChild){
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;
            }else{

                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }
        }
        temp.leftChild = grandparent;
        grandparent.isLeftChild = true;
        grandparent.parent = temp;

    }

    /**
     *  is taking the grandparent of the child whom created the conflict(the violation)
     *  and rotate it to the right, so the parent takes the grandparent place,
     *  and the grandparent becomes the right child, leaving the left child in the same place
     * @param grandparent
     */
    public void rightRotate(Node<K,V> grandparent){// the node to be rotate to right is the grandparent
        Node<K,V> temp = grandparent.leftChild;//a temporary pointer to the parent
        grandparent.leftChild = temp.rightChild;//in case a right child exist, becomes the grandparent leftChild

        if(grandparent.leftChild != null){
            grandparent.leftChild.parent = grandparent;
            grandparent.leftChild.isLeftChild = true;
        }
        if(grandparent.parent == null){  // means that the grandparent is the root of the tree

            root = temp;
            temp.parent = null;

        }else{

            temp.parent = grandparent.parent;
            if(grandparent.isLeftChild){
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;

            }else{

                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }
        }
        temp.rightChild = grandparent;
        grandparent.isLeftChild = false;
        grandparent.parent = temp;
    }

    /**
     *
     * @param grandparent
     */
    public void leftRightRotate(Node<K,V> grandparent){//the grandparent in the parameter

        leftRotate(grandparent.leftChild);//the parent will become the left child
        rightRotate(grandparent);// the grandparent will become the right child
    }

    /**
     *
     * @param grandparent
     */
    public void rightLeftRotate(Node<K,V> grandparent){

        rightRotate(grandparent.rightChild);//the parent will become the right child
        leftRotate(grandparent);// the grandparent will become the left child
    }

}

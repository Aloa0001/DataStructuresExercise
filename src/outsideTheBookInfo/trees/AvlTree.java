package outsideTheBookInfo.trees;

public class AvlTree<T>{


    class Node <T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T obj){

            this.data = obj; // add object value as data
            left = right = parent = null;// initiate the three nodes as null
        }
    }

    Node<T> root;
    int currentSize;

    public AvlTree(){
        root = null;
        currentSize = 0;
    }

    public void add(T obj){

        Node<T> node = new Node<T>(obj);

        if(root == null){// check if the tree is empty
            root = node;// add node as root
            currentSize++;
            return;
        }
        add(root,node);
    }

    private void add(Node<T> parent, Node<T> newNode){

        if(((Comparable<T>)newNode.data).compareTo(parent.data)>0){
            if(parent.right == null){
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            }else{
                add(parent.right, newNode);
            }
        }else{
            if(parent.left== null){
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            }else{
                add(parent.left, newNode);
            }
        }
        checkBalance(newNode);
    }
    public void checkBalance(Node<T> node){

        if((height(node.left) - height(node.right) > 1) || (height(node.left) - height(node.right) < -1)){
            rebalance(node);
        }
        if(node.parent == null){
            return;
        }
        checkBalance(node.parent);
    }

    private   void rebalance(Node<T> node){

        if(height(node.left) - height(node.right)>1){

            if(height(node.left.left)>height( node.left.right)){
                node = rightRotate(node);
            }else{
                node = leftRightRotate(node);
            }
        }else{
            if(height(node.right.left)>height(node.right.right)){
                node = leftRotate(node);
            }else{
                node = rightLeftRotate(node);
            }
        }
        if(node.parent == null){
            root = node;
        }
    }

    /**
     *
     * @param
     * @return returnes the height of the whole tree
     */
    public int height(){
        if(root == null){
            return 0;
        }
        return height(root)-1;
    }

    /**
     * takes a node from the tree and calculate the height of THE LONGEST PATH (right or left)
     * TO THAT NODE FROM THE LEAFS
     * @param node
     * @return the height of the subtree
     */
    private int height(Node<T> node){
        if(node == null){
            return 0;
        }else{
            int leftHight = height(node.left) + 1;
            int rightHight = height(node.right) + 1;
            if(leftHight > rightHight){
                return leftHight;
            }else{
                return  rightHight;
            }
        }
    }

    public Node<T> leftRotate(Node<T> node){ // for imbalances to the right child, right subtree

        Node<T> temp = node.right;//a temporary pointer set to the node's right child
        node.right = temp.left;// the node right child set to the left child
        temp.left = node;//temporary pointer left child set to the node who is rotating
        return temp;
    }

    public Node<T> rightRotate(Node<T> node){//for imbalances to the left child, left subtree

        Node<T> temp = node.left;//pointer set to the nodes left child
        node.left = temp.right;//node.left set to the right child
        temp.right = node;//temp.right equal to the node that is rotating
        return temp;
    }

    public Node<T> leftRightRotate(Node<T> node){//left child, right subtree imbalance

        node.left = leftRotate(node.left);//rotate the parent to the left
        return leftRotate(node);// rotate the grandparent to the right
    }

    public Node<T> rightLeftRotate(Node<T> node){//right child, left subtree imbalance

        node.right = rightRotate(node.right);//rotate the parent to the right
        return leftRotate(node);// rotate the grandparent to the left
    }
}

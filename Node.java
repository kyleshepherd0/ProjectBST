class Node<E extends Comparable<? super E>> {
    private E element;
    private Node<E> left;
    private Node<E> right;

    // Implement the constructor
    Node(){
        left = right = null;
    }
    Node(E val){
        left = right = null;
        element = val;
    }
    Node(E val, Node<E> l, Node<E> r){
        left = l;
        right = r;
        element = val;
    }

    // Implement the setElement method
    public void setElement(E element){
        element = this.element;
    }

    // Implement the setLeft method
    public void setLeft(Node left){
        left = this.left;
    }

    // Implement the setRight method
    public void setRight(Node right){
        right = this.right;
    }

    // Implement the getLeft method
    public Node getLeft(){
        return left;
    }
    // Implement the getRight method
    public Node getRight(){
        return right;
    }

    // Implement the getElement method
    public E getElement(){
        return element;
    }

    // Implement the isLeaf method
    public boolean isLeaf(Node e){
        return ((left == null) && (right == null));
    }
}

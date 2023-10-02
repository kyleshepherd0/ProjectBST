class BST<E extends Comparable<E>> {
    private Node<E> root;
    private int nodeCount;


    // Implement the constructor
    BST() {
        root = null;
        nodeCount = 0;
    }

    // Implement the clear method
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    // Implement the size method
    public int size() {
        return nodeCount;
    }

    // Implement the insert method
    public void insert(E e) {
        root = insertHelp(root, e);
        nodeCount++;
    }

    // Implement the remove method
    public E remove(E key) {
        E temp = findHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key);
            nodeCount--;
        }
        return temp;
    }

    // Implement the find method
    public E find(E key) {
        return findHelp(root, key);
    }

    //@Override
    // Implement the iterator method



    // Implement the BSTIterator class



    private E findHelp(Node<E> root, E key) {
        if (root.equals(null)) {
            return null;
        }
        else if (root.getElement().compareTo(key) > 0){
            return (E) findHelp(root.getLeft(), key);
        }
        else if (root.getElement().compareTo(key) == 0) {
            return root.getElement();
        }
        else{
            return (E) findHelp(root.getRight(), key);
        }
    }
    private Node<E> insertHelp(Node<E> root, E key){
        if (root.equals(null)){
            return new Node<E>(key);
        }
        else if (root.getElement().compareTo(key) > 0){
            root.setLeft(insertHelp(root.getLeft(), key));
        }
        else{
            root.setRight(insertHelp(root.getRight(), key));
        }
        return root;
    }

    private Node<E> removeHelp(Node<E> root, E key){
        if (root == null){
            return null;
        }
        if (root.getElement().compareTo(key) > 0){
            root.setLeft(removeHelp(root.getLeft(), key));
        }
        else if (root.getElement().compareTo(key) < 0){
            root.setRight(removeHelp(root.getRight(), key));
        }
        else{ //found it, remove it
            nodeCount--;
            if (root.getLeft() == null){
                return root.getRight();
            }
            else if (root.getRight() == null){
                return root.getLeft();
            }
            else { //two children
                Node<E> temp = getMax(root.getLeft());
                root.setElement(temp.getElement());
                root.setLeft(deleteMax(root.getLeft()));
            }
        }
        return root;
    }

    private Node<E> getMax(Node<E> root){
        if (root.getRight() == null){
            return root;
        }
        return getMax(root.getRight());
    }

    private Node<E> deleteMax(Node<E> root){
        if (root.getRight() == null){
            return root.getRight();
        }
        else{
            root.setRight(deleteMax(root.getRight()));
            return root;
        }
    }

    private void printHelp(Node<E> root){
        if (root == null){
            return;
        }
        printHelp(root.getLeft());
        printVisit(root.getElement());
        printHelp(root.getRight());
    }
}

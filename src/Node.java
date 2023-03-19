public abstract class Node<K> implements Comparable<K>{
    public K value;
    public Node<K> left;
    public Node<K> right;

    Node(K value) {
        this.value=value;
    }

    public boolean hasLeft() {
        return (left != null);
    }

    public boolean hasRight() {
        return (right != null);
    }
}

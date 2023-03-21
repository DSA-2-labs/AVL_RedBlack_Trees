public class AVLNode<K extends Comparable<K>> {
    public K value;
    public AVLNode<K> left;
    public AVLNode<K> right;
    public int height;

    public boolean hasLeft() {
        return (left != null);
    }

    AVLNode(K value) {
        this.value = value;
        left=null;
        right=null;
        this.height = 1;
    }
}

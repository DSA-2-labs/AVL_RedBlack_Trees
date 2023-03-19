public class AVLNode<K extends Comparable<K>> extends Node<K> {
    int height;
    AVLNode(K value) {
        super(value);
        left=null;
        right=null;
        this.height = 0;
    }
}

import java.awt.*;

import static java.awt.Color.RED;
import static java.awt.Color.BLACK;

public class RBNode<K extends Comparable<K>> {

    public K value;
    public RBNode<K> left;
    public RBNode<K> right;
    public int height;
    public Color color;
    public RBNode parent;

    RBNode(K value) {
        this.value = value;
        this.left=null;
        this.right=null;
        this.height = 0;
        this.color = RED;
    }
}

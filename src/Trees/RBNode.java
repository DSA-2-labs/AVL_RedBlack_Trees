package Trees;

import java.awt.*;

import static java.awt.Color.RED;
import static java.awt.Color.BLACK;

public class RBNode<K extends Comparable<K>> {

    public K value;
    public RBNode<K> left;
    public RBNode<K> right;
    private boolean isNull;
    public Color color;
    public RBNode parent;

    RBNode(K value) {
        this.isNull = false;
        this.value = value;
        this.left = createNullLeaf();
        this.right = createNullLeaf();
        this.color = RED;
    }

    RBNode () {
    }

    private RBNode<K> createNullLeaf () {
        RBNode<K> node = new RBNode<>();
        node.isNull = true;
        node.color = BLACK;
        return node;
    }

    public boolean isNullLeaf () {
        return this.isNull;
    }

    public void setLeaf () {
        this.isNull = true;
        this.color = BLACK;
        this.value = null;
    }
}

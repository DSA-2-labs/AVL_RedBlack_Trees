import java.awt.*;

import static java.awt.Color.RED;
import static java.awt.Color.BLACK;

public class RBNode<K extends Comparable<K>> extends Node<K> {
    public Color color;
    public RBNode parent;
    RBNode(K value) {
        super(value);
        this.color = RED;
    }
}

import java.awt.*;

public class RedBlackTree<K extends Comparable<K>> extends AbstractBST<K> {

    @Override
    public boolean insert(K key) {
        if (insert(root, key) == null)
            return false;
        return true;
    }

    private RBNode insert(Node<K> node, K key) {
        if (node == null) {
            size++;
            Node newNode = new RBNode(key);
            if (size == 1) {
                ((RBNode<K>) newNode).color = Color.BLACK;
                root = newNode;
            }
            return new RBNode(key);
        }
        String curVal = String.valueOf(node.value);
        String val = String.valueOf(key);
        int cmp = node.value.compareTo(key);

        Node newNode = null;
        if (cmp > 0) {
            if (node.left != null)
                return insert(node.left, key);
            newNode = new RBNode(key);
            node.left = newNode;
            ((RBNode<K>) newNode).parent = (RBNode<K>)node;
            size++;
        } else if (cmp < 0) {
            if (node.right != null)
                return insert(node.right, key);
            newNode = new RBNode(key);
            node.right = newNode;
            ((RBNode<K>) newNode).parent = (RBNode<K>)node;
            size++;
        }
        else { // key already exists
        }
        return (RBNode) newNode;
    }

    @Override
    public boolean delete(K key) {
        return false;
    }

    private void rotateleft(RBNode node){
        RBNode x = (RBNode) node.right;
        node.right = x.left;
        x.left = node ;
        x.color = node.color;
        node.color = Color.RED;
    }
    private  void rotateright(RBNode node){
        RBNode x = (RBNode) node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = Color.RED;

    }

    public void test (RBNode node) {
        if (node == null)
            return;
        System.out.print("val: " + node.value + " ");
        if (node.left != null) {
            System.out.print("left: " + node.left.value + " ");
        }
        if (node.right != null) {
            System.out.print("right: " + node.right.value + " ");
        }
        if (node.parent != null) {
            System.out.print("parent: " + node.parent.value + " ");
        }

        System.out.println(node.color);
        test((RBNode) node.left);
        test((RBNode) node.right);
    }

}

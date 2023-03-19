import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class RedBlackTree<K extends Comparable<K>> implements BinarySearchTree<K> {

    RBNode<K> root;
    int size;

    RedBlackTree() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public boolean insert(K key) {
        return insert(root, key) != null;
    }

    private RBNode insert(RBNode node, K key) {
        if (node == null) {
            size++;
            RBNode newNode = new RBNode(key);
            if (size == 1) {
                newNode.color = BLACK;
                root = newNode;
            }
            return newNode;
        }
        int cmp = node.value.compareTo(key);
        RBNode newNode = null;
        if (cmp > 0) {
            if (node.left != null)
                return insert((RBNode) node.left, key);
            newNode = new RBNode(key);
            node.left = newNode;
            newNode.parent = node;
            size++;
        } else if (cmp < 0) {
            if (node.right != null)
                return insert((RBNode) node.right, key);
            newNode = new RBNode(key);
            node.right = newNode;
            newNode.parent = node;
            size++;
        }
        else { // key already exists
        }
        return newNode;
    }

    @Override
    public boolean delete(K key) {
        return false;
    }

    @Override
    public boolean search(K key) {
        boolean found = false;
        RBNode temp = root;
        while(temp != null)
        {
            int cmp = temp.value.compareTo(key);
            if(cmp == 0)
                return true;
            else if(cmp > 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int height() {
        return 0;
    }

    private void rotateleft(RBNode node){
        RBNode x = (RBNode) node.right;
        node.right = x.left;
        if(x.left != null){
            x.left.parent = node;
        }
        x.parent = node.parent;
        if(node.parent == null){
            root = x;
        }else if(node.parent.left == node){
            node.parent.left = x;
        }else{
            node.parent.right = x;
        }
        node.parent = x;
        x.left = node ;
    }
    private  void rotateright(RBNode node){
        RBNode x = (RBNode) node.left;
        node.left = x.right;
        if(x.right != null){
            x.right.parent = node;
        }
        x.parent = node.parent;
        if(node.parent == null){
            root = x;
        }else if(node == node.parent.left){
            node.parent.left = x;
        }else{
            node.parent.right = x;
        }
        node.parent = x;
        x.right = node;
    }
    private void fixInput(RBNode node){

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

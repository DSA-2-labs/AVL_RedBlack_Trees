import java.awt.*;

public class RedBlackTree<K> extends AbstractBST<K> {

    @Override
    public boolean insert(K key) {
        return false;
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
}

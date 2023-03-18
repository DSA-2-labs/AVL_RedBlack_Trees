public abstract class AbstractBST<K> implements BinarySearchTree<K> {

    Node<K> root;
    int size = 0;

    @Override
    public abstract boolean insert(K key);

    @Override
    public abstract boolean delete(K key);

    @Override
    public boolean search(K key) {
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
}

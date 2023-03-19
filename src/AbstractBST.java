public abstract class AbstractBST<K extends Comparable<K>> implements BinarySearchTree<K> {

    Node<K> root;
    int size = 0;

    @Override
    public abstract boolean insert(K key);

    @Override
    public abstract boolean delete(K key);

    @Override
    public boolean search(K key) {
        boolean found = false;
        Node temp = root;
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
        if(this.root==null)
            return -1;
        else
            return get_height(this.root);
    }
    public int get_height(Node<K> N)
    {
        if(N==null)
            return -1;
        return (1+Math.max(get_height(N.left),get_height(N.right)));
    }
}

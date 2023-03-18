public interface BinarySearchTree<K> {

    /**
     * takes a key and inserts it
     * if it is not in the tree
     * @param key the key to be inserted
     * @return true if it is added
     * and false if it already exists
     */
    boolean insert (K key);

    /**
     * takes a key and deletes it
     * if it is in the tree
     * @param key the key to be deleted
     * @return true if it is deleted
     * and false if it is not in the tree
     */
    boolean delete (K key);

    /**
     * takes a key and searches for it
     * @param key to be searched for
     * @return true if it is found in the tree
     * and false otherwise
     */
    boolean search (K key);

    /**
     * @return the number of keys in the tree
     */
    int size ();

    /**
     * @return the height of the tree
     */
    int height ();
}

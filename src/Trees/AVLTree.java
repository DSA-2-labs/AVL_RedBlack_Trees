package Trees;

public class AVLTree<K extends Comparable<K>> implements BinarySearchTree<K> {
    AVLNode<K> root;
    private int size;
    public AVLTree() {
        root = null;
        size=0;
    }

    @Override
    public boolean insert(K key) {
        if(search(key)){
            return false;
        }
        root=insertrec(root,key);
        if (root == null)
            return false;
        size++;
        return true;
    }

    public AVLNode<K> insertrec(AVLNode<K> root,K data){
        if (root == null){
            root = new AVLNode<K>(data);
            return root;
        }
        if (data.compareTo(root.value) < 0){
            root.left = insertrec(root.left, data);
        }
        else if (data.compareTo(root.value) > 0){
            root.right = insertrec(root.right, data);
        }
        updateheight(root);
        return applybalance(root);
    }

    private AVLNode<K> applybalance(AVLNode<K> root) {
        int balance = balance(root);
        if (balance > 1 && balance(root.left) >= 0){
            return rightrotate(root);
        }
        if (balance < -1 && balance(root.right) <= 0){
            return leftrotate(root);
        }
        if (balance > 1 && balance(root.left) < 0){
            root.left = leftrotate(root.left);
            return rightrotate(root);
        }
        if (balance < -1 && balance(root.right) > 0){
            root.right = rightrotate(root.right);
            return leftrotate(root);
        }
        return root;
    }

    private AVLNode<K> leftrotate(AVLNode<K> root) {
        AVLNode<K> rchild=root.right;
        root.right= rchild.left;
        rchild.left=root;
        updateheight(root);
        updateheight(rchild);
        return rchild;
    }

    private AVLNode<K> rightrotate(AVLNode<K> root) {
        AVLNode<K> lchild=root.left;
        root.left= lchild.right;
        lchild.right=root;
        updateheight(root);
        updateheight(lchild);
        return lchild;
    }

    int height(AVLNode<K> node){
        if (node == null){
            return 0;
        }
        return node.height;
    }
    private int balance(AVLNode<K> root) {
        if (root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    private void updateheight(AVLNode<K> root) {
        root.height = Math.max(height(root.left), height(root.right)) + 1;
    }

    @Override
    public boolean delete(K key) {
        if(!search(key)){
            return false;
        }
        root=deleterec(root,key);
        if (root == null)
            return false;
        size--;
        return true;
    }

    public AVLNode<K> deleterec(AVLNode<K> root, K data){
        if (root == null){
            return root;
        }
        if (data.compareTo(root.value) < 0){
            root.left = deleterec(root.left, data);
        }
        else if (data.compareTo(root.value) > 0){
            root.right = deleterec(root.right, data);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            root.value = minvalue(root.right);
            root.right = deleterec(root.right, root.value);
        }
        updateheight(root);
        return applybalance(root);
    }

    private K minvalue(AVLNode<K> right) {
        AVLNode<K> current = right;
        while (current.left != null)
            current = current.left;
        return current.value;
    }
    private K maxvalue(AVLNode<K> right) {
        AVLNode<K> current = right;
        while (current.right != null)
            current = current.right;
        return current.value;
    }

    @Override
    public boolean search(K key){
        AVLNode<K> temp=root;
        while(temp != null)
        {
            int cmp = key.compareTo(temp.value);
            if(cmp == 0)
                return true;
            else if(cmp > 0)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return root.height;
    }
}

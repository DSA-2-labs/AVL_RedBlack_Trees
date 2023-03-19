public class AVLTree<K extends Comparable<K>> implements BinarySearchTree<K> {
    AVLNode<K> root;
    int size;
    AVLTree(){
        root = null;
        size=0;
    }

    @Override
    public boolean insert(K key) {
        root=insertrec(root,key);
        if (root == null)
            return false;
        size++;
        return true;
    }

    private AVLNode<K> insertrec(AVLNode<K> root, K data) {
        if (root == null){
            root = new AVLNode<K>(data);
            return root;
        }
        if (data.compareTo(root.value) < 0){
            root.left = insertrec((AVLNode<K>) root.left, data);
        }
        else if (data.compareTo(root.value) > 0){
            root.right = insertrec((AVLNode<K>) root.right, data);
        }
        updateheight(root);
        return applybalance(root);

    }

    private AVLNode<K> applybalance(AVLNode<K> root) {
        int balance = getbalance(root);
        if (balance > 1 && getbalance((AVLNode<K>) root.left) >= 0) //LL
            return rightrotate(root);
        if (balance > 1 && getbalance((AVLNode<K>) root.left) < 0) { //LR
            root.left = leftrotate((AVLNode<K>) root.left);
            return rightrotate(root);
        }
        if (balance < -1 && getbalance((AVLNode<K>) root.right) <= 0)//RR
            return leftrotate(root);
        if (balance < -1 && getbalance((AVLNode<K>) root.right) > 0) {//RL
            root.right = rightrotate((AVLNode<K>) root.right);
            return leftrotate(root);
        }
        return root;
    }

    private AVLNode<K> leftrotate(AVLNode<K> left) {
        AVLNode<K> right = (AVLNode<K>) left.right;
        AVLNode<K> rightleft = (AVLNode<K>) right.left;
        right.left = left;
        left.right = rightleft;
        updateheight(left);
        updateheight(right);
        return right;
    }

    private AVLNode<K> rightrotate(AVLNode<K> root) {
        AVLNode<K> left = (AVLNode<K>) root.left;
        AVLNode<K> leftright = (AVLNode<K>) left.right;
        left.right = root;
        root.left = leftright;
        updateheight(root);
        updateheight(left);
        return left;
    }

    private int getbalance(AVLNode<K> root) {
        if (root == null)
            return 0;
        return height((AVLNode<K>) root.left) - height((AVLNode<K>) root.right);
    }

    int height(AVLNode<K> node){
        if (node == null){
            return 0;
        }
        return node.height;
    }
    private void updateheight(AVLNode<K> root) {
        root.height = 1 + Math.max(height((AVLNode<K>) root.left), height((AVLNode<K>) root.right));
    }

    @Override
    public boolean delete(K key) {
        root=deleterec(root,key);
        if (root == null)
            return false;
        size--;
        return true;
    }

    private AVLNode<K> deleterec(AVLNode<K> root, K key) {
        if (root == null)
            return root;
        if (key.compareTo(root.value) < 0)
            root.left = deleterec((AVLNode<K>) root.left, key);
        else if (key.compareTo(root.value) > 0)
            root.right = deleterec((AVLNode<K>) root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                AVLNode<K> temp = null;
                if (temp == root.left)
                    temp = (AVLNode<K>) root.right;
                else
                    temp = (AVLNode<K>) root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                AVLNode<K> temp = minvalue((AVLNode<K>) root.right);
                root.value = temp.value;
                root.right = deleterec((AVLNode<K>) root.right, temp.value);
            }
        }
        if (root == null)
            return root;
        updateheight(root);
        return applybalance(root);

    }

    private AVLNode<K> minvalue(AVLNode<K> right) {
        AVLNode<K> current = right;
        while (current.left != null)
            current = (AVLNode<K>) current.left;
        return current;
    }
    private AVLNode<K> maxvalue(AVLNode<K> right) {
        AVLNode<K> current = right;
        while (current.right != null)
            current = (AVLNode<K>) current.right;
        return current;
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
                temp = (AVLNode<K>) temp.right;
            else
                temp = (AVLNode<K>) temp.left;
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

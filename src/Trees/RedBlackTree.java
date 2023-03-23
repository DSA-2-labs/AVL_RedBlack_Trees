package Trees;

import java.awt.*;

import static java.awt.Color.*;

public class RedBlackTree<K extends Comparable<K>> implements BinarySearchTree<K> {

    public RBNode<K> root;
    private int size;
    private boolean deleteFlag = true;

    public RedBlackTree() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public boolean insert(K key) {
        return insert(root, key) != null;
    }

    private RBNode<K> insert(RBNode<K> node, K key) {
        if (node == null || node.isNullLeaf()) {
            size++;
            RBNode<K> newNode = new RBNode<>(key);
            if (size == 1) {
                newNode.color = BLACK;
                root = newNode;
            }
            return newNode;
        }
        int cmp = node.value.compareTo(key);
        RBNode<K> newNode = null;
        if (cmp > 0) {
            if (node.left != null && !node.left.isNullLeaf())
                return insert(node.left, key);
            newNode = new RBNode<>(key);
            node.left = newNode;
            newNode.parent = node;
            size++;
        } else if (cmp < 0) {
            if (node.right != null && !node.right.isNullLeaf())
                return insert(node.right, key);
            newNode = new RBNode<>(key);
            node.right = newNode;
            newNode.parent = node;
            size++;
        }
        fixInput(newNode);
        return newNode;
    }

    @Override
    public boolean delete(K key) {
        delete(root, key);
        if (deleteFlag)
            size--;
        return deleteFlag;
    }

    private RBNode<K> delete(RBNode<K> node, K key) {
        if (node == null || node.isNullLeaf()) {
            deleteFlag = false;
            return node;
        }
        int cmp = node.value.compareTo(key);
        if (cmp > 0) {
            delete(node.left, key);
        } else if (cmp < 0) {
            delete(node.right, key);
        }
        else {
            deleteFlag = true;
            if ((node.left.isNullLeaf()) || (node.right.isNullLeaf())) {
                RBNode<K> temp = node.right.isNullLeaf() ? node.left : node.right;
                Color nodeCol = node.color;
                temp.parent = node.parent;
                if (temp.isNullLeaf()) {
                    if (node.parent == null){}
                    else if (node == node.parent.right)
                        node.parent.right = temp;
                    else
                        node.parent.left = temp;
                    node.setLeaf();
                } else {
                    if (node.parent == null)
                        root = temp;
                    else if (node == node.parent.right)
                        node.parent.right = temp;
                    else
                        node.parent.left = temp;
                    node = temp;
                }
                if (nodeCol == BLACK) { // node to be deleted is black
                    if (temp.color == RED) { // check if child is red
                        temp.color = BLACK; // then recolor with black
                    }
                    else {
                        deleteCase1 (temp);
                    }
                }
                else {
                    temp.color = BLACK; // then recolor with black
                }
            } else {
                RBNode<K> temp = minvalue(node.right);
                node.value = temp.value;
                delete(node.right, temp.value);
            }
        }
        return node;
    }

    private RBNode<K> getSibling (RBNode<K> node) {
        RBNode<K> parent = node.parent;
        if (node == parent.left) {
            return parent.right;
        }
        else {
            return parent.left;
        }
    }

    // case 1: doubleBlack is now at the root
    private void deleteCase1(RBNode<K> doubleBlack) {
        if (doubleBlack.parent == null) {
            return;
        }
        if (doubleBlack.color == RED) {
            doubleBlack.color = BLACK;
            return;
        }
        deleteCase2(doubleBlack);
    }

    // case 2: sibling is black and has red child
    private void deleteCase2(RBNode<K> doubleBlack) {
        RBNode<K> s = getSibling(doubleBlack);
        if (s.color == BLACK) {
            if (s == s.parent.right && s.right.color == RED) { //RR
                if (s.parent.color == BLACK) {
                    s.right.color = BLACK;
                }
                else {
                    if (s.left.color == RED) {
                        s.color = RED;
                        s.parent.color = BLACK;
                        s.right.color = BLACK;
                    }
                }
                rotateleft(s.parent);
            }
            else if (s == s.parent.right && s.left.color == RED) { //RL
                s.color = RED;
                s.left.color = BLACK;
                rotateright(s.left.parent);
                deleteCase2(doubleBlack);
            }
            else if (s == s.parent.left && s.left.color == RED) { //LL
                if (s.parent.color == BLACK) {
                    s.left.color = BLACK;
                }
                else {
                    if (s.right.color == RED) {
                        s.color = RED;
                        s.parent.color = BLACK;
                        s.left.color = BLACK;
                    }
                }
                rotateright(s.parent);
            }
            else if (s == s.parent.left && s.right.color == RED){ //LR
                s.color = RED;
                s.right.color = BLACK;
                rotateleft(s.right.parent);
                deleteCase2(doubleBlack);
            }
            else {
                deleteCase3(doubleBlack);
            }
        }
        else {
            deleteCase4(doubleBlack);
        }
    }

    private void deleteCase3(RBNode<K> doubleBlack){  //sibling Black , 2 child black
        RBNode<K> s = getSibling(doubleBlack);
        s.color = RED;
        deleteCase1(doubleBlack.parent);
    }
    private void deleteCase4(RBNode<K> doubleBlack)
    {
        RBNode<K> s = getSibling(doubleBlack);
        s.parent.color = RED;
        s.color = BLACK;
        if(doubleBlack.parent.left == doubleBlack) //sibling is right
        {
            rotateleft(s.parent);
        }
        else //sibling is left
        {
            rotateright(s.parent);
        }
        deleteCase1(doubleBlack);
    }

    private RBNode<K> minvalue(RBNode<K> node) {
        RBNode<K> prev = null;
        while (node != null && !node.isNullLeaf()) {
            prev = node;
            node = node.left;
        }
        return prev != null ? prev : node;
    }

    @Override
    public boolean search(K key) {
        return search(root, key);
    }

    private boolean search(RBNode<K> root, K key) {
        if (root == null || root.isNullLeaf()) {
            return false;
        }
        int cmp = root.value.compareTo(key);
        if (cmp == 0) {
            return true;  // Base case for a root node that contains the key
        } else if (cmp > 0) {
            return search(root.left, key);  // Recursively search in the left subtree
        } else {
            return search(root.right, key);  // Recursively search in the right subtree
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int height() {
        return height(root);
    }

    public int height(RBNode<K> root) {
        if (root == null || root.isNullLeaf()) {
            return -1;  // Base case for an empty tree
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    private void rotateleft(RBNode<K> node){
        RBNode<K> x = node.right;
        node.right = x.left;
        x.left.parent = node;
        x.parent = node.parent;
        if(node.parent == null){
            root = x;
        }else if(node.parent.left == node){
            node.parent.left = x;
        }else{
            node.parent.right = x;
        }
        node.parent = x;
        x.left = node;
    }
    private  void rotateright(RBNode<K> node){
        RBNode<K> x = node.left;
        node.left = x.right;
        x.right.parent = node;
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
    private void fixInput(RBNode<K> node){
        if(node != null && node != root && node.parent.color == RED ) {
            if (node.parent == node.parent.parent.left) {
                RBNode<K> uncle = node.parent.parent.right;
                if (uncle.color == RED){
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    fixInput(node.parent.parent);
                }else{
                    if(node == node.parent.right){ //LR
                        node = node.parent;
                        rotateleft(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateright(node.parent.parent);
                }
            }else{
                RBNode<K> uncle = node.parent.parent.left;
                if( uncle.color == RED){
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    fixInput(node.parent.parent);
                }else{
                    if(node == node.parent.left){ //RL
                        node = node.parent;
                        rotateright(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateleft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }
}
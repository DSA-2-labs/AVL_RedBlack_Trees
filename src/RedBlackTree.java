import java.awt.*;

import static java.awt.Color.*;

public class RedBlackTree<K extends Comparable<K>> implements BinarySearchTree<K> {

    RBNode<K> root;
    private int size;
    private boolean deleteFlag = true;

    RedBlackTree() {
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
//        fixInput(newNode);
        return newNode;
    }

    @Override
    public boolean delete(K key) {
        root = delete(root, key);
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
            node.left = delete(node.left, key);
        } else if (cmp < 0) {
            node.right = delete(node.right, key);
        }
        else {
            deleteFlag = true;
            if ((node.left.isNullLeaf()) || (node.right.isNullLeaf())) {
                RBNode<K> temp = node.right.isNullLeaf() ? node.left : node.right;
//                if (temp == null) {
//                    temp = node;
//                    node = null;
//                } else {
                    temp.parent = node.parent;
                    if (node == node.parent.left) {
                        node.parent.left = temp;
                    }
                    else {
                        node.parent.right = temp;
                    }
                    Color nodeCol = node.color;
                    node = temp;
//                }
                if (nodeCol == BLACK) { // node to be deleted is black
                    if (temp.color == RED) { // check if child is red
                        temp.color = BLACK; // then recolor with black
                    }
                    else {
                        deleteCase1 (temp);
                    }
                }
            } else {
                RBNode<K> temp = minvalue(node.right);
                node.value = temp.value;
                node.right = delete(node.right, temp.value);
            }
        }
        return node;
    }

    private void deleteCase1(RBNode<K> doubleBlack) {

    }

    private RBNode<K> minvalue(RBNode<K> right) {
        RBNode<K> current = right;
        while (current.left != null)
            current = current.left;
        return current;
    }

    @Override
    public boolean search(K key) {
        RBNode<K> temp = root;
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
        x.left = node ;
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
                if (uncle != null && uncle.color == RED){
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    fixInput(node);
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
                if(uncle != null && uncle.color == RED){
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    fixInput(node);
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

    public void test (RBNode<K> node) {
        if (node == null || node.isNullLeaf())
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
        test(node.left);
        test(node.right);
    }

}
public class Main {
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        t.insert(41);
        t.insert(38);
        t.insert(31);
        t.insert(12);
        t.insert(19);
        t.insert(8);
        t.test((RBNode) t.root);
    }
}
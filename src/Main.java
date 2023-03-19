public class Main {
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        System.out.println(t.insert(41));
        System.out.println(t.insert(41));
        System.out.println(t.insert(38));
        System.out.println(t.insert(31));
        System.out.println(t.insert(12));
        System.out.println(t.insert(19));
        System.out.println(t.insert(31));
        System.out.println(t.insert(8));
        t.test(t.root);
    }
}
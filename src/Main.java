public class Main {
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        System.out.println(t.insert(41));
        System.out.println(t.insert(41));
        System.out.println(t.insert(38));
        System.out.println(t.insert(31));
        System.out.println(t.insert(12));
        System.out.println(t.insert(19));
        System.out.println(t.insert(8));
//        System.out.println(t.delete(38));
//        System.out.println(t.delete(38));
//        System.out.println(t.insert(5));
//        System.out.println(t.insert(8));
//        System.out.println(t.insert(1));
//        System.out.println(t.insert(13));
//        System.out.println(t.insert(6));
//        System.out.println(t.insert(7));
//        System.out.println(t.insert(11));
//        System.out.println(t.insert(12));
//        System.out.println(t.delete(1));
        t.test(t.root);
//        System.out.println(t.root.value);*/
//        AVLTree t2=new AVLTree();
//        Testing testcases=new Testing();
//        t2.insert(7);
//        t2.insert(7);
       // testcases.test_insertAVL();
    }
}
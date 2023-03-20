import org.junit.Test;
import static org.junit.Assert.*;

public class Testing {
    //AVL tree tests
    AVLTree T1=new AVLTree();
    RedBlackTree T2=new RedBlackTree();
    public void test_insertAVL()
    {
        assertEquals("Test 1",true,T1.insert(7));
        //assertEquals("Test 2",false,T1.insert(7));
    }
    public void test_deleteAVL()
    {
        assertEquals("Test 3",true,T1.delete(7));
        assertEquals("Test 4",false,T1.delete(7));
    }
    public void test_SearchAVL()
    {
        T1.insert(9);T1.insert(4);T1.insert(10);T1.insert(37);T1.insert(1);
        assertEquals("Test 3",true,T1.search(3));
        assertEquals("Test 4",false,T1.search(7));
    }

    //Red Black tree test
    public void test_insertRB()
    {
        //assertEquals("",,);
    }
    public void test_deleteRB()
    {

    }
    public void testApplication()
    {

    }
}


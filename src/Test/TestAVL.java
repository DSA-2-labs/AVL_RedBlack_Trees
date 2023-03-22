package Test;
import Trees.AVLTree;
import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestAVL {
    private AVLTree<Integer> T1=new AVLTree<>();
    private void insertcases(Integer...objs)
    {
        for (Integer object: objs)
            T1.insert(object);
    }

    @Test
    //@Ignore("Should be fixed")
    public void test1()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
    @Test
    //@Ignore("Should be fixed")
    public void test2()
    {
        assertTrue(T1.size()==0);
        insertcases(7,3,18,10,22,8,11,26,2,6,13);
        assertTrue(T1.delete(26));//empty
        assertTrue(T1.delete(13));//7,3,18,10,22,8,11,26,2,6
        assertFalse(T1.search(13));
        assertTrue(T1.delete(18));//7,3,10,22,8,11,26,2,6
        assertFalse(T1.search(18));
        assertFalse(T1.insert(11));
        assertTrue(T1.delete(10));//7,3,22,8,11,26,2,6
        assertFalse(T1.search(10));
        assertTrue(T1.delete(3));//7,22,8,11,26,2,6
        assertFalse(T1.search(3));
        assertTrue(T1.delete(7));//22,8,11,26,2,6
        assertFalse(T1.search(7));
        assertTrue(T1.delete(22));//8,11,26,2,6
        assertFalse(T1.search(22));
        assertTrue(T1.delete(8));//11,26,2,6
        assertFalse(T1.search(8));
        assertTrue(T1.delete(6));//11,26,2
        assertFalse(T1.search(6));
        assertTrue(T1.search(2));
        assertTrue(T1.delete(2));
        assertFalse(T1.search(2));
        assertTrue(T1.delete(11));//26
        assertFalse(T1.search(11));
        assertFalse(T1.search(26));
        assertTrue(T1.size()==0);
    }
    @Test
    //@Ignore("Should be fixed")
    public void test3()
    {
        assertTrue(T1.size()==0);
        insertcases(10,20,30,40,50);
        assertEquals(3,T1.height());
    }
    @Test
    //@Ignore("Should be fixed")
    public void test4()
    {
        assertTrue(T1.size()==0);
        insertcases(50,40,30);
        assertTrue(T1.size()==3);
    }
    @Test
    //@Ignore("Should be fixed")
    public void test5()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
    @Test
    //@Ignore("Should be fixed")
    public void test6()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
    @Test
    //@Ignore("Should be fixed")
    public void test7()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
    @Test
    //@Ignore("Should be fixed")
    public void test8()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
    @Test
    //@Ignore("Should be fixed")
    public void test9()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
    @Test
    //@Ignore("Should be fixed")
    public void test10()
    {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
    }
}

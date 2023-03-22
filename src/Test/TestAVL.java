package Test;
import Trees.AVLTree;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAVL <K extends Comparable<K>> {
    private AVLTree<Integer> T1=new AVLTree<Integer>();
    private void insertcases(Integer...objs)
    {
        for (Integer object: objs)
            T1.insert(object);
    }
    @Test
    @Ignore("Should be fixed")
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
    @Ignore("Should be fixed")
    public void test2()
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
    @Ignore("Should be fixed")
    public void test3()
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
    @Ignore("Should be fixed")
    public void test4()
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
    @Ignore("Should be fixed")
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
    @Ignore("Should be fixed")
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
    @Ignore("Should be fixed")
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
    @Ignore("Should be fixed")
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
    @Ignore("Should be fixed")
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
    @Ignore("Should be fixed")
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

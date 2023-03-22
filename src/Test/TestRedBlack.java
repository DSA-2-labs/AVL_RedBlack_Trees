package Test;

import Trees.RedBlackTree;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRedBlack {
    private RedBlackTree<Integer> T1 = new RedBlackTree();

    private void insertcases(Integer... objs) {
        for (Integer object : objs)
            T1.insert(object);
    }

    @Test
    public void test1() {
        assertTrue(T1.size()==0);
        insertcases(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);
        assertTrue(T1.delete(88));//16,24,36,19,44,28,61,74,83,64,52,65,86,93
        assertFalse(T1.search(88));
        assertTrue(T1.delete(19));//16,24,36,44,28,61,74,83,64,52,65,86,93
        assertFalse(T1.search(19));
        assertFalse(T1.insert(16));
        assertTrue(T1.delete(16));//24,36,44,28,61,74,83,64,52,65,86,93
        assertFalse(T1.search(16));
        assertTrue(T1.delete(28));//24,36,44,61,74,83,64,52,65,86,93
        assertFalse(T1.search(28));
        assertTrue(T1.delete(24));//36,44,61,74,83,64,52,65,86,93
        assertFalse(T1.search(24));
        assertTrue(T1.delete(36));//44,61,74,83,64,52,65,86,93
        assertFalse(T1.search(36));
        assertTrue(T1.delete(52));//44,61,74,83,64,65,86,93
        assertFalse(T1.search(52));
        assertTrue(T1.delete(93));//44,61,74,83,64,65,86
        assertFalse(T1.search(93));
        assertTrue(T1.delete(86));//44,61,74,83,64,65
        assertFalse(T1.search(86));
        assertTrue(T1.delete(83));//44,61,74,64,65
        assertFalse(T1.search(83));
        assertTrue(T1.size()==5);//44,61,74,64,65
    }

    @Test
    public void test2() {
        assertTrue(T1.size() == 0);
        insertcases(7, 3, 18, 10, 22, 8, 11, 26, 2, 6, 13);
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
        assertTrue(T1.size() == 0);
    }

    @Test
    public void test3() {
        assertTrue(T1.size() == 0);
        insertcases(10, 20, 30, 40, 50);
        assertEquals(2, T1.height());
    }

    @Test
    public void test4() {
        assertTrue(T1.size() == 0);
        insertcases(50, 40, 30);
        assertTrue(T1.size() == 3);
    }

    @Test
    public void test5() {
        assertTrue(T1.size() == 0);
        insertcases(2,5,7,1,90,0,3);
        assertFalse(T1.insert(2));
        assertTrue(T1.insert(10));
        assertEquals(4,T1.height());
    }

    @Test
    public void test6() {
        assertTrue(T1.size() == 0);
        insertcases(1,2,3,4);
        assertEquals(2, T1.height());
        assertTrue(T1.search(4));
        assertFalse(T1.search(10));
    }

    @Test
    public void test7() {
        insertcases(0,1,2,3,4,5,6,7,8,9);
        assertEquals(4,T1.height());
        assertEquals(10,T1.size());
        assertTrue(T1.delete(6));
        assertFalse(T1.delete(10));
        assertTrue(T1.delete(9));
        assertFalse(T1.search(9));
        assertEquals(3,T1.height());
        assertEquals(8,T1.size());
        assertFalse(T1.search(6));
        assertTrue(T1.insert(6));
        assertTrue(T1.search(6));
        assertEquals(9,T1.size());
        assertEquals(3,T1.height());
    }

    @Test
    public void test8() {
        assertTrue(T1.size()==0);
        insertcases(10,5,17,2,9,12,20,3,11,15,18,30,13,33);
        assertEquals(4, T1.height());
        assertTrue(T1.delete(9));
        assertEquals(4, T1.height());
        assertEquals(13, T1.size());
    }

    @Test
    public void test9() {
        assertEquals(0, T1.size());
        insertcases(1,2,3,4,5,6,7,8,9,22,20,18);
        assertFalse(T1.search(80));
        assertEquals(12,T1.size());
    }

    @Test
    public void test10() {
        assertEquals(0, T1.size());
        assertEquals(-1,T1.height());
        assertTrue(T1.insert(7));
        assertEquals(0,T1.height());
        insertcases(9,8,4,-11);
        assertEquals(5,T1.size());
    }
    @Test
    public void test11()
    {
        assertEquals(0, T1.size());
        insertcases(5,2,7,1,4,6,9,3,16);
        assertEquals(3,T1.height());
        assertTrue(T1.insert(15));
        assertEquals(3, T1.height());
        assertTrue(T1.search(7));
        assertTrue(T1.delete(7));
        assertFalse(T1.search(7));
    }
    @Test
    public void test12()
    {
        assertEquals(0, T1.size());
        insertcases(100,1000,2,33333,4,0);
    }
    @Test
    public void test13()
    {
        assertEquals(0, T1.size());
        insertcases(99,5,3,-1);
    }
    @Test
    public void test14()
    {
        assertEquals(0, T1.size());
        insertcases(1,1,1);
        assertEquals(1,T1.size());
        assertEquals(1,T1.height());
    }
    @Test
    public void test15()
    {
        assertEquals(0, T1.size());
        insertcases(10,20,7,5,8);
    }

}

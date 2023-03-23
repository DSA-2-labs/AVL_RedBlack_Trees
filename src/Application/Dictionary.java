package Application;
import Trees.BinarySearchTree;
import Trees.RedBlackTree;
import Trees.AVLTree;
import Application.FileReader.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary <K extends Comparable<K>>{
    private BinarySearchTree<K> tree;
    public Dictionary(String Tree_Type)
    {
        if(Tree_Type.equalsIgnoreCase("AVL"))
        {
            tree = new AVLTree<>();
        }
        else if(Tree_Type.equalsIgnoreCase("RedBlack"))
        {
            tree = new RedBlackTree<>();
        }
    }
    public boolean insert_word(K key)
    {
        return tree.insert(key);
    }
    public boolean delete_word(K key)
    {
        return tree.delete(key);
    }
    public boolean search_word(K key)
    {
        return tree.search(key);
    }
    public long search_multiword(String fname) throws FileNotFoundException
    {
        long startTime=0,endTime=0;
        startTime=System.nanoTime();
        for (Object word:FileReader.loadfile(fname)){
            String x= search_word((K)word) ? "Found" : "Not Found";
            System.out.println(word+" : "+ x);

        }
        endTime=System.nanoTime()-startTime;
        return endTime;
    }
    public long Batch_Insert(String fname) throws FileNotFoundException
    {
        long startTime=0,endTime=0;
        startTime=System.nanoTime();
        for (Object word:FileReader.loadfile(fname)){
            String x= insert_word((K)word) ? "Word inserted successfully!" : "Word already exists!";
            System.out.println((K)word+" : "+ x);
        }
        endTime=System.nanoTime()-startTime;
        return endTime;
    }
    public long Batch_Delete(String fname) throws FileNotFoundException
    {
        long startTime=0,endTime=0;
        startTime=System.nanoTime();
        for (Object word:FileReader.loadfile(fname)){
            String x= delete_word((K)word) ? "Word deleted successfully!" : "Word doesn't exist!";
            System.out.println(word+" : "+ x);

        }
        endTime=System.nanoTime()-startTime;
        return endTime;
    }
    public int DictionarySize()
    {
        return tree.size();
    }
    public int DictHeight()
    {
        return tree.height();
    }
}
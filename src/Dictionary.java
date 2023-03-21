import FileReader.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Dictionary <K>{
    BinarySearchTree tree;
    public Dictionary(String Tree_Type)
    {
        if(Tree_Type.equalsIgnoreCase("AVL"))
        {
            tree = new AVLTree();
        }
        else if(Tree_Type.equalsIgnoreCase("RedBlack"))
        {
            tree = new RedBlackTree();
        }
    }
    public void insert_word(K key)
    {
        if(tree.insert((Comparable) key))
            System.out.println("\""+ key+"\"" + "Added Successfully");
        else
            System.out.println("Error! Already Exist");
    }
    public void delete_word(K key)
    {
        if(tree.delete((Comparable) key))
            System.out.println("\""+ key+"\"" + "Deleted Successfully");
        else
            System.out.println("Error! Such word isn't exist");
    }
    public void search_word(K key)
    {
        if(tree.search((Comparable) key))
            System.out.println("This word is already exist");
        else
            System.out.println("This word isn't exist");
    }
    public void Batch_Insert(String filepath) throws FileNotFoundException
    {
        ArrayList<K> batch= (ArrayList<K>) FileReader.loadfile(filepath);
        int countinserted=0;
        int countnotinserted=0;
        for (K word:batch)
        {
            if(tree.insert((Comparable) word))
                countinserted++;
            else
                countnotinserted++;
        }
        System.out.println("Number Of inserted elements = "+countinserted);
        System.out.println("Number Of already existing elements = "+countnotinserted);
    }
    public void Batch_Delete(String filepath) throws FileNotFoundException
    {
        ArrayList<K> batch= (ArrayList<K>) FileReader.loadfile(filepath);
        int countdeleted=0;
        int countnotdeleted=0;
        for (K word:batch)
        {
            if(tree.insert((Comparable) word))
                countdeleted++;
            else
                countnotdeleted++;
        }
        System.out.println("Number Of deleted elements = "+countdeleted);
        System.out.println("Number Of not existing elements = "+countnotdeleted);
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

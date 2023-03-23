package Application;
import Trees.BinarySearchTree;
import Trees.RedBlackTree;
import Trees.AVLTree;
import Application.FileReader.FileReader;
import java.util.ArrayList;

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
    public ArrayList<Boolean> search_multiword(String fname) throws RuntimeException
    {
        ArrayList<Boolean> result=new ArrayList<>();
        for (Object word:FileReader.loadfile(fname)){
            boolean found = search_word((K)word);
            String x= found ? "Found" : "Not Found";
            System.out.println(word+" : "+ x);
            result.add(found);
        }
        return result;
    }
    public ArrayList<Boolean> Batch_Insert(String fname) throws RuntimeException
    {
        ArrayList<Boolean> result=new ArrayList<>();
        for (Object word:FileReader.loadfile(fname))
        {
            boolean added = insert_word((K)word);
            String x= added ? "Word inserted successfully!" : "Word already exists!";
            System.out.println(word+" : "+ x);
            result.add(added);
        }
        return result;
    }
    public ArrayList<Boolean> Batch_Delete(String fname) throws RuntimeException
    {
        ArrayList<Boolean> result=new ArrayList<>();
        for (Object word:FileReader.loadfile(fname))
        {
            boolean deleted = delete_word((K)word);
            String x= deleted ? "Word deleted successfully!" : "Word doesn't exist!";
            System.out.println(word+" : "+ x);
            result.add(deleted);
        }
        return result;
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
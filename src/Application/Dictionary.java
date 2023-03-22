package Application;
import Trees.BinarySearchTree;
import Trees.RedBlackTree;
import Trees.AVLTree;
import Application.FileReader.FileReader;
import java.io.FileNotFoundException;
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
    public ArrayList<Boolean> search_multiword(String fname) throws FileNotFoundException
    {
        ArrayList<Boolean> result=new ArrayList<>();
        for (Object word:FileReader.loadfile(fname)){
            String x= search_word((K)word) ? "Found" : "Not Found";
            System.out.println(word+" : "+ x);
            result.add(search_word((K)word));
        }
        return result;
    }
    public ArrayList<Boolean> Batch_Insert(String fname) throws FileNotFoundException
    {
        ArrayList<Boolean> result=new ArrayList<>();
        for (Object word:FileReader.loadfile(fname))
        {
            String x= insert_word((K)word) ? "Word inserted successfully!" : "Word already exists!";
            System.out.println(word+" : "+ x);
            result.add(insert_word((K)word));
        }
        return result;
    }
    public ArrayList<Boolean> Batch_Delete(String fname) throws FileNotFoundException
    {
        ArrayList<Boolean> result=new ArrayList<>();
        for (Object word:FileReader.loadfile(fname))
        {
            String x= delete_word((K)word) ? "Word deleted successfully!" : "Word doesn't exist!";
            System.out.println(word+" : "+ x);
            result.add(delete_word((K)word));
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
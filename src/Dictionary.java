public class Dictionary {
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
    public void insert_word(String key)
    {
        if(tree.insert(key))
            System.out.println("\""+ key+"\"" + "Added Successfully");
        else
            System.out.println("Error! Already Exist");
    }
    public void delete_word(String key)
    {
        if(tree.delete(key))
            System.out.println("\""+ key+"\"" + "Deleted Successfully");
        else
            System.out.println("Error! Such word isn't exist");
    }
    public void Batch_Insert(String filepath)
    {

    }
    public void Batch_Delete(String filepath)
    {

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

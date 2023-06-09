package Interface;

import Application.*;
import java.util.Scanner;

public class CLI {
    public void i() {
        Dictionary<String> dictionary = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Dictionary program!");
        System.out.println("Please select an option:");
        System.out.println("1. AVL Tree");
        System.out.println("2. Red Black Tree");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> dictionary = new Dictionary<>("AVL");
            case 2 -> dictionary = new Dictionary<>("RedBlack");
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Invalid choice!");
                i();
            }
        }
        do{
            System.out.println("Please select an option:");
            System.out.println("1. Insert a word");
            System.out.println("2. Delete a word");
            System.out.println("3. Search a word");
            System.out.println("4. Search multiple words");
            System.out.println("5. Batch insert");
            System.out.println("6. Batch delete");
            System.out.println("7. Dictionary size");
            System.out.println("8. Dictionary tree height");
            System.out.println("9. Return to choose tree type");
            System.out.println("10. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter the word:");
                    String word = sc.next();
                    assert dictionary != null;
                    if (dictionary.insert_word(word))
                        System.out.println(word + " : " + "Word inserted successfully!");
                    else
                        System.out.println(word + " : " +"Word already exists!");
                }
                case 2 -> {
                    System.out.println("Please enter the word:");
                    String word = sc.next();
                    assert dictionary != null;
                    if (dictionary.delete_word(word))
                        System.out.println(word + " : " +"Word deleted successfully!");
                    else
                        System.out.println(word + " : " +"Word does not exist!");
                }
                case 3 -> {
                    System.out.println("Please enter the word:");
                    String word = sc.next();
                    assert dictionary != null;
                    if (dictionary.search_word(word))
                        System.out.println(word + " : " +"Word found!");
                    else
                        System.out.println(word + " : " +"Word not found!");
                }
                case 4 -> {
                    System.out.println("Please enter the file name:");
                    String fname = sc.next();
                    assert dictionary != null;
                    try {
                        dictionary.search_multiword(fname);
                    } catch (RuntimeException e) {
                        System.out.println("File not found!");
                    }
                }
                case 5 -> {
                    System.out.println("Please enter the file name:");
                    String fname = sc.next();
                    assert dictionary != null;
                    try {
                        dictionary.Batch_Insert(fname);
                    } catch (RuntimeException e) {
                        System.out.println("File not found!");
                    }
                }
                case 6 -> {
                    System.out.println("Please enter the file name:");
                    String fname = sc.next();
                    assert dictionary != null;
                    try {
                        dictionary.Batch_Delete(fname);
                    } catch (RuntimeException e) {
                        System.out.println("File not found!");
                    }
                }
                case 7 -> {
                    assert dictionary != null;
                    System.out.println("Dictionary size: " + dictionary.DictionarySize());
                }
                case 8 -> {
                    assert dictionary != null;
                    String x = dictionary.DictHeight()==-1?"Dictionary is empty!":"Dictionary tree height: " + dictionary.DictHeight();
                    System.out.println(x);
                }
                case 9 -> i();
                case 10 -> System.exit(0);
                default -> {
                    System.out.println("Invalid choice!");
                }
            }
        }while (true);
    }
}
package FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static ArrayList<Object> loadfile(String fname) throws FileNotFoundException
    {
        File file=new File(fname);
        Scanner sc=new Scanner(file);
        ArrayList<Object> list=new ArrayList<>();
        while (sc.hasNext())
        {
            list.add(sc.nextLine());
        }
        sc.close();
        return list;
    }
}

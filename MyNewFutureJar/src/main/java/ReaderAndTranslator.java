import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderAndTranslator {
    public ArrayList<ArrayList<Integer>> readAndTranslate() {
        File file = new File("C:\\Users\\talll\\Desktop\\HeapSorter\\example.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String c=scanner.next();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        while (scanner.hasNext()) {
            ArrayList <Integer> list = new ArrayList();
            while (!c.equals(".")) {
                if(!c.equals(".")) {
                    list.add(Integer.valueOf(c));
                }
                c = scanner.next();
            }
            if (scanner.hasNext())
                c = scanner.next();
            arrayLists.add(list);
        }
        return arrayLists;
    }
}

package ru.itis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {
    Random random = new Random();
    PrintWriter pw = null;

    public void generate() throws IOException{
        pw = new PrintWriter(new File("C:\\Users\\Justice\\Desktop\\11-702\\HeapSort\\Generate.txt"));
        int countOfArrays = random.nextInt(100) + 50;
        for (int i = 0; i < countOfArrays; i++){
            int sizeOfArrays = random.nextInt(10000) + 100;
            String line = " ";
            for (int j = 0; j < sizeOfArrays; j++){
                int x = random.nextInt(10000) + 100;
                line = line + x + " ";
            }
            pw.print(line);
            pw.print("\n");
        }
        pw.close();
    }
}

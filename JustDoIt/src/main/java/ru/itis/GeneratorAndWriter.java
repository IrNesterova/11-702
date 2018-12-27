package ru.itis;

import java.io.*;
import java.util.Random;

public class GeneratorAndWriter {
    Random random = new Random();
    Writer output = null;

    public void generateAndWrite() throws IOException {
        try {
            File file = new File("example.txt");
            output = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("example.txt"), "utf-8"));
            int k1 = random.nextInt(1)+100;
            int k2=0;
            for (int j = 0; j < k1; j++) {
                k2 = random.nextInt(3900)+6000;
                for (int i = 0; i < k2; i++) {
                    output.append(Integer.valueOf(random.nextInt(10000)).toString() + " ");
                }
                output.append(".");
                output.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}

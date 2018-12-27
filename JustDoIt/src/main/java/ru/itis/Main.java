package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;


import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private String classFolder;

    @Parameter
    public static void run(ArrayList<ArrayList<Integer>> list, HeapSorter heapSorter ) {
        Long startTime;
        Long finishTime;
        for (int j = 0; j < list.size(); j++) {
            Integer[] array = new Integer[list.get(j).size()];
            for (int i = 0; i < list.get(j).size(); i++) {
                array[i] = list.get(j).get(i);
            }
            startTime = System.nanoTime();
            heapSorter.sort(array);
            finishTime = System.nanoTime() - startTime;
            System.out.println(array.length);
            //finishTime + " " + array.length + " " +heapSorter.getCount()
        }
    }

    public void run() throws Exception {
        Files
                .list(Paths.get(classFolder))
                .forEach(file -> {
                    try {
                        URL url = new URL("file://C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\Java\\Classes\\");
                        URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
                        Class aClass = loader.loadClass("User");
                        System.out.println(aClass.getName());
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                });
    }

    public static void main(String[] args) throws IOException {
        HeapSorter heapSorter = new HeapSorter();

        /*Integer arr[] = new Integer[]{3, 4, 2, 0, 1, 5, 7, 9, 4, 7};
            Long startTime = System.nanoTime();
        heapSorter.sort(arr);
            Long finishTime = System.nanoTime() - startTime;
        System.out.println(finishTime + " " + heapSorter.getCount() + " " + arr.length + " ");*/

        GeneratorAndWriter generatorAndWriter = new GeneratorAndWriter();
        //generatorAndWriter.generateAndWrite();

        ReaderAndTranslator readerAndTranslator = new ReaderAndTranslator();
        ArrayList<ArrayList<Integer>> list = readerAndTranslator.readAndTranslate();

        run(list, heapSorter);
        int i = 0;
    }
}

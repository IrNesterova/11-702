package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    @Parameter(names = "-classFolder")
    private String classFolder;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        try {
            main.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void run() throws Exception {
        Files
                .list(Paths.get(classFolder))
                .forEach(file -> {
                    try {
                        URL url = new URL("C:\\Users\\Justice\\Desktop\\11-702\\JCommanderDemo\\target");
                        URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
                        Class aClass = loader.loadClass("User");
                        System.out.println(aClass.getName());
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                });
    }
}

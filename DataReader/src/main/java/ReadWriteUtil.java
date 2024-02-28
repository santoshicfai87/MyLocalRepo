package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class ReadWriteUtil {

    public static void main(String[] args) throws IOException {
        writeInputString(readInputString("input.txt"), "output.txt");
        System.out.println("task completed!");
    }

    public static String readInputString(String inputDataPath) throws IOException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Files.readAllLines(Paths.get(inputDataPath))
                .forEach(stringBuilder::append);
        return stringBuilder.reverse().toString();
    }

    public static Path writeInputString(String input, String outputDataPath) throws IOException {
        return Files.write(Paths.get(outputDataPath), Collections.singletonList(input));
    }
}

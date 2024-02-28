package main.test;

import main.java.ReadWriteUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ReadWriterUtilTest {
    File inputFile, outputFile;
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        inputFile = folder.newFile("input.txt");
        outputFile = folder.newFile("output.txt");
        FileWriter fw1 = new FileWriter(inputFile);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        bw1.write("ABC");
        bw1.close();
    }

    @Test
    public void checkReverseStringData() throws IOException {
        Assert.assertEquals("CBA", Files.readAllLines(ReadWriteUtil.writeInputString(ReadWriteUtil.readInputString(inputFile.getPath()), outputFile.getPath())).get(0));
    }
}

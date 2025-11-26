import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File("src"));
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("Reading file: " + selectedFile.getName());

            try {
                List<String> lines = Files.readAllLines(selectedFile.toPath());

                for (String line : lines) {
                    System.out.println(line);
                    lineCount++;
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                    charCount += line.length();
                }

                System.out.println("\n--- File Summary ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
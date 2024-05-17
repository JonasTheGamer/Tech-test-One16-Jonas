package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        HashSet<String> wordsSet = readWordsFromFile("src/main/resources/input.txt");

        List<String> words = wordsSet.stream().filter(word -> word.length() == 6).toList();
        List<String> wordPartsList = wordsSet.stream().filter(word -> word.length() < 6).toList();
        HashSet<String> wordParts = new HashSet<>(wordPartsList);

        for (String wordPart: wordParts) {
            // Example: foo

            // Loop through all words to see which ones start with foo
            words.stream().filter(word -> word.startsWith(wordPart)).forEach(word -> {
                String partTwo = word.substring(wordPart.length());
                System.out.printf("%s+%s=%s\n", wordPart, partTwo, word);
            });
        }
    }

    // Read words from file and store them in a HashSet
    private static HashSet<String> readWordsFromFile(String fileName) {
        HashSet<String> wordsSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Add the word to the HashSet
                wordsSet.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsSet;
    }
}

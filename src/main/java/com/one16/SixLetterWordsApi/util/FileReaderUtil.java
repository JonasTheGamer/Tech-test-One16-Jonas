package com.one16.SixLetterWordsApi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public class FileReaderUtil {
    public static HashSet<String> readWordsFromFile(String fileName) {
        HashSet<String> wordsSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
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

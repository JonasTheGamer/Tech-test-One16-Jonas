package be.one16.SixLetterWordsApi.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public class FileReaderUtil {
    public static HashSet<String> readWordsFromFile(String fileName) throws IOException {
        HashSet<String> wordsSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Add the word to the HashSet
                wordsSet.add(line);
            }
        }
        return wordsSet;
    }
}

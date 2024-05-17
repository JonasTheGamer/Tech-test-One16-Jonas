package com.one16.SixLetterWordsApi;

import com.one16.SixLetterWordsApi.util.FileReaderUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Main {
    // TODO: Add input file as application parameter
    // TODO: Add maxWordCombinationLength as application parameter
    // TODO: Add wordLength as application parameter

    public static void main(String[] args) {
        HashSet<String> wordsSet;
        String filePath = "src/main/resources/input2.txt";

        // Read the file
        try {
            wordsSet = FileReaderUtil.readWordsFromFile(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            return;
        }

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6, 3);

        // Print them to the console
        matches.forEach(System.out::println);
    }
}

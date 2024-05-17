package com.one16.SixLetterWordsApi;

import com.one16.SixLetterWordsApi.util.FileReaderUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashSet<String> wordsSet;
        String filePath = "src/main/resources/input.txt";

        // Read the file
        try {
            wordsSet = FileReaderUtil.readWordsFromFile(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            return;
        }

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6);

        // Print them to the console
        matches.forEach(System.out::println);
    }
}

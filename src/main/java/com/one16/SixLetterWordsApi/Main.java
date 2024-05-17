package com.one16.SixLetterWordsApi;

import com.one16.SixLetterWordsApi.util.FileReaderUtil;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashSet<String> wordsSet = FileReaderUtil.readWordsFromFile("src/main/resources/input.txt");

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
}

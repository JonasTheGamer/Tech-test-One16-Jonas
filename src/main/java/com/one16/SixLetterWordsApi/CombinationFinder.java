package com.one16.SixLetterWordsApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationFinder {
    public static List<String> findWordMatches(HashSet<String> wordsSet, int wordLength) {
        List<String> matches = new ArrayList<>();

        // Get the words that we obtain by combining multiple words
        List<String> words = wordsSet.stream().filter(word -> word.length() == wordLength).toList();

        // Get the parts of words that we can combine to form a word
        List<String> wordPartsList = wordsSet.stream().filter(word -> word.length() < wordLength).toList();

        // Convert the list of word parts to a HashSet for faster lookups
        HashSet<String> wordParts = new HashSet<>(wordPartsList);

        for (String wordPart : wordParts) {
            // Example: foo
            // Loop through all words to see which ones start with foo
            words.stream().filter(word -> word.startsWith(wordPart)).forEach(word -> {
                // Example: foo+bar=foobar
                String partTwo = word.substring(wordPart.length());
                matches.add(String.format("%s+%s=%s", wordPart, partTwo, word));
            });
        }

        return matches;
    }
}

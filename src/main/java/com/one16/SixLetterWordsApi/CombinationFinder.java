package com.one16.SixLetterWordsApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationFinder {
    // TODO: Keep maxWordCombinationLength into account
    // TODO: Remove strange comments
    public static List<String> findWordMatches(HashSet<String> wordsSet, int wordLength, int maxWordCombinationLength) {
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

                // Check if the second part of the word is in the wordParts set
                if (wordParts.contains(partTwo)) {
                    matches.add(String.format("%s+%s=%s", wordPart, partTwo, word));
                } else {

                    for(String wordPart2: wordParts) {
                        String partOneAndTwo = wordPart + wordPart2;
                        words.stream().filter(word2 -> word2.startsWith(partOneAndTwo)).forEach(word2 -> {
                            String partThree = word2.substring(partOneAndTwo.length());
                            if(wordParts.contains(partThree)) {
                                matches.add(String.format("%s+%s+%s=%s", wordPart, wordPart2, partThree, word));
                            }
                        });
                    }
                }
            });
        }

        return matches;
    }
}

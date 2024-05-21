package com.one16.SixLetterWordsApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationFinder {

    public static List<String> findWordMatches(HashSet<String> wordsSet, int wordLength, int maxWordCombinationLength) {
        List<String> matches = new ArrayList<>();
        List<String> words = wordsSet.stream().filter(word -> word.length() == wordLength).toList();
        List<String> wordPartsList = wordsSet.stream().filter(word -> word.length() < wordLength).toList();
        HashSet<String> wordParts = new HashSet<>(wordPartsList);

        for (String wordPart : wordParts) {
            findMatchesRecursive(wordPart, words, wordParts, new ArrayList<>(), matches, maxWordCombinationLength, wordLength);
        }

        return matches;
    }

    private static void findMatchesRecursive(String currentPart, List<String> words, HashSet<String> wordParts, List<String> currentCombination, List<String> matches, int maxWordCombinationLength, int targetLength) {
        currentCombination.add(currentPart);

        // Make sure that the loop no longer runs when the combination would be too long
        if(currentCombination.size() == maxWordCombinationLength) {
            return;
        }

        // Loop through the words to see if any of them match the currentPart
        for (String word : words) {
            if (word.startsWith(currentPart)) {
                String remainingPart = word.substring(currentPart.length());

                // If the currentPart is the word itself, match!
                if (remainingPart.isEmpty() && currentPart.length() == targetLength) {
                    matches.add(String.join("+", currentCombination) + "=" + word);
                }
                // If the remaining part itself is in the wordParts, match!
                // For example: currentPart is foo & remainingPart is bar, and foobar is in the wordParts
                else if (wordParts.contains(remainingPart)) {
                    List<String> newCombination = new ArrayList<>(currentCombination);
                    newCombination.add(remainingPart);
                    matches.add(String.join("+", newCombination) + "=" + word);
                }
                // Otherwise, continue the search
                else {
                    for (String nextPart : wordParts) {
                        String newPart = currentPart + nextPart;
                        findMatchesRecursive(newPart, words, wordParts, new ArrayList<>(currentCombination), matches, maxWordCombinationLength, targetLength);
                    }
                }
            }
        }

        currentCombination.remove(currentCombination.size() - 1);
    }
}

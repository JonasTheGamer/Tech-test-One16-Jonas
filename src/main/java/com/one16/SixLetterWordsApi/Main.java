package com.one16.SixLetterWordsApi;

import com.one16.SixLetterWordsApi.util.FileReaderUtil;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashSet<String> wordsSet = FileReaderUtil.readWordsFromFile("src/main/resources/input.txt");

        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6);
        matches.forEach(System.out::println);
    }
}

package be.one16.SixLetterWordsApi;

import be.one16.SixLetterWordsApi.util.FileReaderUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<String> wordsSet;
        String filePath = Config.inputFilePath;

        // Read the file
        try {
            wordsSet = FileReaderUtil.readWordsFromFile(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            return;
        }

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, Config.wordLength, Config.maxWordCombinationLength);

        // Print them to the console
        matches.forEach(System.out::println);

        // Wait for user input before closing the application
        System.out.println("Press Enter to exit...");
        scanner.nextLine();
        scanner.close();
    }
}

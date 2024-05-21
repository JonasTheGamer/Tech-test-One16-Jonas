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
        String filePath;
        int wordLength;
        int maxWordCombinationLength;

        // Check if any arguments were provided
        if (args.length > 0) {
            if(args.length != 3) {
                System.out.println("Invalid number of arguments. Please provide the input file path, the word length, and the maximum word combination length.");
                System.out.println("Valid usage: java -jar SixLetterWordsApi.jar <inputFilePath> <wordLength> <maxWordCombinationLength>");
                return;
            }

            try {
                filePath = args[0];
                wordLength = Integer.parseInt(args[1]);
                maxWordCombinationLength = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid arguments provided. Please provide the input file path, the word length, and the maximum word combination length.");
                System.out.println("Valid usage: java -jar SixLetterWordsApi.jar <inputFilePath> <wordLength> <maxWordCombinationLength>");
                return;
            }
        } else {
            System.out.println("No arguments provided. Attempting to use default configuration. (Not recommended unless in development)");
            System.out.println("Valid usage: java -jar SixLetterWordsApi.jar <inputFilePath> <wordLength> <maxWordCombinationLength>");

            filePath = DefaultConfig.inputFilePath;
            wordLength = DefaultConfig.wordLength;
            maxWordCombinationLength = DefaultConfig.maxWordCombinationLength;
        }

        // Read the file
        try {
            wordsSet = FileReaderUtil.readWordsFromFile(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            return;
        }

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, wordLength, maxWordCombinationLength);

        // Print them to the console
        matches.forEach(System.out::println);

        // Wait for user input before closing the application
        System.out.println("Press Enter to exit...");
        scanner.nextLine();
        scanner.close();
    }
}

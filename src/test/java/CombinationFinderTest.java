import com.one16.SixLetterWordsApi.CombinationFinder;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationFinderTest {
    @Test
    void findMatchesShouldReturnCorrectMatches() {
        // Create a HashSet with sample words
        HashSet<String> wordsSet = new HashSet<>();
        wordsSet.add("fo");
        wordsSet.add("obar");
        wordsSet.add("foo");
        wordsSet.add("bar");
        wordsSet.add("foobar");

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6, 2);

        // Check if the matches are correct
        assertEquals(2, matches.size());
        assertEquals("foo+bar=foobar", matches.get(0));
        assertEquals("fo+obar=foobar", matches.get(1));
    }

    @Test
    void findMatchesWithoutWordsShouldReturnEmptyMatches() {
        // Create an empty HashSet
        HashSet<String> wordsSet = new HashSet<>();

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6, 2);

        // Check if the matches are correct
        assertEquals(0, matches.size());
    }

    @Test
    void findMatchesShouldRespectMaxMatchCombinationLength0() {
        // Create a HashSet with sample words
        HashSet<String> wordsSet = new HashSet<>();
        wordsSet.add("fo");
        wordsSet.add("foo");
        wordsSet.add("ob");
        wordsSet.add("ar");
        wordsSet.add("bar");
        wordsSet.add("foobar");

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6, 2);

        // Check if the matches are correct
        assertEquals(1, matches.size());
        assertEquals("foo+bar=foobar", matches.get(0));
    }

    @Test
    void findMatchesShouldRespectMaxMatchCombinationLength1() {
        // Create a HashSet with sample words
        HashSet<String> wordsSet = new HashSet<>();
        wordsSet.add("fo");
        wordsSet.add("ob");
        wordsSet.add("ar");
        wordsSet.add("foobar");

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6, 2);

        // Check if the matches are correct
        assertEquals(0, matches.size());
    }

    @Test
    void findMatchesShouldRespectMaxMatchCombinationLength2() {
        // Create a HashSet with sample words
        HashSet<String> wordsSet = new HashSet<>();
        wordsSet.add("fo");
        wordsSet.add("ob");
        wordsSet.add("ar");
        wordsSet.add("foobar");

        // Get the matches
        List<String> matches = CombinationFinder.findWordMatches(wordsSet, 6, 3);

        // Check if the matches are correct
        assertEquals(1, matches.size());
        assertEquals("fo+ob+ar=foobar", matches.get(0));
    }
}

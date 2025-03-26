import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    // Constructor
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all words with the maximum length in the order they appear in 'sentence'.
     * Handles varying amounts of whitespace and returns an empty list if there are no words.
     */
    public List<String> findLongestWords() {
        // If the input is null or trimmed empty, return an empty list immediately.
        if (sentence == null || sentence.trim().isEmpty()) {
            return Collections.emptyList();
        }

        // Split the sentence by one or more whitespace characters.
        String[] tokens = sentence.split("\\s+");
        
        // Prepare a list to store longest words found so far.
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        for (String token : tokens) {
            // Remove punctuation just in case (e.g. commas, exclamation marks, etc.).
            // If you're certain there's no punctuation, you could skip this step.
            String cleanWord = token.replaceAll("[^a-zA-Z0-9]", "");

            // Track the length of the cleaned word.
            int wordLength = cleanWord.length();

            // If there's a new maximum length, clear the list and update maxLength.
            if (wordLength > maxLength) {
                maxLength = wordLength;
                longestWords.clear();
                longestWords.add(cleanWord);
            } 
            // If this word matches the current maximum length, add it to the list as well.
            else if (wordLength == maxLength && wordLength != 0) {
                longestWords.add(cleanWord);
            }
        }

        return longestWords;
    }
}


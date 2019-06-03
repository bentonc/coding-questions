package org.bentonc.codingquestions.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 *
 * Given a string, find its first non-repeating character.
 *
 * Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”, 
 * then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’. 
 */
public class GetFirstNonRepeatingCharacter {
    static final int NO_OF_CHARS = 256;

    public class BruteForceSolution {
        private int characterCounts[] = new int[NO_OF_CHARS];

        // Calculate count of characters in the passed string.
        private void calculateCharacterCounts(String str)
        {
            for (int i = 0; i < str.length(); i++) {
                characterCounts[str.charAt(i)]++;
            }
        }

        // The method returns index of first non-repeating character in a string. If all characters are repeating then
        // returns -1.
        public int firstNonRepeating(String str)
        {
            calculateCharacterCounts(str);
            int index = -1, i;

            for (i = 0; i < str.length();  i++) {
                if (characterCounts[str.charAt(i)] == 1) {
                    index = i;
                    break;
                }
            }

            return index;
        }
    }

    class CountIndex
    {
        int count;
        int index;

        // Constructor for first occurrence.
        CountIndex(int index) {
            this.count = 1;
            this.index = index;
        }

        // Method for updating count.
        void increment() {
            this.count++;
        }
    }

    public class EfficientSolution {
        private HashMap<Character, CountIndex> countIndexByCharacter = new HashMap<>(NO_OF_CHARS);

        // Calculate count of characters in the passed string.
        private void calculateCharacterCounts(String str)
        {
            for (int i = 0; i < str.length();  i++) {
                // If character already occurred.
                if(countIndexByCharacter.containsKey(str.charAt(i))) {
                    // Update the count.
                    countIndexByCharacter.get(str.charAt(i)).increment();
                }
                // Else if it's the first occurrence, then store the index and count = 1.
                else {
                    countIndexByCharacter.put(str.charAt(i), new CountIndex(i));
                }
            }
        }

        // The method returns index of first non-repeating character in a string. If all characters are repeating then
        // returns -1.
        public int firstNonRepeating(String str)
        {
            calculateCharacterCounts(str);
            int result = Integer.MAX_VALUE;

            List<CountIndex> characterCounts = new ArrayList<>(countIndexByCharacter.values());

            for (int i = 0; i < characterCounts.size(); i++) {
                // If this character occurs only once and appears before the current result, then update the result.
                if ((characterCounts.get(i).count == 1) && (characterCounts.get(i).index < result)) {
                    result = characterCounts.get(i).index;
                }
            }

            return result;
        }
    }
}

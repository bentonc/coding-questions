package org.bentonc.codingquestions.geeksforgeeks;

import groovy.util.logging.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * https://leetcode.com/problems/minimum-window-substring/
 */
@Log4j2
public class MinimumWindowSubstring {

    static final int CHARACTER_COUNT = 256;
    private final Logger logger = LogManager.getLogger(MinimumWindowSubstring.class);

    String findSubstring(final String s, final String t)
    {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Check if string's length is less than pattern's length. If yes, then no such window can exist.
        if (s.length() < t.length())
        {
            logger.info("No such window exists.");
            return "";
        }

        int expected[] = new int[CHARACTER_COUNT];
        int actual[] = new int[CHARACTER_COUNT];

        // Store occurrence of characters of pattern.
        for (int i = 0; i < t.length(); i++) {
            expected[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int minWindowPos = -1;
        int minWindowLength = Integer.MAX_VALUE;

        // Start traversing the string.
        int count = 0; // count of characters
        while(right < s.length()) {
            char charAtRight = s.charAt(right);

            // Count occurrence of characters of string.
            actual[charAtRight]++;

            // If string's char matches with pattern's char then increment count.
            if ((expected[charAtRight] != 0) && (actual[charAtRight] <= expected[charAtRight])) {
                count++;
            }

            // If all the characters are matched.
            if (count == t.length()) {
                char charAtLeft = s.charAt(left);

                logger.debug("window: {}", s.substring(left, right + 1));

                // Try to minimize the window i.e., check if any character is occurring more times than its occurrence
                // in the pattern. If yes, then remove it from starting and also remove the useless characters.
                while ((actual[charAtLeft] > expected[charAtLeft]) || expected[charAtLeft] == 0) {
                    if (actual[charAtLeft] > expected[charAtLeft]) {
                        actual[charAtLeft]--;
                    }

                    logger.debug(
                            "actual[{}]: {}, expected[{}]: {}",
                            charAtLeft, actual[charAtLeft], charAtLeft, expected[charAtLeft]);

                    left++;
                    charAtLeft = s.charAt(left);

                    logger.debug("window: {}", s.substring(left, right + 1));
                }

                // Update window size.
                int windowLength = (right - left) + 1;
                if (minWindowLength > windowLength) {
                    minWindowLength = windowLength;
                    minWindowPos = left;
                }
            }

            right++;
        }

        // If no window found.
        if (minWindowPos == -1) {
            logger.info("No such window exists");
            return "";
        }

        // Return substring starting from minWindowPos and length minLength.
        return s.substring(minWindowPos, minWindowPos + minWindowLength);
    }
}

package org.bentonc.codingquestions.geeksforgeeks;

/**
 * https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
 *
 * A Program to check if strings are rotations of each other or not
 *
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1? (eg given s1 = ABCD and
 * s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
public class StringsAreRotations {
    // Function checks if passed strings (str1 and str2) are rotations of each other.
    static boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be a substring of str1 concatenated with str1.
        return (
                (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1)
        );
    }
}

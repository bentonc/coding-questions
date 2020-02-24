package org.bentonc.codingquestions.geeksforgeeks

class MinimumWindowSubstringTest extends GroovyTestCase {
    MinimumWindowSubstring unit = new MinimumWindowSubstring();

    void testFindSubstring() {
        assertEquals("ACB", unit.findSubstring("ABAACBAB", "ABC"));
        assertEquals("t stri", unit.findSubstring("this is a test string","tist"));
    }
}

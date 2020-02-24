package org.bentonc.codingquestions.geeksforgeeks

class MinimumWindowSubstringTest extends GroovyTestCase {
    MinimumWindowSubstring unit

    void setUp() {
        super.setUp()
        unit = new MinimumWindowSubstring();
    }

    void testFindSubstring() {
        assertEquals("ACB", unit.findSubstring("ABAACBAB", "ABC"));
        assertEquals("t stri", unit.findSubstring("this is a test string","tist"));
    }
}

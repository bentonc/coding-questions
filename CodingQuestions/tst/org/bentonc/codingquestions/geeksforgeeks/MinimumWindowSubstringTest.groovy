package org.bentonc.codingquestions.geeksforgeeks

class MinimumWindowSubstringTest extends GroovyTestCase {
    MinimumWindowSubstring testClass

    void setUp() {
        super.setUp()
        testClass = new MinimumWindowSubstring();
    }

    void testFindSubstring() {
        assertEquals("ACB", testClass.findSubstring("ABAACBAB", "ABC"));
        assertEquals("t stri", testClass.findSubstring("this is a test string","tist"));
    }
}

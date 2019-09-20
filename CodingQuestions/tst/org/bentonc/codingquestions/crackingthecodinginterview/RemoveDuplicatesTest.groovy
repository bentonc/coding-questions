package org.bentonc.codingquestions.crackingthecodinginterview

class RemoveDuplicatesTest extends GroovyTestCase {

    RemoveDuplicates testClass

    void setUp() {
        super.setUp()
        testClass = new RemoveDuplicates()
    }

    void testRemoveDuplicates() {
        def str = 'abbbbcadabaefdegaf'
        assertEquals('abcdefg', testClass.removeDuplicates(str))
    }
}

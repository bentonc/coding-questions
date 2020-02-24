package org.bentonc.codingquestions.crackingthecodinginterview

class RemoveDuplicatesTest extends GroovyTestCase {

    RemoveDuplicates unit

    void setUp() {
        super.setUp()
        unit = new RemoveDuplicates()
    }

    void testRemoveDuplicates() {
        def str = 'abbbbcadabaefdegaf'
        assertEquals('abcdefg', unit.removeDuplicates(str))
    }
}

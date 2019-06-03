package org.bentonc.codingquestions.crackingthecodinginterview

class RemoveDuplicatesTest extends GroovyTestCase {

    RemoveDuplicates instance

    void setUp() {
        instance = new RemoveDuplicates()
    }

    void testRemoveDuplicates() {
        def str = 'abbbbcadabaefdegaf'

        assertEquals('abcdefg', instance.removeDuplicates(str))
    }
}

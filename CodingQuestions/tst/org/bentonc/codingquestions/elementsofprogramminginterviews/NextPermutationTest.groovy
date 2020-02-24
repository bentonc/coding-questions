package org.bentonc.codingquestions.elementsofprogramminginterviews

class NextPermutationTest extends GroovyTestCase {
    NextPermutation unit

    void setUp() {
        super.setUp()
        unit = new NextPermutation();
    }

    void testNextPermutation() {
        def perm = [6, 2, 1, 5, 4, 3, 0]
        def result = unit.nextPermutation(perm)

        assertEquals([6, 2, 3, 0, 1, 4, 5], result)
    }
}

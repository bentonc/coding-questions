package org.bentonc.codingquestions.elementsofprogramminginterviews

class EvenOddTest extends GroovyTestCase {

    EvenOdd unit

    void setUp() {
        super.setUp()
        unit = new EvenOdd()
    }

    void testEvenOdd() {
        def arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        unit.evenOdd(arr)

        assertEquals([10, 2, 8, 4, 6, 7, 5, 9, 3, 1], arr)
    }
}

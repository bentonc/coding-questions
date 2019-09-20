package org.bentonc.codingquestions.elementsofprogramminginterviews

class EvenOddTest extends GroovyTestCase {

    EvenOdd testClass

    void setUp() {
        super.setUp()
        testClass = new EvenOdd()
    }

    void testEvenOdd() {
        def arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        testClass.evenOdd(arr)

        assertEquals([10, 2, 8, 4, 6, 7, 5, 9, 3, 1], arr)
    }
}

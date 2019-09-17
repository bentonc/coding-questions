package org.bentonc.codingquestions.geeksforgeeks

class SortByFrequencyTest extends GroovyTestCase {

    SortByFrequency testClass

    void setUp() {
        super.setUp()
        testClass = new SortByFrequency()
    }

    void testBySorting() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        testClass.bySorting(integers)
    }

    void testByMap() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        testClass.byMap(integers);
    }

    void testByBst() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        testClass.byBst(integers);
    }
}

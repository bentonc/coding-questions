package org.bentonc.codingquestions.geeksforgeeks

class SortByFrequencyTest extends GroovyTestCase {

    SortByFrequency instance

    void setUp() {
        instance = new SortByFrequency()
    }

    void testBySorting() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        instance.bySorting(integers)
    }

    void testByMap() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        instance.byMap(integers);
    }

    void testByBst() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        instance.byBst(integers);
    }
}

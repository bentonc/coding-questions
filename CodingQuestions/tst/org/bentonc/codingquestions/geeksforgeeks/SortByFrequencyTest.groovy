package org.bentonc.codingquestions.geeksforgeeks

class SortByFrequencyTest extends GroovyTestCase {

    SortByFrequency unit = new SortByFrequency()

    void testBySorting() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        unit.bySorting(integers)
    }

    void testByMap() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        unit.byMap(integers);
    }

    void testByBst() {
        def integers = [ 5, 2, 2, 8, 5, 6, 8, 8 ]

        unit.byBst(integers);
    }
}

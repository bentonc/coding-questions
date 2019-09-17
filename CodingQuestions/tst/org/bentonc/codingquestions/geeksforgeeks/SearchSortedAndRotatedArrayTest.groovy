package org.bentonc.codingquestions.geeksforgeeks

class SearchSortedAndRotatedArrayTest extends GroovyTestCase {

    SearchSortedAndRotatedArray testClass

    void setUp() {
        super.setUp()
        testClass = new SearchSortedAndRotatedArray()
    }

    void testPivotedBinarySearch() {
        def array = [ 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 ]

        def result = testClass.pivotedBinarySearch(array, array.size(), 2)
        // println('Index of the element is: ' + result)

        assertEquals(6, result)
    }
}

package org.bentonc.codingquestions.geeksforgeeks

class SearchSortedAndRotatedArrayTest extends GroovyTestCase {

    SearchSortedAndRotatedArray instance

    void setUp() {
        instance = new SearchSortedAndRotatedArray()
    }

    void testPivotedBinarySearch() {
        def array = [ 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 ]

        def result = instance.pivotedBinarySearch(array, array.size(), 2)
        // println('Index of the element is: ' + result)

        assertEquals(6, result)
    }
}

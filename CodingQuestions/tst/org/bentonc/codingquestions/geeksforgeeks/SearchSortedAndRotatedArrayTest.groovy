package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class SearchSortedAndRotatedArrayTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(SearchSortedAndRotatedArrayTest.class)
    SearchSortedAndRotatedArray unit = new SearchSortedAndRotatedArray()

    void testPivotedBinarySearchRecursive() {
        def array = [ 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 ]

        def result = unit.pivotedBinarySearchRecursive(array, 2)
        logger.debug('Index of the element is: {}', result)

        assertEquals(6, result)
    }

    void testPivotedBinarySearchIterative() {
        def array = [ 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 ]

        def result = unit.pivotedBinarySearchIterative(array, 2)
        logger.debug('Index of the element is: {}', result)

        assertEquals(6, result)
    }

    void testSortedBinarySearch() {
        def array = [ 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 ]

        def result = unit.sortedBinarySearch(array, 0, array.size() - 1, 2)
        logger.debug('Index of the element is: {}', result)

        assertEquals(6, result)
    }
}

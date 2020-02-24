package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class AlternatePositiveAndNegativeNumbersTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(AlternatePositiveAndNegativeNumbersTest.class)
    AlternatePositiveAndNegativeNumbers unit

    void setUp() {
        super.setUp()
        unit = new AlternatePositiveAndNegativeNumbers()
    }

    void testRearrange() {
        def arr = [ -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 ] as int[]
        def n = arr.length

        logger.debug('Given array is: {}', arr)

        unit.rearrange(arr, n)

        logger.debug('Rearranged array is: {}', arr)

        def expected = [ -5, 5, -2, 2, -8, 4, 7, 1, 8, 0 ] as int[]
        assertEquals(expected, arr)
    }
}

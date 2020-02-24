package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class GetSubarraysEqualToKTest extends groovy.util.GroovyTestCase {

    Logger logger = LogManager.getLogger(GetSubarraysEqualToKTest.class)
    GetSubarraysEqualToK unit = new GetSubarraysEqualToK()

    void testBruteForce() {
        def array = [ 10, 2, -2, -20, 10 ]
        def k = -10

        def result = unit.bruteForce(array, k)

        // result:3
        logger.debug('result: {}', result)

        assertEquals(3, result)
    }

    void testEfficient() {
        def array = [ 10, 2, -2, -20, 10 ]
        def k = -10

        def result = unit.efficient(array, k)

        // result:3
        logger.debug('result: {}', result)

        assertEquals(3, result)
    }
}

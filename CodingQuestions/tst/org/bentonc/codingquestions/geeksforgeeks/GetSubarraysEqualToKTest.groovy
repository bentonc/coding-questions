package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class GetSubarraysEqualToKTest extends groovy.util.GroovyTestCase {

    Logger logger = LogManager.getLogger(GetSubarraysEqualToKTest.class)
    GetSubarraysEqualToK testClass

    void setUp() {
        super.setUp()
        testClass = new GetSubarraysEqualToK()
    }

    void testBruteForce() {
        def array = [ 10, 2, -2, -20, 10 ]
        def k = -10

        def result = testClass.bruteForce(array, k)

        // result:3
        logger.debug('result: {}', result)

        assertEquals(3, result)
    }

    void testEfficient() {
        def array = [ 10, 2, -2, -20, 10 ]
        def k = -10

        def result = testClass.efficient(array, k)

        // result:3
        logger.debug('result: {}', result)

        assertEquals(3, result)
    }
}

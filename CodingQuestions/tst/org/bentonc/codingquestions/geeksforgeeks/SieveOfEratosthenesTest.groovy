package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class SieveOfEratosthenesTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(SieveOfEratosthenesTest)
    SieveOfEratosthenes unit = new SieveOfEratosthenes()

    void testGetPrimes() {
        def expected = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]

        assertEquals(expected, unit.getPrimes(50))
    }
}

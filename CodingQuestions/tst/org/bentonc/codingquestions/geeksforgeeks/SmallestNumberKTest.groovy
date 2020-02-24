package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class SmallestNumberKTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(SmallestNumberKTest.class)
    SmallestNumberK unit

    void setUp() {
        super.setUp()
        unit = new SmallestNumberK()
    }

    void testCalculate() {
        def result = unit.calculate(100)

        // result:455
        logger.debug('result: {}', result)

        assertEquals(455, result)
    }
}

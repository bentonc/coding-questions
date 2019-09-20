package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class SmallestNumberKTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(SmallestNumberKTest.class)
    SmallestNumberK testClass

    void setUp() {
        super.setUp()
        testClass = new SmallestNumberK()
    }

    void testCalculate() {
        def result = testClass.calculate(100)

        // result:455
        logger.debug('result: {}', result)

        assertEquals(455, result)
    }
}

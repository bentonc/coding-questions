package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.apache.tools.ant.taskdefs.Get

class GetExpressionsTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(GetExpressionsTest.class)
    GetExpressions testClass

    void setUp() {
        super.setUp()
        testClass = new GetExpressions()
    }

    void testRecursive1() {
        def result = []
        testClass.recursive(6, '123', 0, '', 0, 0, result)

        // result: [1+2+3, 1*2*3]
        logger.debug('result: {}', result)

        assertEquals(['1+2+3', '1*2*3'], result)
    }

    void testRecursive2() {
        def result = []
        testClass.recursive(7, '125', 0, '', 0, 0, result)

        // result: [1*2+5, 12-5]
        logger.debug('result: {}', result)

        assertEquals(['1*2+5', '12-5'], result)
    }
}

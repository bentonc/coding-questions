package org.bentonc.codingquestions.geeksforgeeks

class GetExpressionsTest extends GroovyTestCase {

    GetExpressions testClass

    void setUp() {
        super.setUp()
        testClass = new GetExpressions()
    }

    void testRecursive1() {
        def result = []
        testClass.recursive(6, '123', 0, '', 0, 0, result)

        // result: [1+2+3, 1*2*3]
        // println('result: ' + result)

        assertEquals(['1+2+3', '1*2*3'], result)
    }

    void testRecursive2() {
        def result = []
        testClass.recursive(7, '125', 0, '', 0, 0, result)

        // result: [1*2+5, 12-5]
        // println('result: ' + result)

        assertEquals(['1*2+5', '12-5'], result)
    }
}

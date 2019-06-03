package org.bentonc.codingquestions.geeksforgeeks

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName

class GetExpressionsTest extends GroovyTestCase {

    GetExpressions instance


    void setUp() {
        instance = new GetExpressions()
    }

    void testRecursive1() {
        def result = []
        instance.recursive(6, '123', 0, '', 0, 0, result)

        // result: [1+2+3, 1*2*3]
        // println('result: ' + result)

        assertEquals(['1+2+3', '1*2*3'], result)
    }

    void testRecursive2() {
        def result = []
        instance.recursive(7, '125', 0, '', 0, 0, result)

        // result: [1*2+5, 12-5]
        // println('result: ' + result)

        assertEquals(['1*2+5', '12-5'], result)
    }
}

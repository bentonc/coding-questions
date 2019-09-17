package org.bentonc.codingquestions.geeksforgeeks

class SmallestNumberKTest extends GroovyTestCase {

    SmallestNumberK testClass

    void setUp() {
        super.setUp()
        testClass = new SmallestNumberK()
    }

    void testCalculate() {
        def result = testClass.calculate(100)

        // result:455
        // println('result: ' + result)

        assertEquals(455, result)
    }
}

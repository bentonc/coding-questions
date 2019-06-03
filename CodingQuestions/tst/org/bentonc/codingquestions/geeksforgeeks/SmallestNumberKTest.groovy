package org.bentonc.codingquestions.geeksforgeeks

class SmallestNumberKTest extends GroovyTestCase {

    SmallestNumberK instance

    void setUp() {
        instance = new SmallestNumberK()
    }

    void testCalculate() {
        def result = instance.calculate(100)

        // result:455
        // println('result: ' + result)

        assertEquals(455, result)
    }
}

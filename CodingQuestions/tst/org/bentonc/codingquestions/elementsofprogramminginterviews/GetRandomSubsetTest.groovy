package org.bentonc.codingquestions.elementsofprogramminginterviews

class GetRandomSubsetTest extends GroovyTestCase {
    GetRandomSubset testClass

    void setUp() {
        super.setUp()
        testClass = new GetRandomSubset()
    }

    void testRandomSampling() {
        def result = testClass.randomSampling(3, [3, 7, 5, 11])
    }
}

package org.bentonc.codingquestions.elementsofprogramminginterviews

class GetRandomSubsetTest extends GroovyTestCase {
    GetRandomSubset unit

    void setUp() {
        super.setUp()
        unit = new GetRandomSubset()
    }

    void testRandomSampling() {
        def result = unit.randomSampling(3, [3, 7, 5, 11])
    }
}

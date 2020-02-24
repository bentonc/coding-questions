package org.bentonc.codingquestions.elementsofprogramminginterviews

class GetRandomSubsetTest extends GroovyTestCase {
    GetRandomSubset unit = new GetRandomSubset()

    void testRandomSampling() {
        def result = unit.randomSampling(3, [3, 7, 5, 11])
    }
}

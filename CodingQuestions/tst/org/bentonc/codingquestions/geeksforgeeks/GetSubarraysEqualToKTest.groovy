package org.bentonc.codingquestions.geeksforgeeks

class GetSubarraysEqualToKTest extends groovy.util.GroovyTestCase {

    GetSubarraysEqualToK instance

    void setUp() {
       instance = new GetSubarraysEqualToK()
    }

    void testBruteForce() {
        def array = [ 10, 2, -2, -20, 10 ]
        def k = -10

        def result = instance.bruteForce(array, k)

        // result:3
        // println('result: ' + result)
        // println()

        assertEquals(3, result)
    }

    void testEfficient() {
        def array = [ 10, 2, -2, -20, 10 ]
        def k = -10

        def result = instance.efficient(array, k)

        // result:3
        // println('result: ' + result)
        // println()

        assertEquals(3, result)
    }
}

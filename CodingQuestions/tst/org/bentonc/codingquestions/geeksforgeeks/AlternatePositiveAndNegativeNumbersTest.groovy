package org.bentonc.codingquestions.geeksforgeeks

class AlternatePositiveAndNegativeNumbersTest extends GroovyTestCase {

    AlternatePositiveAndNegativeNumbers instance

    void setUp() {
        instance = new AlternatePositiveAndNegativeNumbers()
    }

    void testRearrange() {
        def arr = [ -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 ] as int[]
        def n = arr.length

        // println('Given array is: ')
        // instance.printArray(arr, n)

        instance.rearrange(arr, n)

        // println('Rearranged array is: ')
        // instance.printArray(arr, n)

        def expected = [ -5, 5, -2, 2, -8, 4, 7, 1, 8, 0 ] as int[]
        assertEquals(expected, arr)
    }
}

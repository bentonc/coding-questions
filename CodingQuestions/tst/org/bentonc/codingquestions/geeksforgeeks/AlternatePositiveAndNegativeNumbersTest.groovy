package org.bentonc.codingquestions.geeksforgeeks

class AlternatePositiveAndNegativeNumbersTest extends GroovyTestCase {

    AlternatePositiveAndNegativeNumbers testClass

    void setUp() {
        super.setUp()
        testClass = new AlternatePositiveAndNegativeNumbers()
    }

    // A utility function to print an array 'arr[]' of size 'n'.
    void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ' ')
        }

        System.out.println();
    }

    void testRearrange() {
        def arr = [ -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 ] as int[]
        def n = arr.length

        // println('Given array is: ')
        // printArray(arr, n)

        testClass.rearrange(arr, n)

        // println('Rearranged array is: ')
        // printArray(arr, n)

        def expected = [ -5, 5, -2, 2, -8, 4, 7, 1, 8, 0 ] as int[]
        assertEquals(expected, arr)
    }
}

package org.bentonc.codingquestions.geeksforgeeks

class NumberOfIslandsTest extends GroovyTestCase {

    NumberOfIslands testClass

    void setUp() {
        super.setUp()
        testClass = new NumberOfIslands()
    }

    void testCountIslands() {
        def matrix = [
                [ 1, 1, 0, 0, 0 ] as int[],
                [ 0, 1, 0, 0, 1 ] as int[],
                [ 1, 0, 0, 1, 1 ] as int[],
                [ 0, 0, 0, 0, 0 ] as int[],
                [ 1, 0, 1, 0, 1 ] as int[]
        ] as int[][]

        // println('Number of islands is: ' + testClass.countIslands(matrix))

        assertEquals(5, testClass.countIslands(matrix))
    }
}

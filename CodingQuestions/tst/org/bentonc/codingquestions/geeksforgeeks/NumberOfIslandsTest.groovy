package org.bentonc.codingquestions.geeksforgeeks

class NumberOfIslandsTest extends GroovyTestCase {

    NumberOfIslands instance

    void setUp() {
        instance = new NumberOfIslands()
    }

    void testCountIslands() {
        def matrix = [
                [ 1, 1, 0, 0, 0 ] as int[],
                [ 0, 1, 0, 0, 1 ] as int[],
                [ 1, 0, 0, 1, 1 ] as int[],
                [ 0, 0, 0, 0, 0 ] as int[],
                [ 1, 0, 1, 0, 1 ] as int[]
        ] as int[][]

        // println('Number of islands is: ' + instance.countIslands(matrix))

        assertEquals(5, instance.countIslands(matrix))
    }
}

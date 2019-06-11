package org.bentonc.codingquestions.crackingthecodinginterview

class RotateMatrixTest extends GroovyTestCase {

    RotateMatrix instance

    void setUp() {
        instance = new RotateMatrix()
    }

    void printMatrix(int[][] matrix) {
        for (int a = 0; a < matrix.length; ++a) {
            for (int b = 0; b < matrix[0].length; ++b) {
                print(String.format("%3d", matrix[a][b]))
            }
            println()
        }

        println();
    }

    void testRotate() {
        def matrix = [
                [  1,  2,  3,  4,  5 ] as int[],
                [  6,  7,  8,  9, 10 ] as int[],
                [ 11, 12, 13, 14, 15 ] as int[],
                [ 16, 17, 18, 19, 20 ] as int[],
                [ 21, 22, 23, 24, 25 ] as int[]
        ] as int [][]

        // printMatrix(matrix)
        instance.rotate(matrix, matrix.length)
        // printMatrix(matrix)

        def expected = [
                [ 21, 16, 11,  6,  1 ] as int[],
                [ 22, 17, 12,  7,  2 ] as int[],
                [ 23, 18, 13,  8,  3 ] as int[],
                [ 24, 19, 14,  9,  4 ] as int[],
                [ 25, 20, 15, 10,  5 ] as int[]
        ]

        assertEquals(expected, matrix)
    }
}

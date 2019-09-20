package org.bentonc.codingquestions.crackingthecodinginterview

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.bentonc.codingquestions.utils.LogUtils

class RotateMatrixTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(RotateMatrixTest.class)
    RotateMatrix testClass

    void setUp() {
        super.setUp()
        testClass = new RotateMatrix()
    }

    void printMatrix(int[][] matrix) {
        LogUtils.logSeparator(logger)
        for (int a = 0; a < matrix.length; ++a) {
            final StringBuffer sb = new StringBuffer();
            for (int b = 0; b < matrix[0].length; ++b) {
                sb.append(String.format("%3d", matrix[a][b]))
            }
            logger.debug(sb.toString())
        }
    }

    void testRotate() {
        def matrix = [
                [  1,  2,  3,  4,  5 ] as int[],
                [  6,  7,  8,  9, 10 ] as int[],
                [ 11, 12, 13, 14, 15 ] as int[],
                [ 16, 17, 18, 19, 20 ] as int[],
                [ 21, 22, 23, 24, 25 ] as int[]
        ] as int [][]

        printMatrix(matrix)
        testClass.rotate(matrix, matrix.length)
        printMatrix(matrix)

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

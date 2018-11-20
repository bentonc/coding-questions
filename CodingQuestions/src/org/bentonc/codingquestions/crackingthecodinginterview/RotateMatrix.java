package org.bentonc.codingquestions.crackingthecodinginterview;

public class RotateMatrix {
    public static void printMatrix(int[][] matrix) {
        for (int a = 0; a < matrix.length; ++a) {
            for (int b = 0; b < matrix[0].length; ++b) {
                System.out.format("%3d", matrix[a][b]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    public static void run() {
         int[] row1 = {  1,  2,  3,  4,  5 };
         int[] row2 = {  6,  7,  8,  9, 10 };
         int[] row3 = { 11, 12, 13, 14, 15 };
         int[] row4 = { 16, 17, 18, 19, 20 };
         int[] row5 = { 21, 22, 23, 24, 25 };

         int[][] matrix = { row1, row2, row3, row4, row5 };

         printMatrix(matrix);
         rotate(matrix, matrix.length);
         printMatrix(matrix);
    }
}

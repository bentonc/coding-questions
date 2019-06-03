package org.bentonc.codingquestions.geeksforgeeks;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the
 * below matrix contains 5 islands.
 *
 * Example:
 *
 * Input : mat[][] = {
 *     {1, 1, 0, 0, 0},
 *     {0, 1, 0, 0, 1},
 *     {1, 0, 0, 1, 1},
 *     {0, 0, 0, 0, 0},
 *     {1, 0, 1, 0, 1}
 * }
 *
 * Output : 5
 */
public class NumberOfIslands {

    // No of rows and columns
    static final int ROW = 5;
    static final int COL = 5;

    // A function to check if a given cell (row, col) can be included in depthFirstSearch.
    private boolean isUnvisited(int matrix[][], int row, int col, boolean visited[][])
    {
        // Row number is in range, column number is in range and value is 1 and not yet visited.
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (matrix[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do depthFirstSearch for a 2D boolean matrix. It only considers the 8 neighbors as adjacent
    // vertices.
    private void depthFirstSearch(int matrix[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers of 8 neighbors of a given cell.
        int rowNeighbor[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNeighbor[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited.
        visited[row][col] = true;

        // Recur for all connected neighbours.
        for (int k = 0; k < 8; ++k) {
            if (isUnvisited(matrix, row + rowNeighbor[k], col + colNeighbor[k], visited)) {
                depthFirstSearch(matrix, row + rowNeighbor[k], col + colNeighbor[k], visited);
            }
        }
    }

    // The main function that returns count of islands in a given boolean 2D matrix.
    public int countIslands(int matrix[][])
    {
        // Make a bool array to mark visited cells. Initially all cells are unvisited.
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells of given matrix.
        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet, then new island found, Visit all cells in this island
                    // and increment island count.
                    depthFirstSearch(matrix, i, j, visited);
                    ++count;
                }
            }
        }

        return count;
    }
}

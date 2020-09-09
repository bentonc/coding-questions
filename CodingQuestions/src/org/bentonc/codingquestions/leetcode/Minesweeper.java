package org.bentonc.codingquestions.leetcode;

/**
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an
 * unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right,
 * and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
 * finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return
 * the board after revealing this position according to the following rules:
 *
 * 1. If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * 2. If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of
 *    its adjacent unrevealed squares should be revealed recursively.
 * 3. If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 *    representing the number of adjacent mines.
 * 4. Return the board when no more squares will be revealed.
 */
public class Minesweeper {

    private boolean withinBounds(char[][] board, int x, int y) {
        if (y < 0 || y >= board.length) {
            return false;
        }

        if (x < 0 || x >= board[0].length) {
            return false;
        }

        return true;
    }

    private void check(char[][] board, int x, int y) {
        if (!withinBounds(board, x, y)) {
            return;
        }

        // If visited return.
        if (board[y][x] == 'B') {
            return;
        }

        // if visited return.
        if (board[y][x] >= '1' && board[y][x] <= '8') {
            return;
        }

        // Directional offsets.
        int[] a = { -1,  0,  1, -1,  1, -1,  0,  1 };
        int[] b = { -1, -1, -1,  0,  0,  1,  1,  1 };

        int count = 0;

        // Find surrounding mines.
        for (int d = 0; d < 8; d++) {
            int xp = x + a[d];
            int yp = y + b[d];

            if (withinBounds(board, xp, yp) && board[yp][xp] == 'M') {
                ++count;
            }
        }

        // If count > 0, mark it.
        if (count > 0) {
            board[y][x] = (char)('0' + count);
        }
        // Else mark the square blank and recursively check surrounding squares.
        else {
            board[y][x] = 'B';

            for (int d = 0; d < 8; d++) {
                int xp = x + a[d];
                int yp = y + b[d];

                check(board, xp, yp);
            }
        }
    }

    public void click(char[][] board, int x, int y) {
        if (!withinBounds(board, x, y)) {
            return;
        }

        // If clicked mine, mark and return;
        if (board[y][x] == 'M') {
            board[y][x] = 'X';
            return;
        }
        // Else check the square.
        else {
            check(board, x, y);
            return;
        }
    }
}

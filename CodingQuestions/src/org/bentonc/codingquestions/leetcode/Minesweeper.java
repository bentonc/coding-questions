package org.bentonc.codingquestions.leetcode;

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

            System.out.println(
                    "x:" + x + ", y:" + y + ", d:" + d + ", xp:" + xp + ", yp:" + yp);

            System.out.println("withinBounds:" + withinBounds(board, xp, yp));

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

package org.bentonc.codingquestions.leetcode

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class MinesweeperTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(Minesweeper.class)
    Minesweeper unit = new Minesweeper()

    void printBoard(char[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                print board[y][x]
            }
            println ""
        }
    }

    void testClick() {
        def board = [
                ['E', 'E', 'E', 'E', 'E'] as char[],
                ['E', 'E', 'M', 'E', 'E'] as char[],
                ['E', 'E', 'E', 'E', 'E'] as char[],
                ['E', 'E', 'E', 'E', 'E'] as char[]
        ] as char[][]

        printBoard(board)

        unit.click(board, 3, 0)

        printBoard(board)
    }
}

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
            println ''
        }
        println ''
    }

    void testClick() {
        def board = [
                ['E', 'E', 'E', 'E', 'E'] as char[],
                ['E', 'E', 'M', 'E', 'E'] as char[],
                ['E', 'E', 'E', 'E', 'E'] as char[],
                ['E', 'E', 'E', 'E', 'E'] as char[]
        ] as char[][]

        printBoard(board)

        unit.click(board, 0, 3)
        printBoard(board)

        def expected1 = [
                ['B', '1', 'E', '1', 'B'] as char[],
                ['B', '1', 'M', '1', 'B'] as char[],
                ['B', '1', '1', '1', 'B'] as char[],
                ['B', 'B', 'B', 'B', 'B'] as char[]
        ] as char[][]

        assertEquals(expected1, board)

        unit.click(board, 2, 1)
        printBoard(board)

        def expected2 = [
                ['B', '1', 'E', '1', 'B'] as char[],
                ['B', '1', 'X', '1', 'B'] as char[],
                ['B', '1', '1', '1', 'B'] as char[],
                ['B', 'B', 'B', 'B', 'B'] as char[]
        ] as char[][]

        assertEquals(expected2, board)
    }
}

package org.bentonc.codingquestions.blindcurated.arrays

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BuySellStockTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(BuySellStockTest.class)
    BuySellStock unit = new BuySellStock()

    void testBuySellOnceBruteForce() {
        def prices = [20, 1, 2, 90, 10, 110, 50]
        def actual = unit.buySellOnceBruteForce(prices)
        assertEquals(109, actual)
    }

    void testBuySellOnceOptimal() {
        def prices = [20, 1, 2, 90, 10, 110, 50]
        def actual = unit.buySellOnceOptimal(prices)
        assertEquals(109, actual)
    }

    void testBuySellMultipleBruteForce() {
        def prices = [100, 180, 260, 310, 40, 535, 695]
        def actual = unit.buySellMultipleBruteForce(prices)
        assertEquals(865, actual)
    }

    void testBuySellMultipleOptimalCase1() {
        def prices = [100, 180, 260, 310, 40, 535, 695]
        def actual = unit.buySellMultipleOptimal(prices)
        assertEquals(865, actual)
    }

    void testBuySellMultipleOptimalCase2() {
        def prices = [10, 9, 8, 7, 6, 5, 8, 10, 2]
        def actual = unit.buySellMultipleOptimal(prices)
        assertEquals(5, actual)
    }
}

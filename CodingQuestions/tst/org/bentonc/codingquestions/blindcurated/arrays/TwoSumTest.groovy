package org.bentonc.codingquestions.blindcurated.arrays

import javafx.util.Pair
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class TwoSumTest extends GroovyTestCase {
    Logger logger = LogManager.getLogger(TwoSumTest.class)
    TwoSum unit = new TwoSum()

    void testHash() {
        assertEquals(new Pair<>(0, 1), unit.hash([2, 7, 11, 15], 9).get())
    }

    void testSort() {
        assertEquals(new Pair<>(0, 1), unit.sort([2, 7, 11, 15], 9).get())
    }
}

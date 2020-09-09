package org.bentonc.codingquestions.blindcurated.arrays

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class MaximumSubarrayTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(MaximumSubarray.class)
    MaximumSubarray unit = new MaximumSubarray()

    void testGetMaximumSum() {
        def list = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        assertEquals(6, unit.getMaximumSum(list))
    }
}

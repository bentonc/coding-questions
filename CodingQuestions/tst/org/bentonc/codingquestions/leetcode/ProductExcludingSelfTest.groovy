package org.bentonc.codingquestions.leetcode

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ProductExcludingSelfTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(ProductExcludingSelf.class)
    ProductExcludingSelf unit

    void setUp() {
        super.setUp()
        unit = new ProductExcludingSelf()
    }

    void testEfficient() {
        assertEquals([24,12,8,6], unit.efficient([1, 2, 3, 4]))
    }
}

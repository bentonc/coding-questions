package org.bentonc.codingquestions.leetcode

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ProductExcludingSelfTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(ProductExcludingSelf.class)
    ProductExcludingSelf testClass

    void setUp() {
        super.setUp()
        testClass = new ProductExcludingSelf()
    }

    void testEfficient() {
        assertEquals([24,12,8,6], testClass.efficient([1,2,3,4]))
    }
}

package org.bentonc.codingquestions.blindcurated.arrays

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ProductExcludingSelfTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(ProductExcludingSelf.class)
    ProductExcludingSelf unit = new ProductExcludingSelf()

    void testEfficient1() {
        assertEquals([24,12,8,6], unit.efficient1([1, 2, 3, 4]))
    }

    void testEfficient2() {
        assertEquals([24,12,8,6], unit.efficient2([1, 2, 3, 4]))
    }
}

package org.bentonc.codingquestions.blindcurated.arrays

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class HasDuplicatesTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(HasDuplicates.class)
    HasDuplicates unit = new HasDuplicates()

    void testHasDuplicatesCase1() {
        def list = Arrays.asList(1, 2, 3, 1)
        assertTrue(unit.hasDuplicates(list))
    }

    void testHasDuplicatesCase2() {
        def list = Arrays.asList(1, 2, 3, 4)
        assertFalse(unit.hasDuplicates(list))
    }

    void testHasDuplicatesCase3() {
        def list = Arrays.asList(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        assertTrue(unit.hasDuplicates(list))
    }
}

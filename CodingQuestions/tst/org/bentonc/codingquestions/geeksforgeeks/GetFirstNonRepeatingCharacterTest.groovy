package org.bentonc.codingquestions.geeksforgeeks

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class GetFirstNonRepeatingCharacterTest extends GroovyTestCase {

    Logger logger = LogManager.getLogger(GetFirstNonRepeatingCharacterTest.class)

    void testBruteForceSolution() {
        def unit = new GetFirstNonRepeatingCharacter.BruteForceSolution()

        def str = 'geeksforgeeks';
        def index = unit.firstNonRepeating(str)

        logger.debug(index == -1 ?
                String.format('Either all characters are repeating or string is empty') :
                String.format('First non-repeating character in "%s" is "%s".', str, str.charAt(index)))

        assertEquals('f', str.charAt(index))
    }

    void testEfficientSolution() {
        def unit = new GetFirstNonRepeatingCharacter.EfficientSolution()

        def str = 'geeksforgeeks'
        def index = unit.firstNonRepeating(str)

        logger.debug(index == -1 ?
                String.format('Either all characters are repeating or string is empty') :
                String.format('First non-repeating character in "%s" is "%s".', str, str.charAt(index)))

        assertEquals('f', str.charAt(index))
    }
}

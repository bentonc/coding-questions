package org.bentonc.codingquestions.geeksforgeeks

class GetFirstNonRepeatingCharacterTest extends GroovyTestCase {

    void testBruteForceSolution() {
        def instance = new GetFirstNonRepeatingCharacter.BruteForceSolution()

        def str = 'geeksforgeeks';
        def index = instance.firstNonRepeating(str)

//        println(index == -1 ?
//                String.format('Either all characters are repeating or string is empty') :
//                String.format('First non-repeating character in "%s" is "%s".', str, str.charAt(index))
//        )

        assertEquals('f', str.charAt(index))
    }

    void testEfficientSolution() {
        def instance = new GetFirstNonRepeatingCharacter.EfficientSolution()

        def str = 'geeksforgeeks'
        def index = instance.firstNonRepeating(str)

//        println(index == -1 ?
//                String.format('Either all characters are repeating or string is empty') :
//                String.format('First non-repeating character in "%s" is "%s".', str, str.charAt(index))
//        )

        assertEquals('f', str.charAt(index))
    }
}

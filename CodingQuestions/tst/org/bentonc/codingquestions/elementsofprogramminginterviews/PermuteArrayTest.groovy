package org.bentonc.codingquestions.elementsofprogramminginterviews

class PermuteArrayTest extends GroovyTestCase {
    PermuteArray unit

    void setUp() {
        super.setUp()
        unit = new PermuteArray()
    }

    void testApplyPermutation1() {
        testCase1: {
            def perm = [3, 1, 2, 0]
            def A = ['a', 'b', 'c', 'd']
            unit.applyPermutation1(perm, A)
            assertEquals(['d', 'b', 'c', 'a'], A)
        }

        testCase2: {
            def perm = [3, 1, 0, 2]
            def A = ['a', 'b', 'c', 'd']
            unit.applyPermutation1(perm, A)
            assertEquals(['c', 'b', 'd', 'a'], A)
        }

        testCase3: {
            def perm = [3, 1, 0, 4, 2]
            def A = ['a', 'b', 'c', 'd', 'e']
            unit.applyPermutation1(perm, A)
            assertEquals(['c', 'b', 'e', 'a', 'd'], A)
        }
    }

    void testApplyPermutation2() {
        testCase1: {
            def perm = [3, 1, 2, 0]
            def A = ['a', 'b', 'c', 'd']
            unit.applyPermutation2(perm, A)
            assertEquals(['d', 'b', 'c', 'a'], A)
        }

        testCase2: {
            def perm = [3, 1, 0, 2]
            def A = ['a', 'b', 'c', 'd']
            unit.applyPermutation2(perm, A)
            assertEquals(['c', 'b', 'd', 'a'], A)
        }

        testCase3: {
            def perm = [3, 1, 0, 4, 2]
            def A = ['a', 'b', 'c', 'd', 'e']
            unit.applyPermutation2(perm, A)
            assertEquals(['c', 'b', 'e', 'a', 'd'], A)
        }
    }
}

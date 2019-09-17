package org.bentonc.codingquestions.elementsofprogramminginterviews

class PermuteArrayTest extends GroovyTestCase {
    PermuteArray testClass

    void setUp() {
        super.setUp()
        testClass = new PermuteArray()
    }

    void testApplyPermutation1() {
        testCase1: {
            def perm = [3, 1, 2, 0]
            def A = ['a', 'b', 'c', 'd']
            testClass.applyPermutation1(perm, A)
            assertEquals(['d', 'b', 'c', 'a'], A)
        }

        testCase2: {
            def perm = [3, 1, 0, 2]
            def A = ['a', 'b', 'c', 'd']
            testClass.applyPermutation1(perm, A)
            assertEquals(['c', 'b', 'd', 'a'], A)
        }

        testCase3: {
            def perm = [3, 1, 0, 4, 2]
            def A = ['a', 'b', 'c', 'd', 'e']
            testClass.applyPermutation1(perm, A)
            assertEquals(['c', 'b', 'e', 'a', 'd'], A)
        }
    }

    void testApplyPermutation2() {
        testCase1: {
            def perm = [3, 1, 2, 0]
            def A = ['a', 'b', 'c', 'd']
            testClass.applyPermutation2(perm, A)
            assertEquals(['d', 'b', 'c', 'a'], A)
        }

        testCase2: {
            def perm = [3, 1, 0, 2]
            def A = ['a', 'b', 'c', 'd']
            testClass.applyPermutation2(perm, A)
            assertEquals(['c', 'b', 'd', 'a'], A)
        }

        testCase3: {
            def perm = [3, 1, 0, 4, 2]
            def A = ['a', 'b', 'c', 'd', 'e']
            testClass.applyPermutation2(perm, A)
            assertEquals(['c', 'b', 'e', 'a', 'd'], A)
        }
    }
}

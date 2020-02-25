package org.bentonc.codingquestions.elementsofprogramminginterviews;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bentonc.codingquestions.utils.LogUtils;

import java.util.Collections;
import java.util.List;

/**
 * A permutation is a rearrangement of members of a sequence into a new sequence. For example, there are 24
 * permutations of <a, b, c, d>; some of these are <b, a, d, c>, <d, a, b, c>, and <a, d, b, c>. A permutation can be
 * specified by an array P, where P[i] represents the location of the element at i in the permutation. For example,
 * the array <2, 0, 1, 3> represents the permutation that maps the element at location 0 to location 2, the element
 * at location 1 to location 0, the element at location 2 to location 1, and keep the element at location 3 unchanged.
 * A permutation can be applied to an array to reorder the array. For example, the permutation <2, 0, 1, 3> applied to
 * A = <a, b, c, d> yields the array <b, c, a, d>.
 *
 * Given an array A of n elements and a permutation P, apply P to A.
 */
public class PermuteArray {
    private final Logger logger = LogManager.getLogger(PermuteArray.class);

    public void applyPermutation1(final List<Integer> perm, final List<String> A) {
        LogUtils.logSeparator(logger);
        logger.debug("perm: {}, A: {}", perm, A);

        for (int i = 0; i < A.size(); i++) {
            // Check if the element at index i has not been moved by checking if perm.get(i) is non-negative.
            int next = i;
            logger.debug("increment - i: {}, next: {}",  i, next);
            while (perm.get(next) >= 0) {
                int j = perm.get(next);
                Collections.swap(A, i, j);

                // Subtracts perm.size() from an entry in perm to make it negative, which indicates the corresponding
                // move has been performed.
                perm.set(next, perm.get(next) - perm.size());

                next = j;

                logger.debug("swap - i: {}, j: {}, next: {}, perm: {}, A: {}", i, j, next, perm, A);
            }
        }

        // Restore perm.
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }

    /**
     * If we cannot use the sign bit, we can allocate an array of n Booleans indicating whether the element at index i
     * has been processed. Alternatively, we can avoid using O(n) additional storage, by going from left-to-right and
     * applying the cycle only if the current position is the leftmost position in the cycle.
     */
    public void applyPermutation2(final List<Integer> perm, final List<String> A) {
        LogUtils.logSeparator(logger);
        logger.debug("perm: {}, A: {}", perm, A);

        for (int i = 0; i < A.size(); i++) {
            // Traverse the cycle to see if i is the minimum element.

            boolean isMin = true;
            int j = perm.get(i);

            logger.debug("i: {}, j: {}", i, j);

            while (j != i) {
                if (j < i) {
                    isMin = false;

                    logger.debug("[break] i: {}, j: {}", i, j);

                    break;
                }

                j = perm.get(j);

                logger.debug("[continue] i: {}, j: {}", i, j);
            }

            if (isMin) {
                cyclicPermutation(i, perm, A);
            }
        }
    }

    private void cyclicPermutation(final int start, final List<Integer> perm, final List<String> A) {
        int i = start;
        String temp = A.get(start);

        do {
            int nextI = perm.get(i);
            String nextTemp = A.get(nextI);

            A.set(nextI, temp);

            logger.debug(
                    "start: {}, i: {}, nextI: {}, temp: {}, perm: {}, A: {}",
                    start, i, nextI, temp, perm, A);

            i = nextI;
            temp = nextTemp;
        } while (i != start);
    }
}

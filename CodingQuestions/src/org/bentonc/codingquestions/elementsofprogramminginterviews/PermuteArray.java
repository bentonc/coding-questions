package org.bentonc.codingquestions.elementsofprogramminginterviews;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bentonc.codingquestions.utils.LogUtils;

import java.util.Collections;
import java.util.List;

public class PermuteArray {
    private final Logger logger = LogManager.getLogger(PermuteArray.class);

    public void applyPermutation1(final List<Integer> perm, final List<String> A) {
        LogUtils.logSeparator(logger);
        logger.debug("perm: {}, A: {}", perm, A);

        for (int i = 0; i < A.size(); i++) {
            // Check if the element at index i has not been moved by checking if perm.get(i) is non-negative.
            int next = i;
            while (perm.get(next) >= 0) {
                int j = perm.get(next);
                Collections.swap(A, i, j);

                // Subtracts perm.size() from an entry in perm to make it negative, which indicates the corresponding
                // move has been performed.
                perm.set(next, perm.get(next) - perm.size());

                logger.debug("i: {}, j: {}, perm: {}, A: {}", i, j, perm, A);

                next = j;
            }
        }

        // Restore perm.
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }

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

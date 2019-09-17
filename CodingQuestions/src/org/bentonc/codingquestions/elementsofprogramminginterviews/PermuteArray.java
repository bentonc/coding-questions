package org.bentonc.codingquestions.elementsofprogramminginterviews;

import java.util.Collections;
import java.util.List;

public class PermuteArray {
    public void applyPermutation1(final List<Integer> perm, final List<String> A) {
        // System.out.println(String.format("perm: %s, A: %s", perm, A));

        for (int i = 0; i < A.size(); i++) {
            // Check if the element at index i has not been moved by checking if perm.get(i) is non-negative.
            int next = i;
            while (perm.get(next) >= 0) {
                int j = perm.get(next);
                Collections.swap(A, i, j);

                // Subtracts perm.size() from an entry in perm to make it negative, which indicates the corresponding
                // move has been performed.
                perm.set(next, perm.get(next) - perm.size());

                // System.out.println(String.format("i: %d, j: %d, perm: %s, A: %s", i, j, perm, A));

                next = j;
            }
        }

        // Restore perm.
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }

        // System.out.println();
    }

    public void applyPermutation2(final List<Integer> perm, final List<String> A) {
        // System.out.println(String.format("perm: %s, A: %s", perm, A));

        for (int i = 0; i < A.size(); i++) {
            // Traverse the cycle to see if i is the minimum element.

            boolean isMin = true;
            int j = perm.get(i);

            // System.out.println(String.format("i: %d, j: %d", i, j));

            while (j != i) {
                if (j < i) {
                    isMin = false;

                    // System.out.println(String.format("[break] i: %d, j: %d", i, j));

                    break;
                }

                j = perm.get(j);

                // System.out.println(String.format("[continue] i: %d, j: %d", i, j));
            }

            if (isMin) {
                cyclicPermutation(i, perm, A);
            }
        }

        // System.out.println();
    }

    private void cyclicPermutation(final int start, final List<Integer> perm, final List<String> A) {
        int i = start;
        String temp = A.get(start);

        do {
            int nextI = perm.get(i);
            String nextTemp = A.get(nextI);

            A.set(nextI, temp);

            // System.out.println(
            //         String.format(
            //                 "start: %d, i: %d, nextI: %d, temp: %s, perm: %s, A: %s",
            //                 start, i, nextI, temp, perm, A));

            i = nextI;
            temp = nextTemp;
        } while (i != start);
    }
}

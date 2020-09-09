package org.bentonc.codingquestions.blindcurated.arrays;

import java.util.List;

public class MaximumSubarray {

    public int getMaximumSum(final List<Integer> list) {
        int totalMax = Integer.MIN_VALUE;
        int runningMax = 0;

        for (int i = 0; i < list.size(); i++) {
            runningMax += list.get(i);

            if (runningMax < 0) {
                runningMax = 0;
            } else if (totalMax < runningMax) {
                totalMax = runningMax;
            }
        }

        return totalMax;
    }
}

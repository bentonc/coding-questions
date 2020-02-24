package org.bentonc.codingquestions.geeksforgeeks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 *
 * Number of sub-arrays that sum to exactly k.
 *
 * Given an unsorted array of integers, find the number of subarrays with a sum exactly equal to a given number k.
 **/
public class GetSubarraysEqualToK {

    private final Logger logger = LogManager.getLogger(GetSubarraysEqualToK.class);

    public int bruteForce(List<Integer> list, int k) {
        int result = 0;

        for (int i = 0; i < list.size(); ++i) {
            int currentSum = 0;

            for (int j = i; j < list.size(); ++j) {
                currentSum += list.get(j);
                logger.debug("i: {}, j: {}, currentSum: {}", i, j, currentSum);

                if (currentSum == k) {
                    logger.debug("currentSum: {}, sub-array: {}", currentSum, list.subList(i, j + 1));
                    ++result;
                }
            }
        }

        return result;
    }

    public int efficient(List<Integer> list, int k) {
        logger.debug("array: {}, k: {}", list, k);

        // Number of sub-arrays starting from index zero with a value of x.
        Map<Integer, Integer> previousSum = new HashMap<>();

        int result = 0;

        // Sum of elements so far.
        int currentSum = 0;

        for (int i = 0; i < list.size(); ++i) {
            // Add current element to sum of elements so far.
            currentSum += list.get(i);

            // If currentSum is equal to k, increment the count of sub-arrays.
            if (currentSum == k) {
                ++result;
                logger.debug("i: {}, result: {}", i, result);
            }

            // Remove any sub-arrays from 0 to i that have a sum of currentSum - k.
            if (previousSum.containsKey(currentSum - k)) {
                result += previousSum.get(currentSum - k);
                logger.debug("i: {}, currentSum: {}, result: {}", i, currentSum, result);
            }

            // Increment previousSum.
            previousSum.put(currentSum, previousSum.getOrDefault(currentSum, 0) + 1);
            logger.debug("i: {}, array: {}, previousSum: {}", i, list.subList(0, i + 1), previousSum);
        }

        return result;
    }
}

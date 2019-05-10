package org.bentonc.codingquestions.geeksforgeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 *
 * Number of sub-arrays that sum to exactly k.
 *
 * Given an unsorted array of integers, find the number of subarrays with a sum exactly equal to a given number k.
 * */
public class GetSubarraysEqualToK {
    public static int bruteForce(List<Integer> list, int k) {
        int result = 0;

        for (int i = 0; i < list.size(); ++i) {
            int currentSum = 0;

            for (int j = i; j < list.size(); ++j) {
                currentSum += list.get(j);
                System.out.format("i:%d,j:%d,currentSum:%d\n", i, j, currentSum);

                if (currentSum == k) {
                    System.out.format("currentSum:%d,sub-array:%s\n", currentSum, list.subList(i, j + 1));
                    ++result;
                }
            }
        }

        return result;
    }

    public static int efficient(List<Integer> list, int k) {
        System.out.format("array:%s,k:%d\n", list, k);

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
                System.out.format("i:%d,result:%d\n", i, result);
            }

            // Remove any sub-arrays from 0 to i that have a sum of currentSum - k.
            if (previousSum.containsKey(currentSum - k)) {
                result += previousSum.get(currentSum - k);
                System.out.format("i:%d,currentSum:%d,result:%d\n", i, currentSum, result);
            }

            // Increment previousSum.
            previousSum.put(currentSum, previousSum.getOrDefault(currentSum, 0) + 1);
            System.out.format("i:%d,array:%s,previousSum:%s\n", i, list.subList(0, i + 1), previousSum);
        }

        return result;
    }

    public static void run() {
        {
            System.out.println("GetSubarraysEqualToK.efficient(...).");

            List<Integer> array = Arrays.asList(10, 2, -2, -20, 10);
            int k = -10;

            int result = efficient(array, k);

            // result:3
            System.out.format("result:%d\n\n", result);
        }

        {
            System.out.println("GetSubarraysEqualToK.bruteForce(...).");

            List<Integer> array = Arrays.asList(10, 2, -2, -20, 10);
            int k = -10;

            int result = bruteForce(array, k);

            // result:3
            System.out.format("result:%d\n\n", result);
        }
    }
}

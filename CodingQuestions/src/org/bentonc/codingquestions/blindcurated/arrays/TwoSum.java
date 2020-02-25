package org.bentonc.codingquestions.blindcurated.arrays;

import javafx.util.Pair;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    Optional<Pair<Integer, Integer>> hash(List<Integer> list, int target) {
        final Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int difference = target - value;

            if (indices.containsKey(difference)) {
                return Optional.of(new Pair<>(indices.get(difference), i));
            }

            indices.put(value, i);
        }

        return Optional.empty();
    }

    Optional<Pair<Integer, Integer>> sort(List<Integer> list, int target) {
        Collections.sort(list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (list.get(left) + list.get(right) < target) {
                left++;
            }
            else if (list.get(left) + list.get(right) > target) {
                right--;
            }
            else {
                return Optional.of(new Pair<>(left, right));
            }
        }

        return Optional.empty();
    }
}

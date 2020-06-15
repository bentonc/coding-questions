package org.bentonc.codingquestions.blindcurated.arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i]. Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 **/
public class ProductExcludingSelf {

    Logger logger = LogManager.getLogger(ProductExcludingSelf.class);

    public List<Integer> efficient(List<Integer> nums) {
        List<Integer> result = new ArrayList<>(nums.size());

        logger.debug("Forward");

        result.add(1);
        for (int i = 1; i < nums.size(); i++) {
            result.add(nums.get(i - 1) * result.get(i - 1));

            logger.debug("result: {}", result);
        }

        logger.debug("Backward");

        int right = nums.get(nums.size() - 1);
        logger.debug("right: {}", right);

        for (int i = nums.size() - 2; i >= 0; i--) {
            result.set(i, right * result.get(i));
            right *= nums.get(i);

            logger.debug("result: {}, right: {}", result, right);
        }

        logger.debug ("Done");

        return result;
    }

}

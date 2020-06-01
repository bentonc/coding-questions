package org.bentonc.codingquestions.geeksforgeeks;

import java.util.List;

/**
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 * Search an element in a sorted and rotated array.
 *
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending
 * order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 *
 * Rephrased for interview by Charles Benton: Given an array that has been sorted and then rotated at some given
 * element, implement an approach to finding an element in that array.
 *
 * Ex: [ 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 ]
 */
public class SearchSortedAndRotatedArray {

    private int binarySearchRecursive(final List<Integer> array, final int left, final int right, final int target) {
        if (right < left)
            return -1;

        /* start + (end - start) / 2 */
        int index = (left + right) / 2;

        if (target == array.get(index)) {
            return index;
        }

        if (array.get(index) < target) {
            return binarySearchRecursive(array, (index + 1), right, target);
        }

        return binarySearchRecursive(array, left, (index - 1), target);
    }

    private int findPivotRecursive(final List<Integer> array, final int left, final int right) {
        // Base cases.
        if (right < left) {
            return -1;
        }

        if (right == left) {
            return left;
        }

        /* start + (end - start) / 2 */
        int pivot = (left + right) / 2;

        if ((pivot < right) && (array.get(pivot) > array.get(pivot + 1))) {
            return pivot;
        }

        if ((pivot > left) && (array.get(pivot) < array.get(pivot - 1))) {
            return (pivot - 1);
        }

        if (array.get(pivot) <= array.get(left)) {
            return findPivotRecursive(array, left, pivot - 1);
        }

        return findPivotRecursive(array, pivot + 1, right);
    }

    // O(log n)
    public int pivotedBinarySearchRecursive(final List<Integer> array, final int target) {
        int pivot = findPivotRecursive(array, 0, array.size() - 1);

        // If we didn't find a pivot, then  array is not rotated at all.
        if (pivot == -1) {
            return binarySearchRecursive(array, 0, array.size() - 1, target);
        }

        // If we found a pivot, then first compare with pivot and then search in two subarrays around pivot.
        if (array.get(pivot) == target) {
            return pivot;
        }

        if (array.get(0) <= target) {
            return binarySearchRecursive(array, 0, pivot - 1, target);
        }

        return binarySearchRecursive(array, pivot+1, array.size() - 1, target);
    }

    private int binarySearchIterative(final List<Integer> array, int left, int right, final int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array.get(mid) == target) {
                return mid;
            }

            if (array.get(mid) < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int findPivotIterative(final List<Integer> array) {
        if (array.size() <= 0) {
            return -1;
        }

        if (array.get(0) < array.get(array.size() - 1)) {
            return 0;
        }

        int left = 0;
        int right = array.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (array.get(mid - 1) > array.get(mid) && array.get(mid) < array.get(mid + 1)) {
                return mid;
            }

            if (array.get(mid) > array.get(mid + 1)) {
                return mid + 1;
            }

            if (array.get(mid) > array.get(left)) {
                left = mid + 1;
            }

            else right = mid;
        }

        return left;
    };

    public int pivotedBinarySearchIterative(final List<Integer> array, final int target) {
        if (array.size() <= 0) {
            return -1;
        }

        int pivot = findPivotIterative(array);

        if (array.get(pivot) == target) {
            return pivot;
        }

        if (target < array.get(array.size() - 1)) {
            return binarySearchIterative(array, pivot, array.size() - 1, target);
        }

        return binarySearchIterative(array, 0, pivot - 1, target);
    }

    // O(log n)
    public int sortedBinarySearch(final List<Integer> array, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (array.get(mid) == target) {
            return mid;
        }

        // If arr[0...mid] first subarray is sorted.
        if (array.get(0) <= array.get(mid)) {
            // As this subarray is sorted, we can quickly check if key lies in this half or the other half.
            if (target >= array.get(0) && target <= array.get(mid)) {
                return sortedBinarySearch(array, 0, mid - 1, target);
            }

            // If key does not lie in first half of the subarray, divide the other half into two subarrays, such that
            // we can quickly check if key lies in the other half.
            return sortedBinarySearch(array, mid + 1, right, target);
        }

        // If arr[0..mid] first subarray is not sorted, then arr[mid..right] must be the sorted subarray.
        if (target >= array.get(mid) && target <= array.get(right)) {
            return sortedBinarySearch(array, mid + 1, right, target);
        }

        return sortedBinarySearch(array, 0, mid - 1, target);
    }
}

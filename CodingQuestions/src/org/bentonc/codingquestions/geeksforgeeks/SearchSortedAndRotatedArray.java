package org.bentonc.codingquestions.geeksforgeeks;

import java.util.Arrays;
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
    public static int findPivot(final List<Integer> array, final int start, final int end)
    {
        // Base cases.
        if (end < start) {
            return -1;
        }

        if (end == start) {
            return start;
        }

        /* start + (end - start) / 2 */
        int pivot = (start + end) / 2;

        if ((pivot < end) && (array.get(pivot) > array.get(pivot + 1))) {
            return pivot;
        }

        if ((pivot > start) && (array.get(pivot) < array.get(pivot - 1))) {
            return (pivot - 1);
        }

        if (array.get(pivot) <= array.get(start)) {
            return findPivot(array, start, pivot - 1);
        }

        return findPivot(array, pivot + 1, end);
    }

    public static int binarySearch(final List<Integer> array, final int start, final int end, final int target)
    {
        if (end < start)
            return -1;

        /* start + (end - start) / 2 */
        int index = (start + end) / 2;
        
        if (target == array.get(index)) {
            return index;
        }
        
        if (array.get(index) < target) {
            return binarySearch(array, (index + 1), end, target);
        }
        
        return binarySearch(array, start, (index - 1), target);
    }

    public static int pivotedBinarySearch(final List<Integer> array, final int n, final int target)
    {
        int pivot = findPivot(array, 0, n - 1);

        // If we didn't find a pivot, then  array is not rotated at all.
        if (pivot == -1) {
            return binarySearch(array, 0, n - 1, target);
        }

        // If we found a pivot, then first compare with pivot and then search in two subarrays around pivot.
        if (array.get(pivot) == target) {
            return pivot;
        }

        if (array.get(0) <= target) {
            return binarySearch(array, 0, pivot - 1, target);
        }

        return binarySearch(array, pivot+1, n - 1, target);
    }

    public static void run() {
        List<Integer> array1 = Arrays.asList(3, 4, 5, 6, 1, 2);

        int result1 = findPivot(array1, 0, array1.size() - 1);
        System.out.println("result: " + result1);

        // Let us search 3 in below array
        // List<Integer> array2 = Arrays.asList(5, 6, 7, 8, 9, 10, 1, 2, 3);
        List<Integer> array2 = Arrays.asList(6, 7, 8, 9, 10, 1, 2, 3, 4, 5);

        int result2 = pivotedBinarySearch(array2, array2.size(), 2);
        System.out.println("Index of the element is: " + result2);
    }
}

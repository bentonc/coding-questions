package org.bentonc.codingquestions;

import java.util.List;

public class SearchSortedAndRotatedArray {
    static int findPivot(final List<Integer> array, final int start, final int end)
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

    static int binarySearch(final List<Integer> array, final int start, final int end, final int target)
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

    static int pivotedBinarySearch(final List<Integer> array, final int n, final int target)
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
}

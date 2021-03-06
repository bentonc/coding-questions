package org.bentonc.codingquestions.geeksforgeeks;

/**
 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 *
 * Rearrange array in alternating positive & negative items with O(1) extra space.
 *
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive
 * number is followed by negative and vice-versa maintaining the order of appearance. Number of positive and negative
 * numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more
 * negative numbers, they too appear in the end of the array.
 */
public class AlternatePositiveAndNegativeNumbers {

    // Utility function to right rotate all elements between [outofplace, cur].
    private void rotate(int arr[], int n, int start, int end) {
        int tmp = arr[end];

        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }

        arr[start] = tmp;
    }

    public void rearrange(int arr[], int n) {
        int outofplace = -1;

        for (int index = 0; index < n; index++) {
            if (outofplace >= 0) {
                // Find the item which must be moved into the out-of-place
                // entry if out-of-place entry is positive and current
                // entry is negative OR if out-of-place entry is negative
                // and current entry is negative then right rotate.
                //
                // [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
                //      ^                          ^
                //      |                          |
                //     outofplace      -->      outofplace
                //
                if (((arr[index] >= 0) && (arr[outofplace] < 0)) ||
                    ((arr[index] < 0) && (arr[outofplace] >= 0))
                ) {
                    rotate(arr, n, outofplace, index);

                    // The new out-of-place entry is now 2 steps ahead.
                    if (index - outofplace > 2) {
                        outofplace = outofplace + 2;
                    }
                    else {
                        outofplace = -1;
                    }
                }
            }

            // If no entry has been flagged out-of-place.
            if (outofplace == -1) {
                // Check if current entry is out-of-place.
                if (((arr[index] >= 0) && ((index & 0x01)==0)) ||
                    ((arr[index] < 0) && (index & 0x01)==1)
                ) {
                    outofplace = index;
                }
            }
        }
    }
}

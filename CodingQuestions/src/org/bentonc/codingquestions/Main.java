package org.bentonc.codingquestions;

import java.util.Arrays;
import java.util.List;

/**
 * http://collabedit.com/4kgm3
 */
public class Main {
    public static void main(String[] args) {
//        {
//            List<String> result = new ArrayList<>();
//            GetExpressions.recursive(6, "123", 0, "", 0, 0, result);
//
//            // result:[1+2+3, 1*2*3]
//            System.out.println("result:" + result);
//        }
//
//        {
//            List<String> result = new ArrayList<>();
//            GetExpressions.recursive(7, "125", 0, "", 0, 0, result);
//
//            // result:[1*2+5, 12-5]
//            System.out.println("result:" + result);
//        }

//        {
//            System.out.println("GetSubarraysEqualToK.efficient(...).");
//
//            List<Integer> array = Arrays.asList(10, 2, -2, -20, 10);
//            int k = -10;
//
//            int result = GetSubarraysEqualToK.efficient(array, k);
//
//            // result:3
//            System.out.format("result:%d\n\n", result);
//        }
//
//        {
//            System.out.println("GetSubarraysEqualToK.bruteForce(...).");
//
//            List<Integer> array = Arrays.asList(10, 2, -2, -20, 10);
//            int k = -10;
//
//            int result = GetSubarraysEqualToK.bruteForce(array, k);
//
//            // result:3
//            System.out.format("result:%d\n\n", result);
//        }
//
//        {
//            System.out.println("SmallestNumberK.calc(...).");
//
//            int result = SmallestNumberK.calc(100);
//
//            // result:455
//            System.out.format("result:%d\n\n", result);
//        }

//        {
//            AlternatePositiveAndNegativeNumbers rearrange =
//                    new AlternatePositiveAndNegativeNumbers();
//
//            //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
//            //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
//            //int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
//            //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
//            int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
//            int n = arr.length;
//
//            System.out.println("Given array is: ");
//            rearrange.printArray(arr, n);
//
//            rearrange.rearrange(arr, n);
//
//            System.out.println("Rearranged array is: ");
//            rearrange.printArray(arr, n);
//        }

        {
            List<Integer> array1 = Arrays.asList(3, 4, 5, 6, 1, 2);

            int result1 = SearchSortedAndRotatedArray.findPivot(array1, 0, array1.size() - 1);
            System.out.println("result: " + result1);

            // Let us search 3 in below array
            List<Integer> array2 = Arrays.asList(5, 6, 7, 8, 9, 10, 1, 2, 3);

            int result2 = SearchSortedAndRotatedArray.pivotedBinarySearch(array2, array2.size(), 2);
            System.out.println("Index of the element is: " + result2);
        }
    }
}

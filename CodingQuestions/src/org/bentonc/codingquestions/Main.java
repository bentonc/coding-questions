package org.bentonc.codingquestions;

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

        {
            AlternatePositiveAndNegativeNumbers rearrange =
                    new AlternatePositiveAndNegativeNumbers();

            //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
            //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
            //int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
            //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
            int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
            int n = arr.length;

            System.out.println("Given array is: ");
            rearrange.printArray(arr, n);

            rearrange.rearrange(arr, n);

            System.out.println("Rearranged array is: ");
            rearrange.printArray(arr, n);
        }
    }
}

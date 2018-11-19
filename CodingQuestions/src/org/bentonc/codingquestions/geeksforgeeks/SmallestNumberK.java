package org.bentonc.codingquestions.geeksforgeeks;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/smallest-number-k-product-digits-k-equal-n/
 *
 * Smallest number k such that the product of digits of k is equal to n.
 *
 * Given a non-negative number n. The problem is to find the smallest number k such that the product of digits of k is
 * equal to n. If no such number k can be formed then print “-1”.
 */
public class SmallestNumberK {
    public static int calc(int n) {
        if ((n >= 0) && (n <= 9)) {
            return n;
        }

        Stack<Integer> digits = new Stack<>();

        // Repeatedly divide n by the numbers 9 to 2 until all the numbers are used or n > 1.
        for (int i = 9; i >= 2 && n > 1; --i) {
            while (n % i == 0) {
                // Save the digit i that divides n onto the stack.
                digits.push(i);
                n = n / i;

                System.out.println(String.format("n:%d, i:%d, digits:%s", n, i, digits));
            }
        }

        // If n != 1, then no number k can be formed.
        if (n != 1) {
            return -1;
        }

        // Pop the digits from the stack and add them to k.
        int k = 0;
        while (!digits.empty()) {
            k = (k * 10) + digits.peek();
            digits.pop();
        }

        return k;
    }
}

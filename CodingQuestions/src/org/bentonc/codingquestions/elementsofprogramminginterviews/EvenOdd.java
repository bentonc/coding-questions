package org.bentonc.codingquestions.elementsofprogramminginterviews;

import java.util.Collections;
import java.util.List;

public class EvenOdd {
    public void evenOdd(final List<Integer> arr) {
        int nextEven = 0;
        int nextOdd = arr.size() - 1;

        while(nextEven < nextOdd) {
            if (arr.get(nextEven) % 2 == 0) {
                nextEven++;
            } else {
                Collections.swap(arr, nextEven, nextOdd);
                nextOdd--;
            }
        }
    }
}

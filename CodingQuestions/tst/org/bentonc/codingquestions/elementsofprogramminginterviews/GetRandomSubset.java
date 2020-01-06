package org.bentonc.codingquestions.elementsofprogramminginterviews;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GetRandomSubset {
    private final Logger logger = LogManager.getLogger(GetRandomSubset.class);

   public List<Integer> randomSampling(int k, List<Integer> A) {
       Random rng = new Random();

       for (int i = 0; i < k; ++i) {
           // Generate a rnadom int in [i, A.size() - 1].
           Collections.swap(A, i, i + rng.nextInt(A.size() - i));
       }

       return A.subList(0, k);
   }
}

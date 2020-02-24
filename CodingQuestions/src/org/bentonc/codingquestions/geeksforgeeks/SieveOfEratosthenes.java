package org.bentonc.codingquestions.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    List<Integer> getPrimes(final int n) {
        List<Boolean> table = new ArrayList<Boolean>();

        for (int i = 0; i < n + 1; i++) {
            table.add(true);
        }

        for (int p = 2; p * p <= n; p++) {
            if (table.get(p))
            {
                for (int i = p * p; i <= n; i += p) {
                    table.set(i, false);
                }
            }
        }

        List<Integer> primes = new ArrayList<Integer>();

        // Print all table numbers
        for (int i = 2; i <= n; i++) {
            if (table.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }
}

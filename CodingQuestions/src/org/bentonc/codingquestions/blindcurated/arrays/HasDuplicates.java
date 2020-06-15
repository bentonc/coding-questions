package org.bentonc.codingquestions.blindcurated.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HasDuplicates {
    public boolean hasDuplicates(final List<Integer> list) {
        final Map<Integer, Boolean> seen = new HashMap<>();

        for (int i = 0; i < list.size(); ++i) {
            if (seen.containsKey(list.get(i))) {
                return true;
            }

            seen.put(list.get(i), true);
        }

        return false;
    }
}

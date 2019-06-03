package org.bentonc.codingquestions.crackingthecodinginterview;

public class RemoveDuplicates {
    public String removeDuplicates(String str) {
        char[] cstr = str.toCharArray();

        if (cstr == null) return new String();

        int len = cstr.length;

        if (len < 2) return str;

        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;

            for (j = 0; j < tail; ++j) {
                if (cstr[i] == cstr[j]) break;
            }

            if (j == tail) {
                cstr[tail] = cstr[i];
                ++tail;
            }
        }

        cstr[tail] = 0;

        return new String(cstr, 0, tail);
    }
}

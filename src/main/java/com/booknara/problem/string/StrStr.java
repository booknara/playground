package com.booknara.problem.string;

/**
 * 28. Implement strStr() (Easy)
 * https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        for(int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    // Java String::index method
    public int strStr1(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int sourceSize = haystack.length();
        int targetSize = needle.length();
        int max = sourceSize - targetSize;
        for (int i = 0; i <= max; i++) {
            while (i <= max && haystack.charAt(i) != needle.charAt(0)) {
                i++;
            }

            if (i <= max) {
                // already checked the first character matched
                int j = i + 1;
                int end = j + targetSize - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); k++, j++);

                if (j == end) return i;
            }
        }

        return -1;
    }
}

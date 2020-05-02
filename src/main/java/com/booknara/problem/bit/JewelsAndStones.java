package com.booknara.problem.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones (Easy)
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    // T: O(J.length + S.length), S: O(1)
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0) {
            // No jewel letters
            return 0;
        }

        long bitVector = 0;     // 64 bits can cover all the character bits(A(65)~Z(90), a(97)~z(122))
        // 65 ~ 122, total length is 122 - 65 + 1(inclusive) = 58
        long n = 1;
        for (char j: J.toCharArray()) {
            int pos = j - 'A';  // ASCII A(65)
            bitVector |= n << pos;
        }

        int res = 0;
        for (char s: S.toCharArray()) {
            int pos = s - 'A';  // ASCII A(65)
            if ((bitVector & (n << pos)) != 0) {
                res++;
            }
        }

        return res;
    }

    // T: O(J.length + S.length), S: O(J.length)
    public int numJewelsInStones1(String J, String S) {
        if (J == null || J.length() == 0) {
            // No jewel letters
            return 0;
        }

        Set<Character> set = new HashSet<>();
        for (char j: J.toCharArray()) {
            set.add(j);
        }

        int res = 0;
        for (char s: S.toCharArray()) {
            if (set.contains(s)) {
                res++;
            }
        }

        return res;
    }
}

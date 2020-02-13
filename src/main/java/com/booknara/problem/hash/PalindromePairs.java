package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String s = words[i] + words[j];
                String reversed = new StringBuilder(s).reverse().toString();
                if (s.equals(reversed)) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    ans.add(item);
                }
            }
        }

        return ans;
    }

    
}

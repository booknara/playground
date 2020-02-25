package com.booknara.problem.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet code: 93. Restore IP Addresses (Medium)
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return ans;
        }

        dfs(s, "", 0, 0, ans);
        return ans;
    }

    public void dfs(String input, String prefix, int index, int group, List<String> ans) {
        if (group > 4) {
            // Invalid result
            return;
        }

        if (group == 4 && index == input.length()) {
            ans.add(prefix);
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (index + i > input.length()) {
                break;
            }

            String s = input.substring(index, index + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }

            dfs(input, prefix + s + (group == 3 ? "" : "."), index + i, group + 1, ans);
        }
    }
}

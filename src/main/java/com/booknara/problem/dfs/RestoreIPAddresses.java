package com.booknara.problem.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses (Medium)
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

    public List<String> restoreIpAddressesFaster(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < 4 || s.length() > 12) {
            return ans;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l != s.length()) {
                            continue;
                        }

                        StringBuilder builder = new StringBuilder();
                        int n1 = Integer.parseInt(s.substring(0, i));
                        int n2 = Integer.parseInt(s.substring(i, i + j));
                        int n3 = Integer.parseInt(s.substring(i + j, i + j + k));
                        int n4 = Integer.parseInt(s.substring(i + j + k, i + j + k + l));
                        if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                            builder.append(n1)
                                    .append(".")
                                    .append(n2)
                                    .append(".")
                                    .append(n3)
                                    .append(".")
                                    .append(n4);
                            if (builder.length() == s.length() + 3) {
                                ans.add(builder.toString());
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

}

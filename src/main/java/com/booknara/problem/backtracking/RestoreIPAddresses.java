package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses (Medium)
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    // T:O(1), S:O(1)
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l != s.length()) {
                            continue;
                        }

                        int first = Integer.parseInt(s.substring(0, i));
                        int second = Integer.parseInt(s.substring(i, i + j));
                        int third = Integer.parseInt(s.substring(i + j, i + j + k));
                        int fourth = Integer.parseInt(s.substring(i + j + k, i + j + k + l));
                        if (first <= 255 &&
                                second <= 255 &&
                                third <= 255 &&
                                fourth <= 255) {
                            StringBuilder builder = new StringBuilder();
                            builder.append(first);
                            builder.append(".");
                            builder.append(second);
                            builder.append(".");
                            builder.append(third);
                            builder.append(".");
                            builder.append(fourth);

                            // Need to check again because of ""010010" -> 0.1.001.0 (incorrect case)
                            if (builder.length() == s.length() + 3) {
                                res.add(builder.toString());
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    // T:O(1), S:O(1)
    public List<String> restoreIpAddresses1(String s) {
        // input check, s only contains digits
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        // 4 groups, (each group can be up to 3 digits)
        int n = s.length();
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    for (int l = k + 1; l < k + 4; l++) {
                        if (i <= n && j <= n && k <= n && l <= n) {
                            int first = Integer.parseInt(s.substring(0, i));
                            int second = Integer.parseInt(s.substring(i, j));
                            int third = Integer.parseInt(s.substring(j, k));
                            int fourth = Integer.parseInt(s.substring(k, l));

                            if (!validRange(first)) continue;
                            if (!validRange(second)) continue;
                            if (!validRange(third)) continue;
                            if (!validRange(fourth)) continue;

                            StringBuilder builder = new StringBuilder();
                            builder.append(first).append(".")
                                    .append(second).append(".")
                                    .append(third).append(".")
                                    .append(fourth);
                            if (builder.length() != s.length() + 3) {
                                continue;
                            }

                            res.add(builder.toString());
                        }
                    }
                }
            }
        }

        return res;
    }

    public boolean validRange(int num) {
        return num >= 0 && num < 256;
    }
    /**
     ?.?.?.?
     ? = 0 ~ 255
     */
    // T:O(1), S:O(1)
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        dfs(s, "", 0, 0, res);
        return res;
    }

    private void dfs(String s, String prefix, int index, int group, List<String> res) {
        if (group > 4) return;

        if (index == s.length() && group == 4) {
            res.add(new String(prefix));
            return;
        }

        // a total of 4 group ip address
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) {
                break;
            }

            String ip = s.substring(index, index + i);
            // Check "0*" number and valid range
            if ((ip.startsWith("0") && ip.length() > 1) || Integer.parseInt(ip) > 255) {
                continue;
            }

            String newPrefix = prefix + ip + (group < 3 ? "." : "");

            dfs(s, newPrefix, index + i, group + 1, res);
        }
    }
}

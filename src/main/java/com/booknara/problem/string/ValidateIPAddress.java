package com.booknara.problem.string;

/**
 * 468. Validate IP Address (Medium)
 * https://leetcode.com/problems/validate-ip-address/
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";

        // edge case (ends with delimeters)
        if (IP.charAt(IP.length() - 1) == '.'
                || IP.charAt(IP.length() - 1) == ':') return "Neither";

        String[] array = IP.split("\\.");
        if (array.length == 4) {
            // checking IPv4, 4 groups
            return isIPv4(array);
        }

        array = IP.split("\\:");
        if (array.length == 8) {
            // checking IPv6, 8 groups
            return isIPv6(array);
        }

        return "Neither";
    }

    public String isIPv4 (String[] array) {
        for (int i = 0; i < 4; i++) {
            String s = array[i];
            try {
                int num = Integer.parseInt(s);
                // each group should be equal to or less than 3 digits and ranges btw 0 ~ 255
                // verify the length of input and interger has same length (e.g 01 -> 1, 001 -> 1)
                if (num < 0 || num >= 256 || s.length() != String.valueOf(num).length()) {
                    return "Neither";
                }
            } catch (Exception e) {
                return "Neither";
            }
        }

        return "IPv4";
    }

    public String isIPv6 (String[] array) {
        for (int i = 0; i < 8; i++) {
            String s = array[i];
            if (s.length() == 0 || s.length() > 4) {
                return "Neither";
            }
            // the length of each group should be equal to or less than 4 digit(not empty)
            // and each character should be 0 9 or A(a) ~ F(f)
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f')) {
                    continue;
                }

                return "Neither";
            }
        }

        return "IPv6";
    }

    // T:O(n), S:O(1)
    public String validIPAddress1(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";

        // input check
        // IP string only contains ., :, letter, digit
        if (IP.contains(".")) {
            return isIPv4(IP) ? "IPv4" : "Neither";
        }

        return isIPv6(IP) ? "IPv6" : "Neither";
    }

    // "172.16.254.1"
    public boolean isIPv4(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '.') count++;
        }
        if (count != 3) return false;

        String[] parts = s.split("\\.");
        if (parts.length != 4) return false;

        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (p.length() == 0 || p.length() > 3) return false;

            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                if (j == 0) {
                    if (c == '0' && p.length() > 1) return false; // leading zero
                }

                if (!Character.isDigit(c)) return false;
            }

            int num = Integer.parseInt(p);
            if (num < 0 || num > 255) return false;
        }

        return true;
    }

    public boolean isIPv6(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ':') count++;
        }
        if (count != 7) return false;

        String[] parts = s.split(":");
        if (parts.length != 8) return false;

        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (p.length() == 0 || p.length() > 4) return false;

            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                if (Character.isDigit(c)) continue;
                if (c >= 'a' && c <= 'f') continue;
                if (c >= 'A' && c <= 'F') continue;

                return false;
            }
        }

        return true;
    }
}

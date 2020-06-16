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
}

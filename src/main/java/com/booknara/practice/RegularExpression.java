package com.booknara.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static boolean isValidMessage(String message, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(message).matches();
    }

    public static String extractCode(String message, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(message);
        return matcher.find() ? matcher.group(0) : "";
    }
}

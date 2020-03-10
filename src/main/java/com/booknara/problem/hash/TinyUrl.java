package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL (Medium)
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class TinyUrl {
    private static final String PREFIX = "http://tinyurl.com/";

    Map<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(longUrl.hashCode());
        map.put(key, longUrl);
        return PREFIX + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.substring(PREFIX.length()));
    }
}

package com.booknara.problem.hash;

import java.util.*;

/**
 * 1152. Analyze User Website Visit Pattern (Medium)
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/
 */
public class AnalyzeUserWebsiteVisitPattern {
    // T:O(n^3), S:O(n)
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // username - website - timestamp (ascending based on timestamp)

        List<Visit> tracking = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            tracking.add(new Visit(username[i], timestamp[i], website[i]));
        }

        // Sort by timestamp (time ascending)
        tracking.sort(Comparator.comparingInt(v -> v.timestamp));

        Map<String, List<String>> map = new HashMap<>();
        for (Visit v: tracking) {
            map.putIfAbsent(v.username, new ArrayList<>());
            map.get(v.username).add(v.website);
        }

        Map<List<String>, Integer> count = new HashMap<>();
        for (List<String> w: map.values()) {
            if (w.size() < 3) continue;

            Set<List<String>> set = generateThreeSeq(w);
            for (List<String> seq: set) {
                count.putIfAbsent(seq, 0);
                count.put(seq, count.get(seq) + 1);
            }
        }

        List<String> res = new ArrayList<>();
        int max = 0;
        for (Map.Entry<List<String>, Integer> entry: count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            } else if (entry.getValue() == max) {
                // String a = entry.getKey().toString();
                // String b = res.toString();
                // System.out.println(a);
                // System.out.println(b);
                if (entry.getKey().toString().compareTo(res.toString()) < 0) {
                    res = entry.getKey();
                }
            }
        }

        return res;
    }

    public Set<List<String>> generateThreeSeq(List<String> list) {
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    set.add(Arrays.asList(list.get(i), list.get(j), list.get(k)));
                }
            }
        }

        return set;
    }

    class Visit {
        String username;
        int timestamp;
        String website;

        Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }

        @Override
        public String toString() {
            return "Visit{" +
                    "username='" + username + '\'' +
                    ", timestamp=" + timestamp +
                    ", website='" + website + '\'' +
                    '}';
        }

    }
}

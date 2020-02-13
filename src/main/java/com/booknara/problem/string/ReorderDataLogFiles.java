package com.booknara.problem.string;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorderDataLogFiles {
    class Pair {
        String id;
        String log;
        String origin;

        public Pair(String id, String log, String origin) {
            this.id = id;
            this.log = log;
            this.origin = origin;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return null;
        }

        PriorityQueue<Pair> p = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (Character.isDigit(o1.log.charAt(0))) {
                    StringBuilder builder = new StringBuilder();
                    for (char c: o1.log.toCharArray()) {
                        builder.append(c + 'z');
                    }
                    o1.log = builder.toString();
                }

                if (Character.isDigit(o2.log.charAt(0))) {
                    StringBuilder builder = new StringBuilder();
                    for (char c: o2.log.toCharArray()) {
                        builder.append(c + 'z');
                    }
                    o2.log = builder.toString();
                }

                return o1.log.compareTo(o2.log) == 0 ?
                        o1.id.compareTo(o2.id) : o1.log.compareTo(o1.log);
            }
        });

        for (String s: logs) {
            // System.out.println(s);
            String[] pair = s.split(" ", 2);
            //System.out.println(pair[0] + "," + pair[1]);
            p.add(new Pair(pair[0], pair[1].replaceAll("\\s+", ""), s));
        }

        String[] ans = new String[logs.length];
        int i = 0;
        while (!p.isEmpty()) {
            ans[i++] = p.poll().origin;
        }

        return ans;
    }
}

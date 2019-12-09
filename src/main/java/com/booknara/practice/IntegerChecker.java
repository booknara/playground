package com.booknara.practice;

public class IntegerChecker {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = Integer.valueOf(100);
        System.out.println(a == b);
        System.out.println(a.intValue() == b.intValue());
        System.out.println(a.equals(b));

        Integer c = Integer.valueOf(150);
        Integer d = Integer.valueOf(150);
        System.out.println(c == d);     // Don't be surprise (Check the source code, http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/lang/Integer.java)
        System.out.println(c.intValue() == d.intValue());
        System.out.println(c.equals(d));
    }
}

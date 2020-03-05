package com.booknara.practice.collection;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreeMapTest {

    @Test
    public void test_integer_key_natural_order() {
        System.out.println("test_integer_key_natural_order");
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(1, 1);
        System.out.println(map);
        map.put(2, 1);
        System.out.println(map);
        map.put(5, 1);
        System.out.println(map);
        map.put(3, 1);
        System.out.println(map);
        map.put(4, 1);
        System.out.println(map);
        map.put(-1, 1);
        System.out.println(map);
    }

    @Test
    public void test_string_key_natural_order() {
        System.out.println("test_string_key_natural_order");
        Map<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        System.out.println(map);
        map.put("z", 1);
        System.out.println(map);
        map.put("x", 1);
        System.out.println(map);
        map.put("ab", 1);
        System.out.println(map);
        map.put("b", 1);
        System.out.println(map);
        map.put("1", 1);
        System.out.println(map);
    }

    @Test
    public void test_string_key_reverse_order() {
        System.out.println("test_string_key_reverse_order");
        Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put("a", 1);
        System.out.println(map);
        map.put("z", 1);
        System.out.println(map);
        map.put("x", 1);
        System.out.println(map);
        map.put("ab", 1);
        System.out.println(map);
        map.put("b", 1);
        System.out.println(map);
        map.put("1", 1);
        System.out.println(map);
    }
}

package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// TODO HashMap + Doubly LinkedList
public class LRUCache2 {
    class Element {
        int key;
        int value;
        Element(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Integer> map;
    LinkedList<Element> list;
    int capacity;

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            list.remove(new Element(key, value));
            list.add(new Element(key, value));

            return value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (list.size() == this.capacity) {
            Element first = list.remove();
            map.remove(first.key);
        }

        if (map.containsKey(key)) {
            int v = map.get(key);
            Element e = new Element(key, v);
            list.remove(e);
        }

        list.add(new Element(key, value));
        map.put(key, value);
    }
}

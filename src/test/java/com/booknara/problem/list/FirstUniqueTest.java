package com.booknara.problem.list;

import org.junit.Test;

public class FirstUniqueTest {
    // ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
    //[[[2,3,5]],[],[5],[],[2],[],[3],[]]
    @Test
    public void test() {
        FirstUnique firstUnique = new FirstUnique(new int[] {2,3,5});
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }
}

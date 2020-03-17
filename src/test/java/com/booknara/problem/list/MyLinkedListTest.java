package com.booknara.problem.list;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {
    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        Assert.assertEquals(2, myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        Assert.assertEquals(3, myLinkedList.get(1));
    }

    @Test
    public void test1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        Assert.assertEquals(2, myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        Assert.assertEquals(2, myLinkedList.get(0));
    }

    @Test
    public void test2() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        Assert.assertEquals(2, myLinkedList.get(5));

        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
}

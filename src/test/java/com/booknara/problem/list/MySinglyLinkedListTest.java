package com.booknara.problem.list;

import org.junit.Assert;
import org.junit.Test;

public class MySinglyLinkedListTest {
    @Test
    public void test() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        mySinglyLinkedList.addAtHead(1);
        mySinglyLinkedList.addAtTail(3);
        mySinglyLinkedList.addAtIndex(1, 2);
        Assert.assertEquals(2, mySinglyLinkedList.get(1));
        mySinglyLinkedList.deleteAtIndex(1);
        Assert.assertEquals(3, mySinglyLinkedList.get(1));
    }

    @Test
    public void test1() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        mySinglyLinkedList.addAtHead(1);
        mySinglyLinkedList.addAtTail(3);
        mySinglyLinkedList.addAtIndex(1, 2);
        Assert.assertEquals(2, mySinglyLinkedList.get(1));
        mySinglyLinkedList.deleteAtIndex(0);
        Assert.assertEquals(2, mySinglyLinkedList.get(0));
    }

    @Test
    public void test2() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        mySinglyLinkedList.addAtHead(2);
        mySinglyLinkedList.deleteAtIndex(1);
        mySinglyLinkedList.addAtHead(2);
        mySinglyLinkedList.addAtHead(7);
        mySinglyLinkedList.addAtHead(3);
        mySinglyLinkedList.addAtHead(2);
        mySinglyLinkedList.addAtHead(5);
        mySinglyLinkedList.addAtTail(5);
        Assert.assertEquals(2, mySinglyLinkedList.get(5));

        mySinglyLinkedList.deleteAtIndex(6);
        mySinglyLinkedList.deleteAtIndex(4);
    }
}

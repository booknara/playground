package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {
    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(-10);
        stack.push(14);
        Assert.assertEquals(-10, stack.getMin());
        Assert.assertEquals(-10, stack.getMin());
        stack.push(-20);
        Assert.assertEquals(-20, stack.getMin());
        Assert.assertEquals(-20, stack.getMin());

        Assert.assertEquals(-20, stack.top());
        Assert.assertEquals(-20, stack.getMin());

        stack.pop();
        stack.push(10);
        stack.push(-7);
        Assert.assertEquals(-10, stack.getMin());
        stack.push(-7);
        stack.pop();
        Assert.assertEquals(-7, stack.top());
        Assert.assertEquals(-10, stack.getMin());
        stack.pop();
//        ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
//        [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
//
//
//        [null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-10,null,null,-7,-10,null]
    }
}

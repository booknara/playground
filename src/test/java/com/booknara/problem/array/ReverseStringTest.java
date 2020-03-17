package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {
    @Test
    public void reverseString() {
        ReverseString reverseString = new ReverseString();
        char[] input = new char[] {'h', 'e', 'l', 'l', 'o'};
        char[] output = new char[] {'o', 'l', 'l', 'e', 'h'};
        reverseString.reverseString(input);
        Assert.assertArrayEquals(output, input);
    }
}

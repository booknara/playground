package com.booknara.practice;

import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionTest {
    @Test
    public void isValidMessage() {
        String regex = "\\b\\d{6}\\b is your two-factor authentication token.";
        Assert.assertTrue(RegularExpression.isValidMessage("123456 is your two-factor authentication token.", regex));
        Assert.assertFalse(RegularExpression.isValidMessage("123456", regex));
        Assert.assertFalse(RegularExpression.isValidMessage("1234567 is your two-factor authentication token.", regex));
    }

    @Test
    public void extractCode() {
        String regex = "\\b\\d{6}\\b";
        Assert.assertEquals("123456", RegularExpression.extractCode("123456 is your two-factor authentication token.", regex));
        Assert.assertEquals("", RegularExpression.extractCode("1234567 is your two-factor authentication token.", regex));
    }
}

package com.booknara.problem.string;

import org.junit.Assert;
import org.junit.Test;

public class ValidateIPAddressTest {
    @Test
    public void validIPAddress() {
        ValidateIPAddress validateIPAddress = new ValidateIPAddress();
        Assert.assertEquals("Neither", validateIPAddress.validIPAddress("1e1.16.254.1"));
        Assert.assertEquals("IPv6", validateIPAddress.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        Assert.assertEquals("Neither", validateIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}

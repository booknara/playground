package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class FibonacciTest {
    @Test
    public void fib1Test() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(f.fib1(0),0);
        Assert.assertEquals(f.fib1(3),2);
        Assert.assertEquals(f.fib1(4),3);
        Assert.assertEquals(f.fib1(5),5);
        Assert.assertEquals(f.fib1(10),55);
        Assert.assertEquals(f.fib1(30),832040);
        //Assert.assertEquals(f.fib1(100),24278230);
    }

    @Test
    public void fib2Test() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(f.fib2(0),0);
        Assert.assertEquals(f.fib2(3),2);
        Assert.assertEquals(f.fib2(4),3);
        Assert.assertEquals(f.fib2(5),5);
        Assert.assertEquals(f.fib2(10),55);
        Assert.assertEquals(f.fib2(30),832040);
        //Assert.assertEquals(f.fib2(100),24278230);
    }

    @Test
    public void fib3Test() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(f.fib3(0),0);
        Assert.assertEquals(f.fib3(3),2);
        Assert.assertEquals(f.fib3(4),3);
        Assert.assertEquals(f.fib3(5),5);
        Assert.assertEquals(f.fib3(10),55);
        Assert.assertEquals(f.fib3(30),832040);
        //Assert.assertEquals(f.fib3(100),24278230);
    }

    @Test
    public void fib4Test() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(f.fib4(0),0);
        Assert.assertEquals(f.fib4(3),2);
        Assert.assertEquals(f.fib4(4),3);
        Assert.assertEquals(f.fib4(5),5);
        Assert.assertEquals(f.fib4(10),55);
        Assert.assertEquals(f.fib4(30),832040);
        //Assert.assertEquals(f.fib4(100),24278230);
    }

    @Test
    public void fib5Test() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(f.fib5(0),BigInteger.valueOf(0));
        Assert.assertEquals(f.fib5(3), BigInteger.valueOf(2));
        Assert.assertEquals(f.fib5(4), BigInteger.valueOf(3));
        Assert.assertEquals(f.fib5(5), BigInteger.valueOf(5));
        Assert.assertEquals(f.fib5(10), BigInteger.valueOf(55));
        Assert.assertEquals(f.fib5(30), BigInteger.valueOf(832040));
        BigInteger v = f.fib5(100).mod(BigInteger.valueOf((int)Math.pow(10, 8) + 7));
        Assert.assertEquals(v,BigInteger.valueOf(24278230));
        Assert.assertEquals(f.fib5(300), new BigInteger("222232244629420445529739893461909967206666939096499764990979600"));
    }

    @Test
    public void fib6Test() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(f.fib6(0),0);
        Assert.assertEquals(f.fib6(3),2);
        Assert.assertEquals(f.fib6(4),3);
        Assert.assertEquals(f.fib6(5),5);
        Assert.assertEquals(f.fib6(10),55);
        Assert.assertEquals(f.fib6(30),832040);
    }
}

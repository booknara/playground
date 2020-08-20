package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeBuySellStockTransactionFeeTest {
    @Test
    public void maxProfit() {
        BestTimeBuySellStockTransactionFee bestTimeBuySellStockTransactionFee
                = new BestTimeBuySellStockTransactionFee();
        Assert.assertEquals(8, bestTimeBuySellStockTransactionFee.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        Assert.assertEquals(5, bestTimeBuySellStockTransactionFee.maxProfit(new int[]{1,3,2,8}, 2));
    }
}

package com.rs.neatcode.slidingwindow

class Stocks {

    // Complexity = N^2
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for(i in 0 until prices.size - 1) {
            var r = i + 1
            while(r < prices.size && prices[i] < prices[r]) {
                var profit = prices[r] - prices[i]
                if(maxProfit < profit) {
                    maxProfit = profit
                }
                r++
            }
        }
        return maxProfit
    }


    fun maxProfit2(prices: IntArray): Int {
        var min = Integer.MAX_VALUE
        var profit = 0
        for (p in prices) {
            min = Math.min(min, p)
            profit = Math.max(profit, p - min)
        }
        return profit
    }

}
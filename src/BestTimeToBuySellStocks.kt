class BestTimeToBuySellStocks {

    fun maxProfit(prices: IntArray): Int {

        var profitSoFar = 0

        for (i in prices.indices) {
            for (j in i + 1 until prices.size) {
                if (profitSoFar < prices[j] - prices[i]) {
                    profitSoFar = prices[j] - prices[i]
                }
            }
        }

        return profitSoFar

    }

    fun maxProfit2(prices: IntArray): Int {

        var maxProfit = 0
        var minPrice = Integer.MAX_VALUE

        for (p in prices) {
            minPrice = p.coerceAtMost(minPrice)
            maxProfit = maxProfit.coerceAtLeast(p - minPrice)

        }

        return maxProfit
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

    fun maxProfit3(prices: IntArray): Int {

        var maxProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1]
            }
        }
        return maxProfit

    }
}

fun main() {
    println(BestTimeToBuySellStocks().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(BestTimeToBuySellStocks().maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(BestTimeToBuySellStocks().maxProfit3(intArrayOf(7, 1, 5, 3, 6, 4)))
}

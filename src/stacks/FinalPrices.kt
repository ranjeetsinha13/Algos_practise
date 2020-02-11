package stacks

import kotlin.math.min

class FinalPrices {
    fun finalPrices(prices: IntArray): IntArray {
        var result = IntArray(prices.size)
        for (i in 0..prices.size - 2) {
            var minIndex = Int.MAX_VALUE
            for (j in (i + 1) until prices.size) {
                if (prices[j] <= prices[i]) {
                    minIndex = Math.min(minIndex, j)
                }
            }
            result[i] = prices[i] - if (minIndex < prices.size) prices[minIndex] else 0
        }
        result[prices.size - 1] = prices[prices.size - 1]
        return result
    }
}

fun main() {
    println(FinalPrices().finalPrices(intArrayOf(10, 1, 1, 6)).contentToString())
}
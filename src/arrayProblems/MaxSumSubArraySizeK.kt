package arrayProblems

import java.lang.IllegalArgumentException

class MaxSumSubArraySizeK {

    fun maxSumSubArraySizeK(arr: IntArray, K: Int): Int {
        if(arr.size < K) throw IllegalArgumentException("array size less than $K")
        var start = 0
        var windowSum = 0
        var maxSum = 0
        for (i in arr.indices) {
            windowSum += arr[i]
            if (i >= K - 1) {
                maxSum = Math.max(maxSum, windowSum)
                windowSum -= arr[start]
                start++
            }
        }
        return maxSum
    }

    fun smallestSubArrayWithAGivenSum(arr: IntArray, s: Int): Int {
        var start = 0
        var sum =0
        var result = Integer.MAX_VALUE
        for (i in arr.indices) {
            sum += arr[i]
            while (sum >= s) {
                result = Math.min(result, i - start + 1)
                sum -= arr[start++]
            }
        }
        return result
    }
    
 }

fun main() {
    println(MaxSumSubArraySizeK().maxSumSubArraySizeK(intArrayOf(2, 1, 5, 1, 3, 2), 3))
    println(MaxSumSubArraySizeK().maxSumSubArraySizeK(intArrayOf(2, 3, 4, 1, 5 ), 2))
    println(MaxSumSubArraySizeK().smallestSubArrayWithAGivenSum(intArrayOf(2, 1, 5, 2, 8), 8))
    println(MaxSumSubArraySizeK().smallestSubArrayWithAGivenSum(intArrayOf(2, 1, 5, 2, 3, 2), 7))
}
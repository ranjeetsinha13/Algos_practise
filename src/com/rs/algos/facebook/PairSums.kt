package com.rs.facebook

class PairSums {
    // Time complexity O(N^2)
    fun numberOfWays(arr: Array<Int>, k: Int): Int {
        // Write your code here
        var count = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] + arr[j] == k) {
                    count++
                }
            }
        }

        return count
    }

    fun numberOfWaysEfficient(arr: Array<Int>, k: Int): Int {
        // Write your code here
        var count = 0
        val frequencyMap = hashMapOf<Int, Int>()
        for (i in arr.indices) {
            // The element is already visited
            if (frequencyMap.contains(k - arr[i])) {
                count++
            } else {
                frequencyMap[arr[i]] = frequencyMap.getOrDefault(arr[i], 0) + 1
            }
        }

        return count
    }

}

fun main() {
    println(PairSums().numberOfWays(arrayOf(1, 2, 3, 4, 3), 6))
    println(PairSums().numberOfWaysEfficient(arrayOf(1, 2, 3, 4, 3), 6))
}
package com.rs.neatcode.arrays

class LongestConsequetiveSequence {

    // Time complexity O(N)
    fun longestConsecutive(nums: IntArray): Int {

        var set = mutableSetOf<Int>()
        for (i in nums.indices) {
            set.add(nums[i])
        }

        var count = 0
        for (num in set) {
            if (!set.contains(num - 1)) {
                var currentCount = 1
                var temp = num + 1
                while (set.contains(temp++)) {
                    currentCount++
                }
                count = Math.max(count, currentCount)
            }
        }
        return count
    }
}

fun main() {
    println(LongestConsequetiveSequence().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(LongestConsequetiveSequence().longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
}
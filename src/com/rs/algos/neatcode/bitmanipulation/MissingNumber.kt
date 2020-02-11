package com.rs.neatcode.bitmanipulation

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val size = nums.size
        var i = 0
        while (i < size) {
            while (nums[i] != i  && nums[i] < size) {
                // Swap the numbers so that nums[i] = i
                val temp = nums[i]
                nums[i] = nums[temp]
                nums[temp] = temp
            }
            i++
        }
        for (index in nums.indices) {
            if (nums[index] != index) return index
        }
        return size
    }
}

fun main() {
    println(MissingNumber().missingNumber(intArrayOf(6, 5, 4, 3, 2, 0)))
}
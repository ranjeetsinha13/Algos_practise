package com.rs.neatcode.twopointers

class TwoSum {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1
        while (left < right) {
            if (target == numbers[right] + numbers[left]) {
                return intArrayOf(left + 1, right + 1)
            } else if (target < numbers[right] + numbers[left]) {
                right--
            } else {
                left++
            }
        }
        return intArrayOf()
    }
}
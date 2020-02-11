package com.rs.neatcode.arrays

class ProductExceptSelf {
    // Complexity O(n^2)
    fun productExceptSelf(nums: IntArray): IntArray {
        Integer.MIN_VALUE
        var result = IntArray(nums.size)
        for (i in nums.indices) {
            result[i] = 1
            for (j in 0 until i) {
                result[i] *= nums[j]
            }
            for (k in i + 1 until nums.size) {
                result[i] *= nums[k]
            }

        }
        return result
    }
}
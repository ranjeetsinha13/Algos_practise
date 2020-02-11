package com.rs.neatcode.arrays

//https://leetcode.com/problems/contains-duplicate/description/
// NeetCode 150 problem 1
// space complexity O(N)
// Time complexity O(N)
// TODO  Understand the internal working of hashSet to understand the complexity of this problem better
class CheckDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashSet = mutableSetOf<Int>()
        for (num in nums) {
            if (hashSet.contains(num))
                return true
            else
                hashSet.add(num)
        }
        return false
    }
}
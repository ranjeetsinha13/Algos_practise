package com.rs.algos

class BinarySearch {

    fun binarySearch(nums: IntArray, item: Int): Int {
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == item)
                return mid
            else if (nums[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return -1
    }

    fun binarySearchRecursive(nums: IntArray, item: Int, start: Int, end: Int): Int {
        if (end >= start) {
            val mid = (start + end) / 2
            return if (nums[mid] == item)
                mid
            else if (nums[mid] < item) {
                binarySearchRecursive(nums, item, mid + 1, end)
            } else {
                binarySearchRecursive(nums, item, start, mid - 1)
            }
        }
        return -1
    }

    fun binarySearchInfiniteArray(nums: IntArray, item: Int): Int {
        var value = nums[0]
        var start = 0
        var end = 1
        while (value < item) {
            start = end
            if (2 * end < nums.size - 1)
                end *= 2
            else
                end = nums.size - 1
            value = nums[end]
        }
        return binarySearchRecursive(nums, item, start, end)
    }
}


fun main() {
    println(BinarySearch().binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 7))
    println(BinarySearch().binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
    println(BinarySearch().binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 1))

    println(BinarySearch().binarySearchRecursive(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 7, 0, 8))
    println(BinarySearch().binarySearchRecursive(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5, 0, 8))
    println(BinarySearch().binarySearchRecursive(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 1, 0, 8))

}
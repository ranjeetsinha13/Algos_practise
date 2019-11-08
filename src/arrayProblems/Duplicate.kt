package arrayProblems

class Duplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()

        print(nums.contentToString())
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) return true
        }
        return false
    }

    //https://leetcode.com/problems/product-of-array-except-self/

    fun productExceptSelf(nums: IntArray): IntArray {

        // [1,2,3,4]
        var result = IntArray(nums.size) { 1 }

        var temp = 1

        for (i in 1 until nums.size) {
            result[i] = nums[i - 1] * result[i - 1]
        }

        temp = nums[nums.size - 1]
        for (i in nums.size - 2 downTo 0) {
            result[i] *= temp
            temp *= nums[i]
        }

        return result

    }

}

fun main() {

    println(Duplicate().containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(Duplicate().productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString())

}
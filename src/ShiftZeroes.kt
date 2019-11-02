//https://leetcode.com/problems/move-zeroes/

class ShiftZeroes {

    fun moveZeroes(nums: IntArray) {
        var lastZeroFound = 0

        for (i in nums.indices) {

            if (nums[i] != 0) {
                nums[i] = nums[lastZeroFound].also { nums[lastZeroFound] = nums[i] }
                lastZeroFound++
            }
        }

        print(nums.contentToString())


    }

}

fun main() {
    ShiftZeroes().moveZeroes(intArrayOf(0, 1, 0, 3, 12))

}
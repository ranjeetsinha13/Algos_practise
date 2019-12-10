package arrayProblems

class SortColors {
    // https://leetcode.com/problems/sort-colors/

    fun sortColors(nums: IntArray): Unit {

        var nums = nums
        var p0 = 0
        var curr = 0
        var p2 = nums.size - 1

        while (curr <= p2) {

            when {
                nums[curr] == 0 -> {
                    nums[p0] = nums[curr].also { nums[curr] = nums[p0] }
                    p0++
                    curr++
                }
                nums[curr] == 2 -> {
                    nums[p2] = nums[curr].also { nums[curr] = nums[p2] }
                    p2--
                }
                else -> curr++
            }
        }

    }
}

fun main() {
    SortColors().sortColors(intArrayOf(2, 0, 2, 1, 1, 0))
}
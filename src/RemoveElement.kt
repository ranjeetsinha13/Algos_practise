import java.util.*

//https://leetcode.com/problems/remove-element/
class RemoveElement {

    fun removeElement(nums: IntArray, elemToRemove: Int): Int {

        var indexToRemove = 0
        for (i in nums.indices) {
            if (nums[i] != elemToRemove) {
                nums[i] = nums[indexToRemove].also { nums[indexToRemove] = nums[i] }
                indexToRemove++
            }
        }

        for (i in nums.indices) {
            if (nums[i] == elemToRemove) {
                return i
            }
        }

        return nums.size

    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        for (j in 1 until nums.size) {
            if (nums[i] != nums[j]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1

    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/


    fun removeDuplicates2(nums: IntArray): Int {
        var i = 1
        var count = 1
        for (j in 1 until nums.size) {
            if (nums[j] == nums[j - 1]) {
                count++
            } else {
                count = 1
            }

            if (count <= 2) {
                nums[i++] = nums[j]
            }

        }
        return i

    }


}


fun main() {

    println(RemoveElement().removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
    println(RemoveElement().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    println(RemoveElement().removeDuplicates2(intArrayOf(1, 1, 1, 2, 2, 3)))

}
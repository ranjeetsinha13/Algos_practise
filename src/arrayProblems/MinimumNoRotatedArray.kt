package arrayProblems

class MinimumNoRotatedArray {
    fun findMin(nums: IntArray): Int {

        if (nums.size == 1) return nums[0]

        var left = 0
        var right = nums.size - 1

        if (nums[left] < nums[right]) {
            // no rotation
            return nums[left]
        }

        while (left <= right) {

            var mid = left + (right - left) / 2

            if (nums[mid] > nums[mid + 1]) {

                return nums[mid + 1]

            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid]
            }

            if (nums[mid] > nums[0]) {
                left++
            } else {
                right--
            }

        }

        return -1

    }
}

fun main() {

}
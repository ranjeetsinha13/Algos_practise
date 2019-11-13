package arrayProblems

import java.util.*
import kotlin.collections.HashMap

class MajorityElement {


    fun majorityElement(nums: IntArray): Int {


        var maj = nums[0]
        var count = 0

        for (n in nums) {

            if (count == 0) {
                maj = n
            }

            if (maj == n) count += 1 else count -= 1

        }

        return maj

    }

    //https://leetcode.com/problems/majority-element-ii/

    fun majorityElement2(nums: IntArray): List<Int> {

        var list = mutableSetOf<Int>()
        Arrays.sort(nums)

        if (nums.isEmpty()) return emptyList()

        var count = 0

        var num = nums[0]

        for (i in nums.indices) {
            if (num == nums[i]) {
                count++
            } else {
                count = 1
                num = nums[i]
            }

            if (count > nums.size / 3) {
                list.add(nums[i])
            }
        }

        return list.toList()

    }

    // https://leetcode.com/problems/two-sum/

    fun twoSum(nums: IntArray, target: Int): IntArray {

        var col = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (col.containsKey(nums[i])) {
                return intArrayOf(i, col[nums[i]]!!)
            } else {
                col[target - nums[i]] = i
            }

        }
        return intArrayOf(-1, -1)

    }

    //https://leetcode.com/problems/container-with-most-water/solution/

    fun maxArea(height: IntArray): Int {

        var left = 0
        var right = height.size - 1
        var area = 0
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left))

            if (height[left] < height[right]) left++ else right--
        }
        return area

    }

    //https://leetcode.com/problems/trapping-rain-water/

    fun trap(height: IntArray): Int {

        var leftMax = Int.MIN_VALUE
        var rightMax = Int.MIN_VALUE
        var left = 0
        var right = height.size - 1
        var ans = 0

        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left]
            if (height[right] > rightMax) rightMax = height[right]
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax - height[left])
                left++
            } else {
                ans += Math.max(
                    0, rightMax - height[right]
                )
                right--
            }


        }
        return ans


    }

}


fun main() {

    println(MajorityElement().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    println(MajorityElement().majorityElement2(intArrayOf(1, 1, 1, 3, 3, 2, 2, 2)))
    println(MajorityElement().twoSum(intArrayOf(3, 2, 4), 6).contentToString())
    println(MajorityElement().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(MajorityElement().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))

}
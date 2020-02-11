package hashing

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

class TwoSumArray {

    fun twoSum(nums: IntArray, target: Int): IntArray? {

        val sumHash = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]
            if (sumHash.containsKey(complement)) {
                return sumHash[complement]?.let { intArrayOf(it, i) }
            }
            sumHash[nums[i]] = i
        }

        throw IllegalArgumentException()

    }


}

fun main() {

    println(TwoSumArray().twoSum(intArrayOf(5, 6, 3, 2, 1), 5)?.contentToString())
}
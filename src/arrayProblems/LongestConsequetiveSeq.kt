package arrayProblems

import java.util.*
import kotlin.collections.HashSet


class LongestConsequetiveSeq {
    fun longestConsecutive(nums: IntArray): Int {

        val numSet = HashSet(nums.asList())
        var maxCount = 0
        for (n in numSet) {
            var countSoFar = 0
            var num = n
            while (num in numSet) {
                num++
                countSoFar++
            }
            if (countSoFar >= maxCount) {
                maxCount = countSoFar
            }
        }
        return maxCount
    }
}

fun main() {

    println(LongestConsequetiveSeq().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))

}
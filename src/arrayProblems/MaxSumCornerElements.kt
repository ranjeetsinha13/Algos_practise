package arrayProblems

/**
 * https://www.interviewbit.com/problems/pick-from-both-sides/
 */
class MaxSumCornerElements {

    fun maxSumCornerElements(arr: IntArray, k: Int): Int {
        var end = arr.size - 1
        var sumSoFar = 0
        for (i in 0 until k) {
            sumSoFar += arr[i]
        }
        var maxSum = sumSoFar

        for (i in k - 1 downTo 0) {
            sumSoFar = sumSoFar - arr[i] + arr[end]
            maxSum = Math.max(maxSum, sumSoFar)
            end--
        }
        return maxSum
    }
}

fun main() {
    println(MaxSumCornerElements().maxSumCornerElements(intArrayOf(8, 4, 4, 8, 12, 3, 2, 9), 3))
}
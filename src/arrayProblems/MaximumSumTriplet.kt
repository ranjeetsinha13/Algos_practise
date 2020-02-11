package arrayProblems

class MaximumSumTriplet {
    fun maximumSumTriplet(array: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        for (i in 0 until array.size) {
            for (j in i + 1 until array.size) {
                for (k in j + 1 until array.size) {
                    if (i < j && j < k && array[i] < array[j] && array[j] < array[k]) {
                        maxSum = Math.max(array[i] + array[j] + array[k], maxSum)
                    }
                }
            }
        }
        return maxSum
    }
}

fun main() {
    println(MaximumSumTriplet().maximumSumTriplet(intArrayOf(2, 5, 3, 1, 4, 9)))
}
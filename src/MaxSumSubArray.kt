import java.util.*

class MaxSumSubArray {

    fun maxSumSubArray(A: IntArray): Int {

        var maxSoFar = Integer.MIN_VALUE
        var maxEndingHere = 0

        for (i in A) {
            maxEndingHere += i

            maxSoFar = maxEndingHere.coerceAtLeast(maxSoFar)

            maxEndingHere = 0.coerceAtLeast(maxEndingHere)

            Arrays.sort(A)

        }

        return maxSoFar
    }
}



fun main() {

    println(MaxSumSubArray().maxSumSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))

}
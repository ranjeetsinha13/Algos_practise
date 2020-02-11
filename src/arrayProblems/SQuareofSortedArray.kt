package arrayProblems

class SQuareofSortedArray {

    fun sortedSquares(A: IntArray): IntArray {
        var result = IntArray(A.size)
        var left = 0
        var right = 0
        for (i in A.indices) {
            if (A[i] >= 0) {
                left = i - 1
                right = i
                break
            }
        }

        var i = 0
        while (left >= 0 && right < A.size) {
            val r = A[right] * A[right]
            val l = A[left] * A[left]
            if (l > r) {
                result[i++] = r
                right++
            } else {
                result[i++] = l
                left--
            }
        }

        // Copy the remaining elements
        while (right < A.size && i < A.size) {
            result[i++] = A[right] * A[right]
            right++
        }
        while (left >= 0 && i < A.size) {
            result[i++] = A[left] * A[left]
            left--
        }

        return result
    }
}

fun main() {
    println(SQuareofSortedArray().sortedSquares(intArrayOf(-3)).contentToString())
}
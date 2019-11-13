class SQuareofSortedArray {

    fun sortedSquares(A: IntArray): IntArray {

        var sq = IntArray(A.size) { -1 }

        var j = 0
        while (j < A.size && A[j] < 0) {
            j++
        }

        var i = j - 1

        var t = 0

        while (i >= 0 && j < A.size) {
            if (A[i] * A[i] < A[j] * A[j]) {
                sq[t++] = A[i] * A[i]
                i--
            } else {
                sq[t++] = A[j] * A[j]
                j++
            }
        }

        while (j < A.size) {
            sq[t++] = A[j] * A[j]
            j++
        }

        while (i >= 0) {
            sq[t++] = A[i] * A[i]
            i--
        }
        return sq

    }
}

fun main() {
    println(SQuareofSortedArray().sortedSquares(intArrayOf(-3, -2, -1, 4, 5, 6)).contentToString())
}
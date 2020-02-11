package arrayProblems

class MinNumberOfLights {
    fun minNumberOfLights(A: IntArray, B: Int): Int {
        var i = 0
        var result = 0
        while (i < A.size) {
            var j = i + B - 1
            // traverse in reverse from i + B - 1 to find the position where light can be turned on.
            while (j >= 0 && A[j] != 1 && j >= i - B + 1) j--
            if (j >= 0 && j != i - B && A[j] == 1) {
                result++
                i = j + B
            } else return -1
        }
        return result
    }
}

fun main() {
    println(MinNumberOfLights().minNumberOfLights(intArrayOf(0, 0, 1, 1, 1, 0, 0, 1), 3))
    println(MinNumberOfLights().minNumberOfLights(intArrayOf(0, 0, 0, 1, 0), 3))
}
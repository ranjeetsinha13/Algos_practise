package arrayProblems

fun threeConsecutiveOdds(arr: IntArray): Boolean {

    for (i in 0 until arr.size - 2) {
        if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
            return true
        }
    }
    return false
}

fun main() {
    println(threeConsecutiveOdds(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)))
}
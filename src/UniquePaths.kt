class UniquePaths {

    fun uniquePaths(m: Int, n: Int): Int {
        var arr = Array(m) { Array(n) { 0 } }


        for (i in 0 until m) {
            arr[i][0] = 1
        }

        for (j in 0 until n) {
            arr[0][j] = 1
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1]
            }
        }
        return arr[m - 1][n - 1]
    }
}

fun main() {

    println(UniquePaths().uniquePaths(3, 3))

}
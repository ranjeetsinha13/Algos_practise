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

    // https://leetcode.com/problems/unique-paths-ii/solution/

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

        if (obstacleGrid[0][0] == 1) return 0

        obstacleGrid[0][0] = 1

        var row = obstacleGrid.size
        var column = obstacleGrid[0].size

        for (i in 1 until row) {
            obstacleGrid[i][0] = if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) 1 else 0
        }

        for (i in 1 until column) {
            obstacleGrid[0][i] = if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) 1 else 0
        }

        for (i in 1 until row) {
            for (j in 1 until column) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                } else {
                    obstacleGrid[i][j] = 0
                }
            }
        }

        return obstacleGrid[row - 1][column - 1]

    }
}

fun main() {

    println(UniquePaths().uniquePaths(3, 3))

}
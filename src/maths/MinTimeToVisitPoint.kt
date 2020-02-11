package maths

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var sum = 0
    for (i in 1 until points.size) {
        var x = Math.abs(points[i][0] - points[i - 1][0])
        var y = Math.abs(points[i][1] - points[i - 1][1])
        sum += Math.max(x, y)
    }
    return sum
}

fun main() {
    println(minTimeToVisitAllPoints(arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))))
}
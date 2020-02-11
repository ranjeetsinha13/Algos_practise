package maths

import kotlin.collections.ArrayList


fun pascalTriangle(row: Int, col: Int): Int {
    if (row + 1 == 1 || col + 1 == 1 || row == col) return 1

    return pascalTriangle(row - 1, col - 1) + pascalTriangle(row - 1, col)
}

fun pascalTriangeOptimised(row: Int, col: Int): Int {

    var result: MutableList<Int> = object : ArrayList<Int>(row + 1) {
        init {
            add(1)
        }
    }

    for (i in 0 until row) {
        for (j in i downTo 1) {
            result[j] = result[j] + result[j - 1]
        }
        result.add(1)
    }
    if (result.size < col) return -1

    return result[col - 1]

}


fun main() {
    //println(pascalTriangle(5, 4))
    println(pascalTriangeOptimised(3, 5))
}
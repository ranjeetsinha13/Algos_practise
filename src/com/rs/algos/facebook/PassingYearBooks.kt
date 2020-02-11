package com.rs.facebook

class PassingYearBooks {
    // [2,1]
    fun passingYearBooks(arr: Array<Int>): Array<Int> {
        val result = Array(arr.size) { 1 }
        for (i in arr.indices) {
            var temp = i
            while (arr[temp] != i + 1) {
                result[i]++
                temp = arr[temp] - 1
            }
        }
        return result
    }
}

fun main() {
    print(PassingYearBooks().passingYearBooks(arrayOf(2, 1)).contentToString())
}
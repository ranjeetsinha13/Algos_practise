package com.rs.algos

class SelectionSort {
    fun selectionSort(arr: IntArray) {
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] > arr[j]) {
                    val temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }
        }
        print(arr.contentToString())
    }
}

fun main() {
    SelectionSort().selectionSort(intArrayOf(2, 5, 1, 8, 3, 12, 4, 17, 11, 10, 5, 6, 9))
}
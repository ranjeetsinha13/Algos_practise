package com.rs.facebook

class ReverseArray {
    // This is similar to finding if two strings are anagrams
    fun areTheyEqual(arr_a: Array<Int>, arr_b: Array<Int>): Boolean {
        val mapA = hashMapOf<Int, Int>()
        val mapB = hashMapOf<Int, Int>()
        if (arr_a.size != arr_b.size) return false
        for (a in arr_a) {
            mapA[a] = mapA.getOrDefault(a, 0) + 1
        }
        for (b in arr_b) {
            mapB[b] = mapB.getOrDefault(b, 0) + 1
        }
        for (c in mapA.keys) {
            if (mapB[c] != mapA[c]) return false
        }
        return true
    }
}

fun main() {
    println(ReverseArray().areTheyEqual(arrayOf(2, 3, 4, 5), arrayOf(5, 4, 2, 3)))

}
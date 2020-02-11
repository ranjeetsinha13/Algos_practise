package hashing

import kotlin.math.min

//https://leetcode.com/problems/distribute-candies/

fun distributedCandles(candles: IntArray): Int {

    val hashSet = mutableSetOf<Int>()
    for (c in candles) {
        hashSet.add(c)
    }
    return min(hashSet.size, candles.size / 2)

}

fun commonChars(A: Array<String>): List<String> {

    var charCount = IntArray(26) { 0 }


    var result = mutableListOf<String>()

    for (ch in "abcdefghijklmnopqrstuvwxyz") {
        var count = 0
        for (s in A) {
            if (ch !in s) continue
            else {
                count++
            }
        }
        if (count == A.size)
            result.add(ch.toString())
    }
    return result

}

fun main() {
    println(distributedCandles(intArrayOf(1, 1, 2, 3)))
    println(commonChars(arrayOf("bella", "label", "roller")))
}

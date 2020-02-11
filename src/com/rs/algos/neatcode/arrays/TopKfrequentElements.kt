package com.rs.neatcode.arrays

import java.util.PriorityQueue

class TopKfrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var map = mutableMapOf<Int, Int>()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }


        var pq = PriorityQueue<Int>(map.size) { o1, o2 ->
            map[o1]!! - map[o2]!!
        }

        for (key in map.keys) {
            pq.add(key)
            if (pq.size > k) {
                pq.poll()
            }
        }
        println(pq)
        var result = mutableListOf<Int>()
        for (i in 0 until k) {
            result.add(pq.poll())
        }

        println(result)
        return result.toIntArray()

    }
}

fun main() {
    println(TopKfrequentElements().topKFrequent(intArrayOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 3, 3,1,1,1,1), 3))
}
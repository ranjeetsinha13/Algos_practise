package com.rs.neatcode.arrays

import java.util.PriorityQueue
import kotlin.concurrent.thread

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var result = mutableMapOf<String, MutableList<String>>()
        for(str in strs) {
            var key = str.toCharArray().sorted().toString()
            if (!result.containsKey(key)) {
                result[key] = arrayListOf()
            }
            result[key]?.add(str)
        }
        return result.values.toList()
    }
}

fun main() {

}

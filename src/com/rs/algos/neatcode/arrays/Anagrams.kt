package com.rs.neatcode.arrays

class Anagrams {
    fun checkAnagrams(a: String, b: String): Boolean {
        if (a.length != b.length) return false
        val m1 = hashMapOf<Char, Int>()
        val m2 = hashMapOf<Char, Int>()
        for (ch in a) {
            m1[ch] = m1.getOrDefault(ch, 0) + 1
        }
        for (ch in b) {
            m2[ch] = m2.getOrDefault(ch, 0) + 1
        }
        for (ch in m1.keys) {
            if (m1[ch] != m2[ch]) return false
        }
        return true
    }
}

fun main() {
    println(Anagrams().checkAnagrams("abcd", "dcba"))
}
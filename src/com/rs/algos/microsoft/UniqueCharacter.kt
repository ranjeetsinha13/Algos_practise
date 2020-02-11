package com.rs.microsoft

class UniqueCharacter {
    // Wrong solution, will give wrong output for aaaaab
    fun findFirstUniqueChar(s: String): Char {
        val map = hashMapOf<Char, Int>()
        for (i in s.indices) {
            if (!map.containsKey(s[i])) {
                map[s[i]] = i
            } else {
                map.remove(s[i])
            }
        }
        var min = Int.MAX_VALUE
        var result = '9'
        for (key in map.keys) {
            if (map.getOrDefault(key, min) < min) {
                min = map.getOrDefault(key, min)
                result = key
            }
        }
        return result
    }

    fun findFirstUniqueChar1(s: String): Char? {
        val map = hashMapOf<Char, Int>()
        for (ch in s) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }
        for (ch in s) {
            if (map[ch] == 1) return ch
        }
        return null
    }
}

fun main() {
    println(UniqueCharacter().findFirstUniqueChar("abaccdeff"))
    println(UniqueCharacter().findFirstUniqueChar("aabccd"))
    println(UniqueCharacter().findFirstUniqueChar("aaaaab"))

}
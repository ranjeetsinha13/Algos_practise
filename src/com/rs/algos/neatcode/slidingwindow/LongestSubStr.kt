package com.rs.neatcode.slidingwindow

class LongestSubStr {
    fun lengthOfLongestSubstring(s: String): Int {
        var set = mutableSetOf<Char>()
        var i = 0
        var j = 0
        var result = 0
        while (i < s.length && j < s.length) {
            if(!set.contains(s[i])) {
                set.add(s[i])
                i++
                result = Math.max(result, i - j)
            }
            else {
                set.remove(s[j])
                j++
            }
        }
        return result
    }
}

fun main() {
    println(LongestSubStr().lengthOfLongestSubstring("abcabc"))
}
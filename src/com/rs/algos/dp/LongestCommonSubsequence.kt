package com.rs.dp

// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

class LongestCommonSubsequence {

    // Example input “ABCDGH” and “AEDFHR”
    fun longestCommonSubsequence(input1: String, input2: String): String {
        var pointer1 = 0
        var pointer2 = 0
        var result = ""
        // corner case 1 - length of both strings is 0
        if (input1.isEmpty() || input2.isEmpty()) return ""
        while (pointer1 < input1.length) {
            if (input1[pointer1] == input2[pointer2]) {
                result+=input1[pointer1]
                pointer1++
                pointer2++
            }
            else {
                pointer2++
            }
            if (pointer2 >= input2.length) {
                pointer2 = pointer1
                pointer1++
            }
        }
        return result
    }
}

fun main() {
    println(LongestCommonSubsequence().longestCommonSubsequence("ABCDGH", "AEDFHR"))
    println(LongestCommonSubsequence().longestCommonSubsequence("AGGTAB", "GXTXAYB"))
}

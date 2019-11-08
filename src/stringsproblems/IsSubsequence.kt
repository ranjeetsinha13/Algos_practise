package stringsproblems

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {

        var c1 = 0
        var c2 = 0
        while (c1 < s.length && c2 < t.length) {

            if (s[c1] == t[c2]) {
                c1++
                c2++
            } else {
                c2++
            }
        }

        if (c1 == s.length) {
            return true
        }
        return false

    }

    //https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

    fun longestSubstring(s: String, k: Int): Int {

        var arr = IntArray(26) { 0 }

        for (ch in s) {
            arr[ch - 'a']++
        }

        println(arr.contentToString())

        var count = 0
        var maxCount = 0

        for (i in arr) {

            if (i >= k) {
                count += i
            } else {
                if (count > maxCount) {
                    maxCount = count
                }
                count = 0
            }

        }

        return maxCount

    }
}

fun main() {

    println(IsSubsequence().isSubsequence("ahc", "ahbgdc"))
    println(IsSubsequence().longestSubstring("ababacb", 3))

}
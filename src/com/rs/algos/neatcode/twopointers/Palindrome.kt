package com.rs.neatcode.twopointers

class Palindrome {

    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length -1
        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit()) {
                left++
            }
            while (left < right && !s[right].isLetterOrDigit()) {
                right--
            }
            if (s[left].lowercase() != s[right].lowercase()) {
                return false
            }
            left++
            right--
        }
        return true
    }
}
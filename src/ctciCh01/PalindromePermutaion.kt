package ctciCh01

/*
Given a string, write a function to check if it is a permutation of a palin­ drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
 */

class PalindromePermutaion {


    fun palindromePermutation(str: String): Boolean {

        var stCountArr = IntArray(26) { 0 }


        for (ch in str) {
            if (ch in "abcdefghijklmnopqrstuvwx")
                stCountArr[ch.toInt() - 'a'.toInt()]++
        }

        var foundOdd = false
        for (i in stCountArr) {
            if (i % 2 == 1) {
                if (foundOdd) return false
                foundOdd = true
            }
        }
        return true

    }

    fun isAnagram(s: String, t: String): Boolean {

        var a1 = s.toCharArray().apply { sort() }
        var a2 = t.toCharArray().apply { sort() }
        return (a1.contentToString() == a2.contentToString())

    }

    //https://leetcode.com/problems/find-all-anagrams-in-a-string/

    fun findAnagrams(s: String, p: String): List<Int> {

        var pSorted = p.toCharArray().apply { sort() }.contentToString()
        var indexList = mutableListOf<Int>()

        for (i in 0..(s.length - p.length)) {
            var str = s.substring(i, i + p.length).toCharArray().apply { sort() }.contentToString()
            if (str == pSorted) {
                indexList.add(i)
            }

        }
        return indexList

    }

}

fun main() {

    println(PalindromePermutaion().palindromePermutation("taco cat"))
    println(PalindromePermutaion().isAnagram("anagram", "margana"))
    println(PalindromePermutaion().findAnagrams("abab", "ab"))

}
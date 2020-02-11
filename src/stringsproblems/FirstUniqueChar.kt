package stringsproblems

import kotlin.collections.LinkedHashMap
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.collections.mutableSetOf
import kotlin.collections.set


class FirstUniqueChar {


    fun firstUniqChar(s: String): Int {

        // Use linkedhashMap to maintain order
        var cc: LinkedHashMap<Char, CharCount> = LinkedHashMap()


        for (i in s.indices) {

            if (cc.containsKey(s[i])) {
                var count = cc[s[i]]?.count ?: 0

                cc[s[i]] = CharCount(cc[s[i]]?.index!!, count + 1)
            } else {
                cc[s[i]] = CharCount(i, 1)
            }

        }
        var minIndex = Int.MAX_VALUE
        for (key in cc.keys) {

            if (cc[key]?.count == 1 && cc[key]?.index!! < minIndex) {
                minIndex = cc[key]?.index ?: -1
            }

        }
        if (minIndex == Int.MAX_VALUE) minIndex = -1
        return minIndex

    }

    fun getUniqueCharacterSubstring(input: String): String? {
        val visited = mutableMapOf<Char, Int>()
        var output = ""
        var start = 0
        var end = 0
        while (end < input.length) {
            val currChar = input[end]
            if (visited.containsKey(currChar)) {
                start = Math.max(visited[currChar]!! + 1, start)
            }
            if (output.length < end + 1 - start) {
                output = input.substring(start, end + 1)
            }
            visited[currChar] = end
            end++
        }
        return output
    }

    fun maxSubStrWithUniqueChars(s: String): Int {
        val hashSet = mutableSetOf<Char>()
        var i = 0
        var j = 0
        var ans = 0
        var result = ""
        while (i < s.length && j < s.length) {
            if (!hashSet.contains(s[i])) {
                hashSet.add(s[i++])
                if (ans < i - j) {
                    result = s.substring(j, i)
                    ans = i - j
                }

            } else {
                hashSet.remove(s[j++])
            }
        }
        println(result)
        return ans
    }

    //https://leetcode.com/contest/leetcode-weekly-contest-2/problems/find-the-difference/
    fun findTheDifference(s: String, t: String): Char {

        var c = 0

        for (ch in s) {
            c = c.xor(ch.toInt())
        }
        for (ch in t) {
            c = c.xor(ch.toInt())
        }

        return c.toChar()

    }

    //https://leetcode.com/contest/leetcode-weekly-contest-2/problems/elimination-game/

    fun lastRemaining(n: Int): Int {

        var list: MutableList<Int> = mutableListOf()

        for (i in 1..n) {
            list.add(i)
        }
        var counter = 0
        while (list.size > 1) {

            if (counter % 2 == 0) {
                //list.removeAt()
            } else {

            }
        }

        return 0
    }

}


class CharCount(var index: Int, var count: Int)

fun main() {

    println(FirstUniqueChar().getUniqueCharacterSubstring("aqwertfdsqawevhbnjkloipl"))
    //println(FirstUniqueChar().firstUniqChar(""))
    //println(FirstUniqueChar().findTheDifference("abcd", "abced"))

}
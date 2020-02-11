package stringsproblems

class LongestSubstringProblems {

    fun longestSubStringWithoutRepeatingChars(str: String): Int {
        // Save the position of last occurance of character
        val visitedMap = HashMap<Char, Int>()
        var start = 0
        var max = 0
        for (i in str.indices) {
            if (visitedMap.containsKey(str[i])) {
                start = Math.max(start, visitedMap.getOrDefault(str[i], 0) + 1)
            }
            visitedMap[str[i]] = i
            max = Math.max(max, i - start + 1)
        }
        return max
    }

    fun longestSubStringWithoutRepeatingChars2(str: String): Int {
        // Use Hashset
        val visitedSet = HashSet<Char>()
        var i = 0
        var j = 0
        var max = 0
        while (i < str.length && j < str.length) {
            if (!visitedSet.contains(str[i])) {
                visitedSet.add(str[i++])
                max = Math.max(max, i - j)
            } else {
                visitedSet.remove(str[j++])
            }
        }
        return max
    }

    // https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

    fun longestSubstringWithMaxKRepeatingChars(str: String, K: Int): Int {
        val freqCountMap = HashMap<Char, Int>()
        var start = 0
        var max = 0
        if (str.length < K) return str.length
        for (i in str.indices) {
            freqCountMap[str[i]] = freqCountMap.getOrDefault(str[i], 0) + 1
            if (freqCountMap.size <= K) {
                max = Math.max(max, i - start + 1)
            }
            while (freqCountMap.size > K) {
                // remove the characters till size becomes K
                freqCountMap[str[i]] = freqCountMap.getOrDefault(str[i], 0) - 1
                if (freqCountMap[str[i]] == 0) freqCountMap.remove(str[i])
                start++
            }
        }
        return max
    }

}

fun main() {
    println(LongestSubstringProblems().longestSubstringWithMaxKRepeatingChars("araaci", 2))
}
